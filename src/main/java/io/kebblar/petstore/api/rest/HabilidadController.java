/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      PaisController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:26:20
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Habilidad;
import io.kebblar.petstore.api.model.domain.UsuarioHabilidad;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.response.HabilidadResponse;
import io.kebblar.petstore.api.service.HabilidadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "habilidad")
@RequestMapping(value = "/api")
public class HabilidadController {
    private final HabilidadService habilidadService;

    public HabilidadController(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    @GetMapping(
            value = "/habilidad/{id}",
            produces = "application/json; charset=utf-8")
    public List<HabilidadResponse> getHabilidadResponseList(
            @ApiParam(name = "id", value = "Id del Usuario")
            @PathVariable int id) throws ControllerException {
        return this.habilidadService.getHabilidadResponseList(id);
    }
    
    @GetMapping(
            value = "/habilidad",
            produces = "application/json; charset=utf-8")
    public List<Habilidad> getHabilidades() throws ControllerException {
        return this.habilidadService.getHabilidades();
    }
    
    @PutMapping(
            value = "/habilidad",
            produces = "application/json; charset=utf-8")
    public int insertUsuarioHabilidad(@RequestBody UsuarioHabilidad usuarioHabilidad) throws ControllerException {
        return this.habilidadService.insertUsuarioHabilidad(usuarioHabilidad);
    }
    
    @PostMapping(
            value = "/habilidad",
            produces = "application/json; charset=utf-8")
    public int insertUsuarioHabilidades(@RequestBody List<UsuarioHabilidad> usuarioHabilidadesList) throws ControllerException {
        return this.habilidadService.insertUsuarioHabilidad(usuarioHabilidadesList);
    }    
    
    @DeleteMapping(
            value = "/habilidad/{id}",
            produces = "application/json; charset=utf-8")
    public int delete(@PathVariable int id) throws ControllerException {
        return this.habilidadService.deleteUsuarioHabilidades(id);
    }

}
