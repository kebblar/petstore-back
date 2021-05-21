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

import javax.inject.Inject;

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
import io.kebblar.petstore.api.support.MailSenderService;
import io.kebblar.petstore.api.utils.CreatePDF;

/**
 * <p>
 * Implementación de la interfaz {@link OrdenCompraService}.
 * 
 * <p>
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
	
	@Inject
	private Environment environment;

	private OrdenCompraMapper ordenCompraMapper;
	
	private UsuarioDetalleMapper usuarioDetalleMapper;
	
	private UsuarioMapper usuarioMapper;
	
	private MailSenderService mailSenderService;


	/*
	 * Constructor con atributos mapper
	 */
	public OrdenCompraServiceImpl(OrdenCompraMapper ordenCompraMapper, 
									UsuarioDetalleMapper usuarioDetalleMapper,
									UsuarioMapper usuarioMapper,
									MailSenderService mailSenderService) {
		this.ordenCompraMapper = ordenCompraMapper;
		this.usuarioDetalleMapper=usuarioDetalleMapper;
		this.usuarioMapper=usuarioMapper;
		this.mailSenderService=mailSenderService;
	}

	/*
	 * Implementación del método getAll
	 */
	@Override
	public List<DatosOrden> getAll() throws BusinessException {
		try {
			return ordenCompraMapper.getAll();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new BusinessException();
		}
	}
	
	
	/*
	 * Implementación del método insert
	 */
	@Override
	public int insert(DatosOrden datosOrden) throws BusinessException {
		try {
			return ordenCompraMapper.insert(datosOrden);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new BusinessException();
		}
	}


	@Override
	public DatosOrden procesarOrdenCompra(DatosOrden ordenCompra) throws BusinessException {
		try {
			Usuario usuario=usuarioMapper.getById(ordenCompra.getIdUsuario());
			
			UsuarioDetalle usuarioDetalle= usuarioDetalleMapper.getById(usuario.getId());
			
			String dest= environment.getProperty( "app.destination-folder" );
			
			String pdf= CreatePDF.createPDFOrdenCompra(usuarioDetalle, usuario, ordenCompra, dest);
			
			String formatDate= new SimpleDateFormat("yyyy-MM-dd").format(ordenCompra.getFecha());
			Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(formatDate);
			ordenCompra.setFecha(fecha);
			
			String url= environment.getProperty( "app.destination.url" );
			
			ordenCompra.setRecibo(url+pdf);
			
			ordenCompraMapper.insert(ordenCompra);
			
			mailSenderService.sendHtmlMail2(usuario.getCorreo(), "Recibo de compra petstore", "Recibo de compra PETSTORE", new File(dest+pdf));
			
		} catch (SQLException e) {
			System.out.println("Error SQL: "+e);
			logger.error(e.getMessage());
			throw new BusinessException();
		} catch (ParseException e) {
			System.out.println("Error SQL: "+e);
			logger.error(e.getMessage());
			throw new BusinessException();
		} catch(ProcessPDFException p) {
			System.out.println("Error SQL: "+p);
			logger.error(p.getMessage());
			throw new BusinessException();
		}
		return ordenCompra;
	}
	
	

	

}
