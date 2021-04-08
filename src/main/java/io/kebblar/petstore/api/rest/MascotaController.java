package io.kebblar.petstore.api.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.InsertaMascotaResponse;
import io.kebblar.petstore.api.model.Mascota;
import io.kebblar.petstore.api.service.MascotaService;

@RestController
@RequestMapping(value = "/api")
public class MascotaController {
    private MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping(path = "/prueba.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba() throws ServletException {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dato-1", "gus_ok");
        mapa.put("dato-2", "tavo_bad");
        return mapa;
    }

    @GetMapping(path = "/prueba2.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba2() throws ServletException {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dato-1", "gus");
        mapa.put("dato-2", "tavo");
        return mapa;
    }

    @GetMapping(path = "/mascotas/{id}.json", produces = "application/json; charset=utf-8")
    public Mascota getMascota(@PathVariable int id) throws BusinessException {
        return mascotaService.getMascota(id);
    }

    @PostMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public InsertaMascotaResponse insertaMascota(@Valid @RequestBody Mascota mascota) throws BusinessException {
        int id = mascotaService.insertaMascota(mascota);
        return new InsertaMascotaResponse(id);
    }

}
