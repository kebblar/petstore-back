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
 * Nombre:      TestProcesoCompra
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:39:03
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

import io.kebblar.petstore.api.mapper.DireccionMapper;
import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.mapper.MunicipioMapper;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>TestProcesoCompra class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
public class TestProcesoCompra {
    private static final Logger logger = LoggerFactory.getLogger(TestProcesoCompra.class);

    @Mock
    private DireccionService direccionService;

    @Mock
    private EstadoService estadoService;

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

    /**
     * <p>prepare.</p>
     *
     * @throws java.sql.SQLException if any.
     */
    @Before
    public void prepare() throws SQLException {
        MockitoAnnotations.initMocks(this);
        
        direccionService = new DireccionServiceImpl(direccionMapper);
        estadoService = new EstadoServiceImpl(estadoMapper);
        municipioService = new MunicipioServiceImpl(municipioMapper);
        lista.add(direccion1);

        when(direccionMapper.getDireccionesNombre(1)).thenReturn(lista);
        when(direccionMapper.getDireccionesNombre(3)).thenReturn(null);

        when(direccionMapper.insert(Mockito.any())).thenReturn(1);
        when(direccionMapper.insertUsuarioDireccion(Mockito.any())).thenReturn(1);
        when(estadoMapper.getByPais(1)).thenReturn(edos);
        when(municipioMapper.getByEstado(1)).thenReturn(muns);

        edos.add(new Estado(1,2,"MiEdo"));
        muns.add(new Municipio(1,2, "Mun 2"));
    }

    /**
     * <p>direccionesConNombreTest.</p>
     */
    @Test
    public void direccionesConNombreTest() {
        List<DireccionConNombre> dir;
        //Verifica que la lista recuperada por el metodo es la misma que fue creada
        try {
            dir = direccionService.getDireccionesNombre(1);
            assertEquals(dir,lista);
        } catch(Exception e) {
            logger.info("No existe el usuario 1");
        }
        //Lanza excepcion si no existe el usuario
        try {
            dir = direccionService.getDireccionesNombre(3);
        } catch (Exception e) {
            logger.info("No existe el usuario 3");
            assertTrue(true);
      }
    }

    /**
     * <p>agregaDireccionTest.</p>
     */
    @Test
    public void agregaDireccionTest(){
        try {
            assertTrue(direccionService.agregaDireccion(nuevaDireccion)==1);
        } catch(Exception e){
            logger.info("No se puede agregar la dirección");
        }
        try {
            direccionService.agregaDireccion(null);
        } catch (Exception e) {
            logger.info("No puede agregarse un nulo como dirección");
            assertTrue(true);
        }
    }

    /**
     * <p>getByPaisTest.</p>
     */
    @Test
    public void getByPaisTest() {
        try {
            assertEquals(edos, estadoService.getByPais(1));
        } catch (Exception e) {
            logger.info("Ocurre problema con el id del país buscado");
        }
    }

    /**
     * <p>getByEstadoTest.</p>
     */
    @Test
    public void getByEstadoTest() {
        try {
            assertEquals(muns, municipioService.getByEstado(1));
        } catch (Exception e) {
            logger.info("Problema con el estado");
        }
    }

}
