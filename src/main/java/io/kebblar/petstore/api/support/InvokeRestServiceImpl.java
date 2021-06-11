package io.kebblar.petstore.api.support;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.kebblar.petstore.api.model.exceptions.GoogleCaptchaException;
import io.kebblar.petstore.api.model.request.GoogleCaptcha;

@Service("invokeRestService")
public class InvokeRestServiceImpl implements InvokeRestService {
    
    public String getBitsoInfo2() {
        String url = "https://api.bitso.com/v3/ticker/?book=btc_mxn";
        RestTemplate restTemplate = new RestTemplate();
                
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "curl");     //"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
        return restTemplate.postForObject(url, entity, String.class);
        
        // https://stackoverflow.com/questions/16781680/http-get-with-headers-using-resttemplate
        //return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }
    
    
    @Override
    public String checkCaptcha(GoogleCaptcha googleCaptcha) throws GoogleCaptchaException {
        try {
            String result = genericChecker(
                    GoogleCaptcha.GOOGLE_RECAPTCHA_VERIFY_URL,
                    GoogleCaptcha.GOOGLE_RECAPTCHA_SECRET_CODE,
                    googleCaptcha.getResponse());
            return result;
        } catch (RestClientException e) {
            throw new GoogleCaptchaException(e.getMessage());
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

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        String body = ""; // No recibe nada en su body... lo manda como parámetros en el url
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForObject(redirectUrl.toString(), entity, String.class);
    }

}
