/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   FileUploadController.java
 * Tipo:        Clase 
 * AUTOR:       Isabel Contreras
 * Fecha:       Martes 11 de Mayo de 2021 (09_05)
 *
 * Historia:    .
 *              20210511_0905 Se agrega la documentacion del controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.UploadException;
import io.kebblar.petstore.api.support.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Implementacion del controlador REST asociado a los endpoints
 * de gestion de Archivos
 * 
 * @author  Isabel Contreras
 * @see     io.kebblar.petstore.api.support.UploadService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@Api(value = "negocio")
@RequestMapping(value = "/api")
public class FileUploadController {

    @Value("${app.destination-folder}")
    private String destinationFolder;

    @Value("${app.max-file-size}")
    private long max;

    private final UploadService uploadService;

    /**
     * Constructor para la inyeccion de dependencias.
     *
     * @param uploadService el servicio que ofrece almacenamiento
     */
    @Autowired
    public FileUploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    /**
     * Recibe un(os) archivo(s) del front y lo almacena en la carpeta y almacena una copia en
     * ${app.destination-folder}/kdm y otra copia en ${application.properties}/kdm.
     *
     * @param files archivo a almacenar
     * @return lista que contiene el modelo de donde se almaceno el archivo
     * @throws UploadException si hay algun error
     */
    @ApiOperation(value = "Recibe un(os) archivo(s) del front que se guardaran")
    @PostMapping(path = "/upload.json", produces = "application/json; charset=utf-8")
    public List<UploadModel> handleFileUploadWithKDMCopy(
    		@ApiParam(name= "files", value = "Variable que contine el (los) archivo (s) a guardar")
    		@RequestParam("files") MultipartFile[] files) throws UploadException {
        List<UploadModel> listaUpload = uploadService.store(files, destinationFolder, max);
        return listaUpload;
    }


}
/*
curl http://localhost:9999/api/upload.json -X POST \
-F 'files=@/Users/garellano/Desktop/peliculas/01.jpg' \
-F 'files=@/Users/garellano/Desktop/peliculas/02.jpg'


image/png
application/pdf
application/x-tika-ooxml excel
image/jpeg

*/
