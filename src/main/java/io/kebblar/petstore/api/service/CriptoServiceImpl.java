package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BitcoinTransactionException;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class CriptoServiceImpl implements CriptoService {
    private static final Logger logger = LoggerFactory.getLogger(CriptoServiceImpl.class);

    private CriptoMapper criptoMapper;
    private RemoteRestCallService remoteRestCallService;
    private OrdenCompraService ordenCompraService;

    public CriptoServiceImpl(CriptoMapper criptoMapper, RemoteRestCallService remoteRestCallService, OrdenCompraService ordenCompraService){
        this.criptoMapper=criptoMapper;
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
            return criptoMapper.insertTransaccion(transaccionBtc);
        }catch (SQLException e){
            throw new MapperCallException("Problema insertando la transaccion", "Problema de insercion");
        }
    }

    @Override
    @Scheduled(fixedDelay = 3600000) //Se invoca el metodo cada hora
    public void schedulerBlockchain() throws BitcoinTransactionException {
        logger.info("Llamando servicio de verificacion de blockchain");
        List<TransaccionBtc> transactions;
        try {
            transactions = criptoMapper.getAll();
        } catch(SQLException e){
            throw new BitcoinTransactionException("No puede recuperarse la lista de ordenes pendientes");
        }
        if (transactions.isEmpty()) {
            logger.info("No hay transacciones pendientes");
        } else {
            //Revisamos cada transaccion para ver si esta ya a parece en la blockchain
            for(TransaccionBtc transaction : transactions) {
                String wallet = transaction.getWallet();
                BlockCyperChecker blockChecker = remoteRestCallService.verifyBalance(wallet);
                logger.info(blockChecker.toString());
                if(blockChecker.getTotalReceived()!=0) {
                    logger.info("Nuevo deposito encontrado de la direccion: " + wallet);
                    if(blockChecker.getBalance() < transaction.getMonto()) throw new BitcoinTransactionException("El monto depositado no es correcto");
                    DatosOrden datos = setNuevaOrden(transaction);
                    try {
                        ordenCompraService.procesarOrdenCompra(datos); //La compra comienza a procesarse cuando el pago es acreditado
                        criptoMapper.delete(transaction.getId()); // Se borra del historial de transacciones pendientes
                    } catch (SQLException | BusinessException e) {
                        throw new BitcoinTransactionException("No puede procesarse la orden de compra o eliminarse");
                    }
                }
            }
        }
    }

    private DatosOrden setNuevaOrden(TransaccionBtc transaction) {
        String uniqueID = UUID.randomUUID().toString();
        return new DatosOrden(0,
                transaction.getIdUsuario(),
                transaction.getIdDireccion(),
                1,
                2,
                3,
                transaction.getIdAnuncio(),
                uniqueID.substring(18),
                transaction.getFecha(),
                false,
                (long)transaction.getMonto(),
                (int)transaction.getMonto(),
                transaction.getDescripcion(),
                "");
    }
}
