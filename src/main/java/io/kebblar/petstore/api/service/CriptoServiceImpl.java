package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.CriptoMapper;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CriptoServiceImpl implements CriptoService {

    private CriptoMapper criptoMapper;

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
}
