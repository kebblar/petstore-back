package io.kebblar.petstore.api.config;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.kebblar.petstore.api.model.domain.JwtBody;
import io.kebblar.petstore.api.model.enumerations.EnumMessage;
import io.kebblar.petstore.api.model.enumerations.EnumRoles;
import io.kebblar.petstore.api.model.exceptions.CustomException;
import io.kebblar.petstore.api.utils.JwtHelper;

@Aspect
@Component
public class AuthorizeUserAspect {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizeUserAspect.class);
    private final JwtHelper jwtHelper;

    @Value("${security.token.lasts:120}")
    private String stringSecurityTokenLasts;
    
    public AuthorizeUserAspect(JwtHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    @Around("@annotation(authorizedRoles)")
    public Object authorize(ProceedingJoinPoint joinPoint, AuthorizedRoles authorizedRoles) throws Throwable {
        // convierte los mintos recibidos como cadena en 'stringSecurityTokenLasts' a milisegundos:
        long validez = convierte(stringSecurityTokenLasts);
        
        // Obteniendo el JWT de la invocación:
        Object[] argumentos = joinPoint.getArgs();
        Object cadena = argumentos[0]; // como el método exige un JWT como primer parámetro, el [0] está garantizado
        String jwt = cadena.toString();
        
        // se valida UNICAMENTE la estructura y la firma:
        this.jwtHelper.valida(jwt); // esto dispara un CustomException si la validación falla
        
        // Los roles que provienen de la anotacion:
        EnumRoles[] roles = authorizedRoles.value();
        
        // se obtiene el body del JWT ya como objeto java:
        JwtBody body = this.jwtHelper.bodyToObject(jwt);
        
        // se valida la caducidad
        long now = System.currentTimeMillis();
        long delta = now - body.getCreation();
        if(delta > validez) throw new CustomException(EnumMessage.TOKEN_EXPIRED);
        
        // se obtienen los roles del interior del jwt:
        List<String> rolesBody = body.getRoles();
        
        // se comparan los Enums con las cadenas de roles 
        // y si ninguno hizo match, dispara una excepcion:
        for(EnumRoles e : roles) {
            for(String s : rolesBody) {
                if(e.toString().equals(s)) {
                    Object result = joinPoint.proceed();
                    return result;                    
                }
            }
        }
        throw new CustomException(EnumMessage.NOT_AUTHORIZED);
    }
    
    private long convierte(String stringSecurityTokenLasts) {
        long minutos = 1000 * 60L;
        try {
            return minutos * Integer.parseInt(stringSecurityTokenLasts);
        } catch (Exception e) {
            logger.error("Cannot parse value: " + stringSecurityTokenLasts + " using 60 as default");
            return minutos * 30;
        }
    }
    
}