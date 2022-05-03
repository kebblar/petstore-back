package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.List;

import io.kebblar.petstore.api.model.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.ConsultaMapper;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.CustomException;
import io.kebblar.petstore.api.model.request.ConsultaRequest;
import io.kebblar.petstore.api.model.response.ConsultaResponse;
import io.kebblar.petstore.api.utils.JwtHelper;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    private static final Logger logger = LoggerFactory.getLogger(ConsultaServiceImpl.class);

    private final ConsultaMapper consultaMapper;
    private final AccessHelperService accessHelperService;
    private final JwtHelper jwtHelper;

    public ConsultaServiceImpl(
            AccessHelperService accessHelperService,
            ConsultaMapper consultaMapper,
            JwtHelper jwtHelper) {
        this.accessHelperService = accessHelperService;
        this.consultaMapper = consultaMapper;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public List<ConsultaResponse> consulta(String jwt) throws ServiceException {
        // Obtén el id asociado al usuario que mandó el jwt:
        int id = this.getUserIdFromJwt(jwt);
        try {
            return consultaMapper.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String guarda(String jwt, List<ConsultaRequest> datos) throws ServiceException{
          // Obtén el id asociado al usuario que mandó el jwt:
        int idUser = this.getUserIdFromJwt(jwt);

        // Ve a la base de datos y borra todos los datos asociados:
        try {
            consultaMapper.delete(idUser);
        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }

        // Ve a la base de datos y guarda los resultados:
        for(ConsultaRequest current : datos) {
            try {
                if(idUser>0 && current.getSelected()>0) consultaMapper.insert(idUser, current.getId(), current.getSelected());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return "{'succeed':'true'}".replace('\'', '\"');
    }

    private int getUserIdFromJwt(String jwt) throws ServiceException {
        try {
            String correo = jwtHelper.bodyToObject(jwt).getMail();
            Usuario usr = accessHelperService.getUsuarioByCorreo(correo);
            return usr.getId();
        } catch (CustomException e) {
            return 0;
        }
    }
}
