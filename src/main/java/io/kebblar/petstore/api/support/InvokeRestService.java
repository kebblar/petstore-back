/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   InvokeRestService.java
 * Tipo:        interface
 * AUTOR:       Daniel Alvarez Morales
 * Fecha:       15 de Mayo de 2021 (16_00)
 *
 * Historia:    .
 *              20210503_1600 Creación
 *
 */
package io.kebblar.petstore.api.support;

import io.kebblar.petstore.api.model.exceptions.GoogleCaptchaException;
import io.kebblar.petstore.api.model.exceptions.ProcessPDFException;
import io.kebblar.petstore.api.model.request.GoogleCaptcha;
import io.kebblar.petstore.api.model.response.SmsResponse;

/**
 * <p>Definición de la interfaz de servicios para 'InvokeRestService'.
 * 
 * @author  dalvarez
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface InvokeRestService {
  /**
    * <p>Método utilizado para procesar validación por captcha
    * 
    * @param Objeto de tipo GoogleCaptcha.
    * @return Cadena con el resultado de la validación captcha.
    * @throws GoogleCaptchaException
    */
    String checkCaptcha(GoogleCaptcha googleCaptcha) throws GoogleCaptchaException;
    
    String getBitsoInfo2();
    
    /**
     * <p>Método utilizado para envio de mensajes SMS
     * 
     * @param URL del servicio REST para envio de mensajes SMS.
     * @param Credenciales para utilizar el servicio de envio SMS
     * @param Telefóno al cual se enviara el SMS
     * @param Mensaje de texto el cual se enviara en el SMS
     * @return SmsResponse que contiene la información de  respuesta del servicio.
     * @throws ProcessPDFException
     */
    SmsResponse smsSend(String url, String credential, String tel, String msj) throws ProcessPDFException;
}
