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
 * Nombre:      OrdenCompraController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:26:11
 */
package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.service.MunicipioService;
import io.kebblar.petstore.api.service.OrdenCompraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'DatosOrden'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.
 *
 * @author Fhernanda Romo, Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see DatosOrden
 * @see MunicipioService
 */
@RestController
@Api("value = pagos")
@RequestMapping(value="/api")
public class OrdenCompraController {

    private OrdenCompraService ordenCompraService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param OrdenCompraService Servicios de orden de compra
     */
    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService=ordenCompraService;
    }

    @ApiOperation(
            value = "ProcesaOrdenController::insert",
            notes = "Recibe un objeto DatosOrden el cual debe de ser insertado "
                + " como dato dentro de la base de datos del sistema.")
    @PostMapping( value = "/procesa-orden.json",
            produces = "application/json; charset=utf-8")
    public String procesaOrden(
            @ApiParam(name="datosOrden", value="DatosOrden que será insertado en el sistema en DatosOrden.")
            @RequestBody DatosOrden datosCompra) throws BusinessException{
        ordenCompraService.procesarOrdenCompra(datosCompra);
        return datosCompra.toString();
    }

}