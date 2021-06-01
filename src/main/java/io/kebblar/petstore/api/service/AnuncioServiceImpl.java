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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import io.kebblar.petstore.api.mapper.AnuncioImagenMapper;
import io.kebblar.petstore.api.mapper.AnuncioMapper;
import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.domain.AnuncioAtributo;
import io.kebblar.petstore.api.model.domain.AnuncioImagen;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.exceptions.UploadException;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.AtributoRequest;
import io.kebblar.petstore.api.model.request.BusquedaAdministracionRequest;
import io.kebblar.petstore.api.model.request.BusquedaRequest;
import io.kebblar.petstore.api.model.response.AnuncioImagenResponse;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
import io.kebblar.petstore.api.model.response.BusquedaAdministracionResponse;
import io.kebblar.petstore.api.model.response.BusquedaResponse;
import io.kebblar.petstore.api.model.response.PaginacionAnunciosResponse;
import io.kebblar.petstore.api.model.response.AtributoResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import io.kebblar.petstore.api.utils.AnuncioAtributosEnum;
import io.kebblar.petstore.api.utils.AnuncioCategoriaEnum;
import io.kebblar.petstore.api.support.UploadService;
import io.kebblar.petstore.api.utils.AnuncioEstatusEnum;
import io.kebblar.petstore.api.utils.AnuncioUtil;
import io.kebblar.petstore.api.utils.AnuncioValAtributosEnum;

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
    private AnuncioImagenMapper anuncioImagenMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param anuncioMapper mapper utilizado para llamar a metodos de persistencia
     */
    public AnuncioServiceImpl(AnuncioMapper anuncioMapper, UploadService uploadService,
    		AnuncioImagenMapper anuncioImagenMapper) {
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
		Anuncio anuncioAlta= new Anuncio();
		anuncioAlta.setTitulo(request.getTitulo());
		anuncioAlta.setPrecio(request.getPrecio());
		anuncioAlta.setIdCategoria(request.getIdCategoria());
		anuncioAlta.setDescripcion(request.getDescripcion());
		anuncioAlta.setEstatus(AnuncioEstatusEnum.EN_EDICION.getId());
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
				anuncioAlta.setSku(AnuncioUtil.generaSku());
				anuncioAlta.setFechaAlta(new Date());
				anuncioAlta.setFechaModificacion(anuncioAlta.getFechaAlta());
				anuncioMapper.insert(anuncioAlta);
			}
			for(AtributoRequest ar : request.getAtributos()) {
				AnuncioAtributo aa =  new AnuncioAtributo();
				aa.setIdAnuncio(anuncioAlta.getId());
				aa.setIdAtributo(ar.getId());
				aa.setValor(ar.getValor());
				anuncioMapper.insertAtributo(aa);
			}
			logger.info("Anuncio guardado correctamente, id asociado: "+anuncioAlta.getId());
			return new AnuncioResponse(anuncioAlta.getId(),anuncioAlta.getSku());
		}catch (Exception e) { // SQLException no hizo caso
			  throw new TransactionException("Registro fallido. Ocurrio un error durante el guardado de informacion");
		}
	}
	
	@Override
	public AnuncioResponse confirmarAnuncio(int id) throws BusinessException {
		AnuncioResponse response = new AnuncioResponse();
		try {
			//Si los datos son correctos, se procede con el guardado
			Anuncio anuncio = anuncioMapper.getAnuncioById(id);
			if(AnuncioEstatusEnum.EN_EDICION.getId()!=anuncio.getEstatus() 
					&& AnuncioEstatusEnum.ACTIVO.getId()!=anuncio.getEstatus()
					&& AnuncioEstatusEnum.PUBLICADO.getId()!=anuncio.getEstatus()) {
				throw new BusinessException("Error de datos","El anuncio no se encuentra en un estatus valido",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			if(!AnuncioUtil.validaFechasPeriodo(anuncio.getFechaInicioVigencia(), anuncio.getFechaFinVigencia())) {
				throw new BusinessException("Error de datos","Fechas de vigencia no validas",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			List<AnuncioImagen> imagenes = anuncioImagenMapper.getImagenes(id);
			if(imagenes==null || imagenes.isEmpty()) {
				throw new BusinessException("Error de datos","El anuncio debe tener asociada al menos una imagen para confirmar su registro", 4092,"CVE_4092",HttpStatus.CONFLICT);
			}
			response.setId(anuncio.getId());
			response.setSku(anuncio.getSku());
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
			throw new BusinessException();
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
			if(AnuncioEstatusEnum.ELIMINADO.getId()==anuncio.getEstatus()) {
				throw new BusinessException("Error de datos","El anuncio ha sido eliminado previamente",4091,"CVE_4091",HttpStatus.CONFLICT);
			}		
			//Se procede a realizar el eliminado del registro
			anuncioMapper.eliminaAnuncio(id, AnuncioEstatusEnum.ELIMINADO.getId(), new Date());
			response.setId(anuncio.getId());
			response.setSku(anuncio.getSku());	
		} catch (SQLException e) {
			throw new BusinessException();
		}
		return response;	
	}
	
	@Override
	public AnuncioImagenResponse guardarImagen(int idAnuncio, MultipartFile file) throws BusinessException {
		try {
			String contentType = file.getContentType();
			if(!contentType.equals("image/jpeg") && !contentType.equals("image/png") && !contentType.equals("application/jpg")) {
				throw new BusinessException("Error de datos","Formato de imagen no valido",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			Anuncio anuncio=anuncioMapper.getAnuncioById(idAnuncio);
			if(anuncio==null || AnuncioEstatusEnum.ELIMINADO.getId()==anuncio.getEstatus()) {
				throw new BusinessException("Error de datos","No existe el  anuncio para asociar la imagen",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			UploadModel upload = uploadService.storeOne(file, destinationFolder, max);
			AnuncioImagen imagenEnt= new AnuncioImagen(anuncio.getId(),upload.getNuevoNombre(),upload.getNombreOriginal());
			anuncioImagenMapper.insertImagen(imagenEnt);
			return new AnuncioImagenResponse(imagenEnt.getId(),anuncio.getId(),imagenEnt.getUuid(),imagenEnt.getImagen());
		}catch (UploadException | SQLException e) {
			throw new BusinessException("Error de sistema","Error al guardar la imagen.",4091,"CVE_4091",HttpStatus.CONFLICT);
		}
	}

	@Override
	public void eliminarImagen(String idImagen) throws BusinessException {		
		try {
			AnuncioImagen entidad=anuncioImagenMapper.getImagen(idImagen);
			if(entidad==null) {
				throw new BusinessException("Error de datos","No se encuentra la informacion solicitada",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			anuncioMapper.eliminarImagen(idImagen);
		}catch(SQLException e) {
			throw new BusinessException("Error de datos","Error al tratar de eliminar la informacion solicitada",4091,"CVE_4091",HttpStatus.CONFLICT);
		}
	}

	@Override
	public DetalleAnuncioResponse detalleAnuncio(int id) throws BusinessException {
		try {
			//Se consulta la informacion del anuncio, para validar estatus
			Anuncio anuncio = anuncioMapper.getAnuncioById(id);
			if(anuncio == null) {
				throw new BusinessException("Error de datos","No se encontro informacion",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			if(AnuncioEstatusEnum.ELIMINADO.getId()==anuncio.getEstatus()) {
				throw new BusinessException("Error de datos","Anuncio no disponible",4091,"CVE_4091",HttpStatus.CONFLICT);
			}	
			//Se consulta la informacion de los atributos del anuncio
			List<AnuncioAtributo> atributos = anuncioMapper.atributosPorAnuncio(id);
			List<AtributoResponse> atributosResponse = null;
			if(atributos!=null && !atributos.isEmpty()) {
				atributosResponse = new ArrayList<>();
				for(AnuncioAtributo atr : atributos) {
					AtributoResponse atrRes=new AtributoResponse();
					atrRes.setId(atr.getIdAtributo());
					atrRes.setDescAtributo(AnuncioAtributosEnum.getDescripcion(atr.getIdAtributo()));
					atrRes.setValor(atr.getValor());
					atrRes.setDescValor(AnuncioValAtributosEnum.getDescValor(atr.getIdAtributo(), atr.getValor()));
					atributosResponse.add(atrRes);
				}
			}
			//Se consulta la informacion de las imagenes del anuncio
			List<AnuncioImagen> imagenes = anuncioImagenMapper.getImagenes(id);
			List<AnuncioImagenResponse> imagenesResponse = null;
			if(imagenes!=null && !imagenes.isEmpty()) {
				imagenesResponse = new ArrayList<>();
				for(AnuncioImagen img : imagenes) {
					imagenesResponse.add(new AnuncioImagenResponse(img.getId(),img.getIdAnuncio(), img.getUuid(), img.getImagen()));
				}
			}
			//Se envía solo lo necesario del detalle del anunio
			DetalleAnuncioResponse detalleResponse= new DetalleAnuncioResponse();
			detalleResponse.setId(anuncio.getId());
			detalleResponse.setSku(anuncio.getSku());
			detalleResponse.setTitulo(anuncio.getTitulo());
			detalleResponse.setIdCategoria(anuncio.getIdCategoria());
			detalleResponse.setDescCategoria(AnuncioCategoriaEnum.getDescripcion(anuncio.getIdCategoria()));
			detalleResponse.setPrecio(anuncio.getPrecio());
			detalleResponse.setDescripcion(anuncio.getDescripcion());
			detalleResponse.setEstatus(anuncio.getEstatus());
			detalleResponse.setDescEstatus(AnuncioEstatusEnum.getDescripcion(anuncio.getEstatus()));
			detalleResponse.setFechaInicioVigencia(anuncio.getFechaInicioVigencia());
			detalleResponse.setFechaFinVigencia(anuncio.getFechaFinVigencia());
			detalleResponse.setAtributos(atributosResponse);
			detalleResponse.setImagenes(imagenesResponse);
			return detalleResponse;	
		} catch (SQLException e) {
			throw new BusinessException();
		}
	}
	
	/**
	 * Método privado que permite realizar validaciones de negocio para confirmar el guardado
	 * @param request Clase que contiene los campos a validar
	 * @throws BusinessException - xcepcion lanzada con el mensaje de error correspondiente
	 */
	private void validaCampos(AnuncioRequest request) throws BusinessException {
		//Validacion de campos obligatorios
		if(request.getAtributos()==null || request.getAtributos().isEmpty()) {
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
			anuncio.setDescripcionEstatus(AnuncioEstatusEnum.getDescripcion(Short.valueOf(anuncio.getEstatus())));
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
			anuncio.setDescCategoria(AnuncioCategoriaEnum.getDescripcion(anuncio.getIdCategoria()));
			List<AnuncioImagen> imagenes = anuncioImagenMapper.getImagenes(anuncio.getId());
			List<AnuncioImagenResponse> imagenesResponse = null;
			if(imagenes!=null && !imagenes.isEmpty()) {
				imagenesResponse = new ArrayList<>();
				for(AnuncioImagen img : imagenes) {
					imagenesResponse.add(new AnuncioImagenResponse(img.getId(),img.getIdAnuncio(), img.getUuid(), img.getImagen()));
				}
				anuncio.setImagenes(imagenesResponse);
			}
		}

		response.setListaAnuncios(anuncios);
		response.setTotalAnuncios(totalAnuncios != null ? totalAnuncios.size() : 0);
		
		return response;
	}

}
