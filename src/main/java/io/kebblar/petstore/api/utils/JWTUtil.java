package io.kebblar.petstore.api.utils;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static io.kebblar.petstore.api.model.enumerations.EnumMessage.*;
import io.kebblar.petstore.api.model.exceptions.CustomException;

/**
 * Clase JWTUtil.
 *
 * @author garellano
 * @version $Id: $Id
 */
public class JWTUtil {
    private static final Logger logger = LoggerFactory.getLogger(JWTUtil.class);
    private static JWTUtil instance = null;

    private JWTUtil() {
    }

    /**
     * <p>Getter for the field <code>instance</code>.</p>
     *
     * @return a {@link io.kebblar.petstore.api.utils.JWTUtil} object.
     */
    public static JWTUtil getInstance() {
        if(instance==null) {
            instance = new JWTUtil();
        }
        return instance;
    }
    
    /**
     * <p>createToken.</p>
     *
     * @param username a {@link java.lang.String} object.
     * @param securityTokenLasts a int.
     * @param encryptKey a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String createToken(final String username, int securityTokenLasts, String encryptKey) {
        byte[] key = encryptKey.getBytes();

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

    /**
     * Checa si un token dado (con estructira correcta) ha sido firmado adecuadamente.
     * En caso de que sea un token con una estructira inválida o no esté firmado de una
     * manera adecuada, dispara una excepción. Si todo esta bien, retorna "true".
     * <p> Es interesante mencionar que si a cadena jwt es verificada exitosamente, entonces
     * es posible parsear (hacer decode) al jwt de manera simple y confiar en la decodificación.
     * Ver decodeJwt para un decode en forma de cadena json.
     *
     * @param jwt Cadena jwt a verificar
     * @param encryptKey Clave de encripción
     *
     * @return Cadena jwt decodificada
     * @throws CustomException
     */
    public String revisaToken(String jwt, String encryptKey) throws CustomException {
        try {
            Jwts
               .parser()
               .setSigningKey(encryptKey.getBytes())
               .parseClaimsJws(jwt).getBody();
            return decodeJwt(jwt);
        } catch(Exception e) {
            throw new CustomException(e, WRONG_TOKEN);
        }
    }
    
    public String decodeJwt(String jwt) {
        String[] chunks = jwt.split("\\.");
        if(chunks.length<3) throw new RuntimeException("Bad jwt");
        Base64.Decoder decoder = Base64.getDecoder();

        try {
            //String header = new String(decoder.decode(chunks[0]));
            //System.out.println(header);
            String payload = new String(decoder.decode(chunks[1]));

            //String signature = new String(chunks[2]);
            //System.out.println(signature);

            return payload;
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Bad jwt");
        }
    }
    
    private String getValueFromDecodedJwtString(String decodedJwt, String field) {
        String[] partes = decodedJwt.substring(1, decodedJwt.length()-1).replaceAll("\"", "").split(",");
        Map<String, String> mapa = new HashMap<>();
        for(String parte : partes) {
            String[] d = parte.split(":");
            mapa.put(d[0], d[1]);
        }
        return mapa.get(field);
    }
    
    public String getCorreoFromDecoded(String decodedJwt) {
        return getValueFromDecodedJwtString(decodedJwt, "jti");
    }

    public long getExpirationFromDecoded(String decodedJwt) {
        String expStr = getValueFromDecodedJwtString(decodedJwt, "exp");
        return Long.valueOf(expStr);
    }
    
    public boolean revisaExpiracion(String decodedJwt) throws CustomException {
        return revisaExpiracion(decodedJwt, System.currentTimeMillis());
    }
    
    public boolean revisaExpiracion(String decodedJwt, long now) throws CustomException {
        long someFutureDay = this.getExpirationFromDecoded(decodedJwt);
        if(someFutureDay< now) throw new CustomException(TOKEN_EXPIRED);
        return true;
    }

    public boolean revisaSender(String decodedJwt, String sender) throws CustomException {
        String correo = this.getCorreoFromDecoded(decodedJwt);
        if(!sender.equals(correo)) throw new CustomException(TOKEN_INVALID);
        return true;
    }

}

/*
{
"iss":"crypto-executor-jwtManager",
"iat":1637609469,
"sub":"Cool jwt Token on: 1637609469452",
"jti":"gustavi",
"exp":1637615469
}
*/
