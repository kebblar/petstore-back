package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.ContadorMapper;
import io.kebblar.petstore.api.model.domain.TablasContadorEnum;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

import java.sql.SQLException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestContador {

    @Mock
    ContadorMapper contadorMapper;

    ContadorService contadorService;

    @Before
    public void prepara () {
        contadorService = new ContadorServiceImpl(contadorMapper);
    }

    @Test
    public void tests () throws BusinessException, SQLException {
        try {
            when(contadorMapper.getTableCount("petstore", "usuario_detalle")).thenReturn(100);
            assertEquals(100, contadorService.getUsuarioDetalleCounter());
            when(contadorMapper.getTableCount("petstore", "usuario")).thenReturn(100);
            assertEquals(100, contadorService.getUsuarioCounter());
            when(contadorMapper.getTableCount("petstore", "pais")).thenReturn(100);
            assertEquals(100, contadorService.getPaisCounter());
            when(contadorMapper.getTableCount("petstore", "estado")).thenReturn(100);
            assertEquals(100, contadorService.getEstadoCounter());
            when(contadorMapper.getTableCount("petstore", "municipio")).thenReturn(100);
            assertEquals(100, contadorService.getMunicipioCounter());
            assertNotNull(contadorService.getTableCounter("tabla"));
            assertNotNull(contadorService.getTableCounter2(TablasContadorEnum.ESTADOS));
        }catch (Exception e) {}
        try {
            when(contadorMapper.getTableCount("petstore","x")).thenThrow(SQLException.class);
            contadorService.getTableCounter("x");
        } catch (MapperCallException m) {
            assertTrue(true);
        }
    }


}
