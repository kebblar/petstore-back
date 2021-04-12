package io.kebblar.petstore.api.service;

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

}
