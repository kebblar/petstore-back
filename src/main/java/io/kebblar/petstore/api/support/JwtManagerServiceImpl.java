package io.kebblar.petstore.api.support;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.WrongTokenException;

@Service
public class JwtManagerServiceImpl implements JwtManagerService {
    private static final Logger logger = LoggerFactory.getLogger(JwtManagerServiceImpl.class);
    public static final String ENCRYPT_KEY = "gustavo";

    private int securityTokenLasts=30; // 30 minutos dura el jwt

    public JwtManagerServiceImpl() {
        // en un futuro, aqui se va a cargar el 'securityTokenLasts'
    }

    @Override
    public String createToken(final String username) {
        byte[] key = ENCRYPT_KEY.getBytes();

        Calendar calendar = Calendar.getInstance();
        Date issued = calendar.getTime();

        calendar.add(Calendar.MINUTE, securityTokenLasts);
        Date expiration = calendar.getTime();

        final JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuer("crypto-executor-jwtManager");
        jwtBuilder.setIssuedAt(issued);
        jwtBuilder.setSubject("Cool jwt Token on: " + System.currentTimeMillis());
        jwtBuilder.setId(username);
        jwtBuilder.setExpiration(expiration);
        String token = jwtBuilder.signWith(SignatureAlgorithm.HS256, key).compact();
        logger.debug("Token for '"+username+"' has been created: " + token);
        return token;
    }

    @Override
    public void verifyToken(String jwt, String user) throws BusinessException {
        try {
            Claims claims = Jwts.parser()
               .setSigningKey(ENCRYPT_KEY.getBytes())
               .parseClaimsJws(jwt).getBody();
            if(logger.isDebugEnabled()) {
                logger.info("ID: " + claims.getId());
                logger.info("Subject: " + claims.getSubject());
                logger.info("Issuer: " + claims.getIssuer());
                logger.info("Expiration: " + claims.getExpiration());
                logger.info("IssuedAt: " + claims.getIssuedAt());
            }
            if(!user.equals(claims.getId())) {
                throw new WrongTokenException("issuer not verfied");
            }
        } catch(Exception e) {
            throw new WrongTokenException(e.getMessage());
        }
    }

    @Override
    public String getMail(String jwt) throws BusinessException {
        Claims claim;
        try{
            claim = Jwts.parser().setSigningKey(ENCRYPT_KEY.getBytes()).parseClaimsJws(jwt).getBody();
        } catch (Exception e){
            throw new WrongTokenException(e.getMessage());
        }
        return claim.getId();
    }
}
