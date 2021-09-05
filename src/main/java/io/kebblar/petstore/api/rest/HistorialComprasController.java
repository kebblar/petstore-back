/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      HistorialComprasController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:25:30
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.service.HistorialComprasService;
import io.swagger.annotations.ApiParam;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints
 * de gestión de las compras hechas por un usuario.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.
 *
 * @author  LMtz
 * @see     io.kebblar.petstore.api.service.historialComprasService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class HistorialComprasController {
    private HistorialComprasService historialComprasService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param historialComprasService Servicios de historial de compras
     */
    public HistorialComprasController(HistorialComprasService historialComprasService) {
        this.historialComprasService = historialComprasService;
    }

    @GetMapping(path = "/historial-compras.json/{idUsuario}", produces = "application/json; charset=utf-8")
    public List<HistorialCompras> getCompras(
            @ApiParam(name = "idUsuario", value = "id del usuario que queremos saber sus compras")
            @PathVariable int idUsuario) throws BusinessException {
        return historialComprasService.getAll(idUsuario);
    }

}