/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AdminController.java
 * Tipo:        Clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_25)
 *
 * Historia:    .
 *              0210506_0925 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.kebblar.petstore.api.service.HealthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints
 * de gestión por HealthService.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 *
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.service.HealthService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@Api(value = "admin")
@RequestMapping(value = "/api")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private HealthService healthService;

    @Value("${app.profile.identifier}")
    private String appProfileIdentifier;

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param healthService Servicios de HealthService
     */
    public AdminController(HealthService healthService) {
        this.healthService = healthService;
    }

    @PostMapping(path="/UploadPictures", produces = "application/json; charset=utf-8")
    public String upload(
        @ApiParam(name = "request", value = "MultipartFile del archivo")
        MultipartHttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + ":"+ value);
        }

        Map<String, MultipartFile> fileMap = request.getFileMap();
        for (MultipartFile multipartFile : fileMap.values()) {
            System.out.println(multipartFile.getOriginalFilename());
        }
        return "ok";
    }

    @ApiOperation(value = "AdminController::logout", notes = "Provoca un 'logout' del usuario firmado en el sistema")
    @GetMapping(path = "/logout.json", produces = "application/json; charset=utf-8")
    public String logout(HttpServletRequest request) throws ServletException {
        String name = "tavo";
        request.logout();
        String res = "{-" + name + "-:-you have been loged out-}";
        return res.replace('-', '"');
    }

    @ApiOperation(value = "AdminController::health", notes = "Entrega un informe a cerca de las variables del sistema")
    @GetMapping(path = "/health.json", produces = "application/json; charset=utf-8")
    public Map<String, String> health(
            @ApiParam(name = "inputData", value = "Los datos de entrada", defaultValue = "ls")
            @RequestParam String inputData
        ) throws IOException {
        logger.info("*** Application Profile Identifier: "+appProfileIdentifier);
        Map<String, String> result = healthService.getInfo(inputData);
        result.put("app.profile.identifier", appProfileIdentifier);
        result.put("spring.datasource.url", springDatasourceUrl);
        return result;
    }

    @ApiOperation(value = "AdminController::health", notes = "Entrega el log del sistema")
    @GetMapping(path = "/log.json", produces = "application/json; charset=utf-8")
    public List<String> getLog(
            @ApiParam(name = "last", value = "Número de lineas", defaultValue = "1")
            @RequestParam Integer last) {
        return healthService.getLog(last);
    }

    @GetMapping(path = "/qa-stats.json", produces = "application/json; charset=utf-8")
    public String getQualityStats(
            @RequestParam int page, @RequestParam int len) {
        final String uri = "https://sonar.ci.ultrasist.net/api/issues/search?ps=" + len + "&p="
                + page
                + "&componentKeys=mx.gob.impi.chatbot.persistence:chatbot-persistence-layer";
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(uri, String.class);
        } catch (RuntimeException e) {
            return "{'error':'" + e.getMessage() + "', 'uri':'" + uri + "'}".replace("'", "\"");
        }
    }
    @GetMapping(path = "/content/{seccion}/{description}", produces = "application/json; charset=utf-8")
    public List<String> getContentByName(
            @PathVariable String description,
            @PathVariable String seccion) {
        List<String> result = new ArrayList<>();
        result.add(description);
        result.add("listo");
        result.add("ya");
        result.add("quedo");
        result.add(seccion);
        return result;
    }
}

