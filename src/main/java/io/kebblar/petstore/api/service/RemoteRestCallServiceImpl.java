/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      Direccion
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */
package io.kebblar.petstore.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.kebblar.petstore.api.model.domain.TickerWrapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Implementación de la interfaz {@link RemoteRestCallService}.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.TickerWrapper
 * @see     io.kebblar.petstore.api.service.RemoteRestCallService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Service
public class RemoteRestCallServiceImpl implements RemoteRestCallService {

    private RestTemplate restTemplate;

    /**
     * Constructor que realiza el setting de todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param restTemplate
     */
    public RemoteRestCallServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TickerWrapper callTickerMicroservice() {
        String url = "https://api.binance.com/api/v1/ticker/24hr?symbol=ETHUSDT";
        return restTemplate.getForObject(url, TickerWrapper.class);
    }

}
