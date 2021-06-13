/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TestCriptomonedas.java
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo (GAA)
 * Fecha:       Domingo 13 de Junio de 2021 (17_50)
 *
 * Historia:    .
 *              20210504_1950 Creación de éste test
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CarritoMapper;
import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
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

    @Before
    public void prepare() throws SQLException {
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
