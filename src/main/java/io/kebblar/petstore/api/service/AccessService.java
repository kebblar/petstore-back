/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AcessService.java
 * Tipo:        interface
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (16_00)
 *
 * Historia:    .
 *              20210503_1600 Creación
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.LoginResponse;

/**
 * <p>Definición de la interfaz de servicios para 'AcessService'.
 * 
 * @author  garellano

 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface AccessService {
    
	/**
     * <P>Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto LoginResponse cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * <ul>Se requiere que el método siga las siguientes reglas:
     *     <li>No admite {@link Usuario} ni clave vacios</li>
     *     <li>Si el usuario no existe, sólo pide que intente de nuevo</li>
     *     <li>Si el usuaro existe y la clave es errónea, le indicará que le quedan menos intentos</li>
     *     <li>Si el usuario está bloqueado (con o sin clave correcta) le indicará que debe esperar cierto tiempo</li>
     * </ul>
     * @param usuario cadena que representa el identificador de autenticación
     * @param clave cadena que representa la credencial de autenticación
     * @return objeto de tipo {@link LoginResponse} con la respuesta esperada del frontend
     * @throws BusinessException
     */
	
    LoginResponse login(String usuario, String clave) throws BusinessException;

    /**
     * <P>Contiene la lògica de negocio para validar las crdenciales de login.
     * 
     * <P>Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto LoginResponse cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * Se requiere que el método siga las siguientes reglas:
     *     - No admite usuario ni clave vacios
     *     - Si el {@link Usuario}no existe, sólo pide que intente de nuevo
     *     - Si el {@link Usuario} existe y la clave es errónea, le indicará que le quedan menos intentos
     *     - Si el {@link Usuario} está bloqueado (con o sin clave correcta) le indicará que debe esperar cierto tiempo
     * @param Objeto de tipo {@link Usuario} con la información de usuario.
     * @param String claveProporcionada
     * @param long Delta
     * @param int maximoNumeroIntentosConcedidos
     * @param long instanteActual
     * @return
     * @throws BusinessException
     */
    LoginResponse login(Usuario usuario, String claveProporcionada, long delta, int maximoNumeroIntentosConcedidos,
            long instanteActual) throws BusinessException;
}
