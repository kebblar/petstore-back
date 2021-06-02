package io.kebblar.petstore.api.rest;

import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.service.CriptoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "pagos")
@RequestMapping(value = "/api")
public class CriptoController {

    private CriptoService criptoService;

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
