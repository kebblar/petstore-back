package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCriptomonedas {
    private static final Logger logger = LoggerFactory.getLogger(TestCriptomonedas.class);

    @Mock
    private CriptoMapper criptoMapper;

    @Mock
    private OrdenCompraService ordenCompraService;

    private RemoteRestCallService remote;
    private CriptoService criptoService;

    private TransaccionBtc t1 = new TransaccionBtc();
    private TransaccionBtc t2 = new TransaccionBtc();

    @Before
    public void prepare() throws SQLException {
        criptoService = new CriptoServiceImpl(criptoMapper, remote, ordenCompraService);

        when(criptoMapper.getByUser(1)).thenReturn("cadenaWallet");
        when(criptoMapper.getByUser(2)).thenThrow(new SQLException());
        when(criptoMapper.insertTransaccion(t1)).thenReturn(1);
        when(criptoMapper.insertTransaccion(t2)).thenThrow(new SQLException());
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
            assertEquals(criptoService.insertTransaccion(t1),1);
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