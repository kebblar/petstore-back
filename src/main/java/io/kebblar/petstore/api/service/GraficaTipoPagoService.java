package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * Interface para el servicio asociado a la entidad 'grafica'.
 *
 * @author Diego González
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface GraficaTipoPagoService {

    /**
     * Método utilizado para obtener una cadena indicando monto total por tipo de pago
     * 'graficaMontoTipoPago'.
     *
     * @return String.
     */
    String getMontoTotalTipoPago() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando monto total por tipo de pago
     * por rango de fechas 'graficaMontoTipoPago'.
     *
     * @return String.
     */
    String getMontoTipoPagoRango(String fechaIni, String fechaFin) throws BusinessException;

}
