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
 * Nombre:      CriptoController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:24:14
 */
package io.kebblar.petstore.api.rest;

import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.MontoBitcoin;
import io.kebblar.petstore.api.service.CriptoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Api(value = "pagos")
@RequestMapping(value = "/api")
public class CriptoController {

    private final CriptoService criptoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param criptoService Servicios de usuario
     */
    public CriptoController(CriptoService criptoService){
        this.criptoService=criptoService;
    }

    @ApiOperation(
            value = "CriptoController::get",
            notes = "Retorna la direccion de la cartera bitcoin de un usuario")
    @GetMapping(
            value = "/wallet/{id}.json",
            produces = "application/json; charset=utf-8")
    public String getWallet(
            @ApiParam(name = "id", value = "Representa el id del usuario")
            @PathVariable int id) throws BusinessException{
        return criptoService.getByUser(id);
    }

    @ApiOperation(
            value = "CriptoController::get-monto",
            notes = "Retorna el monto de la compra en moneda btc")
    @GetMapping(
            value = "/monto-btc/{monto}.json",
            produces = "application/json; charset=utf-8" )
    public MontoBitcoin getMonto(@PathVariable double monto) throws BusinessException {
        return criptoService.getMonto(monto);
    }

    @ApiOperation(
            value = "CriptoController::orden",
            notes = "Posiciona en la base de datos una nueva orden generada")
    @PostMapping(
            value = "/orden.json",
            produces = "application/json; charset=utf-8"
    )
    public int nuevaOrden(
            @ApiParam(name = "orden", value = "Solicitud para una compra pagada el bitcoin")
            @RequestBody TransaccionBtc transaccionBtc) throws BusinessException{
        return criptoService.insertTransaccion(transaccionBtc);
    }

}
