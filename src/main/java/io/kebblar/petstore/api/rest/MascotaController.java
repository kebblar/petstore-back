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
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.ProcesaMascotaResponse;
import io.kebblar.petstore.api.model.Criterio;
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
    
    
    /* Procesamiento de entidades de tipo "Mascota" */
    
    @GetMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public List<Mascota> getAll() throws BusinessException {
        return mascotaService.getAll();
    }
    
    @GetMapping(path = "/mascotas/filtro.json", produces = "application/json; charset=utf-8")
    public List<Integer> getByCriteria(@RequestBody List<Criterio> criterios) throws BusinessException {
        return mascotaService.getByCriteria(criterios);
    }

    @GetMapping(path = "/mascotas/{id}.json", produces = "application/json; charset=utf-8")
    public Mascota getMascota(@PathVariable int id) throws BusinessException {
        return mascotaService.getById(id);
    }

    @PostMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse insertaMascota(@Valid @RequestBody Mascota mascota) throws BusinessException {
        int id = mascotaService.insert(mascota);
        return new ProcesaMascotaResponse("La mascota fué insertada correctamente", id);
    }

    @PutMapping(path = "/mascotas.json", produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse actualizaMascota(@Valid @RequestBody Mascota mascota) throws BusinessException {
        int id = mascotaService.update(mascota);
        return new ProcesaMascotaResponse("La mascota fué actualizada correctamente", id);
    }
    
    @DeleteMapping(path = "/mascotas/{id}.json", produces = "application/json; charset=utf-8")
    public ProcesaMascotaResponse borraMascota(@PathVariable int id) throws BusinessException {
        int result = mascotaService.delete(id);
        return new ProcesaMascotaResponse("La mascota fué borrada correctamente", result);
    }

}
