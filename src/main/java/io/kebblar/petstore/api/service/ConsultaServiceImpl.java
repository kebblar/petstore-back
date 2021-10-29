package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.ConsultaMapper;
import io.kebblar.petstore.api.model.domain.Consulta;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.CustomException;
import io.kebblar.petstore.api.model.request.ConsultaRequest;
import io.kebblar.petstore.api.model.response.ConsultaResponse;
import io.kebblar.petstore.api.utils.JWTUtil;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    private static final Logger logger = LoggerFactory.getLogger(ConsultaServiceImpl.class);
    
    private ConsultaMapper consultaMapper;
    private UsuarioService usuarioService;
	List<Consulta> resultado = new ArrayList<>();

	public ConsultaServiceImpl(UsuarioService usuarioService, ConsultaMapper consultaMapper) {
	    this.usuarioService = usuarioService;
	    this.consultaMapper = consultaMapper;
	}

	@Override
	public List<ConsultaResponse> consulta(String jwt, String encryptKey) {
	    int id = getUserIdFromJwt(jwt, encryptKey);
        try {
            List<ConsultaResponse> result = consultaMapper.getById(id);
            return result;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
	}

	@Override
	public List<ConsultaRequest> guarda(String jwt, String encryptKey, List<ConsultaRequest> datos) {
        int id = getUserIdFromJwt(jwt, encryptKey);
        if(id<1) {
            // NO guardes nada y retorna lo que te mandaron
            return datos;
        }
        // Ve a la base de datos y guarda los resultados:
        try {
            consultaMapper.delete(id);
        } catch (SQLException e1) {
            logger.error(e1.getMessage());
        }
        for(ConsultaRequest current : datos) {
            try {
                Consulta consulta = new Consulta(id, current.getId(), current.getSelected());
                consultaMapper.insert(consulta);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
		return datos;
	}
	
	private int getUserIdFromJwt(String jwt, String encryptKey) {
	    try {
            String correo = JWTUtil.getInstance().getMail(jwt, encryptKey);
            Usuario usr = usuarioService.obtenUsuarioPorCorreo(correo);
            return usr.getId();
        } catch (CustomException e) {
            return 0;
        }
	}
}
