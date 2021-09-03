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

import io.kebblar.petstore.api.mapper.AdministracionComprasMapper;
import io.kebblar.petstore.api.model.domain.AdministracionCompras;
import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

@RunWith(MockitoJUnitRunner.class)
public class TestAdministracionComprasService {
    @Mock
    private AdministracionComprasMapper historialMapper;

    private AdministracionComprasService historialService;

    @Before
    public void prepara() {
        this.historialService = new AdministracionComprasServiceImpl(historialMapper);
    }

    @Test
    public void testSent() throws SQLException, BusinessException{
        List<HistorialCompras> getLista = new ArrayList<HistorialCompras>();
        HistorialCompras compra = new HistorialCompras("abc","2020-10-10",0,1,"foo","paypal","gus@aol.com",
                "foo.com","goo.com");
        getLista.add(compra);
        when(historialMapper.sent(1,"abc")).thenReturn(1);
        assert(historialService.sent(1,"abc").equals("{\"succed\": \"true\"}"));
    }

    @Test
    public void testGetAll() throws SQLException, BusinessException{
        List<AdministracionCompras> getLista = new ArrayList<AdministracionCompras>();
        AdministracionCompras compra = new AdministracionCompras(true,"cve_orden","nueva colonia","mascota foo","foo.com","2020-10-10","calle goo numero 80", "84444");
        getLista.add(compra);
        when(historialMapper.getAll()).thenReturn(getLista);
        assert(historialService.getAll().get(0).getCveOrden() == "foo.com");
    }
}
