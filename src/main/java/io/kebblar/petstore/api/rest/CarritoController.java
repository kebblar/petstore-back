/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   PaisController .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase
 *
 */

package io.kebblar.petstore.api.rest;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'carrito' y otros metodos suplementarios.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 */

@RestController
@Api(value = "carrito")
@RequestMapping(value = "/api")
public class CarritoController {

    @ApiOperation(
            value = "CarritoController:getCarrito",
            notes = "Devuelve la lista de elementos necesarios para poder presentar al usuario" +
                    " su carrito de compras en el frontend, es necesario otorgar el id del usuario" +
                    "del que se desea obtener el carrito.")
    @GetMapping(
            value = "/carrito/{id}.json",
            produces = "application/json; charset=utf-8")
    public List<Map> getCarrito() {
        List<Map> list = new ArrayList<>();
        Map<String, Object> uno = new HashMap<>();
        Map<String, Object> dos = new HashMap<>();
        uno.put("idCarrito", 3);
        uno.put("urlImagen", "https://photos.ci.ultrasist.net/f59b0c41-c534-47d9-afb9-7c5230b9767f.png");
        uno.put("urlAnuncio", "/");
        uno.put("nombre", "Tarantula hembra de 10 cm");
        uno.put("idAnuncio", 8);
        uno.put("precio", 344);

        dos.put("idCarrito", 3);
        dos.put("urlImagen", "https://photos.ci.ultrasist.net/22c84708-a3e6-4486-8b04-3221f71b8e38.png");
        dos.put("urlAnuncio", "/");
        dos.put("nombre", "Gecko de dia frutero");
        dos.put("idAnuncio", 16);
        dos.put("precio", 194);
        list.add(uno);
        list.add(dos);
        return list;
    }

}
