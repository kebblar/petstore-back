package io.kebblar.petstore.api.support;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.utils.JWTUtil;

@Service
public class JwtManagerServiceImpl implements JwtManagerService {
    private Logger logger = LoggerFactory.getLogger(JwtManagerServiceImpl.class);
    
    private JWTUtil jwUtil = JWTUtil.getInstance();
    
    @Value("${security.token.lasts}")
    private String securityTokenLastsString;
    
    @Value("${jwt.encryptor.password}")
    private String ENCRYPT_KEY;
    private int securityTokenLasts;

    public JwtManagerServiceImpl() {
    }
    
    @PostConstruct
    public void init() {
        // es obvio que estos valores los tengo hasta después de
        // que se terminó de ejecutar el constrctor de la clase
        logger.info("securityTokenLastsString: " + this.securityTokenLastsString);
        try {
            this.securityTokenLasts =Integer.parseInt(securityTokenLastsString);
        } catch (Exception e) {
            logger.error(e.getMessage());
            this.securityTokenLasts = 27; // 27 minutos dura el jwt
        }
        logger.info("Duración de token de seguridad: "+securityTokenLasts);
        logger.info("Llave de encripción para el token JWT: >>>"+ENCRYPT_KEY+"<<<");
    }

    @Override
    public String createToken(final String username) {
        return jwUtil.createToken(username, securityTokenLasts, ENCRYPT_KEY);
    }

    @Override
    public void verifyToken(String jwt, String user) throws BusinessException {
        jwUtil.verifyToken(jwt, user, ENCRYPT_KEY);
    }

    @Override
    public String getMail(String jwt) throws BusinessException {
        return jwUtil.getMail(jwt, ENCRYPT_KEY);
    }

}
