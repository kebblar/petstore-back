package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TickerWrapper;

public interface RemoteRestCallService {
    /**
     * Retorna el valor de una criptomoneda en el nstante actual.
     *
     * @return Clase de modelo que contiene la información de una cripto.
     */
    TickerWrapper callTickerMicroservice();
    
    String verifyBalance();
}
