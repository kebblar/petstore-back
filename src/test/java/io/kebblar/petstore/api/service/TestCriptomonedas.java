/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      TestCriptomonedas
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:38:28
 */
package io.kebblar.petstore.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.kebblar.petstore.api.mapper.CarritoMapper;
import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>TestCriptomonedas class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
public class TestCriptomonedas {
    private static final Logger logger = LoggerFactory.getLogger(TestCriptomonedas.class);

    @Mock
    private CriptoMapper criptoMapper;

    @Mock
    private OrdenCompraService ordenCompraService;

    @Mock
    private CarritoMapper carritoMapper;

    private RemoteRestCallService remote;
    private CriptoService criptoService;

    private TransaccionBtc t1 = new TransaccionBtc();
    private TransaccionBtc t2 = new TransaccionBtc();

    List<Carrito> c = new ArrayList<>();

    /**
     * <p>prepare.</p>
     *
     * @throws java.sql.SQLException if any.
     */
    @Before
    public void prepare() throws SQLException {
        MockitoAnnotations.initMocks(this);
        
        criptoService = new CriptoServiceImpl(carritoMapper,criptoMapper, remote, ordenCompraService);

        c.add(new Carrito(1,1,1,"abc"));
        t1.setIdUsuario(1);
        t2.setIdUsuario(2);

        when(criptoMapper.getByUser(1)).thenReturn("cadenaWallet");
        when(criptoMapper.getByUser(2)).thenThrow(new SQLException());
        when(criptoMapper.insertTransaccion(t1)).thenReturn(1);
        when(criptoMapper.insertTransaccion(t2)).thenThrow(new SQLException());
        when(carritoMapper.getAll(1)).thenReturn(c);
        when(carritoMapper.update(Mockito.any())).thenReturn(1);
    }

    /**
     * <p>getByUserTest.</p>
     */
    @Test
    public void getByUserTest() {
        try {
            assertEquals(criptoService.getByUser(1),"cadenaWallet");
        } catch (MapperCallException  e) {
            logger.info("Problema recuperando el wallet del usuario");
        }
        try {
            criptoService.getByUser(2);
        } catch (MapperCallException m) {
            assertTrue(true);
        }
    }

    /**
     * <p>insertTransactionTest.</p>
     */
    @Test
    public void insertTransactionTest() {
        try {
            criptoService.insertTransaccion(t1);
            assertEquals(c.get(0).getCveOrdenCompra(), "btcPen");
        } catch (MapperCallException e) {
            logger.info("Problema insertando una nueva transacción");
        }
        try {
            criptoService.insertTransaccion(t2);
        } catch (MapperCallException b) {
            assertTrue(true);
        }
    }

}
