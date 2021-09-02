/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   WrongTokenException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (17_57)
 *
 * Historia:    .
 *              20210504_1757 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Descripción</p>
 * Excepción que se lanza cuando un usuario intenta entrar al sistema con credenciales incorrectas.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class UserNotExistsException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    
    private static final String DETAILED_MENSAJE = "El usuario %s no se encuentra reistrado.";
    private static final String SHORT_MENSAJE = "Usuario Inexistente";

    /**
     * Indica que el nombre de usuario introducido no existe en el sistema.
     * @param user cadena del usuario introducido
     */
    public UserNotExistsException(String user) {
        super(
                SHORT_MENSAJE,
            mess(user),
            1022,
            "CVE_1022",
            HttpStatus.BAD_REQUEST);
    }

    /**
     * Brinda el mensaje detallado del problema.
     * @param user usuario introducido
     * @return Mensaje específico de la problemática
     */
    private static String mess(String user) {
        return String.format(DETAILED_MENSAJE, user);
    }
    
}
