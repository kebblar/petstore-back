package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.mapper.OrdenCompraMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BitcoinTransactionException;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCriptomonedas {

    @Mock
    private CriptoMapper criptoMapper;

    @Mock
    private OrdenCompraMapper ordenCompraMapper;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Mock
    private UsuarioDetalleMapper usuarioDetalleMapper;

    @Mock
    private OrdenCompraService ordenCompraService;

    private RemoteRestCallService remote;
    private CriptoService criptoService;
    List<TransaccionBtc> list;

    private TransaccionBtc t1 = new TransaccionBtc();

    @Before
    public void prepare() throws SQLException {
        criptoService = new CriptoServiceImpl(criptoMapper, remote, ordenCompraService);

        list = new ArrayList<>();
        TransaccionBtc transaccion1 = new TransaccionBtc(7,1,2,"12Vh6YLge3bYDrojdC1TpwjfS18sdeQjoN",1,false,700, new Date(), "pba test");
        TransaccionBtc transaccion2 = new TransaccionBtc(8,5,28,"1MSzx9JGPEjXpWVDfeNKnDknTgqWeEyiLd",6,false,800, new Date(), "pba test 2");
        list.add(transaccion1);
        list.add(transaccion2);

        when(criptoMapper.getByUser(1)).thenReturn("cadenaWallet");
        when(criptoMapper.getByUser(2)).thenThrow(new SQLException());
        when(criptoMapper.insertTransaccion(t1)).thenReturn(1);
        when(criptoMapper.insertTransaccion(Mockito.any())).thenThrow(new SQLException());
        when(criptoMapper.getAll()).thenReturn(list);
        when(ordenCompraMapper.insert(Mockito.any())).thenReturn(1);
        when(usuarioMapper.getById(Mockito.any())).thenReturn(new Usuario());
        when(usuarioDetalleMapper.getById(Mockito.any())).thenReturn(new UsuarioDetalle());
    }

    @Test
    public void getByUserTest() {
        try {
            assertEquals(criptoService.getByUser(1),"cadenaWallet");
        } catch (MapperCallException e) {}
        try {
            String s = criptoService.getByUser(2);
        } catch (MapperCallException m) {
            assertTrue(true);
        }
    }

    @Test
    public void insertTransactionTest() {
        try {
            assertEquals(criptoService.insertTransaccion(t1),1);
        } catch (MapperCallException e) { }
        try {
            int i = criptoService.insertTransaccion(new TransaccionBtc());
        } catch (MapperCallException b) {
            assertTrue(true);
        }
    }

}
