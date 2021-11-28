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
 * Nombre:      RemoteRestCallServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:22:35
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.response.MontoBitcoin;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.kebblar.petstore.api.model.domain.TickerWrapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class RemoteRestCallServiceImpl implements RemoteRestCallService {

    private final RestTemplate restTemplate;

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

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "curl");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        return restTemplate.postForObject(url, entity, String.class);
    }

    @Override
    public MontoBitcoin getMonto(double monto, int decimas) {
        String claseMonto = convierte();
        int loc = claseMonto.indexOf("last");
        double price = Double.parseDouble(claseMonto.substring(loc).split("\"")[2]);
        return new MontoBitcoin(round(monto/price,decimas), price);
    }

    /**
     * Método que redondea un número a determinados decimales.
     * @param value Número a redondear.
     * @param places Cantidad de decimales a los que se redondeará.
     * @return Resultado después del redondeo.
     */
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
