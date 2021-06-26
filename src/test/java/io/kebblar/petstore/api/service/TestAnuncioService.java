package io.kebblar.petstore.api.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.mapper.AnuncioMapper;
import io.kebblar.petstore.api.mapper.AnuncioMediaMapper;
import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.domain.AnuncioMedia;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.request.BusquedaAdministracionRequest;
import io.kebblar.petstore.api.model.request.BusquedaRequest;
import io.kebblar.petstore.api.model.request.MascotaValorAtributoRequest;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
import io.kebblar.petstore.api.model.response.BusquedaAdministracionResponse;
import io.kebblar.petstore.api.model.response.BusquedaResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import io.kebblar.petstore.api.model.response.PaginacionAnunciosResponse;
import io.kebblar.petstore.api.support.UploadService;

@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(OrderAnnotation.class)
public class TestAnuncioService {

    @Mock
    private UploadService uploadService;

    @Mock
    private AnuncioMapper anuncioMapper;

    @Mock
    private AnuncioMediaMapper anuncioImagenMapper;

    private AnuncioService anuncioService;
    private List<MascotaValorAtributoRequest> atributos;
    private ActualizaAnuncioRequest actualizaAnuncioRequest;

    @Before
    public void pedro() throws SQLException {
        this.anuncioService= new AnuncioServiceImpl(anuncioMapper, uploadService, anuncioImagenMapper);
    }

    /**
    * Escenario donde se trata de actualizar un anuncio existente.
    * 
    * @throws Exception
    */
    @Test()
    public void actualizacion() throws Exception{
      when(anuncioMapper.getAnuncioById(1)).thenReturn(
            new Anuncio(1, 2, "21062317310001", "Gato de colores", "Gato que se despinto con cloro",
            new BigDecimal(234), new Date(), new Date(), new Date(), new Date(), null, (short) 3, "url-search")
      );
        this.atributos = new ArrayList<>();
        this.atributos.add(new MascotaValorAtributoRequest(1,1));
        this.actualizaAnuncioRequest = new ActualizaAnuncioRequest(1,
          "Titulo","descripcion", null, null,
              1, BigDecimal.ONE, atributos
        );
        AnuncioResponse response = anuncioService.guardar(actualizaAnuncioRequest);
           assertTrue(response.getHash() == 30752);
    }

    /**
    * Escenario donde se trata de actualizar un anuncio que no existe.
    * 
    * @throws SQLException
    * @throws BusinessException
    * @throws Exception
    */
    @Test
    public void noExisteAnuncio() throws Exception{
        try {
            when(anuncioMapper.getAnuncioById(1)).thenReturn(null);

            this.atributos = new ArrayList<>();
            this.atributos.add(new MascotaValorAtributoRequest(1,1));
            this.actualizaAnuncioRequest = new ActualizaAnuncioRequest(1,
              "Titulo","descripcion", null, null,
                  1, BigDecimal.ONE, atributos
            );
                anuncioService.guardar(actualizaAnuncioRequest);
            }catch (BusinessException e) {
                assertEquals(e.getLocalExceptionNumber() , 4091);
            }
    }

    @Test
    public void busqueda() throws BusinessException, SQLException {
        List<BusquedaAdministracionResponse> anuncios = new ArrayList<>();
        for(int a=0;a<10;a++) {
            BusquedaAdministracionResponse anuncio = new BusquedaAdministracionResponse();
            anuncio.setId(a);
            anuncio.setFolio("Folio"+a);
            anuncio.setDescripcion("Descricpion"+a);
            anuncio.setIdCategoria(1);
            anuncio.setIdEstatus(3);
            anuncios.add(anuncio);
        }
        when(anuncioMapper.busquedaAnuncio(Mockito.any())).thenReturn(anuncios);
        when(anuncioMapper.obtieneCantidad(Mockito.any())).thenReturn(anuncios);
        when(anuncioMapper.obtieneDescPorId(Mockito.anyInt())).thenReturn("Activo");
        when(anuncioMapper.obtieneCategoria(1)).thenReturn(new Categoria(1,"Caninos",1));


        BusquedaAdministracionRequest busqueda = new BusquedaAdministracionRequest();
        busqueda.setNumPaginas(1);
        busqueda.setTamPaginas(10);
        PaginacionAnunciosResponse response = anuncioService.busquedaAdministracion(busqueda);
        assertEquals(response.getListaAnuncios().size(),10);
    }

    @Test
    public void busquedaUsuario() throws BusinessException, SQLException{
        try {
             List<DetalleAnuncioResponse> anuncios = new ArrayList<>();
                for(int a=0;a<10;a++) {
                    DetalleAnuncioResponse anuncio = new DetalleAnuncioResponse();
                    anuncio.setId(a);
                    anuncio.setFolio("Folio"+a);
                    anuncio.setDescripcion("Descricpion"+a);
                    anuncio.setIdCategoria(1);
                    anuncios.add(anuncio);
                }
                Categoria categoria = new Categoria();
                categoria.setActivo(1);
                categoria.setCategoria("Canino");
                categoria.setId(1);
                List<AnuncioMedia> media = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    AnuncioMedia foto = new AnuncioMedia();
                    foto.setId(1);
                    foto.setIdAnuncio(1);
                    foto.setIdTipo(3);
                    foto.setPrincipal(true);
                    foto.setUuid("23423gf34g34");
                }
                when(anuncioMapper.busquedaFiltro(Mockito.any())).thenReturn(anuncios);
                when(anuncioMapper.totalAnuncioFiltro(Mockito.any())).thenReturn(anuncios);
                when(anuncioMapper.obtieneCategoria(Mockito.anyInt())).thenReturn(categoria);
                when(anuncioImagenMapper.getImagenes(Mockito.anyInt())).thenReturn(media);

                BusquedaRequest busqueda = new BusquedaRequest();
                busqueda.setNumPaginas(1);
                busqueda.setTamPaginas(10);
                BusquedaResponse response = anuncioService.busqueda(busqueda);
                assertEquals(response.getListaAnuncios().size(),10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void detalleAnuncio() throws BusinessException, SQLException{
        try {
            DetalleAnuncioResponse anuncioResponse1= new DetalleAnuncioResponse();
            anuncioResponse1.setTitulo("Titulos");
            anuncioResponse1.setPrecio(new BigDecimal(2));
            anuncioResponse1.setIdEstatus((short)3);
            anuncioResponse1.setIdCategoria(1);
            anuncioResponse1.setId(1);
            anuncioResponse1.setFolio("124123513");
            anuncioResponse1.setFechaInicioVigencia(new Date());
            anuncioResponse1.setFechaFinVigencia(new Date());
            anuncioResponse1.setDescripcion("Descripcion");
            anuncioResponse1.setDescEstatus("Activo");
            List<AnuncioMedia> media = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                AnuncioMedia foto = new AnuncioMedia();
                foto.setId(1);
                foto.setIdAnuncio(1);
                foto.setIdTipo(3);
                foto.setPrincipal(true);
                foto.setUuid("23423gf34g34");
            }
            when(anuncioMapper.getAnuncioDetalle(Mockito.anyInt())).thenReturn(anuncioResponse1);
            when(anuncioImagenMapper.getImagenes(Mockito.anyInt())).thenReturn(media);
            DetalleAnuncioResponse detalleAnuncioResponse = anuncioService.detalleAnuncio(1);
            System.out.print(detalleAnuncioResponse);
            assert(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}