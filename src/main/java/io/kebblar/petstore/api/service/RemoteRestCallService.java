/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   RemoteRestCallService.java
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
     *
     * @return Objeto que contiene la información requerida
     */
    BlockCyperChecker verifyBalance(String address);

    /**
     * Dado un monto en pesos, este método devuelve la cantidad convertida en bitcoin,
     * además de regresar el cambio que tomó el bitcoin para realizar la conversión llamando
     * a la api de bitso para recuperar los datos.
     *
     * @return Objeto con la información del cambio y el monto el btc.
     */
    String convierte();
}
