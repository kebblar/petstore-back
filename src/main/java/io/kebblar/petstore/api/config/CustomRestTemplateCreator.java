package io.kebblar.petstore.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Esta clase auxiliar me permitirá invocar servicios REST de otras fuentes.
 * @author garellano
 */
@Configuration
public class CustomRestTemplateCreator {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }
}
