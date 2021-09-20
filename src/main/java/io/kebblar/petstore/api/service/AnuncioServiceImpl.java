/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AnuncioServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              20210510_0050 Creación de éste servicio
 *              20210523_2030 Se  agrega  el  metodo  de  elimado
 *              logico
 *              20210528_1159 Se agrega el metodo de busqueda
 *              administracion
 *              20210608_1930 Se agrega  renderizado de imagenes
 *              del servicio de guardado               
 */
package io.kebblar.petstore.api.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.tika.Tika;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import io.kebblar.petstore.api.mapper.AnuncioMediaMapper;
import io.kebblar.petstore.api.mapper.AnuncioMapper;
import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.domain.MascotaValorAtributo;
import io.kebblar.petstore.api.model.domain.AnuncioMedia;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;
import io.kebblar.petstore.api.model.exceptions.FileUploadException;
import io.kebblar.petstore.api.model.exceptions.InternalServerException;
import io.kebblar.petstore.api.model.exceptions.NotFoundException;
import io.kebblar.petstore.api.model.exceptions.RuleException;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.request.AnuncioImagenRequest;
import io.kebblar.petstore.api.model.exceptions.UploadException;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.MascotaValorAtributoRequest;
import io.kebblar.petstore.api.model.request.BusquedaAdministracionRequest;
import io.kebblar.petstore.api.model.request.BusquedaRequest;
import io.kebblar.petstore.api.model.response.AnuncioImagenResponse;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
import io.kebblar.petstore.api.model.response.BusquedaAdministracionResponse;
import io.kebblar.petstore.api.model.response.BusquedaResponse;
import io.kebblar.petstore.api.model.response.PaginacionAnunciosResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import io.kebblar.petstore.api.model.response.MascotaValorAtributoResponse;
import io.kebblar.petstore.api.support.UploadService;
import io.kebblar.petstore.api.utils.AnuncioEstatusEnum;
import io.kebblar.petstore.api.utils.AnuncioUtil;

/**
 * Implementación de la interfaz de servicios para 'Anuncio'.
 *
 * @author  Maria Isabel Contreras Garcia
 *
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 *
 *
 * @see     io.kebblar.petstore.api.model.domain.Anuncio
 * @see     UploadService
 * @see     AnuncioMapper
 * @see     AnuncioMediaMapper
 */
@Service
public class AnuncioServiceImpl implements AnuncioService {
    private static final Logger logger = LoggerFactory.getLogger(AnuncioServiceImpl.class);

    @Value("${app.destination-folder}")
    private String destinationFolder;

    @Value("${app.destination-folder-video}")
    private String destinationFolderVideo;

    @Value("${app.max-file-size}")
    private long max;

    @Value("${app.imagen-tam}")
    private int imagenAltura;

    private final UploadService uploadService;
    private final AnuncioMapper anuncioMapper;
    private final AnuncioMediaMapper anuncioImagenMapper;

