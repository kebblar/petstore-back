/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CriptoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:43:55
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CarritoMapper;
import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BitcoinTransactionException;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import io.kebblar.petstore.api.model.response.MontoBitcoin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class CriptoServiceImpl implements CriptoService {
    private static final Logger logger = LoggerFactory.getLogger(CriptoServiceImpl.class);

    private CriptoMapper criptoMapper;
    private RemoteRestCallService remoteRestCallService;
    private OrdenCompraService ordenCompraService;
    private CarritoMapper carritoMapper;

    public CriptoServiceImpl(CarritoMapper carritoMapper, CriptoMapper criptoMapper, RemoteRestCallService remoteRestCallService, OrdenCompraService ordenCompraService){
        this.criptoMapper=criptoMapper;
        this.carritoMapper=carritoMapper;
        this.remoteRestCallService=remoteRestCallService;
        this.ordenCompraService = ordenCompraService;
    }

    @Override
    public String getByUser(int id) throws MapperCallException {
        try {
            return criptoMapper.getByUser(id);
        } catch (SQLException e) {
            throw new MapperCallException("Problema recuperando las direcciones","No podemos procesar la solicitud de cartera digital");
        }
    }

    @Override
    public int insertTransaccion(TransaccionBtc transaccionBtc) throws MapperCallException {
        try{
            List<Carrito> carrito = carritoMapper.getAll(transaccionBtc.getIdUsuario());
            for (Carrito c : carrito) {
                c.setCveOrdenCompra("btcPen");
                carritoMapper.update(c);
            }
            return criptoMapper.insertTransaccion(transaccionBtc);
        }catch (SQLException e){
            throw new MapperCallException("Problema insertando la transaccion", "Problema de insercion");
        }
    }

    @Override
    @Scheduled(fixedDelay = 12*60*60*1000) //Se invoca el metodo cada 12 horas
    public void schedulerBlockchain() throws BitcoinTransactionException {
        logger.info("Llamando servicio de verificacion de blockchain CADA 12 horas");
        List<TransaccionBtc> transactions;
        try {
            transactions = criptoMapper.getAll();
        } catch(SQLException e){
            throw new BitcoinTransactionException("No puede recuperarse la lista de ordenes pendientes");
        }
        if (transactions.isEmpty()) {
            logger.info("No hay transacciones btc pendientes");
        } else {
            //Revisamos cada transaccion para ver si esta ya a parece en la blockchain
            for(TransaccionBtc transaction : transactions) {
                String wallet = transaction.getWallet();
                BlockCyperChecker blockChecker = remoteRestCallService.verifyBalance(wallet);
//                blockChecker.setBalance(1);
                logger.info(blockChecker.toString());
                    if(blockChecker.getBalance()>0){
                        //Se verifica si el balance es distinto a cero
                        logger.info("Deposito encontrado de la direccion: " + wallet);
                        //Puede ser que el balance haya sido registrado con anterioridad, por lo que hay que verificar si es el mismo que
                        //se tiene registrado desde la ultima verificaci'on.
                        if(blockChecker.getBalance()==transaction.getLastBalance()){
                            logger.info("deposito ya registrado en la direccion: " + wallet);
                            continue;
                        }else {
                            if(blockChecker.getBalance()>=(transaction.getLastBalance()+transaction.getMonto())){
                                DatosOrden datos = setNuevaOrden(transaction);
                                logger.info(datos.toString());
                                try {
                                    ordenCompraService.procesarOrdenCompra(datos); //La compra comienza a procesarse cuando el pago es acreditado
                                    criptoMapper.delete(transaction.getId()); // Se borra del historial de transacciones pendientes
                                } catch (SQLException | BusinessException e) {
                                    throw new BitcoinTransactionException("No puede procesarse la orden de compra o eliminarse");
                                }
                            }else {
                                logger.info("Balance insuficiente, contactar con el comprador");
                            }
                            try {
                                // se actualiza el balance con el nuevo monto encontrado
                                transaction.setLastBalance(blockChecker.getBalance());
                                criptoMapper.updateTransaccion(transaction);
                                logger.info("Datos Transaccion actualizados:" + transaction.toString());
                            }catch (SQLException e){
                                throw new BitcoinTransactionException("No pudo actualizarse el monto de la nueva transaccion encontrada");
                            }
                        }
                    }
            }
        }
    }

    /**
     * Crea un objeto orden con los datos de una transacción.
     * @param transaction Transacción btc almacenada.
     * @return Objeto datosOrden con los datos pasados como parámetro.
     */
    private DatosOrden setNuevaOrden(TransaccionBtc transaction) {
        String uniqueID = UUID.randomUUID().toString();
        return new DatosOrden(  transaction.getIdUsuario(),
                                transaction.getIdDireccion(),
                                transaction.getIdPaqueteria(),
                                2,
                                3,
                                uniqueID.substring(18),
                                transaction.getFecha(),
                                false,
                                (long)transaction.getMonto(),
                                transaction.getDescripcion(),
                                "");
    }

    @Override
    public MontoBitcoin getMonto(double monto) throws BitcoinTransactionException {
        String claseMonto = remoteRestCallService.convierte();
        int loc = claseMonto.indexOf("last");
        double price = new Double(claseMonto.substring(loc).split("\"")[2]);
        return new MontoBitcoin(round(monto/price,5), price);
    }

    /**
     * Método que redondea un número a determinados decimales.
     * @param value Número a redondear.
     * @param places Cantidad de decimales a los que se redondeará.
     * @return Resultado después del redondeo.
     */
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
