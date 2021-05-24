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

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.domain.*;
import io.kebblar.petstore.api.service.*;
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
    private DireccionService servicio;
    
    @Autowired
    private QRService qrService;
    
    @GetMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public List<Direccion> getAll() throws ControllerException {
        return servicio.getAll();
    }

    @PostMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba1(@Valid @RequestBody Direccion dato) throws ControllerException {
        servicio.insert(dato);
        return res;
    }
    
    @PutMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba2(@Valid @RequestBody Direccion dato) throws ControllerException {
        servicio.update(dato);
        return res;
    }

    @GetMapping(path = "/direcciones-con-nombre/{userId}.json", produces = "application/json; charset=utf-8")
    public List<DireccionConNombre> getDireccionesUsuario(@PathVariable int userId) throws ControllerException {
        return servicio.getDireccionesNombre(userId);
    }

    @PostMapping(path = "/nueva-direccion.json", produces = "application/json; charset=utf-8")
    public int nuevaDireccion(@RequestBody NuevaDireccion nuevaDireccion) throws ControllerException {
        return servicio.agregaDireccion(nuevaDireccion);
    }
    
    @ResponseBody
    @GetMapping(
            value = "/qrImage/{data}.json", 
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] testphoto(@PathVariable String data) throws ControllerException {
        return qrService.getQRBytes(data);
    }
    
    @GetMapping(value = "/qr/{barcode}",  produces = "image/jpg")
    public @ResponseBody byte[] generateQRCodeImage(@PathVariable("barcode") String barcode) throws Exception  {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        BufferedImage img = qrService.generateQRCodeImage(barcode);
        ImageIO.write(img, "jpg", bao);
        return bao.toByteArray();
    }
}
