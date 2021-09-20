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
 * Nombre:      InvokeRestServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:28:57
 */
package io.kebblar.petstore.api.support;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import io.kebblar.petstore.api.model.exceptions.GoogleCaptchaException;
import io.kebblar.petstore.api.model.exceptions.ProcessPDFException;
import io.kebblar.petstore.api.model.request.GoogleCaptcha;
import io.kebblar.petstore.api.model.request.SmsRequest;
import io.kebblar.petstore.api.model.response.SmsResponse;

/**
 * Implementación de la interfaz {@link io.kebblar.petstore.api.support.InvokeRestService}.
 *
 * @author dalvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service("invokeRestService")
public class InvokeRestServiceImpl implements InvokeRestService {
    private RestTemplate restTemplate;

    /**
     * <p>Constructor for InvokeRestServiceImpl.</p>
     *
     * @param restTemplate a {@link org.springframework.web.client.RestTemplate} object.
     */
    public InvokeRestServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * <p>getBitsoInfo2.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBitsoInfo2() {
        String url = "https://api.bitso.com/v3/ticker/?book=btc_mxn";
        //RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "curl");     //"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return restTemplate.postForObject(url, entity, String.class);

        // https://stackoverflow.com/questions/16781680/http-get-with-headers-using-resttemplate
        //return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }

    /** {@inheritDoc} */
    @Override
    public String checkCaptcha(GoogleCaptcha googleCaptcha) throws GoogleCaptchaException {
        try {
            String result = genericChecker(
                    GoogleCaptcha.GOOGLE_RECAPTCHA_VERIFY_URL,
                    GoogleCaptcha.GOOGLE_RECAPTCHA_SECRET_CODE,
                    googleCaptcha.getResponse());
            return result;
        } catch (RestClientException e) {
            throw new GoogleCaptchaException(e);
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

        //RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        String body = ""; // No recibe nada en su body... lo manda como parámetros en el url
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForObject(redirectUrl.toString(), entity, String.class);
    }

    /** {@inheritDoc} */
    @Override
    public SmsResponse smsSend(String url, String credential, String tel, String msj) throws ProcessPDFException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("credentials", credential);
            SmsRequest smsRequest = new SmsRequest(tel, msj);
            HttpEntity<SmsRequest> request = new HttpEntity<>(smsRequest, headers);
            ResponseEntity<SmsResponse> result = restTemplate.postForEntity(url, request, SmsResponse.class);
            SmsResponse resp= result.getBody();
            return resp;
        } catch (Exception e) {
            throw new ProcessPDFException(e);
        }
    }
}
