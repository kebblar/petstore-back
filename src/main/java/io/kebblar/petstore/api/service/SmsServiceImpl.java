/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   SmsServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Daniel Alvarez Morales
 * Fecha:       20 de Junio de 2021 (16_00)
 *
 * Historia:    .
 *              20210620_1600 Creación
 *
 */
package io.kebblar.petstore.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.exceptions.ProcessPDFException;
import io.kebblar.petstore.api.model.response.SmsResponse;
import io.kebblar.petstore.api.support.InvokeRestService;

/**
 * Implementación de la interfaz {@link SmsService}.
 * 
 * @author dalvarez
 * @see io.kebblar.petstore.api.service.SmsService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
    
    private Environment environment;
    private InvokeRestService invokeRestSMSService;
    
    public SmsServiceImpl(Environment environment, InvokeRestService invokeRestSMSService) {
    	this.environment=environment;
    	this.invokeRestSMSService=invokeRestSMSService;
    }

	@Override
	public void envioSms(String numero, String msj) throws ProcessPDFException {
	    logger.info("Inicia envio SMS");
    	    String urlSMS= environment.getProperty( "app.sms.urlservice" );
    	    String credential = environment.getProperty( "app.sms.credentials" );
    	    SmsResponse responseSMS = invokeRestSMSService.smsSend(urlSMS, credential, "+52"+numero, msj);
    	    logger.info("Response:"+responseSMS.isExito());
	}

	@Override
	public String getCveSMS() {
	    double cve = 10000 + Math.random() * 90000;
	    return String.valueOf((int) cve);
	}
}
