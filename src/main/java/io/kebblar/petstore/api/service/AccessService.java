package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.LoginResponse;

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
     * @return
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
     * @return
     * @throws BusinessException
     */
    LoginResponse login(Usuario usuario, String claveProporcionada, long delta, int maximoNumeroIntentosConcedidos,
            long instanteActual) throws BusinessException;
}
