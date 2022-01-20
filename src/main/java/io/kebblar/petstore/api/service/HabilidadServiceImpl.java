package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.kebblar.petstore.api.mapper.HabilidadMapper;
import io.kebblar.petstore.api.model.domain.UsuarioHabilidad;
import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.exceptions.MapperException;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.response.HabResponse;

@Service
public class HabilidadServiceImpl implements HabilidadService {
    private HabilidadMapper habilidadMapper;

    public HabilidadServiceImpl(HabilidadMapper habilidadMapper) {
        this.habilidadMapper = habilidadMapper;
    }
    
    @Override
    public List<HabResponse> getHabilidades() throws ServiceException {
        try {
            return habilidadMapper.getAllPlainHabilidades();
        } catch (Exception e) {
            throw new MapperException("Error al obtener las habilidades. Msg: ", e.getMessage());
        }
    }

    @Override
    public int insertUsuarioHabilidad(UsuarioHabilidad usuarioHabilidad) throws ServiceException {
        try {
            return habilidadMapper.insertUsuarioHabilidad(usuarioHabilidad);
        } catch (Exception e) {
            throw new MapperException("Error al insertar la habilidad. Msg: ", e.getMessage());
        }
    }

    @Override
    public int deleteUsuarioHabilidades(int id) throws ServiceException {
        try {
            return habilidadMapper.deleteUsuarioHabilidades(id);
        } catch (Exception e) {
            throw new MapperException("Error al eliminar la habilidad. Msg: ", e.getMessage());
        }
    }
    
    @Override
    public int insertUsuarioHabilidad(List<Integer> usuarioHabilidadesList, String correo) throws ServiceException {
        int size = usuarioHabilidadesList.size();
        int idUser = usuarioHabilidadesList.get(0);
        // if(idUser!=usuarioMapper.getByCorreo(correo).getId()) throw new ServiceException(UNAUTHORIZED);
        this.deleteUsuarioHabilidades(idUser);
        List<UsuarioHabilidad> lista = new ArrayList<>();
        for(int i=1; i<size; i++) { // NO TOMAR EL 0 !!!!!!!!!!!
            int estatus = usuarioHabilidadesList.get(i);
            if(estatus>0) {
                int costo = 0;
                if(estatus==2) costo = 1;
                lista.add(new UsuarioHabilidad(idUser, i, costo));
            }
        }
        return this.insertUsuarioHabilidad(lista);
    }
    
    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = TransactionException.class)
    public int insertUsuarioHabilidad(List<UsuarioHabilidad> usuarioHabilidadesList) throws ServiceException {
        // esto es una transacción ACID :
        for(UsuarioHabilidad habilidad : usuarioHabilidadesList) {
            try {
                this.insertUsuarioHabilidad(habilidad);
            } catch (ServiceException e) {
                throw new TransactionException(e.getMessage());
            }
        }
        return usuarioHabilidadesList.size();
    }
    
    @Override
    public List<HabResponse> getHabilidadResponseList(int id) throws ServiceException {
        try {
            return habilidadMapper.getHabilidadResponseList(id);
        } catch (Exception e) {
            throw new MapperException("Error al obtener la habilidad. Msg: "+id, e.getMessage());
        }
    }

    @Override
    public List<HabResponse> getHabilidadResponseListGratis(int id) throws ServiceException {
        try {
            return habilidadMapper.getHabilidadResponseListGratis(id);
        } catch (Exception e) {
            throw new MapperException("Error al obtener la habilidad. Msg: "+id, e.getMessage());
        }
    }

    @Override
    public List<HabResponse> getHabilidadResponseListConCosto(int id) throws ServiceException {
        try {
            return habilidadMapper.getHabilidadResponseListConCosto(id);
        } catch (Exception e) {
            throw new MapperException("Error al obtener la habilidad. Msg: "+id, e.getMessage());
        }
    }

//    private List<HabResponse> transform(List<HabilidadResponse> list) throws ServiceException {
//        List<HabResponse> result = new ArrayList<>();
//        for(HabilidadResponse h : list) {
//            result.add(new HabResponse(h.getHabilidadId(), h.getNombre(), h.getCosto()));
//        }
//        return result; 
//    }
}
