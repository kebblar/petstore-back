package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class CriptoServiceImpl implements CriptoService {

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
        try{
            return criptoMapper.getByUser(id);
        }catch (SQLException e){
            throw new MapperCallException("Problema recuperando las direcciones","No podemos procesar la solicitud de cartera digital");
        }
    }

    @Override
    public int insertTransaccion(TransaccionBtc transaccionBtc) throws BusinessException {
        try{
            return criptoMapper.insertTransaccion(transaccionBtc);
        }catch (SQLException e){
            throw new BusinessException();
        }
    }

    @Override
    @Scheduled(fixedDelay = 3600000) //Se invoca el m'etodo cada hora
    public void schedulerBlockchain() throws BusinessException {
        System.out.println("--------------------\n");
        System.out.println("Llamando servicio de verificacion de blockchain");
        List<TransaccionBtc> transactions;
        try{
            transactions = criptoMapper.getAll();
        }catch(SQLException e){
            throw new BusinessException();
        }
        for(TransaccionBtc transaction : transactions){
            String wallet = transaction.getWallet();
            System.out.println(wallet);
            BlockCyperChecker blockChecker = remoteRestCallService.verifyBalance(wallet);
            System.out.println(blockChecker.toString());
            String uniqueID = UUID.randomUUID().toString();
            if(blockChecker.getTotalReceived()!=0){
                System.out.println("lA DIRECCION "+ wallet + " ACABA DE DEPOSITAR");
                DatosOrden datos = new DatosOrden(0,
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
                System.out.println(datos.toString());
                try{
                    ordenCompraService.procesarOrdenCompra(datos); //La compra comienza a procesarse cuando el pago es acreditado
                    criptoMapper.delete(transaction.getId()); // Se borra del historial de transacciones pendientes
                }catch(SQLException e){
                    throw new BusinessException();
                }

            }
        }
    }
}
