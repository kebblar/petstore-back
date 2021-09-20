/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      SmsService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 09:23:01
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
