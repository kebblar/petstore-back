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
 * Tipo:        Clase
 * Nombre:      SmsServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:23:08
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.response.SmsResponse;
import io.kebblar.petstore.api.support.InvokeRemoteRestService;

import java.security.SecureRandom;

/**
 * Implementación de la interfaz {@link io.kebblar.petstore.api.service.SmsService}.
 *
 * @author dalvarez
 * @see io.kebblar.petstore.api.service.SmsService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
    private final InvokeRemoteRestService invokeRestSMSService;

    /**
     * <p>Constructor for SmsServiceImpl.</p>
     *
     * @param invokeRestSMSService a {@link io.kebblar.petstore.api.support.InvokeRemoteRestService} object.
     */
    public SmsServiceImpl(InvokeRemoteRestService invokeRestSMSService) {
        this.invokeRestSMSService=invokeRestSMSService;
    }

    /** {@inheritDoc} */
    @Override
    public void envioSms(String numero, String msj) throws ServiceException {
        logger.info("Inicia envio SMS");
            SmsResponse responseSMS = invokeRestSMSService.smsSend("+52"+numero, msj);
            logger.info("Response: {}", responseSMS.isExito());
    }

    /** {@inheritDoc} */
    @Override
    public String getCveSMS() {
        SecureRandom rand = new SecureRandom();
        int num = rand.nextInt(100000);
        String cve = String.format("%05d", num);
        String clave = String.valueOf(Integer.parseInt(cve));
        logger.info("Clave Generada para la apertura del PDF via SMS: --> {} <--", clave);
        return clave;
    }
}
