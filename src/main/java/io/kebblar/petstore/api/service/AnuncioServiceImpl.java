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
 *
 */
package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;

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
import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.exceptions.UploadException;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.AtributoRequest;
import io.kebblar.petstore.api.model.response.AnuncioImagenResponse;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
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
				aa.setValor(Integer.parseInt(ar.getValor()));
				anuncioMapper.insertAtributo(aa);
			}
			logger.info("Anuncio guardado correctamente, id asociado: "+anuncioAlta.getId());
			return new AnuncioResponse(anuncioAlta.getId(),anuncioAlta.getSku());
		} catch (SQLException e) {
			  throw new TransactionException("Registro fallido. Haciendo rollback a la transaccion");
		}
	}
	

	@Override
	public AnuncioResponse confirmarAnuncio(int id) throws BusinessException {
		AnuncioResponse response = new AnuncioResponse();
		try {
			//Si los datos son correctos, se procede con el guardado
			Anuncio anuncio = anuncioMapper.getAnuncioById(id);
			if(AnuncioEstatusEnum.EN_EDICION.getId()!=anuncio.getEstatus() 
					&& AnuncioEstatusEnum.ACTIVO.getId()!=anuncio.getEstatus()) {
				throw new BusinessException("Error de datos","El anuncio no se encuentra en un estatus valido",4091,"CVE_4091",HttpStatus.CONFLICT);
			}
			if(!AnuncioUtil.validaFechasPeriodo(anuncio.getFechaInicioVigencia(), anuncio.getFechaFinVigencia())) {
				throw new BusinessException("Error de datos","Fechas de vigencia no validas");
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
			throw new BusinessException("Error de sistema","Error al guardar la imagen.");
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
	
	/**
	 * Método privado que permite realizar validaciones de negocio para confirmar el guardado
	 * @param request Clase que contiene los campos a validar
	 * @throws BusinessException - xcepcion lanzada con el mensaje de error correspondiente
	 */
	private void validaCampos(AnuncioRequest request) throws BusinessException {
		//Validacion de campos obligatorios
		if(request.getAtributos()==null || request.getAtributos().isEmpty()) {
			throw new BusinessException("Error de datos","El registro de un anuncio debe tener al menos un atributo asociado");
		}
		//TODO: En cuanto se tenga el Mapper de catalogo, se validara el estatus del registro de categoria proporcionado
		if(request.getIdCategoria()>7) {
			throw new BusinessException("Error de datos","Categoria no valida");
		}
		//Validacion de fechas de vigencia
		Date fechaInicio = request.getFechaInicioVigencia() != null ? 
				java.util.Date.from(request.getFechaInicioVigencia().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
				:null;
		Date fechaFin =request.getFechaFinVigencia() != null ?
				java.util.Date.from(request.getFechaFinVigencia().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
				:null;
		if(!AnuncioUtil.validaFechasPeriodo(fechaInicio, fechaFin)) {
			throw new BusinessException("Error de datos","Fechas de vigencia no validas");
		}	
	}

}
