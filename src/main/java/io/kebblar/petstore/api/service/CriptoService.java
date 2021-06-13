/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion 
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 * 
 * Artefacto:   CriptoService .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Sunday 13 de June de 2021 (13_15)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210608_1315 Implementación de interface 
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BitcoinTransactionException;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import io.kebblar.petstore.api.model.response.MontoBitcoin;

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
    int insertTransaccion(TransaccionBtc transaccionBtc) throws MapperCallException;

    /**
     * Método que agenda una llamada a determinada api con acceso a la información de la blockchain
     * para poder determinar si un pago hecho con criptomonedas al negocio ya ha sido agregado a la
     * blockchain. de ser así se podrá comenzar a procesar la compra del usuario.
     * @throws BusinessException En caso de algun error.
     */
    void schedulerBlockchain() throws BitcoinTransactionException;

    /**
     * Convierte el monto recibido de pesos mecxicanos a bitcoin y adicional a ello informa tambi'en
     * del precio al que hizo el cambio.
     * @param monto cantidad en pesos mexicanos a ser convertida.
     * @return Objeto con la informaci'on de la conversi'on.
     * @throws BitcoinTransactionException Cuando hay alg'un problema con la conversi'on.
     */
    MontoBitcoin getMonto(double monto) throws BitcoinTransactionException;
}
