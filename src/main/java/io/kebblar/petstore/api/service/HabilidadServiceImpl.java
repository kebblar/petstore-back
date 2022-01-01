package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.kebblar.petstore.api.mapper.HabilidadMapper;
import io.kebblar.petstore.api.model.domain.Habilidad;
import io.kebblar.petstore.api.model.domain.UsuarioHabilidad;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.response.HabilidadResponse;

@Service
public class HabilidadServiceImpl implements HabilidadService {
    private HabilidadMapper habilidadMapper;

    public HabilidadServiceImpl(HabilidadMapper habilidadMapper) {
        this.habilidadMapper = habilidadMapper;
    }
    
    @Override
    public List<Habilidad> getHabilidades() throws BusinessException {
        try {
            return habilidadMapper.getHabilidades();
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener las habilidades. Msg: ", e.getMessage());
        }
    }

    @Override
    public int insertUsuarioHabilidad(UsuarioHabilidad usuarioHabilidad) throws BusinessException {
        try {
            return habilidadMapper.insertUsuarioHabilidad(usuarioHabilidad);
        } catch (SQLException e) {
            throw new MapperCallException("Error al insertar la habilidad. Msg: ", e.getMessage());
        }
    }

    @Override
    public int deleteUsuarioHabilidades(int id) throws BusinessException {
        try {
            return habilidadMapper.deleteUsuarioHabilidades(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al eliminar la habilidad. Msg: ", e.getMessage());
        }
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = TransactionException.class)
    public int insertUsuarioHabilidad(List<UsuarioHabilidad> usuarioHabilidadesList) throws BusinessException {
        // esto es una transacción ACID :
        for(UsuarioHabilidad habilidad : usuarioHabilidadesList) {
            try {
                this.insertUsuarioHabilidad(habilidad);
            } catch (BusinessException e) {
                throw new TransactionException(e.getMessage());
            }
        }
        return usuarioHabilidadesList.size();
    }
    
    @Override
    public List<HabilidadResponse> getHabilidadResponseList(int id) throws BusinessException {
        try {
            return habilidadMapper.getHabilidadResponseList(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener la habilidad. Msg: "+id, e.getMessage());
        }
    }

    @Override
    public List<HabilidadResponse> getHabilidadResponseListGratis(int id) throws BusinessException {
        try {
            return habilidadMapper.getHabilidadResponseListGratis(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener la habilidad. Msg: "+id, e.getMessage());
        }
    }

    @Override
    public List<HabilidadResponse> getHabilidadResponseListConCosto(int id) throws BusinessException {
        try {
            return habilidadMapper.getHabilidadResponseListConCosto(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener la habilidad. Msg: "+id, e.getMessage());
        }
    }

}
