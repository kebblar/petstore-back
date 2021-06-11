package io.kebblar.petstore.api.service;

import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.mapper.HistorialComprasMapper;
import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

@RunWith(MockitoJUnitRunner.class)
public class TestHistorialComprasService {
    @Mock
    private HistorialComprasMapper historialMapper;

    private HistorialComprasService historialService;

    @Before
    public void prepara() {
        this.historialService = new HistorialComprasServiceImpl(historialMapper);
    }

    @Test
    public void Test() throws SQLException, BusinessException{
        List<HistorialCompras> getLista = new ArrayList<HistorialCompras>();
        HistorialCompras compra = new HistorialCompras("abc","2020-10-10",0,1,"foo","paypal","gus@aol.com",
                "foo.com","goo.com");
        getLista.add(compra);
        when(historialMapper.getAll(1)).thenReturn(getLista);
        assert(historialService.getAll(1).get(0).getCveOrden() == "abc");
    }

}
