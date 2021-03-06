/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.config
 * Modulo:      cinepolis
 * Tipo:        clase
 * Autor:       Gustavo Adolfo Arellano Sandoval (garellanos)
 * Fecha:       28 de Marzo de 2020
 * Version:     0.0.2-SNAPSHOT
 * .
 * Clase encargada de ...
 */
package io.kebblar.petstore.api.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.kebblar.petstore.api.utils.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Clase CustomInterceptor.
 */
public class CustomInterceptor extends HandlerInterceptorAdapter {

    /** logger. */
    private Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
    
    private String JWT_TOKEN;
    
    /**
     * Costructor que recibe el jwtoken para validar los tokens que vienen en el header.
     * Esto facilita su posterior procesamiento
     * 
     * @param jwtToken
     */
    public CustomInterceptor(String jwtToken) {
        this.JWT_TOKEN = jwtToken;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (uri.startsWith("/api/")) {
            Enumeration<String> headerNames = request.getHeaderNames();
            ArrayList<String> lista = Collections.list(headerNames);
            for (String headerName : lista) {
                String valor = request.getHeader(headerName);
                if(headerName.contains("jwt") && valor!=null && valor.trim().length()>0) {
                    logger.info("App caller IP detected:: " + request.getRemoteAddr());
                    logger.info("App current uri detected:: " + uri);
                    logger.info("El header " + headerName + " tiene el valor: " + valor);
                    try {
                        JWTUtil.getInstance().verifyToken(valor, JWT_TOKEN, System.currentTimeMillis());
                    } catch (Exception e) {
                        construye(response, e.getMessage());
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private void construye(HttpServletResponse response, String message) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("invalid-token", message);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            response.getWriter().write(mapper.writeValueAsString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//        Enumeration<String> names = request.getParameterNames();
//        while (names.hasMoreElements())
//            System.out.println("Value is: " + names.nextElement());

//        String name = "No user is loged in";
        /**
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            name = authentication.getName();
        }
        */
//        String queryString = request.getQueryString();
//        String remoteAddress = request.getRemoteAddr();
//        Date date = new Date();
        //String uri = request.getRequestURI();
        //if (uri.startsWith("/api/")) {

            // Esta liea es provisional y deberá ser removida en cuanto sea posible:
//            String mensajeImprimir = "\n Fecha: " + date.toString() + "\n username:" + name
//                    + "\n queryString:" + queryString + "\n uri:" + uri + "\n remoteAddress:"
//                    + remoteAddress;
//            logger.info(mensajeImprimir);
            //logger.info("App current uri detected: "+uri);
            // Instead, we have to save object bitacora to DB here .... :)
        //}
        //return true;
    //}

}
