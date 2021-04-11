/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.gob.impi.chatbot.persistence.api.service
 * Modulo:      JwtManagerService
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       1 de Octubre de 2019 (12_26)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio de User
 *
 * Historia:    .
 *              20191001_1226 Creación del tipo
 *
 *
 */
package io.kebblar.petstore.api.support;

import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de JSON Web Tokens
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface JwtManagerService {
    /**
     * Crea el JWT para el usuario solicitado
     * @param username Cadena con el nombre de usuario
     *                 para el que se le genera el JWT
     * @return Cadena con el JSON Web Token
     */
    String createToken(String username);

    /**
     * Verifica que el JWT que se recibe correnponde con
     * el usuario que se quiere autorizar
     * @param jwt
     * @param user
     */
    void verifyToken(String jwt, String user) throws BusinessException;

    /** Devuelve el correo electrónico de un usuario pasado una cadena jwt
     * @param jwt
     */
    String getMail(String jwt) throws BusinessException;
}
