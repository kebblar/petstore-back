package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
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

@Service
public class CriptoServiceImpl implements CriptoService {

    private CriptoMapper criptoMapper;
    private RestTemplate restTemplate = new RestTemplate();
    private RemoteRestCallService remoteRestCallService = new RemoteRestCallServiceImpl(restTemplate);

    public CriptoServiceImpl(CriptoMapper criptoMapper){
        this.criptoMapper=criptoMapper;
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
    @Scheduled(fixedDelay = 10000)
    public void schedulerBlockchain() throws BusinessException {
        System.out.println("Llamando servicio de verificacion de blockchain");
        List<TransaccionBtc> transactions;
        try{
            transactions = criptoMapper.getAll();
        }catch(SQLException e){
            throw new BusinessException();
        }
        Iterator<TransaccionBtc> transaccionBtcIterator = transactions.iterator();
        while(transaccionBtcIterator.hasNext()){
            String wallet = transaccionBtcIterator.next().getWallet();
            int id = transaccionBtcIterator.next().getId();
            System.out.println(wallet);
            BlockCyperChecker blockChecker = remoteRestCallService.verifyBalance(wallet);
            if(blockChecker.getTotalReceived()!=0){
                System.out.println("Enviamos correo al usuario");
                System.out.println("El balance es: "+ blockChecker.getBalance());
                try{
                    criptoMapper.delete(id);
                }catch(SQLException e){
                    throw new BusinessException();
                }

            }
        }
    }
}
