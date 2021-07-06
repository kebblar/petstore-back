/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Modulo:      JWTUtil
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Jueves 2 de Abril de 2020 (22_29)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion del Servicio de informe de salud
 *
 * Historia:    .
 *              20200402_2229 Creación del tipo
 *
 */
package io.kebblar.petstore.api.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.WrongTokenException;

/**
 * Clase JWTUtil.
 */
public class JWTUtil {
    private static final Logger logger = LoggerFactory.getLogger(JWTUtil.class);
    private static JWTUtil instance = null;

    private JWTUtil() {
    }
    
    public static JWTUtil getInstance() {
        if(instance==null) {
            instance = new JWTUtil();
        }
        return instance;
    }

    public String digest(String source, String salt) {
        try {
            return toHexString(getSHA256(source, salt));
        } catch (NoSuchAlgorithmException e) {
            // This Wouldn't ocurr never ever...
            return null;
        }
    }
    
    /**
     * Regresa un arreglo de bytes que es la digestión de un input dado y un 'salt' dado.
     * Generalmente, el 'salt' va a ser el usuario, para este caso de uso. (Auth)
     *
     * @param source Cadena a digestar (Generalmente el password)
     * @param salt Cadena a incluir como 'salt' (Generalmente el Usuaio)
     *
     * @return Areeglo de bytes con la composición digestada
     *
     * @throws NoSuchAlgorithmException No va a pasar nunca, ya que el SHA-256 siempre exste
     */
    public byte[] getSHA256(String source, String salt) throws NoSuchAlgorithmException {
        // Create the 'input' String with a 'salt', generally,
        String input = source + salt;
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Convierte un arreglo de bytes en una cadena hexadecimal.
     *
     * @param hash Arreglo de bytes a ser convertido a cadena.
     *
     * @return Cadena asociada al arreglo dado
     */
    public String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        // Show me the result, baby
        return hexString.toString();
    }
    
    public void verifyToken(String jwt, String user, String encryptKey) throws BusinessException {
        try {
            Claims claims = Jwts.parser()
               .setSigningKey(encryptKey.getBytes())
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
    
    public static void valida(String token, long currentTime) throws Exception {
        if(token==null || token.trim().length()<1) return;
        String estructuraInvalida = "El token posee una estructra inválida: --->"+token+"<---";
        // from: https://jwt.io/
        Base64.Decoder decoder = Base64.getDecoder();
        String[] chunks = token.split("\\.");
        if(chunks.length<2) throw new Exception(estructuraInvalida);
        String payload = new String(decoder.decode(chunks[1]));
        
        if(!payload.contains("\"exp\":")) throw new Exception(estructuraInvalida);
        Long inst = 0L;
        String instante = "";
        for(String parte : payload.split(",")) {
            if(parte.contains("\"exp\":")) {
                try {
                    instante = parte.substring(6, parte.length()-1)+"000";
                    inst = new Long(instante);
                } catch(Exception e) {
                    throw new Exception(estructuraInvalida);
                }
                if (inst < currentTime) throw new Exception("El token ha expirado");
            }
        }
    }
    
//    public static void main(String...argv) {
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjcnlwdG8tZXhlY3V0b3Itand0TWFuYWdlciIsImlhdCI6MTYyNTUyMTYyNiwic3ViIjoiQ29vbCBqd3QgVG9rZW4gb246IDE2MjU1MjE2MjYyMTIiLCJqdGkiOiJndXN0YXZvLWFyZWxsYW5vQGdtYWlsLmNvbSIsImV4cCI6MTYyNTUyMzQyNn0._Omitk0L5XDduhPGaWcmvWBArimQw4lE8qthXK6q1Ys";
//        boolean res = isExpired(token);
//        System.out.println(res);
//    }
    
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
    
    public String getMail(String jwt, String encryptKey) throws BusinessException {
        Claims claim;
        try{
            claim = Jwts.parser().setSigningKey(encryptKey.getBytes()).parseClaimsJws(jwt).getBody();
        } catch (Exception e){
            throw new WrongTokenException(e.getMessage());
        }
        return claim.getId();
    }

}
