package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.domain.TickerWrapper;

public interface RemoteRestCallService {
    /**
     * Retorna el valor de una criptomoneda en el nstante actual.
     *
     * @return Clase de modelo que contiene la información de una cripto.
     */
    TickerWrapper callTickerMicroservice();

    /**
     * Recupera la información acerca de los movimientos de determinada cuenta dentro de
     * la blockchain de bitcoin.
     * @return Objeto que contiene la información requerida
     */
    BlockCyperChecker verifyBalance(String address);

    /**
     * Dado un monto en pesos, este método devuelve la cantidad convertida en bitcoin,
     * además de regresar el cambio que tomó el bitcoin para realizar la conversión llamando
     * a la api de bitso para recuperar los datos.
     * @return Objeto con la información del cambio y el monto el btc.
     */
    String convierte();
}
