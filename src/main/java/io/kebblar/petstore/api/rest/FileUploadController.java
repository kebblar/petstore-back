/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Modulo:      proyecto
 * Clase        FileUploadController
 * Autor:
 * Fecha:       4/30/20, 11:26 PM
 * Version:     1.0-SNAPSHOT
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.UploadException;
import io.kebblar.petstore.api.support.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Endpoint para subir archivos.
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
    @PostMapping(
            path = "/upload.json",
            produces = "application/json; charset=utf-8"
            )
    public UploadModel handleFileUploadWithKDMCopy(
            @RequestHeader("jwt") String jwt,
            @RequestParam("uno") int uno,
            @RequestParam("dos") String dos,
            @RequestParam("file") MultipartFile file
            ) throws UploadException {
        System.out.println(jwt);
        System.out.println(uno);
        System.out.println(dos);
        UploadModel upload = uploadService.storeOne(file, destinationFolder, max);
        return upload;
    } // https://stackoverflow.com/questions/54683075/how-to-implement-multiple-files-upload-with-extra-fields-per-each-file-in-spring
    // https://github.com/ozkanpakdil/spring-examples/tree/master/demoMultiFileUpload
    // https://github.com/ozkanpakdil/spring-examples/blob/master/demoMultiFileUpload/src/main/java/com/mascix/demoMultiFileUpload/Uploader.java

    @PutMapping(
            path = "/upload.json",
            produces = "application/json; charset=utf-8",
            consumes = { "multipart/*" }
            )
    public List<UploadModel> handleFileUploadWithKDMCopyPut(@RequestParam("files") MultipartFile[] files) throws UploadException {
        List<UploadModel> listaUpload = uploadService.store(files, destinationFolder, max);
        return listaUpload;
    } // https://stackoverflow.com/questions/54683075/how-to-implement-multiple-files-upload-with-extra-fields-per-each-file-in-spring

    @PutMapping(
            path = "/upload2.json",
            produces = "application/json; charset=utf-8",
            consumes = { "multipart/*" }
            )
    public UploadModel upload2(@RequestParam("files") MultipartFile files) throws UploadException {
        UploadModel upload = uploadService.storeOne(files, destinationFolder, max);
        return upload;
    }
    
    
    @ApiOperation(
    value = "AnuncioController::Registro",
    notes = "Recibe una imagen que sera asociada a un anuncio")
    @PostMapping(
        path = "/up/imagen.json",
        produces = "application/json; charset=utf-8")
    public UploadModel guardarImagen(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile file) throws BusinessException {
        return uploadService.storeOne(file, destinationFolder, max);
    }
    
    @ApiOperation(
    value = "AnuncioController::Registro",
    notes = "Recibe una imagen que sera asociada a un anuncio")
    @PostMapping(
        path = "/up/imagen2.json",
        produces = "application/json; charset=utf-8")
    public List<UploadModel> guardarImagen2(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile[] files) throws BusinessException {
        return uploadService.store(files, destinationFolder, max);
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
