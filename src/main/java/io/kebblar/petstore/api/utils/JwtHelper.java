package io.kebblar.petstore.api.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.kebblar.petstore.api.model.domain.JwtBody;
import io.kebblar.petstore.api.model.enumerations.EnumMessage;
import io.kebblar.petstore.api.model.enumerations.EnumRoles;
import io.kebblar.petstore.api.model.exceptions.CustomException;

public class JwtHelper {    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    private final String clave;
    
    public JwtHelper(String clave) {
        this.clave = clave;
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    public String getHeader(String jwt) {
        return obten(jwt, 0);
    }
    public String getBody(String jwt) {
        return obten(jwt, 1);
    }
    public String getSignature(String jwt) {
        return obten(jwt, 2);
    }
    private String add(String s1, String s2, String s3) {
        return s1 + "." + s2 + "." + s3;
    }
    public String base64decode(String source) {
        return new String(Base64.getUrlDecoder().decode(source.getBytes()));
    }
    private byte[] getSHA256(String source) throws NoSuchAlgorithmException {
        return getSHA256(source, "");
    }
    public JwtBody bodyToObject(String jwt) {
        return bodyToObject(jwt, JwtBody.class);
    }
    public String base64encode(String source) {
        String res = new String(Base64.getUrlEncoder().encode(source.getBytes()));
        return res.replaceAll("=", "");
    }
    private String obten(String jwt, int seccion) {
        String[] partes = jwt.split("\\.");
        return partes[seccion];
    }
    public void valida(String jwt) throws CustomException {
        if(!verifica(jwt)) throw new CustomException(EnumMessage.TOKEN_INVALID);
    }
    private static byte[] getSHA256(String source, String salt) throws NoSuchAlgorithmException {
        String input = source + salt;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    public String createJwt(Object obj) {
        String parte1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";// {"alg":"HS256", "typ":"JWT"}
        String parte2 = base64encode(objToString(obj));
        String parte3 = sha256Encoded(add(parte1, parte2, clave));
        return add(parte1, parte2, parte3);
    }
    public boolean verifica(String jwt) {
        if(jwt.split("\\.").length!=3) return false;
        String header = getHeader(jwt);
        String body = getBody(jwt);
        String signature = getSignature(jwt);
        String build = sha256Encoded(add(header, body, clave));
        return signature.equals(build);
    }
    private String objToString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "{\"error\":\"true\"}";
        }
    }
    public <T> T bodyToObject(String jwt, Class<T> type) {
        try {
            String body = this.getBody(jwt);
            String decodedBody = this.base64decode(body);
            return objectMapper.readValue(decodedBody, type);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    public <T> T jsonToObject(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    public String sha256Encoded(String source) {
        try {
            String res = new String(Base64.getUrlEncoder().encode(getSHA256(source)));
            return res.replaceAll("=", "");
        } catch (NoSuchAlgorithmException e) {
            return "XXXXXXXXXXX";
        }
    }
    public void sameUserOrSpecificRol(String jwt, String mail, EnumRoles theRole) throws CustomException {
        JwtBody obj = this.bodyToObject(jwt);
        if(obj.getMail().equals(mail)) return;
        for(String r : obj.getRoles()) {
            if(theRole.toString().equals(r)) return;
        }
        throw new CustomException(EnumMessage.NOT_AUTHORIZED);        
    }
    public void sameUserAsJwt(String jwt, String mail) throws CustomException {
        JwtBody obj = this.bodyToObject(jwt);
        if(obj.getMail().equals(mail)) return;
        throw new CustomException(EnumMessage.NOT_AUTHORIZED);        
    }
}
