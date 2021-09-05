/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      MascotaController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:25:38
 */
package io.kebblar.petstore.api.rest;

import java.util.List;
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

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param mascotaService Servicio de Mascota
     * @param mailSenderService Serivico de mailSender
     * @param remoteRestCallService Servicio de remoteRestCall
     */
    public MascotaController(MascotaService mascotaService, RemoteRestCallService remoteRestCallService) {
        this.mascotaService = mascotaService;
        this.remoteRestCallService=remoteRestCallService;
    }

    @GetMapping(
        path = "/mascotas.json",
        produces = "application/json; charset=utf-8")
    public List<Mascota> getAll() throws ControllerException {
        return mascotaService.getAll();
    }

    @PostMapping(
        path = "/mascotas/filtro.json",
        produces = "application/json; charset=utf-8")
    public List<Integer> getByCriteria(@RequestBody List<Criterio> criterios) throws ControllerException {
        return mascotaService.getByCriteria(criterios);
    }

    @GetMapping(
        path = "/mascotas/{id}.json",
        produces = "application/json; charset=utf-8")
    public Mascota getMascota(@PathVariable int id) throws ControllerException {
        return mascotaService.getById(id);
    }

    @PostMapping(
        path = "/mascotas.json",
        produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse insertaMascota(@Valid @RequestBody Mascota mascota) throws ControllerException {
        int id = mascotaService.insert(mascota);
        return new ProcesaMascotaResponse("La mascota fué insertada correctamente", id);
    }

    @PutMapping(
        path = "/mascotas.json",
        produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse actualizaMascota(@Valid @RequestBody Mascota mascota) throws ControllerException {
        int id = mascotaService.update(mascota);
        return new ProcesaMascotaResponse("La mascota fué actualizada correctamente", id);
    }

    @DeleteMapping(
        path = "/mascotas.json",
        produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse borraMascota(@RequestParam int id) throws ControllerException {
        int result = mascotaService.delete(id);
        return new ProcesaMascotaResponse("La mascota fué borrada correctamente", result);
    }

    @GetMapping(
        path = "/tickers.json",
        produces = "application/json; charset=utf-8")
    public TickerWrapper getTicker() throws ControllerException {
        return remoteRestCallService.callTickerMicroservice();
    }

}
