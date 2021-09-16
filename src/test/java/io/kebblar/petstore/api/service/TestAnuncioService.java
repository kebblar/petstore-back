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
 * Nombre:      TestAnuncioService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:37:41
 */
package io.kebblar.petstore.api.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.kebblar.petstore.api.model.exceptions.DatabaseException;
import io.kebblar.petstore.api.model.exceptions.RuleException;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.request.*;
import io.kebblar.petstore.api.model.response.*;
import io.kebblar.petstore.api.utils.AnuncioEstatusEnum;
import io.kebblar.petstore.api.utils.AnuncioUtil;
import org.apache.commons.lang.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Assert;
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
import io.kebblar.petstore.api.support.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>TestAnuncioService class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
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
    private static final Logger logger = LoggerFactory.getLogger(TestAnuncioService.class);
    private Anuncio a;
    private Anuncio anuncio;
    /**
     * <p>pedro.</p>
     *
     * @throws java.sql.SQLException if any.
     */
    @Before
    public void pedro() throws SQLException {
        this.anuncioService= new AnuncioServiceImpl(anuncioMapper, uploadService, anuncioImagenMapper);
        this.atributos = new ArrayList<>();
        this.atributos.add(new MascotaValorAtributoRequest(1,1));
        this.a = new Anuncio();
        this.actualizaAnuncioRequest = new ActualizaAnuncioRequest(1,
                "Titulo","descripcion", null, null,
                1, BigDecimal.ONE, atributos);
        this.anuncio = new Anuncio(1, 2, "21062317310001", "Galas verdes", "Bonitos Weimaraner verdes",
                new BigDecimal(234), new Date(), new Date(), DateUtils.addMonths(new Date(), 1), new Date(), null, (short) 1, "url-search");
    }

    /**
     * Escenario donde se trata de actualizar un anuncio existente.
     *
     * @throws java.lang.Exception Cuando ocurre una excepción en el método guardar de {@link AnuncioService}.
     */
    @Test
    public void actualizacion() throws Exception{
      when(anuncioMapper.getAnuncioById(1)).thenReturn(
            new Anuncio(1, 2, "21062317310001", "Gato de colores", "Gato que se despinto con cloro",
            new BigDecimal(234), new Date(), new Date(), new Date(), new Date(), null, (short) 3, "url-search"));
        AnuncioResponse response = anuncioService.guardar(actualizaAnuncioRequest,a);
        assertEquals(30752, response.getHash());
    }

    /**
     * Escenario donde se crea un anuncio nuevo.
     * @throws Exception No se lanzan excepciones
     */
    @Test
    public void testNuevoAnuncio() throws Exception{
        AnuncioRequest ar = new AnuncioRequest("Bonitas Galas moradas", "Galas pintadas de morado",
                LocalDate.now(), LocalDate.now().plusMonths(2), 1, BigDecimal.ONE, atributos);
        a.setId(1);
        assertEquals(1, anuncioService.guardar(ar, a).getId());
    }

    /**
     * Escenario donde el id que se pasa para ser actualizado no es valido.
     * @throws Exception Se espera una excepcion {@link DataBaseException}
     */
    @Test
    public void testNuevoAnuncioFailed() throws Exception{
        when(anuncioMapper.getAnuncioById(1)).thenThrow(SQLException.class);
        try{
            anuncioService.guardar(actualizaAnuncioRequest,a);
        }catch (DatabaseException e){
            assertTrue(true);
        }
    }

    /**
     * Escenario donde se trata de actualizar un anuncio que no existe.
     *
     * @throws java.lang.Exception Se espera {@link BusinessException}
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
                anuncioService.guardar(actualizaAnuncioRequest,a);
            }catch (BusinessException e) {
                assertEquals(e.getLocalExceptionNumber() , 1013);
            }
    }

    /**
     * <p>busqueda.</p>
     *
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     * @throws java.sql.SQLException if any.
     */
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

    /**
     * <p>busquedaUsuario.</p>
     *
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     * @throws java.sql.SQLException if any.
     */
    @Test
    public void busquedaUsuario() throws BusinessException, SQLException {
        try {
            List<DetalleAnuncioResponse> anuncios = new ArrayList<>();
            for (int a = 0; a < 10; a++) {
                DetalleAnuncioResponse anuncio = new DetalleAnuncioResponse();
                anuncio.setId(a);
                anuncio.setFolio("Folio" + a);
                anuncio.setDescripcion("Descricpion" + a);
                anuncio.setIdCategoria(1);
                anuncios.add(anuncio);
            }
            Categoria categoria = new Categoria();
            categoria.setActivo(1);
            categoria.setCategoria("Canino");
            categoria.setId(1);
            List<AnuncioMedia> media = new ArrayList<>();
            media.add(new AnuncioMedia(1, "str", 1, true));
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
            assertEquals(response.getListaAnuncios().size(), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Caso en el que el anuncio fue encontrado, pero se encuentra eliminado.
     * @throws Exception Se espera {@link RuleException} cuando el anuncio ya se ha eliminado.
     */
    @Test(expected = RuleException.class)
    public void testAnuncioEliminado() throws Exception{
        when(anuncioMapper.getAnuncioById(1)).thenReturn(
                new Anuncio(1, 2, "21062317310001", "Gato de colores", "Gato que se despinto con cloro",
                        new BigDecimal(234), new Date(), new Date(), new Date(), new Date(), null, (short) 5, "url-search"));
        anuncioService.guardar(actualizaAnuncioRequest,a);
    }

    /**
     * Caso en el que el anuncio fue encontrado, pero se encuentra vencido.
     * @throws Exception Se espera {@link RuleException} cuando el anuncio ya se ha vencido.
     */
    @Test(expected = RuleException.class)
    public void testAnuncioVencido() throws Exception{
        when(anuncioMapper.getAnuncioById(1)).thenReturn(
                new Anuncio(1, 2, "21062317310001", "Gato de colores", "Gato que se despinto con cloro",
                        new BigDecimal(234), new Date(), new Date(), new Date(), new Date(), null, (short) 4, "url-search"));
        anuncioService.guardar(actualizaAnuncioRequest,a);
    }

    /**
     * <p>detalleAnuncio.</p>
     *
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     * @throws java.sql.SQLException if any.
     */
    @Test
    public void detalleAnuncio() throws Exception {
        // Happy path
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
            media.add(new AnuncioMedia(1, "str", 1, true));
            when(anuncioMapper.getAnuncioDetalle(Mockito.anyInt())).thenReturn(anuncioResponse1);
            when(anuncioImagenMapper.getImagenes(Mockito.anyInt())).thenReturn(media);
            DetalleAnuncioResponse detalleAnuncioResponse = anuncioService.detalleAnuncio(1);
            System.out.print(detalleAnuncioResponse);
            assert(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Cuando el id no existe
            when(anuncioMapper.getAnuncioDetalle(1)).thenReturn(null);
            anuncioService.detalleAnuncio(1);
        } catch (RuleException r) {
            assertTrue(true);
        }
        // Cuando ocurre error con la DB
        try {
            when(anuncioMapper.getAnuncioDetalle(1)).thenThrow(SQLException.class);
            anuncioService.detalleAnuncio(1);
        } catch (DatabaseException b) {
            assertTrue(true);
        }
    }

    /**
     * Caso en el que el anuncio se encuentra en un status invalido.
     * @throws Exception RuleException, pues los status son invalidos.
     */
    @Test
    public void testConfirmarAnuncioFailed() throws Exception{
        when(anuncioMapper.getAnuncioById(1)).thenReturn(anuncio);
        try {
            anuncio.setIdEstatus(AnuncioEstatusEnum.ELIMINADO.getId());
            anuncioService.confirmarAnuncio(1, new AnuncioResponse());
        }catch (RuleException r){
            assertTrue(true);
        }try {
            anuncio.setIdEstatus(AnuncioEstatusEnum.VENCIDO.getId());
            anuncioService.confirmarAnuncio(1, new AnuncioResponse());
        }catch (RuleException r){
            assertTrue(true);
        }try {
            anuncio.setIdEstatus(AnuncioEstatusEnum.CANCELADO.getId());
            anuncioService.confirmarAnuncio(1, new AnuncioResponse());
        }catch (RuleException r){
            assertTrue(true);
        }
    }

    /**
     * Verifica que si un anuncio cuenta con los estatus validos este es actualizado correctamente
     * @throws Exception No se lanza
     */
    @Test
    public void testConfirmaAnuncio() throws Exception{
        when(anuncioMapper.getAnuncioById(1)).thenReturn(anuncio);
        List<AnuncioMedia> imagenes = new ArrayList<>();
        imagenes.add(new AnuncioMedia());
        when(anuncioImagenMapper.getImagenes(1)).thenReturn(imagenes);
        anuncio.setIdEstatus(AnuncioEstatusEnum.EN_EDICION.getId());
        AnuncioResponse ar = new AnuncioResponse();
        assertEquals(1, anuncioService.confirmarAnuncio(1, ar).getId());
        anuncio.setIdEstatus(AnuncioEstatusEnum.PUBLICADO.getId());
        assertEquals(1, anuncioService.confirmarAnuncio(1, ar).getId());
        anuncio.setIdEstatus(AnuncioEstatusEnum.ACTIVO.getId());
        assertEquals(1, anuncioService.confirmarAnuncio(1, ar).getId());
    }

    /**
     * Se cubren los casos en los que la asignacion de confirmacion de un anuncio puede llegar a fallar.
     * @throws Exception Se lanzan en caso de fallas en el flujo del algoritmo.
     */
    @Test
    public void testFallaConfirmacion() throws Exception{
        when(anuncioMapper.getAnuncioById(1)).thenReturn(anuncio);
        try {
            //Caso en el que el anuncio no tiene imagenes (es nulo).
            when(anuncioImagenMapper.getImagenes(1)).thenReturn(null);
            anuncio.setIdEstatus(AnuncioEstatusEnum.EN_EDICION.getId());
            anuncioService.confirmarAnuncio(1, new AnuncioResponse());
        } catch (RuleException r){
            assertTrue(true);
        }
        //Caso en el que el anuncio no tiene imagenes (es vacio).
        List<AnuncioMedia> imagenes = new ArrayList<>();
        when(anuncioImagenMapper.getImagenes(1)).thenReturn(imagenes);
        anuncio.setIdEstatus(AnuncioEstatusEnum.EN_EDICION.getId());
        try {
            anuncioService.confirmarAnuncio(1, new AnuncioResponse());
        } catch (RuleException r){
            assertTrue(true);
        }
        //Caso en el que hay fechas incorrectas
        anuncio.setFechaInicioVigencia(DateUtils.addMonths(new Date(), 1));
        anuncio.setFechaFinVigencia(new Date());
        try {
            anuncioService.confirmarAnuncio(1, new AnuncioResponse());
        } catch (RuleException r){
            assertTrue(true);
        } try {
            // Caso en el que ocurre un error en la consulta al mapper
            when(anuncioMapper.getAnuncioById(1)).thenThrow(SQLException.class);
            anuncioService.confirmarAnuncio(1, new AnuncioResponse());
        } catch (DatabaseException e) {
            assertTrue(true);
        }
    }

    /**
     * Cubre los casos en los que se preveen fechas a futuro para la publicacion de un anuncio.
     * @throws Exception No falla este test.
     */
    @Test
    public void testConfirmarFuturo() throws Exception {
        when(anuncioMapper.getAnuncioById(1)).thenReturn(anuncio);
        List<AnuncioMedia> imagenes = new ArrayList<>();
        imagenes.add(new AnuncioMedia());
        when(anuncioImagenMapper.getImagenes(1)).thenReturn(imagenes);
        // Caso en el que el anuncio tiene una fecha de publicacion programada
        anuncio.setIdEstatus(AnuncioEstatusEnum.EN_EDICION.getId());
        anuncio.setFechaInicioVigencia(DateUtils.addMonths(new Date(), 1));
        anuncio.setFechaFinVigencia(DateUtils.addMonths(new Date(), 2));
        AnuncioResponse ar = new AnuncioResponse();
        assertEquals(1, anuncioService.confirmarAnuncio(1, ar).getId());
        // Caso en el que la fecha de inicio es nula
        anuncio.setFechaInicioVigencia(null);
        assertEquals(1, anuncioService.confirmarAnuncio(1, ar).getId());

    }

    /**
     * Prueba los casos en los que elimina puede fallar.
     * @throws Exception Se lanza cuando hay un problema en la eliminacion.
     */
    @Test
    public void testEliminaAnuncio() throws Exception{
        try {
            // El anuncio no existe
            when(anuncioMapper.getAnuncioById(1)).thenReturn(null);
            anuncioService.eliminarAnuncio(1, new AnuncioResponse());
        } catch (RuleException r){
            assertTrue(true);
        }
        try {
            // El anuncio existe, pero ya se elimino
            when(anuncioMapper.getAnuncioById(1)).thenReturn(anuncio);
            anuncio.setIdEstatus(AnuncioEstatusEnum.ELIMINADO.getId());
            anuncioService.eliminarAnuncio(1, new AnuncioResponse());
        } catch (RuleException r){
            assertTrue(true);
        }
        try {
            // Cuando no se puede conectar con la DB
            when(anuncioMapper.getAnuncioById(1)).thenThrow(SQLException.class);
            anuncioService.eliminarAnuncio(1, new AnuncioResponse());
        } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

    /**
     * Cuando si se puede eliminar el anuncio.
     * @throws Exception No es lanzada.
     */
    @Test
    public void testEliminaHappyPath() throws Exception {
        when(anuncioMapper.getAnuncioById(1)).thenReturn(anuncio);
        AnuncioResponse ar = new AnuncioResponse();
        anuncioService.eliminarAnuncio(1, ar);
        assertEquals(anuncio.getFolio(), ar.getFolio());
    }

    @Test
    public void testEliminarImagen() throws Exception {
        try {
            when(anuncioImagenMapper.eliminarImagen("aaaa")).thenReturn(0);
            anuncioService.eliminarImagen("aaaa");
        } catch (RuleException e) {
            assertTrue(true);
        }
        try {
            when(anuncioImagenMapper.eliminarImagen("aaaa")).thenThrow(SQLException.class);
            anuncioService.eliminarImagen("aaaa");
        } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

    @Test
    public void eliminaImagen() throws Exception {
        try {
            when(anuncioImagenMapper.eliminarImagen("x")).thenReturn(0);
            anuncioService.eliminarImagen("x");
        } catch (RuleException t){
            assertTrue(true);
        }
        try {
            when(anuncioImagenMapper.eliminarImagen("x")).thenThrow(SQLException.class);
            anuncioService.eliminarImagen("x");
        } catch (DatabaseException d) {
            assertTrue(true);
        }
    }

    @Test
    public void testDetalleAllAnuncio() throws Exception {
        DetalleAnuncioResponse d = new DetalleAnuncioResponse();
        d.setId(1);

        List<MascotaValorAtributoResponse> mvr = new ArrayList<>();
        mvr.add(new MascotaValorAtributoResponse(1,1,"abc", 1, "atributo"));
        List<AnuncioMedia> am = new ArrayList<>();
        am.add(new AnuncioMedia(1, "str", 1, true));
        List<DetalleAnuncioResponse> ld = new ArrayList<>();
        ld.add(d);

        // HappyPath
        when(anuncioMapper.valorAtributosPorAnuncio(1)).thenReturn(mvr);
        when(anuncioImagenMapper.getImagenes(1)).thenReturn(am);
        when(anuncioMapper.getAllAnuncioDetalle()).thenReturn(ld);
        anuncioService.detalleAllAnuncio();
        assertTrue(true);

        //Cuando hay error en el mapper
        try {
            when(anuncioMapper.getAllAnuncioDetalle()).thenThrow(SQLException.class);
            anuncioService.detalleAllAnuncio();
        } catch (DatabaseException v) {
            assertTrue(true);
        }
    }

}


