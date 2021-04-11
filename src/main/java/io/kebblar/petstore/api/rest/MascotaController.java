package io.kebblar.petstore.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
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
import io.kebblar.petstore.api.support.JwtManagerService;
import io.kebblar.petstore.api.support.MailSenderService;

@RestController
@RequestMapping(value = "/api")
public class MascotaController {
    private MascotaService mascotaService;
    private JwtManagerService jwtManagerService;
    private MailSenderService mailSenderService;

    public MascotaController(MascotaService mascotaService, JwtManagerService jwtManagerService, MailSenderService mailSenderService) {
        this.mascotaService = mascotaService;
        this.jwtManagerService=jwtManagerService;
        this.mailSenderService=mailSenderService;
    }

    @GetMapping(path = "/prueba.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba() throws ServletException {
        String token = jwtManagerService.createToken("gus");
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dato-1", token);
        mapa.put("dato-2", "tavo_bad");
        mailSenderService.sendHtmlMail("garellanos@ultrasist.com.mx", "Pba", "<h1>Hello World</h1>");
        return mapa;
    }

    @GetMapping(path = "/prueba2.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba2() throws ServletException {
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
        return mascotaService.callTickerMicroservice();
    }

}
