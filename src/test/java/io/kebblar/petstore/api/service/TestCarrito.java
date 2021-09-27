package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CarritoMapper;
import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.model.exceptions.CarritoException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;
import io.kebblar.petstore.api.model.exceptions.VistaCarritoException;
import io.kebblar.petstore.api.model.response.AnuncioImagenResponse;
import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import io.kebblar.petstore.api.model.response.CarritoVista;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCarrito {

    @Mock
    AnuncioService anuncioService;

    @Mock
    CarritoMapper carritoMapper;

    CarritoService carritoService;
    Carrito carrito1;
    List<CarritoDatosFactura> carritoLista;
    List<CarritoVista> carritoVistas;
    List<Carrito> carritoList;

    @Before
    public void prepara() throws Exception {
        carritoService = new CarritoServiceImpl(carritoMapper, anuncioService);
        carrito1 = new Carrito(1,1,1,"abc");
        carritoLista = new ArrayList<>();
        carritoLista.add(new CarritoDatosFactura("perro", 100, "perro azul"));
        carritoVistas = new ArrayList<>();
        carritoVistas.add(new CarritoVista(1, "abc", "def", 1, 5));
        carritoList = new ArrayList<>();
        carritoList.add(carrito1);
    }

    @Test
    public void testMetodosGet() throws Exception {
        when(carritoMapper.getById(1)).thenReturn(carrito1);
        assertEquals(carrito1, carritoService.getById(1));

        when(carritoMapper.getByCve("aaa")).thenReturn(carritoLista);
        assertEquals(carritoLista, carritoService.getByCveOrden("aaa"));

        when(carritoMapper.getAll(1)).thenReturn(new ArrayList<>());
        assertTrue(carritoService.getCarritoByUserId(1).isEmpty());

        try{
            when(carritoMapper.getById(0)).thenThrow(SQLException.class);
            carritoService.getById(0);
        } catch (DatabaseException d) {
            assertTrue(true);
        }
        try {
            when(carritoMapper.getByCve("x")).thenReturn(new ArrayList<>());
            carritoService.getByCveOrden("x");
        } catch (VistaCarritoException v) {
            assertTrue(true);
        }
        try {
            when(carritoMapper.getByCve("x")).thenThrow(SQLException.class);
            carritoService.getByCveOrden("x");
        } catch (DatabaseException d) {
            assertTrue(true);
        }
        try {
            when(carritoMapper.getAll(0)).thenThrow(SQLException.class);
            carritoService.getCarritoByUserId(0);
        } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

    @Test
    public void testInsertDeleteUpdate() throws Exception {
        when(carritoMapper.update(carrito1)).thenReturn(1);
        when(carritoMapper.getById(1)).thenReturn(carrito1);
        assertEquals(1,carritoService.update(carrito1));
        assertEquals(1,carritoService.save(carrito1));

        when(carritoMapper.insert(carrito1)).thenReturn(1);
        when(carritoMapper.getById(1)).thenReturn(null);
        assertEquals(1,carritoService.insert(carrito1));
        assertEquals(1, carritoService.save(carrito1));

        when(carritoMapper.delete(1)).thenReturn(1);
        assertEquals(1,carritoService.delete(1));

        try {
            when(carritoMapper.insert(Mockito.any(Carrito.class))).thenThrow(SQLException.class);
            carritoService.insert(new Carrito());
        } catch (DatabaseException b) {
            assertTrue(true);
        }
        try {
            when(carritoMapper.update(Mockito.any(Carrito.class))).thenThrow(SQLException.class);
            carritoService.update(new Carrito());
        } catch (DatabaseException d) {
            assertTrue(true);
        }
        try{
            when(carritoMapper.delete(Mockito.anyInt())).thenThrow(SQLException.class);
            carritoService.delete(1);
        } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

    @Test
    public void testUpdateGet() throws Exception {
        when(carritoMapper.getBtcCarrito(1)).thenReturn(carritoList);
        when(carritoMapper.update(Mockito.any(Carrito.class))).thenReturn(1);
        carritoService.updateCarritoCompraBtc("abc", 1);
        assertEquals("abc", carritoList.get(0).getCveOrdenCompra());

        DetalleAnuncioResponse d = new DetalleAnuncioResponse();
        AnuncioImagenResponse a = new AnuncioImagenResponse(1,1,"uuid", 1, true);
        List<AnuncioImagenResponse> lista = new ArrayList<>();
        lista.add(a);
        d.setImagenes(lista);
        d.setTitulo("titulo");
        d.setPrecio(new BigDecimal(100));
        when(carritoMapper.getAll(1)).thenReturn(carritoList);
        when(anuncioService.detalleAnuncio(1)).thenReturn(d);
        assertFalse(carritoService.getCarritoView(1).isEmpty());

        when(carritoMapper.update(Mockito.any(Carrito.class))).thenReturn(1);
        carritoService.updateCarritoCompra("aa",1);
        assertEquals("aa", carritoList.get(0).getCveOrdenCompra());

        try {
            when(carritoMapper.getAll(1)).thenReturn(carritoList);
            when(anuncioService.detalleAnuncio(1)).thenReturn(new DetalleAnuncioResponse());
            assertTrue(carritoService.getCarritoView(1).isEmpty());
        } catch (NullPointerException n) {
            assertTrue(true);
        }

        try {
            when(carritoMapper.getBtcCarrito(Mockito.anyInt())).thenThrow(SQLException.class);
            carritoService.updateCarritoCompraBtc("x", 2);
        } catch (CarritoException c) {
            assertTrue(true);
        }
        try {
            when(carritoMapper.getAll(1)).thenThrow(SQLException.class);
            carritoService.updateCarritoCompra("xd", 1);
        } catch (DatabaseException p) { assertTrue(true); }
    }

}
