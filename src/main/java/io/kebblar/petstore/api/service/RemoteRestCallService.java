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
 * Tipo:        Interface
 * Nombre:      RemoteRestCallService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:22:25
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.domain.TickerWrapper;
import io.kebblar.petstore.api.model.response.MontoBitcoin;

public interface RemoteRestCallService {
    /**
     * Retorna el valor de una criptomoneda en el instante actual.
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

    /**
     * Realiza una conversion del monto ingresado en pesos mexicanos a bitcoin, devolviendo la conversion
     * a la criptomoneda y el tipo de cambio al momento que se invocó el método.
     * @param monto Monto en pesos mexicanos a convertir en Bitcoin.
     * @param decimas Décimas a redondear el resultado.
     * @return Objeto {@link MontoBitcoin} con el monto convertido y el tipo de cambio al momento de la solicitud.
     */
    public MontoBitcoin getMonto(double monto, int decimas);
}
