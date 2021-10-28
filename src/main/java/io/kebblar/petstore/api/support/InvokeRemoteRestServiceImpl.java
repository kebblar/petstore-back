/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.support
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      InvokeRemoteRestServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:28:57
 */
package io.kebblar.petstore.api.support;

import io.kebblar.petstore.api.model.exceptions.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import io.kebblar.petstore.api.model.request.GoogleCaptcha;
import io.kebblar.petstore.api.model.request.SmsRequest;
import io.kebblar.petstore.api.model.response.SmsResponse;

import static io.kebblar.petstore.api.model.exceptions.EnumMessage.GOOGLE_CAPTCHA;

/**
 * Implementación de la interfaz {@link io.kebblar.petstore.api.support.InvokeRemoteRestService}.
 *
 * @author dalvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service("invokeRestService")
public class InvokeRemoteRestServiceImpl implements InvokeRemoteRestService {
    private final RestTemplate restTemplate;
    
    @Value("${bitso}")
    private String bitso; // loading something like https://api.bitso.com/v3/
    
    @Value("${binance}")
    private String binance;
    
    @Value("${google_recaptcha_url}")
    private String googleRecaptchaUrl;
    
    @Value("${google.recaptcha.secret}")
    private String googleRecaptchaSecret;
    
    @Value("${sms_url}")
    String smsUrl; 
    
    @Value("${sms.secret}")
    String smsSecret;

    /**
     * <p>Constructor for InvokeRemoteRestServiceImpl.</p>
     *
     * @param restTemplate a {@link org.springframework.web.client.RestTemplate} object.
     */
    public InvokeRemoteRestServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * <p>getBitsoInfo.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBitsoInfo() {
        String url = this.bitso + "ticker/?book=btc_mxn";
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "curl");     //"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.postForObject(url, entity, String.class);
        // https://stackoverflow.com/questions/16781680/http-get-with-headers-using-resttemplate
    }
    
    /**
     * <p>getBinanceInfo.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBinanceInfo() {
        String url = this.binance + "ticker/24hr?symbol=BTCUSDT";
        return restTemplate.getForObject(url, String.class);
    }
    
    /** {@inheritDoc} */
    @Override
    public String checkCaptcha(GoogleCaptcha googleCaptcha) throws BusinessException {
        try {
            return genericChecker(
                    googleRecaptchaUrl,
                    googleRecaptchaSecret,
                    googleCaptcha.getResponse());
        } catch (RestClientException e) {
            throw new CustomException(GOOGLE_CAPTCHA);
        }
    }

    private String genericChecker(String url, String secret, String response) {
        StringBuilder redirectUrl = new StringBuilder();
        redirectUrl.append(url);
        redirectUrl.append("?secret=");
        redirectUrl.append(secret);
        redirectUrl.append("&response=");
        redirectUrl.append(response);
        redirectUrl.append("&remoteip=127.0.0.1");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        String body = ""; // No recibe nada en su body... lo manda como parámetros en el smsUrl
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForObject(redirectUrl.toString(), entity, String.class);
    }

    /** {@inheritDoc} */
    @Override
    public SmsResponse smsSend(String tel, String msj) throws BusinessException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("credentials", smsSecret);
            SmsRequest smsRequest = new SmsRequest(tel, msj);
            HttpEntity<SmsRequest> request = new HttpEntity<>(smsRequest, headers);
            ResponseEntity<SmsResponse> result = restTemplate.postForEntity(smsUrl, request, SmsResponse.class);
            SmsResponse resp= result.getBody();
            return resp;
        } catch (Exception e) {
            throw new CustomException(EnumMessage.PDF_GENERATION, e.getCause());
        }
    }
}
