/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MapperCallException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (22_20)
 *
 * Historia:    .
 *              20210504_1409 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Excepción que modela la respuesta a una petición de autenticación cuyas
 * credenciales proporcionadas fueron incorrectas.
 *
 * <p>
 * Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author garellano
 * @see io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MapperCallException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    private static final Logger logger = LoggerFactory.getLogger(MapperCallException.class);

    public MapperCallException(String shortMessage, String technicalDescription) {
        super(
            shortMessage,
            buildMessage(technicalDescription),
            4001,
            "CVE_4001",
            HttpStatus.BAD_REQUEST);
    }

    private static String buildMessage(String technicalDescription) {
        String uid = UUID.randomUUID().toString();
        logger.error("UID:: " + technicalDescription);
        return "Codigo de error: " + uid;
    }

}
