/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   PruebaController.java
 * Tipo:        clase
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_44)
 *
 * Historia:    .
 *              20210506_0944 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import io.kebblar.petstore.api.service.DireccionService;
import io.kebblar.petstore.api.support.QRService;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints 
 * de gestión del POJO Direcciones.
 * 
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 * 
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no 
 * llevan  javadoc  debido a que la  documentación  Swagger  API 
 * cumple con ese objetivo.
 * 
 * @author  luz
 * @see     io.kebblar.petstore.api.service.DireccionService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class PruebaController {
    private static final String res = "{'result':'ok'}".replace('\'', '\"');

    @Autowired
    private QRService qrService;

    @GetMapping(
            value = "/qr/{data}", 
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] testphoto(@PathVariable String data) throws ControllerException {
        return qrService.getQRBytes(data);
    }

    @GetMapping(
            value = "/qr-base64/{data}",  
            produces = "image/jpg")
    public @ResponseBody String generateQRBytesBase64(@PathVariable("barcode") String data) throws Exception  {
        return qrService.getQRBytesBase64(data);
    }

}
