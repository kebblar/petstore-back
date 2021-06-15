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
 * Artefacto:   GraficasMontoCategoriaController .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Cloudstore
 * Fecha:       Tuesday 15 de Junio de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210615_1444 Implementación de clase
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.GraficasMontoCategoria;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.service.GraficasMontoCategoriaService;


/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'DatosOrden'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.
 *
 * @author Cloudstore
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficasMontoCategoria
 */
@RestController
@RequestMapping(value="/api")
public class GraficasMontoCategoriaController {

    private GraficasMontoCategoriaService graficasMontoCategoriaService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param GraficasMontoCategoriaService Servicios de gráficas montos por categoría
     */
    public GraficasMontoCategoriaController(GraficasMontoCategoriaService graficasMontoCategoriaService) {
        this.graficasMontoCategoriaService=graficasMontoCategoriaService;
    }
    
    @GetMapping(
            value = "/grafica-monto-categoria.json",
            produces = "application/json; charset=utf-8")
    public @ResponseBody List<GraficasMontoCategoria> obtenerDatosGraficasMontoCategoria() throws Exception  {
        return graficasMontoCategoriaService.getAll();
    }

}