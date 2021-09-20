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
 * Nombre:      QRController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:26:38
 */
package io.kebblar.petstore.api.rest;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.support.QRService;

/**
 * Implementación  del controlador REST asociado a los endpoints
 * de gestión del POJO Direcciones.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}</p>
 *
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.</p>
 *
 * @author  luz
 * @see     io.kebblar.petstore.api.service.DireccionService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class QRController {

    private final QRService qrService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param qrService Servicios de QR
     */
    public QRController(QRService qrService){
        this.qrService = qrService;
    }

    @ApiOperation(value = "QRController::testphoto",
                notes = "Dada una entrada de datos, este endpoint transforma dicha entrada" +
                        "en una imagen QR.")
    @GetMapping(
            value = "/qr/{data}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] testphoto(
            @ApiParam(name = "data", value = "Información a convertir a QR")
            @PathVariable String data) throws ControllerException {
        return qrService.getQRBytes(data);
    }

    @ApiOperation(value = "QRController::generateQRBytesBase64",
                notes = "Devuelve el base 64 de la imagen de qr")
    @GetMapping(
            value = "/qr-base64/{data}",
            produces = "image/jpg")
    public @ResponseBody String generateQRBytesBase64(
            @ApiParam(name = "Informacion con la que se genera el QR")
            @PathVariable("data") String data) throws BusinessException {
        return qrService.getQRBytesBase64(data);
    }

}
