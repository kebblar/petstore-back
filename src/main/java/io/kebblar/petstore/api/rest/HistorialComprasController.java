/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   HistorialComprasController
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

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.domain.Mail;
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
    
    @PostMapping(path = "/historial-compras.json/", produces = "application/json; charset=utf-8")
    public List<HistorialCompras> getCompras(@ApiParam(name = "mail", value = "correo del usuario que queremos saber sus compras") @RequestBody Mail correo) throws BusinessException {
        return historialComprasService.getAll(correo);
    }
    
}