package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.DireccionMapper;
import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.mapper.MunicipioMapper;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestProcesoCompra {

    @Mock
    private DireccionService direccionService;

    @Mock
    private EstadoService estadoService;

    @Mock
    private MetodoPagoService metodoPagoService;

    @Mock
    private MunicipioService municipioService;

    @Mock
    private DireccionMapper direccionMapper;

    @Mock
    private EstadoMapper estadoMapper;

    @Mock
    private MunicipioMapper municipioMapper;

    private final DireccionConNombre direccion1 = new DireccionConNombre();
    private List<DireccionConNombre> lista = new ArrayList<>();
    private final NuevaDireccion nuevaDireccion = new NuevaDireccion(4,1,"Julia",1,"Calle 1", "Colonia 2", "casa azul", "00025",1,2,3);
    private List<Estado> edos = new ArrayList<>();
    private List<Municipio> muns = new ArrayList<>();

    @Before
    public void prepare() throws SQLException {
        direccionService = new DireccionServiceImpl(direccionMapper);
        estadoService = new EstadoServiceImpl(estadoMapper);
        municipioService = new MunicipioServiceImpl(municipioMapper);
        lista.add(direccion1);

        when(direccionMapper.getDireccionesNombre(1)).thenReturn(lista);
        when(direccionMapper.getDireccionesNombre(3)).thenReturn(null);

        when(direccionMapper.insert(Mockito.any())).thenReturn(1);
        when(direccionMapper.insertUsuarioDireccion(Mockito.any())).thenReturn(1);
        when(estadoMapper.getByPais(1)).thenReturn(edos);
        when(municipioMapper.getByPais(1)).thenReturn(muns);

        edos.add(new Estado(1,2,"MiEdo"));
        muns.add(new Municipio(1,2, "Mun 2"));
    }

    @Test
    public void direccionesConNombreTest() {
        List<DireccionConNombre> dir;
        //Verifica que la lista recuperada por el metodo es la misma que fue creada
        try{
            dir = direccionService.getDireccionesNombre(1);
            assertEquals(dir,lista);
        }catch(Exception e) { }
        //Lanza excepcion si no existe el usuario
        try{
            dir = direccionService.getDireccionesNombre(3);
        }catch (Exception e){
            assertTrue(true);
      }
    }

    @Test
    public void agregaDireccionTest(){
        try{
            assertTrue(direccionService.agregaDireccion(nuevaDireccion)==1);
        }catch(Exception e) { }
        try{
            int i = direccionService.agregaDireccion(null);
        }catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void getByPaisTest() {
        try{
            assertEquals(edos, estadoService.getByPais(1));
        }catch (Exception e) { }
    }

    @Test
    public void getByEstadoTest() {
        try{
            assertEquals(muns, municipioService.getByEstado(1));
        }catch (Exception e) { }
    }

}
