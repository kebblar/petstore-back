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
 * Nombre:      RouterController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:27:02
 */
package io.kebblar.petstore.api.rest;

import io.kebblar.petstore.api.model.domain.BlockCyperChecker;
import io.kebblar.petstore.api.model.domain.TickerWrapper;
import io.kebblar.petstore.api.service.RemoteRestCallService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiParam;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Descripción:</p>
 * Implementación  del REST Controller asociado a los endpoints de  gestión del POJO 'rol'.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}</p>
 *
 * <p>NOTA IMPORTANTE: Los distintos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.</p>
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 */
@RestController
@Api(value = "router")
@RequestMapping(value = "/")
//TODO: clase que tambien tiene algunos m'etodos extranos
public class RouterController {

    private final RemoteRestCallService remoteRestCallService;

    public RouterController (RemoteRestCallService remoteRestCallService){
        this.remoteRestCallService = remoteRestCallService;
    }

    @GetMapping(value = "/ui/**")
    public ModelAndView redirectWithUsingForwardPrefix(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new ModelAndView("forward:/", model);
    }

    @GetMapping(value = "/posts/**")
    public ModelAndView redirectQueryPath(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new ModelAndView("forward:/", model);
    }

    @GetMapping("/token.json")
    public String getToken(){
        return "token-de-prueba_RouterController-getToken";
    }

    @GetMapping("/info-cripto/{add}.json")
    public BlockCyperChecker getInfo(
            @ApiParam(name="add", value ="Direccion wallet buscada." )
            @PathVariable String add){
        return remoteRestCallService.verifyBalance(add);
    }

    @GetMapping(
            path = "/tickers.json",
            produces = "application/json; charset=utf-8")
    public TickerWrapper getTicker() {
        return remoteRestCallService.callTickerMicroservice();
    }

}
