/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o parcialmente  siempre y cuando  mantenga  este
 *              aviso y reconozca  la  autoría  del código al no
 *              modificar  los datos  establecidos en la mención 
 *              de "AUTOR".
 *              ------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.config
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CustomInterceptor
 * Autor:       garellano
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 4 Sep 2021 @ 14:29:48
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
 * The {@code String} class represents character strings. All
 * string literals in Java programs, such as {@code "abc"}, are
 * implemented as instances of this class.
 * <p>
 * Strings are constant; their values cannot be changed after they
 * Because String objects are immutable they can be shared. For example:
 * <blockquote><pre>
 *     String str = "abc";
 * </pre></blockquote><p>
 * is equivalent to:
 * <blockquote><pre>
 *     char data[] = {'a', 'b', 'c'};
 *     String str = new String(data);
 * </pre></blockquote><p>
 * Here are some more examples of how strings can be used:
 * <blockquote><pre>
 *     System.out.println("abc");
 *     String cde = "cde";
 *     System.out.println("abc" + cde);
 *     String c = "abc".substring(2,3);
 *     String d = cde.substring(1, 2);
 * </pre></blockquote>
 * <p>
 * The class {@code String} includes methods for examining
 * lowercase. Case mapping is based on the Unicode Standard version
 * specified by the {@link java.lang.Character Character} class.
 *
 * @author  garellano
 * @see     java.lang.Object#toString()
 * @since   0.0.1-SNAPSHOT
 */
public class CustomInterceptor extends HandlerInterceptorAdapter {

    /*
     * Atributos logger y jwt.
     */
    private Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
    private String jwtToken;

    /**
     * Constructor que recibe el jwtoken para validar los tokens que vienen en el header.
     * Esto facilita su posterior procesamiento
     *
     * @param jwtToken jwt token a asignar
     */
    public CustomInterceptor(String jwtToken) {
        this.jwtToken = jwtToken;
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
                if (headerName.contains("jwt") && valor != null && valor.trim().length() > 0) {
                    logger.info("App caller IP detected:: {}", request.getRemoteAddr());
                    logger.info("App current uri detected:: {}", uri);
                    logger.info("El header {} tiene el valor: {}", headerName, valor);
                    try {
                        JWTUtil.getInstance().verifyToken(valor, jwtToken, System.currentTimeMillis());
                    } catch (Exception e) {
                        construye(response, e.getMessage());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Método que se encarga de construir la respuesta mostrando el código http y el mensaje.
     *
     * @param response código de error Http
     * @param message corresponde al texto que explica la situación
     */
    private void construye(HttpServletResponse response, String message) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("invalid-token", message);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            response.getWriter().write(mapper.writeValueAsString(map));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
