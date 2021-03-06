/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   CarritoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 06 de June de 2021 (13_15)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210608_1315 Implementación de clase
 *
 */
package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.mapper.CarritoMapper;

import io.kebblar.petstore.api.model.exceptions.CarritoException;
import io.kebblar.petstore.api.model.exceptions.VistaCarritoException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import io.kebblar.petstore.api.model.response.CarritoVista;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio asociado a la entidad 'carrito'.
 *
 * <p>Implementación de la interfaz {@link CarritoService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  Carrito
 * @see  CarritoService
 */
@Service("carritoService")
public class CarritoServiceImpl implements CarritoService {
    private static final Logger logger = LoggerFactory.getLogger(CarritoServiceImpl.class);

    private CarritoMapper carritoMapper;
    private AnuncioService anuncioService;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param carritoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public CarritoServiceImpl(CarritoMapper carritoMapper, AnuncioService anuncioService) {
        logger.info("CarritoServiceImpl constructor invoked");
        this.carritoMapper = carritoMapper;
        this.anuncioService = anuncioService;
    }

    @Override
    public Carrito getById(int id) throws BusinessException {
        try {
            return carritoMapper.getById(id);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public List<CarritoDatosFactura> getByCveOrden(String cve) throws BusinessException {
        List<CarritoDatosFactura> carro;
        try {
            carro = carritoMapper.getByCve(cve);
            if (carro.size()==0) throw new VistaCarritoException("La clave de orden ingresada no existe");
        } catch (SQLException e) {
            throw new VistaCarritoException("Error al intentar recuperar el carrito de la orden " + cve);
        }
        return carro;
    }

    @Override
    public List<Carrito> getCarritoByUserId(int id) throws BusinessException {
        try {
            return carritoMapper.getAll(id);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public int insert(Carrito carrito) throws BusinessException {
        try {
            return carritoMapper.insert(carrito);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public int update(Carrito carrito) throws BusinessException {
        try {
            return carritoMapper.update(carrito);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public int delete(int id) throws BusinessException {
        try {
            return carritoMapper.delete(id);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public List<CarritoVista> getCarritoView(int id) throws BusinessException {
        List<CarritoVista> lista = new ArrayList<>();
        List<Carrito> carrito = getCarritoByUserId(id);
        for(Carrito elem : carrito) {
            try {
                DetalleAnuncioResponse d = anuncioService.detalleAnuncio(elem.getIdAnuncio());
                String imagen = d.getImagenes().get(0).getUuid();
                lista.add(new CarritoVista(elem.getId(), "https://photos.ci.ultrasist.net/"+imagen, d.getTitulo(), elem.getIdAnuncio(), d.getPrecio().doubleValue()));
            } catch(BusinessException e) {
                logger.error(e.getMessage());
            }
        }
        return lista;
    }

    public void updateCarritoCompra(String cveCompra, int idUser) throws BusinessException {
        List<Carrito> carritos = getCarritoByUserId(idUser);
        for (Carrito carrito : carritos) {
            try {
                carrito.setCveOrdenCompra(cveCompra);
                carritoMapper.update(carrito);
            } catch (Exception e) {
                throw new DatabaseException(e.getMessage());
            }
        }
    }

    @Override
    public void updateCarritoCompraBtc(String cveOrdenCompra, int idUser) throws BusinessException {
        try {
            List<Carrito> carrito = carritoMapper.getBtcCarrito(idUser);
            for(Carrito c : carrito) {
                c.setCveOrdenCompra(cveOrdenCompra);
                carritoMapper.update(c);
             }
        } catch (Exception b) {
            throw new CarritoException("No pudo actualizarse la orden compra del carrito del usuario" + idUser);
        }
    }

    @Override
    public int save(Carrito carrito) throws BusinessException {
        try {
            if (getById(carrito.getId()) == null) {
                return carritoMapper.insert(carrito);
            } else {
                return carritoMapper.update(carrito);
            }
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}
