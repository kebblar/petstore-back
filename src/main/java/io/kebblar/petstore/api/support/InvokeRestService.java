/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.support
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      InvokeRestService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:28:47
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
