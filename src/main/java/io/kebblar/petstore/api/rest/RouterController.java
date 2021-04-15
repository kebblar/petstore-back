/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención 
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 * Modulo:      proyecto-back
 * Clase        RouterController
 * Autor:       Gustavo Arellano
 * Fecha:       4/30/20, 11:42 PM
 * Version:     1.0-SNAPSHOT
 *
 */
package io.kebblar.petstore.api.rest;

import io.swagger.annotations.Api;
import io.kebblar.petstore.api.utils.JWTUtil;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Router para interfases del front.
 */
@RestController
@Api(value = "router")
@RequestMapping(value = "/")
public class RouterController {

    @GetMapping(value = "/ui/**")
    public ModelAndView redirectWithUsingForwardPrefix(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new ModelAndView("forward:/", model);
    }

    @GetMapping("/token.json")
    public String getToken(){
        return JWTUtil.getJWTToken();
    }

}