    private final Tika tika = new Tika();

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param anuncioMapper Instancia del mapper de la entidad anuncio.
     * @param uploadService Instancia del servicio para subir archivos al sistema.
     * @param anuncioImagenMapper Instancia del mapper que intersecta anuncios con las imagenes que les corresponden.
     */
    public AnuncioServiceImpl(
            AnuncioMapper anuncioMapper,
            UploadService uploadService,
            AnuncioMediaMapper anuncioImagenMapper) {
        this.anuncioMapper = anuncioMapper;
        this.uploadService = uploadService;
        this.anuncioImagenMapper = anuncioImagenMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(
                propagation = Propagation.REQUIRED,
                isolation = Isolation.DEFAULT,
                timeout = 36000,
                rollbackFor = TransactionException.class)
    public AnuncioResponse guardar(AnuncioRequest request, Anuncio anuncioAlta) throws BusinessException {
        String s = request.toString();
        logger.info(s);
        AnuncioUtil.validaCampos(request);
        logger.info("Campos del anuncio correctos");
        Anuncio anuncioBase;
        logger.info("Se validará si los estatus son correctos");
        if(request instanceof ActualizaAnuncioRequest) {
            logger.info("Se trata de una actualización de anuncio");
            try {
                logger.info("Buscando el anuncio en la base de datos");
                anuncioBase = anuncioMapper.getAnuncioById(((ActualizaAnuncioRequest)request).getId());
            } catch (SQLException e) {
                throw new DatabaseException("No se pudo validar el estatus del anuncio");
            }
            if(anuncioBase == null) {
                logger.info("Anuncio no encontrado");
                throw new NotFoundException("El anuncio solicitado no existe");
            }
            if(AnuncioEstatusEnum.ELIMINADO.getId()==anuncioBase.getIdEstatus() || AnuncioEstatusEnum.VENCIDO.getId()==anuncioBase.getIdEstatus()) {
                logger.info("Anuncio se encuentra elminado o vencido");
                throw new RuleException("El anuncio no se encuentra en un estatus valido o ha sido eliminado");
            }
         } else {
            logger.info("Se trata de un nuevo anuncio");
        }
        anuncioAlta.setTitulo(request.getTitulo());
        anuncioAlta.setPrecio(request.getPrecio());
        anuncioAlta.setIdCategoria(request.getIdCategoria());
        anuncioAlta.setDescripcion(request.getDescripcion());
        anuncioAlta.setIdEstatus(AnuncioEstatusEnum.EN_EDICION.getId());
        anuncioAlta.setFechaInicioVigencia(request.getFechaInicioVigencia() != null ? java.util.Date.from(request.getFechaInicioVigencia().atStartOfDay().atZone(ZoneId.of(("America/Mexico_City"))).toInstant()):null);
        anuncioAlta.setFechaFinVigencia(request.getFechaFinVigencia() != null ? java.util.Date.from(request.getFechaFinVigencia().atStartOfDay().atZone(ZoneId.of(("America/Mexico_City"))).toInstant()):null);
        String k = anuncioAlta.toString();
        logger.info("Asignando valores al nuevo anuncio: {} ", k);
        try {
            //Si los datos son correctos, se procede con el guardado o actualización
            if(request instanceof ActualizaAnuncioRequest) {
                logger.info("Se trata de una actualización");
                anuncioAlta.setId(((ActualizaAnuncioRequest)request).getId());
                anuncioAlta.setFechaModificacion(new Date());
                anuncioMapper.update(anuncioAlta);
                anuncioMapper.deleteAtributos(anuncioAlta.getId());
            } else {
                logger.info("Se trata de un nuevo anuncio");
                anuncioAlta.setFolio(AnuncioUtil.generaFolio());
                anuncioAlta.setFechaAlta(new Date());
                anuncioAlta.setFechaModificacion(anuncioAlta.getFechaAlta());
                anuncioMapper.insert(anuncioAlta);
            }

            logger.info("Se actualiza el search_url");
            Integer idGenerado = anuncioAlta.getId();
            anuncioAlta.setSearchUrl(idGenerado + "-" + limpia(request.getTitulo()));
            anuncioMapper.update(anuncioAlta);
            logger.info("fin actualiza search url");

            for(MascotaValorAtributoRequest ar : request.getMascotaValorAtributo()) {
                MascotaValorAtributo aa =  new MascotaValorAtributo();
                aa.setIdAnuncio(anuncioAlta.getId());
                aa.setIdValorAtributo(ar.getIdValorAtributo());
                anuncioMapper.insertAtributo(aa);
                }
            logger.info("Anuncio guardado correctamente, id asociado: {}", anuncioAlta.getId());
            return new AnuncioResponse(anuncioAlta.getId(),anuncioAlta.getFolio());
        }catch (Exception e) {
            throw new TransactionException("Registro fallido. Ocurrió un error durante el guardado de información");
        }
    }

    /**
     * Limpia una cadena de caracteres "raras" y regresa la misma
     * cadena (en minúsculas) sustituyendo las letras "raras" por guiones medios.
     *
     * @param original Cadena original de tipo String
     * @return  Cadena limpia
     */
    public static String limpia(String original) {
        String unEspacio = " ";
        String dosEspacios = "  ";
        String guionMedio = "-";
        String dosGuionesMedios = "--";
        String letrasValidas = "0123456789abcdefghijklmnopqrstuvwxyz-";

        // Quita espacios al inicio y al final. Además, manda a minusculas
        String source = original.trim().toLowerCase();

        int i;
        // Colapsa espacios juntos en un solo espacio
        do {
            i = source.indexOf(dosEspacios);
            source = source.replace(dosEspacios, unEspacio);
        } while (i>0);

        // Cambia espacios simples restantes por guion medio
        source = source.replace(unEspacio, guionMedio);

        // Cambia minúsculas acentuadas por minúsculas sin acento
        // No necesito cambiar las mayúsculas porque la cadena está en lowercase
        source = source.replace('á', 'a');
        source = source.replace('é', 'e');
        source = source.replace('í', 'i');
        source = source.replace('ó', 'o');
        source = source.replace('ú', 'u');
        source = source.replace('ñ', 'n');

        // Cambia lo que NO esté en "letrasValidas" por -
        i = source.length();
        StringBuilder result = new StringBuilder();
        for(int j=0; j<i; j++) {
            char test = source.charAt(j);
            result = (letrasValidas.indexOf(test)<1)?result.append(guionMedio):result.append(test);
        }
        // elimina repeticiones de guiones mendios consecutivos
        source = result.toString();
        do {
            i = source.indexOf(dosGuionesMedios);
            source = source.replace(dosGuionesMedios, guionMedio);
        } while (i>=0);
        return source;
    }

    /** {@inheritDoc} */
    @Override
    public AnuncioResponse confirmarAnuncio(int id, AnuncioResponse response) throws BusinessException {
        try {
            //Si los datos son correctos, se procede con el guardado
            Anuncio anuncio = anuncioMapper.getAnuncioById(id);
            if(AnuncioEstatusEnum.EN_EDICION.getId()!=anuncio.getIdEstatus()
                    && AnuncioEstatusEnum.ACTIVO.getId()!=anuncio.getIdEstatus()
                    && AnuncioEstatusEnum.PUBLICADO.getId()!=anuncio.getIdEstatus()) {
                throw new RuleException("El anuncio no se encuentra en un estatus valido");
            }
            if(!AnuncioUtil.validaFechasPeriodo(anuncio.getFechaInicioVigencia(), anuncio.getFechaFinVigencia())) {
                throw new RuleException("Fechas de vigencia no validas");
            }
            List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(id);
            if(imagenes==null || imagenes.isEmpty()) {
                throw new RuleException("El anuncio debe tener asociada al menos una imagen para confirmar su registro");
            }
            response.setId(anuncio.getId());
            response.setFolio(anuncio.getFolio());
            //Si el anuncio no tiene fechas de vigencia, o solo fecha de fin de vigencia valido pasa a esatus PUBLICADO
            if((anuncio.getFechaInicioVigencia()==null && anuncio.getFechaFinVigencia()==null)
                    || (anuncio.getFechaInicioVigencia()==null && anuncio.getFechaFinVigencia()!=null)) {
                anuncioMapper.actualizaEstatus(id, AnuncioEstatusEnum.PUBLICADO.getId());
                response.setInfo("El anuncio ha sido publicado correctamente.");
                return response;
            }
            //Si el anuncio tiene fechas de inicio de vigencia igual a la fecha actual, pasa a estatus PUBLICADO
            if(anuncio.getFechaInicioVigencia()!=null &&
                    AnuncioUtil.comparafechas(new Date(), anuncio.getFechaInicioVigencia())>=0) {
                anuncioMapper.actualizaEstatus(id, AnuncioEstatusEnum.PUBLICADO.getId());
                response.setInfo("El anuncio ha sido publicado correctamente.");
                return response;
            }
            //Si el anuncio tiene fecha de inicio de vigencia posterior a la fecha actual, pasa a esatus ACTIVO
            if(anuncio.getFechaInicioVigencia()!=null &&
                    AnuncioUtil.comparafechas(new Date(), anuncio.getFechaInicioVigencia())<0) {
                anuncioMapper.actualizaEstatus(id, AnuncioEstatusEnum.ACTIVO.getId());
                response.setInfo("El anuncio ha sido guardado, se publicara en cuanto llegue la fecha solicitada.");
                return response;
            }
        } catch (SQLException e) {
            throw new DatabaseException("Ocurrio un error al confirmar la información.");
        }
        return response;
    }

    /** {@inheritDoc} */
    @Override
    public AnuncioResponse eliminarAnuncio(int id, AnuncioResponse response) throws BusinessException {
        try {
            //Se consulta la informacion del anuncio, para validar estatus
            Anuncio anuncio = anuncioMapper.getAnuncioById(id);
            if(anuncio == null) {
                throw new RuleException("No se encontro informacion");
            }
            if(AnuncioEstatusEnum.ELIMINADO.getId()==anuncio.getIdEstatus()) {
                throw new RuleException("El anuncio ha sido eliminado previamente");
            }
            //Se procede a realizar el eliminado del registro
            anuncioMapper.eliminaAnuncio(id, AnuncioEstatusEnum.ELIMINADO.getId(), new Date());
            response.setId(anuncio.getId());
            response.setFolio(anuncio.getFolio());
        } catch (SQLException e) {
            throw new DatabaseException("Ocurrio un error al tratar de eliminar la información.");
        }
        return response;
    }

    /** {@inheritDoc} */
    @Override
    public AnuncioImagenResponse guardarImagen(int idAnuncio, MultipartFile[] files) throws BusinessException {
        AnuncioImagenResponse air = null;
        for(MultipartFile mpf : files) {
            try {
                air = guardarImagen(idAnuncio, mpf);
            } catch (BusinessException e) {
                logger.info(e.getDetailedMessage());
            }
        }
        return air;
    }

    /** {@inheritDoc} */
    @Override
    public AnuncioImagenResponse guardarImagen(int idAnuncio, MultipartFile file) throws BusinessException {
        String contentType = "no-pude-detectar-el-tipo-mime";
        try {
            contentType = this.tika.detect(file.getInputStream());
        } catch (IOException e) {
            throw new InternalServerException("Error al leer el archivo", e.toString());
        }
        long size = file.getSize();
        if (size > max) {
            throw new FileUploadException(size, max);
        }

        try {
            int tipoMedia=0;
            String carpetaDestino=destinationFolder;
            Anuncio anuncio=anuncioMapper.getAnuncioById(idAnuncio);
            if(anuncio==null || AnuncioEstatusEnum.ELIMINADO.getId()==anuncio.getIdEstatus()) {
                throw new RuleException("No existe el  anuncio para asociar la imagen dada.");
            }
            if(contentType.equals("image/jpg") || contentType.equals("image/jpeg")) {
                tipoMedia=1;
            }else if(contentType.equals("image/png") ) {
                tipoMedia=2;
            }else if(contentType.equals("video/mp4")) {
                tipoMedia=4;
                carpetaDestino=destinationFolderVideo;
            }else if(contentType.equals("video/avi")) {
                tipoMedia=5;
                carpetaDestino=destinationFolderVideo;
            }else {
                throw new FileUploadException("Formato de imagen no valido. Solo se aceptan: jpg, jpeg, png, mp4, avi");
            }
            UploadModel upload = uploadService.storeOne(file, carpetaDestino, max);
            AnuncioMedia imagenEnt= new AnuncioMedia(anuncio.getId(),upload.getNuevoNombre(),tipoMedia, Boolean.FALSE);
            anuncioImagenMapper.insertImagen(imagenEnt);
            //Renderizacion de imagen con marca de agua
            if(tipoMedia!=4 && tipoMedia!=5) {
                AnuncioUtil.renderizarYMarcaDeAgua(destinationFolder,"petstore.com", imagenEnt.getUuid(), imagenAltura);
            }
            return new AnuncioImagenResponse(imagenEnt.getId(),anuncio.getId(),imagenEnt.getUuid(),imagenEnt.getIdTipo(),imagenEnt.getPrincipal());
        }catch (UploadException e) {
            throw new FileUploadException(e.getShortMessage());
        }catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void eliminarImagen(String idImagen) throws BusinessException {
        try {
            int borrados = anuncioImagenMapper.eliminarImagen(idImagen);
            if(borrados<1) throw new RuleException("No hay ninguna imagen cuyo ID sea igual a: "+idImagen);
        } catch(SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<DetalleAnuncioResponse> detalleAllAnuncio() throws BusinessException {
        try {
            List<DetalleAnuncioResponse> wrapper = anuncioMapper.getAllAnuncioDetalle();
            for(DetalleAnuncioResponse dar : wrapper) {
                int id = dar.getId();
                List<MascotaValorAtributoResponse> atributosResponse = anuncioMapper.valorAtributosPorAnuncio(id);
                List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(id);
                List<AnuncioImagenResponse> imagenesResponse = new ArrayList<>();
                for(AnuncioMedia img : imagenes) {
                    imagenesResponse.add(new AnuncioImagenResponse(img.getId(),img.getIdAnuncio(), img.getUuid(), img.getIdTipo(),img.getPrincipal()));
                }
                dar.setAtributos(atributosResponse);
                dar.setImagenes(imagenesResponse);
            }
            return wrapper;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public DetalleAnuncioResponse detalleAnuncio(int id) throws BusinessException {
        try {
            //Se consulta la informacion del anuncio, para validar estatus
            DetalleAnuncioResponse detalleResponse = anuncioMapper.getAnuncioDetalle(id);
            if(detalleResponse == null) {
                throw new RuleException("No se encontro informacion");
            }
            short status = detalleResponse.getIdEstatus();
            if( AnuncioEstatusEnum.ELIMINADO.getId()==status) {
                logger.error("Este anuncio (folio: {}) NO se encuentra ni ACTIVO ni PUBLICADO id: {}", detalleResponse.getFolio(), id);
                throw new RuleException("Anuncio no disponible");
            }
            //Se consulta la informacion de los atributos del anuncio
            List<MascotaValorAtributoResponse> atributosResponse = anuncioMapper.valorAtributosPorAnuncio(id);
            //Se consulta la informacion de las imagenes del anuncio
            List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(id);
            List<AnuncioImagenResponse> imagenesResponse = null;
            if(imagenes!=null && !imagenes.isEmpty()) {
                imagenesResponse = new ArrayList<>();
                for(AnuncioMedia img : imagenes) {
                    imagenesResponse.add(new AnuncioImagenResponse(img.getId(),img.getIdAnuncio(), img.getUuid(), img.getIdTipo(),img.getPrincipal()));
                }
            }
            //Se envía solo lo necesario del detalle del anunio
            detalleResponse.setAtributos(atributosResponse);
            detalleResponse.setImagenes(imagenesResponse);
            return detalleResponse;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginacionAnunciosResponse busquedaAdministracion(BusquedaAdministracionRequest filtros) throws BusinessException, SQLException {
        List<String> cadenasMapper = AnuncioUtil.busquedaFiltros(filtros);
        Map<String, String> mapSql = new HashMap<>();
        mapSql.put("sql", cadenasMapper.get(1));
        mapSql.put("total", cadenasMapper.get(0));

        List<BusquedaAdministracionResponse> anuncios = anuncioMapper.busquedaAnuncio(mapSql);
        List<BusquedaAdministracionResponse> totalAnuncios = anuncioMapper.obtieneCantidad(mapSql);
        PaginacionAnunciosResponse response = new PaginacionAnunciosResponse(totalAnuncios != null ? totalAnuncios.size() : 0, anuncios);

        for (BusquedaAdministracionResponse anuncio:anuncios) {
            anuncio.setDescripcionEstatus(anuncioMapper.obtieneDescPorId(anuncio.getIdEstatus()));
            Categoria objetoCategoria = anuncioMapper.obtieneCategoria(anuncio.getIdCategoria());
            anuncio.setDescripcionCategoria(objetoCategoria.getCategoria());
        }
        return response;
    }

    /** {@inheritDoc} */
    @Override
    public BusquedaResponse busqueda(BusquedaRequest filtros) throws BusinessException, SQLException {
        BusquedaResponse  response = new BusquedaResponse();
        List<String> cadenasMapper  = AnuncioUtil.busqueda(filtros);
        Map<String, String> mapSql = new HashMap<>();
        mapSql.put("sql", cadenasMapper.get(1));
        mapSql.put("total", cadenasMapper.get(0));
        List<DetalleAnuncioResponse> anuncios = anuncioMapper.busquedaFiltro(mapSql);
        List<DetalleAnuncioResponse> totalAnuncios = anuncioMapper.totalAnuncioFiltro(mapSql);

        for (DetalleAnuncioResponse anuncio : anuncios) {
            Categoria objetoCategoria = anuncioMapper.obtieneCategoria(anuncio.getIdCategoria());
            anuncio.setDescCategoria(objetoCategoria.getCategoria());
            List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(anuncio.getId());
            List<AnuncioImagenResponse> imagenesResponse = null;
            if(imagenes!=null && !imagenes.isEmpty()) {
                imagenesResponse = new ArrayList<>();
                for(AnuncioMedia img : imagenes) {
                    imagenesResponse.add(new AnuncioImagenResponse(img.getId(),img.getIdAnuncio(), img.getUuid(), img.getIdTipo(),img.getPrincipal()));
                }
                anuncio.setImagenes(imagenesResponse);
            }
        }

        response.setListaAnuncios(anuncios);
        response.setTotalAnuncios(totalAnuncios != null ? totalAnuncios.size() : 0);

        return response;
    }

    /** {@inheritDoc} */
    @Override
    public void imagenPrincipal(AnuncioImagenRequest imagenRequest) throws BusinessException {
        try {
            Anuncio anuncioBase = anuncioMapper.getAnuncioById(imagenRequest.getIdAnuncio());
            if(anuncioBase==null ||(AnuncioEstatusEnum.ELIMINADO.getId()==anuncioBase.getIdEstatus()
                    || AnuncioEstatusEnum.VENCIDO.getId()==anuncioBase.getIdEstatus()
                    || AnuncioEstatusEnum.CANCELADO.getId()==anuncioBase.getIdEstatus())) {
                throw new RuleException("El anuncio no se encuentra en un estatus valido para ser modificado");
            }
            List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(imagenRequest.getIdAnuncio());
            if(imagenes==null || imagenes.isEmpty()) {
                throw new RuleException("El anuncio no cuenta con imagenenes asociadas");
            }
            AnuncioMedia anuncioSolicitado=anuncioImagenMapper.getImagen(imagenRequest.getUuid());
            if(anuncioSolicitado==null) {
                throw new RuleException("Imagen de anuncio no encontrada");
            }
            for(AnuncioMedia img:imagenes) {
                if(imagenRequest.getUuid().equals(img.getUuid())) {
                    anuncioImagenMapper.actualizaPrincipal(img.getUuid(), Boolean.TRUE);
                }else {
                    anuncioImagenMapper.actualizaPrincipal(img.getUuid(), Boolean.FALSE);
                }
            }
        } catch (SQLException e) {
            logger.info("Error: {}", e.getMessage());
            throw new RuleException("No se pudo validar el estatus del anuncio");

        }
    }

    /** {@inheritDoc} */
    @Override
    @Scheduled(cron = "0 0 2 * * ?") //Se invoca el metodo cada dia
    public void schedulerPublicarAnuncio() throws BusinessException {
        logger.info("Llamando servicio para PUBLICAR los anuncios cuya fecha de inicio de publicacion es el dia de hoy");
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar  calendar=Calendar.getInstance();
        try {
            //1. Se consultan todos los anuncios con estatus "ACTIVO" y con fecha de publicacion al dia de hoy
            String fechaBase=dateFormat.format(calendar.getTime());
            String fechaInicio=fechaBase+" 00:00:00";
            String fechaFin=fechaBase+" 23:59:59";
            logger.info("====> Periodo de busqueda: {}, {} ", fechaInicio, fechaFin);
            List<Anuncio> anuncios = anuncioMapper.anunciosPorPublicar(fechaInicio, fechaFin, AnuncioEstatusEnum.ACTIVO.getId());
            //2. Se cambia el estatus a PUBLICADO
            if(anuncios!=null && !anuncios.isEmpty()) {
                for(Anuncio a:anuncios) {
                     anuncioMapper.actualizaEstatus(a.getId(), AnuncioEstatusEnum.PUBLICADO.getId());
                }
                logger.info("====> Total de anuncios que pasaron a PUBLICADOS del dia {}",anuncios.size());
            }else {
                 logger.info("====> No se encontraron anuncios para pasar a PUBLICAR del periodo {} al {}", fechaInicio,fechaFin);
            }
        } catch (SQLException e) {
             logger.error("====>Ocurrio un error durante el proceso de PUBLICAR anuncios: {}", e.getMessage());
        }

        logger.info("Llamando servicio de cambiar estatus a VENCIDO los anuncios cuya fecha fin de publicacion fue el dia de ayer");
        try {
            calendar.add(Calendar.DATE,-1);
            //1. Se consultan los anuncios con estatus PUBLICADO con fecha de publicacion final al día de ayer
            String fechaFin=dateFormat.format(calendar.getTime())+" 23:59:59";
            logger.info("====> Fecha fin de publicacion: {}", fechaFin);
            List<Anuncio> anuncios = anuncioMapper.anunciosPorVencer(fechaFin, AnuncioEstatusEnum.PUBLICADO.getId());
            //2. Se cambia el estatus a VENCIDO
            if(anuncios!=null && !anuncios.isEmpty()) {
                for(Anuncio a:anuncios) {
                     anuncioMapper.actualizaEstatus(a.getId(), AnuncioEstatusEnum.VENCIDO.getId());
                }
                logger.info("====> Total de anuncios que pasaron a VENCIDOS del dia {}", anuncios.size());
            }else {
                logger.info("====> No se encontraron anuncios de VENCIMIENTO del dia {}", fechaFin);
            }
        } catch (SQLException e) {
             logger.error("====>Ocurrio un error durante el proceso de VENCIMIENTO de anuncios: {}", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    public void updateSearchUrl() {
        try {
            List<Anuncio> anuncios = anuncioMapper.getAll();
            for(Anuncio anuncio : anuncios) {
                String limpia = limpia(anuncio.getTitulo());
                Integer id = anuncio.getId();
                anuncio.setSearchUrl(id+"-"+limpia);
                anuncioMapper.update(anuncio);
                logger.info("actualizando el searchurl del anuncio {} con la info: {}", anuncio.getId(), limpia);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<DetalleAnuncioResponse> getBySearchUrl(String searchUrl) throws BusinessException {
        if(searchUrl==null || searchUrl.trim().length()<1 || "all".equals(searchUrl)) searchUrl="%";
        try {
            List<Anuncio> lista = anuncioMapper.getBySearchUrl(searchUrl);
            if(lista==null || lista.isEmpty()) {
                throw new NotFoundException(searchUrl);
            }
            List<DetalleAnuncioResponse> respuesta = new ArrayList<>();
            DetalleAnuncioResponse detalle = null;
            for(Anuncio anuncio : lista) {
                int id = anuncio.getId();
                detalle = this.detalleAnuncio(id);
                respuesta.add(detalle);
            }
            return respuesta;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
