package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.AtributoMapper;
import io.kebblar.petstore.api.mapper.CategoriaAtributoMapper;
import io.kebblar.petstore.api.mapper.CategoriaMapper;
import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.mapper.EstatusAnuncioMapper;
import io.kebblar.petstore.api.mapper.MediaTipoMapper;
import io.kebblar.petstore.api.mapper.MunicipioMapper;
import io.kebblar.petstore.api.mapper.PaisMapper;
import io.kebblar.petstore.api.mapper.ValorAtributoMapper;
import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.domain.EstatusAnuncio;
import io.kebblar.petstore.api.model.domain.MediaTipo;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.model.domain.ValorAtributo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCatalogos {
    private static final Logger logger = LoggerFactory.getLogger(TestCatalogos.class);

    @Mock
    private PaisMapper paisMapper;

    @Mock
    private EstadoMapper estadoMapper;

    @Mock
    private MunicipioMapper municipioMapper;

    @Mock
    private EstatusAnuncioMapper estatusAnuncioMapper;

    @Mock
    private MediaTipoMapper mediaTipoMapper;

    @Mock
    private CategoriaMapper categoriaMapper;

    @Mock
    private AtributoMapper atributoMapper;

    @Mock
    private ValorAtributoMapper valorAtributoMapper;

    @Mock
    private CategoriaAtributoMapper categoriaAtributoMapper;

    @Mock
    private PaisService paisService;

    @Mock
    private EstadoService estadoService;

    @Mock
    private MunicipioService municipioService;

    @Mock
    private EstatusAnuncioService estatusAnuncioService;

    @Mock
    private MediaTipoService mediaTipoService;

    @Mock
    private CategoriaService categoriaService;

    @Mock
    private AtributoService atributoService;

    @Mock
    private CategoriaAtributoService categoriaAtributoService;

    @Mock
    private ValorAtributoService valorAtributoService;

    private Pais pais;
    private List<Estado> estados = new ArrayList<>();
    private List<Municipio> municipios = new ArrayList<>();
    private EstatusAnuncio estatus;
    private MediaTipo mediaTipo;
    private Categoria categoria;
    private Atributo atributo;
    private ValorAtributo valorAtributo;

    @Before
    public void prepare() throws Exception {

        paisService = new PaisServiceImpl(paisMapper);
        estadoService = new EstadoServiceImpl(estadoMapper);
        municipioService = new MunicipioServiceImpl(municipioMapper);
        estatusAnuncioService = new EstatusAnuncioServiceImpl(estatusAnuncioMapper);
        mediaTipoService = new MediaTipoServiceImpl(mediaTipoMapper);
        categoriaService = new CategoriaServiceImpl(categoriaMapper);
        categoriaAtributoService = new  CategoriaAtributoServiceImpl(categoriaAtributoMapper);
        atributoService = new AtributoServiceImpl(atributoMapper);
        valorAtributoService = new ValorAtributoServiceImpl(valorAtributoMapper);
        pais = new  Pais(1, "México");
        estatus = new EstatusAnuncio(1,"ACTIVO");
        mediaTipo = new  MediaTipo(1,"JPG",1);
        categoria = new Categoria(1,"CANINOS", 1);
        atributo = new Atributo(1,"PESO",1);
        valorAtributo = new ValorAtributo(1,1,"10 - 20 KILOS",1);
        estados.add(new Estado(1,1,"VERACRUZ"));
        estados.add(new Estado(2,1,"TABASCO"));
        municipios.add(new Municipio(1,1, "ALVARADO"));
        municipios.add(new Municipio(1,1, "BOCA DEL RIO"));
        when(paisMapper.getById(1)).thenReturn(pais);
        when(estadoMapper.getByPais(1)).thenReturn(estados);
        when(municipioMapper.getByEstado(1)).thenReturn(municipios);
        when(estatusAnuncioMapper.getById(1)).thenReturn(estatus);
        when(mediaTipoMapper.getById(1)).thenReturn(mediaTipo);
        when(categoriaMapper.getById(1)).thenReturn(categoria);
       // when(categoriaAtributoMapper.getAtributosFaltantesByIdCategoria(1).get(0)).thenReturn(atributo);
        when(atributoMapper.getById(1)).thenReturn(atributo);
        when(valorAtributoMapper.getById(1)).thenReturn(valorAtributo);


    }

    @Test
    public void getEstadosByPaisTest() {
        try {
            assertEquals(estados, estadoService.getByPais(1));
        } catch (Exception e) {
            logger.info("Ocurre problema con el id del país buscado");
        }
    }

    @Test
    public void getMunicipiosByEstadoTest() {
        try {
            assertEquals(municipios, municipioService.getByEstado(1));
        } catch (Exception e) {
            logger.info("Problema con el estado");
        }
    }

    @Test
    public void getPaisById() {
        try {
            assertEquals(pais, paisService.getById(1));
        } catch (Exception e) {
            logger.info("Problema con el pais");
        }
    }

   @Test
    public void getEstatusById() {
        try {
            assertEquals(estatus, estatusAnuncioService.getById(1));
        } catch (Exception e) {
            logger.info("Problema con el estatus");
        }
    }

   @Test
   public void getMediatipoById() {
       try {
           assertEquals(mediaTipo, mediaTipoService.getById(1));
       } catch (Exception e) {
           logger.info("Problema con el media");
       }
   }

   @Test
   public void getCategoriaById() {
       try {
           assertEquals(categoria, categoriaService.getById(1));
       } catch (Exception e) {
           logger.info("Problema con el categoria");
       }
   }

   @Test
   public void getAtributoById() {
       try {
           assertEquals(atributo, atributoService.getById(1));
       } catch (Exception e) {
           logger.info("Problema con el atributo");
       }
   }

   @Test
   public void getValorAtributoyId() {
       try {
           assertEquals(valorAtributo, valorAtributoService.getById(1));
       } catch (Exception e) {
           logger.info("Problema con el valor");
       }
   }



}
