/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   FacturaService.java
 * Tipo:        interface
 * AUTOR:       Daniel Alvarez Morales
 * Fecha:       20 de Junio de 2021 (16_00)
 *
 * Historia:    .
 *              20210620_1600 Creación
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.ProcessPDFException;

/**
 * <p>Definición de la interfaz de servicios para 'SmsService'.
 * 
 * @author  dalvarez
 * @see     io.kebblar.petstore.api.model.domain.DatosOrden
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface SmsService {
       /**
        * <p>Método utilizado para envio de mensajes SMS.
        * 
        * @param Número de telefono
        * @param Mensaje de texto
        * @throws ProcessPDFException
        */
	void envioSms(String numero, String mesj) throws ProcessPDFException;
	
        /**
         * <p>Método utilizado para generar una clave de 5 dígitos la cual sera utilizada para enviarla en un mensaje SMS
         * 
         * @return Clave de 5 dígitos aleatorios
         */
	String getCveSMS();
}
