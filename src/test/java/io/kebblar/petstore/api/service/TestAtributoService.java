package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.AtributoMapper;
import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.AtributoDetalleTO;
import io.kebblar.petstore.api.model.domain.ValorAtributo;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestAtributoService {

    @Mock
    private AtributoMapper atributoMapper;
    private Atributo atributo;
    private AtributoService atributoService;
    private List<Atributo> lista;

    @Before
    public void prepara() {
        atributo = new Atributo(1, "atributo1", 1);
        atributoService = new AtributoServiceImpl(atributoMapper);
        lista = new ArrayList<>();
        lista.add(atributo);
        lista.add(new Atributo(2, "atributo2", 1));
    }

    @Test
    public void testGetById() throws Exception {
        when(atributoMapper.getById(1)).thenReturn(atributo);
        assertEquals(atributo, atributoService.getById(1));
        try{
            when(atributoMapper.getById(0)).thenThrow(SQLException.class);
            atributoService.getById(0);
            } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

    @Test
    public void TestGetAll() throws Exception {
        when(atributoMapper.getAll()).thenReturn(lista);
        List<Atributo> l = atributoService.getAll();
        assertEquals(atributo, l.get(0));
        try {
            when(atributoMapper.getAll()).thenThrow(SQLException.class);
            atributoService.getAll();
        } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

    @Test
    public void testInsertUpdateDelete() throws Exception {
        when(atributoMapper.update(atributo)).thenReturn(1);
        when(atributoMapper.delete(1)).thenReturn(1);
        when(atributoMapper.insert(atributo)).thenReturn(1);
        atributoService.update(atributo);
        atributoService.delete(atributo);
        atributoService.insert(atributo);
        assertTrue(true);
        try {
            when(atributoMapper.update(Mockito.any())).thenThrow(SQLException.class);
            atributoService.update(atributo);
        } catch (DatabaseException d) {
            assertTrue(true);
        } try {
            when(atributoMapper.insert(Mockito.any())).thenThrow(SQLException.class);
            atributoService.insert(atributo);
        } catch (DatabaseException d) {
            assertTrue(true);
        } try {
            when(atributoMapper.delete(Mockito.anyInt())).thenThrow(SQLException.class);
            atributoService.delete(atributo);
        } catch (DatabaseException f) {
            assertTrue(true);
        }
    }

    @Test
    public void testSaveGetByNombre() throws Exception {

        when(atributoMapper.getByNombre("atributo1")).thenReturn(lista);
        assertEquals(atributo, atributoService.getByNombre("atributo1").get(0));
        when(atributoMapper.insert(Mockito.any())).thenReturn(1);
        when(atributoMapper.getById(5)).thenReturn(null);
        Atributo a = new Atributo(5, "atributox", 1);
        assertEquals(1, atributoService.save(a));
        when(atributoMapper.getById(1)).thenReturn(atributo);
        when(atributoMapper.update(atributo)).thenReturn(0);
        assertEquals(0, atributoService.save(atributo));
        try {
            when(atributoMapper.insert(Mockito.any())).thenThrow(SQLException.class);
            atributoService.save(a);
        } catch (DatabaseException d) {
            assertTrue(true);
        }
        try {
            when(atributoMapper.update(Mockito.any())).thenThrow(SQLException.class);
            atributoService.save(atributo);
        } catch (DatabaseException d) {
            assertTrue(true);
        }
        try {
            when(atributoMapper.getByNombre("x")).thenThrow(SQLException.class);
            atributoService.getByNombre("x");
        } catch (BusinessException b) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetAtributoDetalle () throws Exception {
        List<AtributoDetalleTO> l = new ArrayList<>();
        AtributoDetalleTO ad = new AtributoDetalleTO();
        ad.setEstatusRango(1);
        ad.setIdAtributo(1);
        ad.setNombreAtributo("nombre");
        ad.setIdRango(1);
        ad.setRangoIdAtributo(2);
        ad.setIdRango(1);
        l.add(ad);
        l.add(ad);
        when(atributoMapper.getAllAtributoDetalle()).thenReturn(l);
        assertFalse(atributoService.getAllAtributoDetalles().isEmpty());

        try {
            when(atributoMapper.getAllAtributoDetalle()).thenThrow(SQLException.class);
            atributoService.getAllAtributoDetalles();
        } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

}
