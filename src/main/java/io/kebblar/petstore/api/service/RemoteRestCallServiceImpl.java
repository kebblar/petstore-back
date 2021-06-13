/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   RemoteRestCallServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (17_50)
 *
 * Historia:    .
 *              20210504_1950 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.response.MontoBitcoin;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.kebblar.petstore.api.model.domain.TickerWrapper;

@Service
public class RemoteRestCallServiceImpl implements RemoteRestCallService {

    private RestTemplate restTemplate;

    public RemoteRestCallServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TickerWrapper callTickerMicroservice() {
        String url = "https://api.binance.com/api/v1/ticker/24hr?symbol=ETHUSDT";
        return restTemplate.getForObject(url, TickerWrapper.class);
    }
    public BlockCyperChecker verifyBalance(String address) {
        String url =  "https://api.blockcypher.com/v1/btc/main/addrs/"+address+"/balance";
        return restTemplate.getForObject(url,BlockCyperChecker.class);
    }

    @Override
    public String convierte() {
        String url = "https://api.bitso.com/v3/ticker/?book=btc_mxn";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "curl");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return restTemplate.postForObject(url, entity, String.class);
     //   return "abc";
    }

}
