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
 * Nombre:      AdministracionComprasController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:22:22
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.kebblar.petstore.api.model.domain.AdministracionCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.service.AdministracionComprasService;
import io.swagger.annotations.ApiParam;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints
 * de gestión de todas las compras hechas por los usuario.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.
 *
 * @author  LMtz
 * @see     io.kebblar.petstore.api.service.AdministracionComprasController
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class AdministracionComprasController {
    private AdministracionComprasService admini;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param AdministracionComprasService Servicios de administracion de compras
     */
    public AdministracionComprasController(AdministracionComprasService admini) {
        this.admini = admini;
    }

    @GetMapping(path = "/administracion-compras.json", produces = "application/json; charset=utf-8")
    public List<AdministracionCompras> getCompras() throws BusinessException {
        return admini.getAll();
    }

    @PostMapping(path = "/administracion-compras-update.json/{estado}/{cveCompra}", produces = "application/json; charset=utf-8")
    public String updateEstado(
            @ApiParam(name = "estado", value = "el nuevo estado de la compra.")
            @PathVariable int estado,
            @ApiParam(name = "cveCompra", value = "el cve de la compra.")
            @PathVariable String cveCompra) throws BusinessException {
        return admini.sent(estado,cveCompra);
    }
}
