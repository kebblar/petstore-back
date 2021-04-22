/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.api.controller
 * Modulo:      cinepolis
 * Tipo:        clase
 * Autor:       Chandra Nichdali QUintas de la Parra
 * Fecha:       14 de Marzo de 2020
 * Version:    1.0-SNAPSHOT
 * .
 * Clase encargada de controlar las excepciones
 */
package io.kebblar.petstore.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import io.kebblar.petstore.api.model.exceptions.ControllerException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador que manejara las excepciones lanzadas por los demas
 * controladores.
 */
@ControllerAdvice
public class CustomControllerAdvice {
    // Take a look at:
    // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400
    private Logger logger = LoggerFactory.getLogger(CustomControllerAdvice.class);

    /**
     * Método que maneja las exepciones de {@link MethodArgumentNotValidException}.
     *
     * @param geEx la excepcion que manejará (de tipo MethodArgumentNotValidException).
     * @return un ResponseEntity con los valores a mostrarse en el JSON de salida.
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> userErrorHandler(MethodArgumentNotValidException geEx) {
        logger.error(getStackTraceExStr(geEx));
        return new ResponseEntity<>(buildValidationErrorResponse(geEx), HttpStatus.BAD_REQUEST);
    }

    /**
     * Método que maneja las exepciones de {@link ControllerException}.
     *
     * @param geEx la excepcion que manejará (de tipo ControllerException).
     * @return un ResponseEntity con los valores a mostrarse en el JSON de salida.
     */
    @ResponseBody
    @ExceptionHandler(value = ControllerException.class)
    public ResponseEntity<Map<String, Object>> errorHandler(ControllerException geEx) {
        logger.error(getStackTraceExStr(geEx));
        int value = geEx.getHttpStatus().value();
        return new ResponseEntity<>(crearMapaRetorno(geEx), HttpStatus.valueOf(value));
    }

    /**
     * Mapa de retorno para errores de tipo MethodArgumentNotValidException.
     *
     * @param geEx la excepcion a mapear (de tipo MethodArgumentNotValidException).
     * @return mapa de valores para una respuesta de validación de campos.
     */
    private Map<String, Object> buildValidationErrorResponse(MethodArgumentNotValidException geEx) {
        BindingResult binding = geEx.getBindingResult();
        Map<String, Object> map = new HashMap<>();
        List<Map<String, String>> lista = new ArrayList<>();
        for (ObjectError fe : binding.getAllErrors()) {
            FieldError error = (FieldError)fe;
            Map<String, String> err = new HashMap<>();
                String defMess = error.getDefaultMessage();
                String[] arr = defMess.split("\\|");
                String index = (arr.length>1)? arr[1]:"0";
            err.put("index", index);
            err.put("description", arr[0]);
            err.put("validation-type", error.getCode());
            err.put("object-name", error.getObjectName());
            err.put("rejected-value", error.getRejectedValue()+"");
            err.put("field-name", error.getField());
            lista.add(err);
        }
        map.put("TipoError", "3001");
        map.put("errors", lista);
        return map;
    }

    /**
     * Método auxiliar que crea el objeto a mostrarse cuando se lance la excepcion.
     *
     * @param ex la excepcion a mapear
     * @return el diccionario con la excepcion mapeada
     */
    private Map<String, Object> crearMapaRetorno(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        if (ex instanceof ControllerException) {
            ControllerException ad = (ControllerException) (ex);
            map.put("exceptionTypeNumber", ad.getLocalExceptionNumber());
            map.put("exceptionTypeKey", ad.getLocalExceptionKey());
            map.put("exceptionLongDescription", ad.getDetailedMessage());
            map.put("exceptionShortDescription", ad.getShortMessage());
            map.put("httpCode", ad.getHttpStatus());
        }
        return map;
    }

    /**
     * Método auxiliar que obtiene a traza de la excepcion completa.
     *
     * @param excepcion la excepcion que se debe rastrear
     * @return su representacion en string
     */
    private String getStackTraceExStr(Exception excepcion) {
        StringBuilder errorGenerica = new StringBuilder();
        if (excepcion instanceof ControllerException) {
            ControllerException ge = (ControllerException) (excepcion);
            errorGenerica.append("tipo: ");
            errorGenerica.append(ge.getLocalExceptionNumber());
            errorGenerica.append(": ");
            errorGenerica.append(ge.getLocalExceptionKey());
            errorGenerica.append(": ");
            errorGenerica.append(ge.getDetailedMessage());
            StringWriter errores = new StringWriter();
            ge.printStackTrace(new PrintWriter(errores));
            errorGenerica.append("\n");
        }
        return errorGenerica.toString();
    }

}

