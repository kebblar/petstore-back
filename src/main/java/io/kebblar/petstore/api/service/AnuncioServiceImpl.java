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
 *
 */
package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.kebblar.petstore.api.mapper.AnuncioMapper;
import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.domain.AnuncioAtributo;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.AtributoRequest;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
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

    private AnuncioMapper anuncioMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param anuncioMapper mapper utilizado para llamar a metodos de persistencia
     */
    public AnuncioServiceImpl(AnuncioMapper anuncioMapper) {
        this.anuncioMapper = anuncioMapper;
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
		anuncioAlta.setSku(AnuncioUtil.generaSku());
		anuncioAlta.setFechaAlta(new Date());
		anuncioAlta.setFechaModificacion(anuncioAlta.getFechaAlta());
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
			throw new BusinessException();
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
