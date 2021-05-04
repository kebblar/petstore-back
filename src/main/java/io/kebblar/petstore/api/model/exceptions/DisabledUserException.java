/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   DisabledUserException.java
 * Tipo:        clase
 * AUTOR:       Ulises A. López (UAL)
 * Fecha:       Martes 4 de Mayo de 2021 (0929)
 *
 * Historia:    .
 *              20210504_0929 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>
 * Excepción que modela la respuesta a una petición, cuando el usuario es
 * candidato para ser deshabilitado.
 * 
 * <p>
 * Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author ulopezu
 * @see io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class DisabledUserException extends BusinessException {
	private static final long serialVersionUID = -7083159020205284484L;

	public DisabledUserException() {
		super("Error de ingreso", "El usuario ha sido deshabilitado.", 2004, "CVE_2004", HttpStatus.BAD_REQUEST);
	}
}
