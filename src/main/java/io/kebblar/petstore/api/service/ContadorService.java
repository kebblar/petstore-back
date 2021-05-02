package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TablasContador;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

public interface ContadorService {
    /**
     * Regresa el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     * @throws BusinessException
     */
    int getUsuarioDetalleCounter() throws BusinessException;
   
    int getUsuarioCounter() throws BusinessException;
    int getPaisCounter() throws BusinessException;
    int getEstadoCounter() throws BusinessException;
    int getMunicipioCounter() throws BusinessException;

    Integer getTableCounter(String tabla) throws BusinessException;
    String getTableCounter2(TablasContador contador) throws BusinessException;
}
