/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AdministracionComprasController
 * Tipo:        clase
 * AUTOR:       Luis Martinez (LMtz)
 * Fecha:       Martes 19 de Mayo de 2021 (22_29)
 *
 * Historia:    .
 *              20210519_2229 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "/administracion-compras-update.json/{estado}/{cveCompra}", produces = "application/json; charset=utf-8")
    public String updateEstado(
            @ApiParam(name = "estado", value = "el nuevo estado de la compra.")
            @PathVariable int estado,
            @ApiParam(name = "cveCompra", value = "el cve de la compra.")
            @PathVariable String cveCompra) throws BusinessException {
        return admini.sent(estado,cveCompra);
    }
}
