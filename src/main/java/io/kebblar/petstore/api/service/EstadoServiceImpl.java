package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.InternalServerException;
import io.kebblar.petstore.api.utils.ValidadorClave;

@Service
public class EstadoServiceImpl implements EstadoService {

    private EstadoMapper estadoMapper;

    public EstadoServiceImpl(EstadoMapper estadoMapper) {
        this.estadoMapper = estadoMapper;
    }

    @Override
    public List<Estado> getAll() throws BusinessException {
        try {
            return estadoMapper.getAll();
        } catch (SQLException e) {
            throw new InternalServerException("Error de comunicación con la base de datos", e.getMessage());
        }
    }

    @Override
    public Estado getEstado(int id) throws BusinessException {
        // Vamos a validar si Kebblar2017 cumple con las reglas de una "clave fuerte"
        ValidadorClave.validate("Kebblar2017");
        // Eso es fundamental para contrarestar un ataque de arcoiris contra las claves "hasheadas" y "salteadas" en DB

        try {
            return estadoMapper.getEstado(id);
        } catch (SQLException e) {
            throw new InternalServerException("Error de comunicación con la base de datos", e.getMessage());
        }
    }

}
