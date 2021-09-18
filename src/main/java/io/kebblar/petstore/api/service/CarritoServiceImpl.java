/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CarritoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:42:54
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
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.CarritoService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
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
     * @param anuncioService a {@link io.kebblar.petstore.api.service.AnuncioService} object.
     */
    public CarritoServiceImpl(CarritoMapper carritoMapper, AnuncioService anuncioService) {
        logger.info("CarritoServiceImpl constructor invoked");
        this.carritoMapper = carritoMapper;
        this.anuncioService = anuncioService;
    }

    /** {@inheritDoc} */
    @Override
    public Carrito getById(int id) throws BusinessException {
        try {
            return carritoMapper.getById(id);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<CarritoDatosFactura> getByCveOrden(String cve) throws BusinessException {
        List<CarritoDatosFactura> carro;
        try {
            carro = carritoMapper.getByCve(cve);
            if (carro.size()==0) throw new VistaCarritoException(cve);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return carro;
    }

    /** {@inheritDoc} */
    @Override
    public List<Carrito> getCarritoByUserId(int id) throws BusinessException {
        try {
            return carritoMapper.getAll(id);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int insert(Carrito carrito) throws BusinessException {
        try {
            return carritoMapper.insert(carrito);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int update(Carrito carrito) throws BusinessException {
        try {
            return carritoMapper.update(carrito);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int delete(int id) throws BusinessException {
        try {
            return carritoMapper.delete(id);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    public void updateCarritoCompra(String cveCompra, int idUser) throws BusinessException {
        List<Carrito> carritos = getCarritoByUserId(idUser);
        for (Carrito carrito : carritos) {
            try {
                carrito.setCveOrdenCompra(cveCompra);
                carritoMapper.update(carrito);
            } catch (Exception e) {
                throw new DatabaseException(e);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void updateCarritoCompraBtc(String cveOrdenCompra, int idUser) throws BusinessException {
        try {
            List<Carrito> carrito = carritoMapper.getBtcCarrito(idUser);
            for(Carrito c : carrito) {
                c.setCveOrdenCompra(cveOrdenCompra);
                carritoMapper.update(c);
             }
        } catch (Exception b) {
            throw new CarritoException(idUser);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int save(Carrito carrito) throws BusinessException {
        try {
            if (getById(carrito.getId()) == null) {
                return carritoMapper.insert(carrito);
            } else {
                return carritoMapper.update(carrito);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

}
