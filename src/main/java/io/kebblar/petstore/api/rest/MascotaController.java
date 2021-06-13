/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MascotaController.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (17_50)
 *
 * Historia:    .
 *              20210504_1950 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Criterio;
import io.kebblar.petstore.api.model.domain.Mascota;
import io.kebblar.petstore.api.model.domain.TickerWrapper;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.response.ProcesaMascotaResponse;
import io.kebblar.petstore.api.service.MascotaService;
import io.kebblar.petstore.api.service.RemoteRestCallService;
import io.kebblar.petstore.api.support.JwtManagerService;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints
 * de gestión del POJO {@link Mascota}.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 *
 * <p>NOTA IMPORTANTE: Los  distintos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Mascota
 * @see     io.kebblar.petstore.api.model.response.ProcesaMascotaResponse
 * @see     io.kebblar.petstore.api.service.MascotaService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class MascotaController {
    private MascotaService mascotaService;
    private RemoteRestCallService remoteRestCallService;
    private JwtManagerService jwtManagerService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param mascotaService Servicio de Mascota
     * @param jwtManagerService Servicio de jswManager
     * @param mailSenderService Serivico de mailSender
     * @param remoteRestCallService Servicio de remoteRestCall
     */
    public MascotaController(MascotaService mascotaService, JwtManagerService jwtManagerService, RemoteRestCallService remoteRestCallService) {
        this.mascotaService = mascotaService;
        this.jwtManagerService=jwtManagerService;
        this.remoteRestCallService=remoteRestCallService;
    }

    @GetMapping(path = "/prueba.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba() throws ControllerException {
        String token = jwtManagerService.createToken("gus");
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dato-1", token);
        mapa.put("dato-2", "tavo_bad");
        return mapa;
    }

    @GetMapping(path = "/prueba2.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba2() throws ControllerException {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dato-1", "gus");
        mapa.put("dato-2", "tavo");
        return mapa;
    }

    /* Procesamiento de entidades de tipo "Mascota" */

    @GetMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public List<Mascota> getAll() throws ControllerException {
        return mascotaService.getAll();
    }

    @PostMapping(path = "/mascotas/filtro.json", produces = "application/json; charset=utf-8")
    public List<Integer> getByCriteria(@RequestBody List<Criterio> criterios) throws ControllerException {
        return mascotaService.getByCriteria(criterios);
    }

    @GetMapping(path = "/mascotas/{id}.json", produces = "application/json; charset=utf-8")
    public Mascota getMascota(@PathVariable int id) throws ControllerException {
        return mascotaService.getById(id);
    }

    @PostMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse insertaMascota(@Valid @RequestBody Mascota mascota) throws ControllerException {
        int id = mascotaService.insert(mascota);
        return new ProcesaMascotaResponse("La mascota fué insertada correctamente", id);
    }

    @PutMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse actualizaMascota(@Valid @RequestBody Mascota mascota) throws ControllerException {
        int id = mascotaService.update(mascota);
        return new ProcesaMascotaResponse("La mascota fué actualizada correctamente", id);
    }

    @DeleteMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse borraMascota(@RequestParam int id) throws ControllerException {
        int result = mascotaService.delete(id);
        return new ProcesaMascotaResponse("La mascota fué borrada correctamente", result);
    }

    @GetMapping(path = "/tickers.json", produces = "application/json; charset=utf-8")
    public TickerWrapper getTicker() throws ControllerException {
        return remoteRestCallService.callTickerMicroservice();
    }

}