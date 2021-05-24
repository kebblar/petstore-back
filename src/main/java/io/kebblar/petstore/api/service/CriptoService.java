package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

public interface CriptoService {

    /**
     * Retorna la billetera digital asociada a determinado usuario del cual conocemos su id dentro del sistema.
     * @param id Representa el id del usuario del que se recuperar'a la cartera.
     * @return Cadena que representa la cartera bitcoin del usuario.
     * @throws MapperCallException Cuando hay un problema recuperando la informaci'on.
     */
    String getByUser(int id) throws MapperCallException;

    /**
     * Metodo que inserta una peticion de pago con bitcoin de un anuncio dentro del sistema.
     * @param transaccionBtc Objeto que contiene los datos de la compra en potencia.
     * @return entero que indica si la inserci'on fue exitosa.
     * @throws BusinessException Si ocurre un problema.
     */
    int insertTransaccion(TransaccionBtc transaccionBtc) throws BusinessException;

    /**
     * Método que agenda una llamada a determinada api con acceso a la información de la blockchain
     * para poder determinar si un pago hecho con criptomonedas al negocio ya ha sido agregado a la
     * blockchain. de ser así se podrá comenzar a procesar la compra del usuario.
     * @throws BusinessException En caso de algun error.
     */
    void schedulerBlockchain() throws BusinessException;

}
