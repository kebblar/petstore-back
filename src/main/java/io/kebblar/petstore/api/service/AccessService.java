/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AccessService.java
 * Tipo:        interface
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Jueves 6 de Mayo de 2021 (20_00)
 *
 * Historia:    .
 *              20210503_1600 Creación
 *              20210506_2000 Documentacion
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.LoginResponse;

/**
 * <p>Definición de la interfaz de servicios para el login.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface AccessService {
    /**
     * Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto LoginResponse cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * Se requiere que el método siga las siguientes reglas:
     *     - No admite usuario ni clave vacios
     *     - Si el usuario no existe, sólo pide que intente de nuevo
     *     - Si el usuaro existe y la clave es errónea, le indicará que le quedan menos intentos
     *     - Si el usuario está bloqueado (con o sin clave correcta) le indicará que debe esperar cierto tiempo
     * @param usuario
     * @param clave
     * @return un objeto de tipo LoginResponse
     * @throws BusinessException
     */
    LoginResponse login(String usuario, String clave) throws BusinessException;
    
    /**
     * Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto LoginResponse cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * Se requiere que el método siga las siguientes reglas:
     *     - No admite usuario ni clave vacios
     *     - Si el usuario no existe, sólo pide que intente de nuevo
     *     - Si el usuaro existe y la clave es errónea, le indicará que le quedan menos intentos
     *     - Si el usuario está bloqueado (con o sin clave correcta) le indicará que debe esperar cierto tiempo
     * @param usuario
     * @param claveProporcionada
     * @param delta
     * @param maximoNumeroIntentosConcedidos
     * @param instanteActual
     * @return un objeto de tipo LoginResponse
     * @throws BusinessException
     */
    LoginResponse login(Usuario usuario, String claveProporcionada, long delta, int maximoNumeroIntentosConcedidos,
            long instanteActual) throws BusinessException;
}
