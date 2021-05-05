package io.kebblar.petstore.api.service;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.ContadorMapper;
import io.kebblar.petstore.api.model.domain.TablasContador;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

@Service
public class ContadorServiceImpl implements ContadorService {
    private ContadorMapper contadorMapper;
    
    public ContadorServiceImpl(ContadorMapper contadorMapper) {
        this.contadorMapper = contadorMapper;
    }

    @Override
    public int getUsuarioDetalleCounter() throws BusinessException {
        return this.getTableCounter("usuario_detalle");
    }
    
    @Override
    public int getUsuarioCounter() throws BusinessException {
        return this.getTableCounter("usuario");
    }

    @Override
    public int getPaisCounter() throws BusinessException {
        return this.getTableCounter("pais");
    }

    @Override
    public int getEstadoCounter() throws BusinessException {
        return this.getTableCounter("estado");
    }

    @Override
    public int getMunicipioCounter() throws BusinessException {
        return this.getTableCounter("municipio");
    }
    
    @Override
    public Integer getTableCounter(String tabla) throws BusinessException {
        String ESQUEMA = "petstore";
        // ********************************** Change previous var 'ESQUEMAS' Accordingly !!!
        try {
            return this.contadorMapper.getTableCount(ESQUEMA, tabla);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener el número de tuplas de la tabla: "+ tabla + " (tabla posiblemente inexistente)", e.getMessage());
        }
    }

    @Override
    public String getTableCounter2(TablasContador contador) throws BusinessException {
        int response = getTableCounter(contador.getTabla());
        return "{\"tabla\":\""+contador.getTabla()+"\", \"contador\": "+response+"}";
    }

}
