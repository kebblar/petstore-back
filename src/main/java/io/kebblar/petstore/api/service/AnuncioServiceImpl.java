/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioServiceImpl.java
 * Tipo:        Clase
 * AUTOR:       Maria Isabel Contreras Garcia (MICG)
 * Fecha:       Jueves 20 de Mayo de 2021 (23_39)
 *
 * Historia:    .
 *              20210510_0050 Creación de éste servicio
 *              20210523_2030 Se  agrega  el  metodo  de  elimado 
 *              logico
 *              20210528_1159 Se agrega el metodo de busqueda
 *              administracion
 *
 */
package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
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
import io.kebblar.petstore.api.model.response.ValorAtributoResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import io.kebblar.petstore.api.utils.AnuncioCategoriaEnum;
import io.kebblar.petstore.api.support.UploadService;
import io.kebblar.petstore.api.utils.AnuncioEstatusEnum;
import io.kebblar.petstore.api.utils.AnuncioUtil;

/**
 * <p>Implementación de la interfaz de servicios para 'Anuncio'.
 * 
 * @author  Maria Isabel Contreras Garcia
 * @see     io.kebblar.petstore.api.model.domain.Anuncio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Service
public class AnuncioServiceImpl implements AnuncioService{

    private static final Logger logger = LoggerFactory.getLogger(AnuncioServiceImpl.class);

    @Value("${app.destination-folder}")
    private String destinationFolder;

    @Value("${app.max-file-size}")
    private long max;

    private final UploadService uploadService;
    private AnuncioMapper anuncioMapper;
    private AnuncioMediaMapper anuncioImagenMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param anuncioMapper mapper utilizado para llamar a metodos de persistencia
     */
    public AnuncioServiceImpl(AnuncioMapper anuncioMapper, UploadService uploadService,
    		AnuncioMediaMapper anuncioImagenMapper) {
        this.anuncioMapper = anuncioMapper;
        this.uploadService = uploadService;
        this.anuncioImagenMapper = anuncioImagenMapper;
    }
    
	@Override
	@Transactional(
	            propagation = Propagation.REQUIRED, 
	            isolation = Isolation.DEFAULT,
	            timeout = 36000, 
	            rollbackFor = TransactionException.class)
	public AnuncioResponse guardar(AnuncioRequest request) throws BusinessException {
		logger.info(request.toString());
		validaCampos(request);
		//Se valida si los estatus son correctos
		if(request instanceof ActualizaAnuncioRequest) {
			try {
				Anuncio anuncioBase = anuncioMapper.getAnuncioById(((ActualizaAnuncioRequest)request).getId());
				if(AnuncioEstatusEnum.ELIMINADO.getId()==anuncioBase.getIdEstatus() 
						|| AnuncioEstatusEnum.VENCIDO.getId()==anuncioBase.getIdEstatus()) {
					throw new BusinessException("Error de datos","El anuncio no se encuentra en un estatus valido o ha sido eliminado",4091,"CVE_4091",HttpStatus.CONFLICT);
				}
			} catch (SQLException e) {
				throw new BusinessException("Error de datos","No se pudo validar el estatus del anuncio",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
		}
		Anuncio anuncioAlta= new Anuncio();
		anuncioAlta.setTitulo(request.getTitulo());
		anuncioAlta.setPrecio(request.getPrecio());
		anuncioAlta.setIdCategoria(request.getIdCategoria());
		anuncioAlta.setDescripcion(request.getDescripcion());
		anuncioAlta.setIdEstatus(AnuncioEstatusEnum.EN_EDICION.getId());
		anuncioAlta.setFechaInicioVigencia(request.getFechaInicioVigencia() != null ? 
				java.util.Date.from(request.getFechaInicioVigencia().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
				:null);
		anuncioAlta.setFechaFinVigencia(request.getFechaFinVigencia() != null ?
				java.util.Date.from(request.getFechaFinVigencia().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
				:null);
		try {
			//Si los datos son correctos, se procede con el guardado o actualizacion
			if(request instanceof ActualizaAnuncioRequest) {
				anuncioAlta.setId(((ActualizaAnuncioRequest)request).getId());
				anuncioAlta.setFechaModificacion(new Date());
				anuncioMapper.update(anuncioAlta);
				anuncioMapper.deleteAtributos(anuncioAlta.getId());
			}else {
				anuncioAlta.setFolio(AnuncioUtil.generaFolio());
				anuncioAlta.setFechaAlta(new Date());
				anuncioAlta.setFechaModificacion(anuncioAlta.getFechaAlta());
				anuncioMapper.insert(anuncioAlta);
			}
			for(MascotaValorAtributoRequest ar : request.getMascotaValorAtributo()) {
				MascotaValorAtributo aa =  new MascotaValorAtributo();
				aa.setIdAnuncio(anuncioAlta.getId());
				aa.setIdValorAtributo(ar.getIdValorAtributo());
				anuncioMapper.insertAtributo(aa);
			}
			logger.info("Anuncio guardado correctamente, id asociado: "+anuncioAlta.getId());
			return new AnuncioResponse(anuncioAlta.getId(),anuncioAlta.getFolio());
		}catch (Exception e) { 
			e.printStackTrace();
			  throw new TransactionException("Registro fallido. Ocurrio un error durante el guardado de informacion");
		}
	}
	
	@Override
	public AnuncioResponse confirmarAnuncio(int id) throws BusinessException {
		AnuncioResponse response = new AnuncioResponse();
		try {
			//Si los datos son correctos, se procede con el guardado
			Anuncio anuncio = anuncioMapper.getAnuncioById(id);
			if(AnuncioEstatusEnum.EN_EDICION.getId()!=anuncio.getIdEstatus() 
					&& AnuncioEstatusEnum.ACTIVO.getId()!=anuncio.getIdEstatus()
					&& AnuncioEstatusEnum.PUBLICADO.getId()!=anuncio.getIdEstatus()) {
				throw new BusinessException("Error de datos","El anuncio no se encuentra en un estatus valido",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			if(!AnuncioUtil.validaFechasPeriodo(anuncio.getFechaInicioVigencia(), anuncio.getFechaFinVigencia())) {
				throw new BusinessException("Error de datos","Fechas de vigencia no validas",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(id);
			if(imagenes==null || imagenes.isEmpty()) {
				throw new BusinessException("Error de datos","El anuncio debe tener asociada al menos una imagen para confirmar su registro", 4092,"CVE_4092",HttpStatus.CONFLICT);
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
			throw new BusinessException("Error de sistema","Ocurrio un error al confirmar la información.", 4092,"CVE_4092",HttpStatus.CONFLICT);
		}
		return response;	
	}
	
	@Override
	public AnuncioResponse eliminarAnuncio(int id) throws BusinessException {
		AnuncioResponse response = new AnuncioResponse();
		try {
			//Se consulta la informacion del anuncio, para validar estatus
			Anuncio anuncio = anuncioMapper.getAnuncioById(id);
			if(anuncio == null) {
				throw new BusinessException("Error de datos","No se encontro informacion",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			if(AnuncioEstatusEnum.ELIMINADO.getId()==anuncio.getIdEstatus()) {
				throw new BusinessException("Error de datos","El anuncio ha sido eliminado previamente",4091,"CVE_4091",HttpStatus.CONFLICT);
			}		
			//Se procede a realizar el eliminado del registro
			anuncioMapper.eliminaAnuncio(id, AnuncioEstatusEnum.ELIMINADO.getId(), new Date());
			response.setId(anuncio.getId());
			response.setFolio(anuncio.getFolio());	
		} catch (SQLException e) {
			throw new BusinessException("Error de sistema","Ocurrio un error al tratar de eliminar la información.", 4092,"CVE_4092",HttpStatus.CONFLICT);
		}
		return response;	
	}
	
	@Override
	public AnuncioImagenResponse guardarImagen(int idAnuncio, MultipartFile file) throws BusinessException {
		try {
			String contentType = file.getContentType();
			int tipoMedia=0;
			if(contentType.equals("image/jpg") ||contentType.equals("image/jpeg")) {
				tipoMedia=1;
			}else if(contentType.equals("image/png") ) {
				tipoMedia=2;
			}else if(contentType.equals("image/gif")) {
				tipoMedia=3;
			}else if(contentType.equals("video/mp4")) {
				tipoMedia=4;
			}else if(contentType.equals("video/avi")) {
				tipoMedia=5;
			}else {
				throw new BusinessException("Error de datos","Formato de imagen no valido. Solo se aceptan: jpg, png, gif, mp4, avi",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			Anuncio anuncio=anuncioMapper.getAnuncioById(idAnuncio);
			if(anuncio==null || AnuncioEstatusEnum.ELIMINADO.getId()==anuncio.getIdEstatus()) {
				throw new BusinessException("Error de datos","No existe el  anuncio para asociar la imagen",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			UploadModel upload = uploadService.storeOne(file, destinationFolder, max);
			AnuncioMedia imagenEnt= new AnuncioMedia(anuncio.getId(),upload.getNuevoNombre(),tipoMedia, Boolean.FALSE);
			anuncioImagenMapper.insertImagen(imagenEnt);
			return new AnuncioImagenResponse(imagenEnt.getId(),anuncio.getId(),imagenEnt.getUuid(),imagenEnt.getIdTipo(),imagenEnt.getPrincipal());
		}catch (UploadException e) {
			throw new BusinessException(e.getShortMessage(),e.getDetailedMessage(),4091,"CVE_4091",HttpStatus.CONFLICT);
		}catch (SQLException e) {
			throw new BusinessException("Error de sistema","Error al guardar la imagen.",4091,"CVE_4091",HttpStatus.CONFLICT);
		}
	}

	@Override
	public void eliminarImagen(String idImagen) throws BusinessException {		
		try {
			AnuncioMedia entidad=anuncioImagenMapper.getImagen(idImagen);
			if(entidad==null) {
				throw new BusinessException("Error de datos","No se encuentra la informacion solicitada",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			anuncioImagenMapper.eliminarImagen(idImagen);
		}catch(SQLException e) {
			throw new BusinessException("Error de sistema","Error al tratar de eliminar la informacion solicitada",4091,"CVE_4091",HttpStatus.CONFLICT);
		}
	}

	@Override
	public DetalleAnuncioResponse detalleAnuncio(int id) throws BusinessException {
		try {
			//Se consulta la informacion del anuncio, para validar estatus
			DetalleAnuncioResponse detalleResponse= anuncioMapper.getAnuncioDetalle(id);
			if(detalleResponse == null) {
				throw new BusinessException("Error de datos","No se encontro informacion",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			if(AnuncioEstatusEnum.ELIMINADO.getId()==detalleResponse.getIdEstatus()) {
				throw new BusinessException("Error de datos","Anuncio no disponible",4091,"CVE_4091",HttpStatus.CONFLICT);
			}	
			//Se consulta la informacion de los atributos del anuncio
			List<ValorAtributoResponse> atributosResponse = anuncioMapper.valorAtributosPorAnuncio(id);
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
			throw new BusinessException("Error de sistema","Ocurrio un error al consultar la información.", 4092,"CVE_4092",HttpStatus.CONFLICT);
		}
	}
	
	/**
	 * Método privado que permite realizar validaciones de negocio para confirmar el guardado
	 * @param request Clase que contiene los campos a validar
	 * @throws BusinessException - xcepcion lanzada con el mensaje de error correspondiente
	 */
	private void validaCampos(AnuncioRequest request) throws BusinessException {
		//Validacion de campos obligatorios
		if(request.getMascotaValorAtributo()==null || request.getMascotaValorAtributo().isEmpty()) {
			throw new BusinessException("Error de datos","El registro de un anuncio debe tener al menos un atributo asociado",4091,"CVE_4091",HttpStatus.CONFLICT);
		}
		//TODO: En cuanto se tenga el Mapper de catalogo, se validara el estatus del registro de categoria proporcionado
		if(request.getIdCategoria()>7) {
			throw new BusinessException("Error de datos","Categoria no valida",4091,"CVE_4091",HttpStatus.CONFLICT);
		}
		//Validacion de fechas de vigencia
		Date fechaInicio = request.getFechaInicioVigencia() != null ? 
				java.util.Date.from(request.getFechaInicioVigencia().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
				:null;
		Date fechaFin =request.getFechaFinVigencia() != null ?
				java.util.Date.from(request.getFechaFinVigencia().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
				:null;
		if(!AnuncioUtil.validaFechasPeriodo(fechaInicio, fechaFin)) {
			throw new BusinessException("Error de datos","Fechas de vigencia no validas",4091,"CVE_4091",HttpStatus.CONFLICT);
		}	
	}

	/**
	 * Metodo que permite realizar la busqueda de productos por medio de filtros, asi como tambien devuelve la paginacion
	 * @param filtros permite utilizar los campos como filtros en la sentencia SQL
	 * @throws BusinessException, SQLException
	 */
	@Override
	public PaginacionAnunciosResponse busquedaAdministracion(BusquedaAdministracionRequest filtros)
			throws BusinessException, SQLException {
		
		List<String> cadenasMapper = AnuncioUtil.busquedaFiltros(filtros);
		Map<String, String> mapSql = new HashMap<>();
		mapSql.put("sql", cadenasMapper.get(1));
		mapSql.put("total", cadenasMapper.get(0));

		List<BusquedaAdministracionResponse> anuncios = anuncioMapper.busquedaAnuncio(mapSql);
		List<BusquedaAdministracionResponse> totalAnuncios = anuncioMapper.obtieneCantidad(mapSql);
		PaginacionAnunciosResponse response = new PaginacionAnunciosResponse(totalAnuncios != null ? totalAnuncios.size() : 0, anuncios);
			
		for (BusquedaAdministracionResponse anuncio:anuncios) {
			Categoria objetoCategoria = new Categoria();			
			anuncio.setDescripcionEstatus(anuncioMapper.obtieneDescPorId(anuncio.getIdEstatus()));
			objetoCategoria = anuncioMapper.obtieneCategoria(anuncio.getIdCategoria());
			anuncio.setDescripcionCategoria(objetoCategoria.getCategoria());
		}
		return response;
	}

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
			Categoria objetoCategoria = new Categoria();
			objetoCategoria = anuncioMapper.obtieneCategoria(anuncio.getIdCategoria());
			anuncio.setDescCategoria(objetoCategoria.getCategoria());
			List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(anuncio.getId());
			List<AnuncioImagenResponse> imagenesResponse = null;
			if(imagenes!=null && !imagenes.isEmpty()) {
				imagenesResponse = new ArrayList<>();
				for(AnuncioMedia img : imagenes) {
//					imagenesResponse.add(new AnuncioImagenResponse(img.getId(),img.getIdAnuncio(), img.getUuid(), img.getImagen()));
				}
				anuncio.setImagenes(imagenesResponse);
			}
		}

		response.setListaAnuncios(anuncios);
		response.setTotalAnuncios(totalAnuncios != null ? totalAnuncios.size() : 0);
		
		return response;
	}

	@Override
	public void imagenPrincipal(int idAnuncio, String uuid) throws BusinessException {
		try {
			Anuncio anuncioBase = anuncioMapper.getAnuncioById(idAnuncio);
			if(AnuncioEstatusEnum.ELIMINADO.getId()==anuncioBase.getIdEstatus() 
					|| AnuncioEstatusEnum.VENCIDO.getId()==anuncioBase.getIdEstatus()
					|| AnuncioEstatusEnum.CANCELADO.getId()==anuncioBase.getIdEstatus()) {
				throw new BusinessException("Error de datos","El anuncio no se encuentra en un estatus valido para ser modificado",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			List<AnuncioMedia> imagenes = anuncioImagenMapper.getImagenes(idAnuncio);
			if(imagenes==null || imagenes.isEmpty()) {
				throw new BusinessException("Error de datos","El anuncio no cuenta con imagenenes asociadas",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			for(AnuncioMedia img:imagenes) {
				if(uuid.equals(img.getUuid())) {
					anuncioImagenMapper.actualizaPrincipal(img.getUuid(), Boolean.TRUE);
				}else {
					anuncioImagenMapper.actualizaPrincipal(img.getUuid(), Boolean.FALSE);
				}	
			}
		} catch (SQLException e) {
			logger.info("Error: "+e.getMessage());
			throw new BusinessException("Error de datos","No se pudo validar el estatus del anuncio",4091,"CVE_4091",HttpStatus.CONFLICT);

		}
	}

}
