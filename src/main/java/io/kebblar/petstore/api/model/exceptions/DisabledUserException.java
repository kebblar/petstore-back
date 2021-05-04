package io.kebblar.petstore.api.model.exceptions;
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
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (14_09)
 *
 * Historia:    .
 *              20210503_1409 Creación de esta Excepción
 *
 */
public class DisabledUserException extends BusinessException{
	
	/**
	 * <p>Excepción que modela la respuesta a una petición de autenticación 
	 * cuyo usuario fue bloqueado anteriormente.
	 * 
	 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
	 * constructorescon la definición necesaria, que incluye en algunos caos el
	 * código HTTP que será devuelto.
	 * 
	 * @author  garellano
	 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
	 * @version 1.0-SNAPSHOT
	 * @since   1.0-SNAPSHOT
	 */
	
    private static final long serialVersionUID = -7083159020205284484L;

    public DisabledUserException() {
        super(
            "Error de ingreso",
            "El usuario ha sido deshabilitado.",
            2004,
            "CVE_2004",
            HttpStatus.BAD_REQUEST);
    }
}
