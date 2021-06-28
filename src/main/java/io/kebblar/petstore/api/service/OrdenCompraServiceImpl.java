/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   FacturaServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Daniel Alvarez Morales
 * Fecha:       15 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *
 */
package io.kebblar.petstore.api.service;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.OrdenCompraMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ProcessPDFException;
import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import io.kebblar.petstore.api.support.MailSenderService;
import io.kebblar.petstore.api.utils.CreatePDF;
import io.kebblar.petstore.api.utils.Signer;

/**
 * Implementación de la interfaz {@link OrdenCompraService}.
 * 
 * Todos los métodos de esta clase disparan {@link BusinessException}
 * 
 * @author dalvarez
 * @see io.kebblar.petstore.api.model.domain.DatosOrden
 * @see io.kebblar.petstore.api.service.OrdenCompraService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {
    private static final Logger logger = LoggerFactory.getLogger(OrdenCompraServiceImpl.class);
    
    private Environment environment;
    private OrdenCompraMapper ordenCompraMapper;
    private UsuarioDetalleMapper usuarioDetalleMapper;
    private UsuarioMapper usuarioMapper;
    private MailSenderService mailSenderService;
    private CarritoService carritoService;
    private DireccionService direccionService;
    private SmsService smsService;
    
    /*
     * Constructor con atributos mapper
     */
    public OrdenCompraServiceImpl(
        OrdenCompraMapper ordenCompraMapper, 
            UsuarioDetalleMapper usuarioDetalleMapper,
            UsuarioMapper usuarioMapper,
            MailSenderService mailSenderService,
            Environment environment,
            CarritoService carritoService,
            DireccionService direccionService,
            SmsService smsService) {
        this.ordenCompraMapper = ordenCompraMapper;
        this.usuarioDetalleMapper=usuarioDetalleMapper;
        this.usuarioMapper=usuarioMapper;
        this.mailSenderService=mailSenderService;
        this.environment=environment;
        this.carritoService=carritoService;
        this.direccionService=direccionService;
        this.smsService=smsService;
    }

    @Override
    public List<DatosOrden> getAll() throws BusinessException {
        try {
            return ordenCompraMapper.getAll();
        } catch (SQLException e) {
            throw new BusinessException("Error en obtener todos los elementos Orden de compra",e.getMessage());
        }
    }
    
    @Override
    public int insert(DatosOrden datosOrden) throws BusinessException {
        try {
            return ordenCompraMapper.insert(datosOrden);
        } catch (SQLException e) {
            throw new BusinessException("Error al insertar Orden de compra",e.getMessage());
        }
    }

    @Override
    public DatosOrden procesarOrdenCompra(DatosOrden ordenCompra) throws BusinessException {
        logger.debug("Procesando una orden de compra");
        try {
            Usuario usuario=usuarioMapper.getById(ordenCompra.getIdUsuario());
            UsuarioDetalle usuarioDetalle= usuarioDetalleMapper.getById(usuario.getId());
            
            String dest= environment.getProperty( "app.destination-folder" );
            String url= environment.getProperty( "app.destination.url" );
            String nombrePdf= CreatePDF.getNamePDF(usuarioDetalle.getId());
            String pdf= nombrePdf + ".pdf";
            
            String formatDate= new SimpleDateFormat("yyyy-MM-dd").format(ordenCompra.getFecha());
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(formatDate);
            ordenCompra.setFecha(fecha);
            ordenCompra.setRecibo(url+pdf);
            
            ordenCompraMapper.insert(ordenCompra);

            if(ordenCompra.getIdMoneda() == 3) {
                carritoService.updateCarritoCompraBtc(ordenCompra.getCveOrdenCompra(), ordenCompra.getIdUsuario());
            } else {
                carritoService.updateCarritoCompra(ordenCompra.getCveOrdenCompra(), ordenCompra.getIdUsuario());
            }
            String cveSMS = smsService.getCveSMS();
            String msjSMS = environment.getProperty( "app.sms.msj" )+cveSMS;
            
            List<CarritoDatosFactura> listCarrito = carritoService.getByCveOrden(ordenCompra.getCveOrdenCompra());
            List<DireccionConNombre> direcciones= direccionService.getDireccionEnvio(ordenCompra.getIdUsuario(), ordenCompra.getIdDireccion());
            CreatePDF.createPDFOrdenCompra(usuarioDetalle, usuario, ordenCompra, dest, url, nombrePdf, listCarrito, direcciones);
            
            Signer firmador =  new Signer(environment.getProperty( "app.keys" ) + "ok.key", environment.getProperty( "app.keys" ) + "ok.cer", dest+pdf);
            String signedPdf = firmador.signPdf();
            CreatePDF.protectDocument(dest+pdf, cveSMS);
            mailSenderService.sendHtmlMail2(usuario.getCorreo(), "Recibo de compra petstore", 
                    "<h1 style='text-align:center;'>¡Gracias por tu compra!</h1>" +
                    "<hr> <br>" + 
                    "<h2 style='text-align:center;'>A continuación encontrarás el recibo de tu compra.</h2> " +
                    "<img style='display: block;\r\n"
                    + "  margin-left: auto;\r\n"
                    + "  margin-right: auto;\r\n"
                    + "  width: 293px;height: 172px;' src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZPPYqewTwvHD5CYGqIngd8ENFVmEgf-M_ig&usqp=CAU'> <br>"+
                    "<small>Por propósitos de seguridad te enviamos el pdf firmado: " + signedPdf  + "</small> <br>" + 
                    "<hr>", new File(dest+pdf));
            smsService.envioSms(usuarioDetalle.getTelefonoCelular(),msjSMS);
            
        } catch (SQLException e) {
            throw new BusinessException("Error SQL: ",e.getMessage());
        } catch (ParseException e) {
            throw new BusinessException("Error ParseException: ",e.getMessage());
        } catch(ProcessPDFException p) {
            throw new BusinessException("Error ProcessPDFException: ",p.getMessage());
        } catch (Exception e) {
             throw new BusinessException("Error Signer: ",e.getMessage());
        }
        return ordenCompra;
    }

}
