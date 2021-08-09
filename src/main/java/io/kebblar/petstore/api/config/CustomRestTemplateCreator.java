package io.kebblar.petstore.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.kebblar.petstore.api.utils.Convert;
import io.kebblar.petstore.api.utils.CreatePDF;

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
    @Bean
    public Convert createConvert() {
        return new Convert();
    }
    @Bean
    public CreatePDF createPDF(Convert convert) {
        return new CreatePDF(convert);
    }
}
 