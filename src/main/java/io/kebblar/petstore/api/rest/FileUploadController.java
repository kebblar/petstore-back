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
 * Nombre:      FileUploadController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:24:46
 */
package io.kebblar.petstore.api.rest;

import static io.kebblar.petstore.api.model.enumerations.EnumMessage.UPLOAD_SERVICE;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import io.kebblar.petstore.api.service.AccessHelperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.exceptions.CustomException;
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
    private final AccessHelperService accessHelperService;
    private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * Constructor para la inyeccion de dependencias.
     *
     * @param uploadService el servicio que ofrece almacenamiento
     */
    public FileUploadController(
            UploadService uploadService,
            AccessHelperService accessHelperService) {
        this.uploadService = uploadService;
        this.accessHelperService = accessHelperService;
    }


    /**
     * Recibe un(os) archivo(s) del front y lo almacena en la carpeta y almacena una copia en
     * ${app.destination-folder}/kdm y otra copia en ${application.properties}/kdm.
     *
     * @param file archivo a almacenar
     * @return lista que contiene el modelo de donde se almaceno el archivo
     * @throws ControllerException si hay algun error
     */
    @PostMapping(
            path = "/upload",
            produces = "application/json; charset=utf-8"
            )
    public UploadModel handleFileUploadWithKDMCopy(
            @RequestHeader("jwt") String jwt,
            @RequestParam("uno") int uno,
            @RequestParam("dos") String dos,
            @RequestParam("file") MultipartFile file
            ) throws ControllerException {
        logger.info(jwt);
        String s = String.valueOf(uno);
        logger.info(s);
        logger.info(dos);
        return uploadService.storeOne(file, destinationFolder, max);
    }
    // https://stackoverflow.com/questions/54683075/how-to-implement-multiple-files-upload-with-extra-fields-per-each-file-in-spring
    // https://github.com/ozkanpakdil/spring-examples/tree/master/demoMultiFileUpload
    // https://github.com/ozkanpakdil/spring-examples/blob/master/demoMultiFileUpload/src/main/java/com/mascix/demoMultiFileUpload/Uploader.java

    @PutMapping(
            path = "/upload",
            produces = "application/json; charset=utf-8",
            consumes = { "multipart/*" }
            )
    public List<UploadModel> handleFileUploadWithKDMCopyPut(@RequestParam("files") MultipartFile[] files) throws ControllerException {
        return uploadService.store(files, destinationFolder, max);
    }
    // https://stackoverflow.com/questions/54683075/how-to-implement-multiple-files-upload-with-extra-fields-per-each-file-in-spring

    @PutMapping(
            path = "/upload2",
            produces = "application/json; charset=utf-8",
            consumes = { "multipart/*" }
            )
    public UploadModel upload2(@RequestParam("files") MultipartFile files) throws ControllerException {
        return uploadService.storeOne(files, destinationFolder, max);
    }

    @PostMapping(
        path = "/up/imagen",
        produces = "application/json; charset=utf-8")
    public UploadModel guardarImagen(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile file) throws ControllerException {
        return uploadService.storeOne(file, destinationFolder, max);
    }

    @PostMapping(
        path = "/up/imagen2",
        produces = "application/json; charset=utf-8")
    public List<UploadModel> guardarImagen2(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile[] files) throws ControllerException {
        return uploadService.store(files, destinationFolder, max);
    }

    @PostMapping(
        path = "/foto-perfil",
        produces = "application/json; charset=utf-8")
    public UploadModel subeFotoPerfil(
    @ApiParam(name = "idUser", value = "id del usuario")
    @RequestHeader("idUser") int idUser,
    @ApiParam(name = "image", value = "Imagen a guardar.")
    @RequestParam("image") MultipartFile files) throws ControllerException {
        if (accessHelperService.getUsuarioById(idUser) == null) throw new CustomException(UPLOAD_SERVICE);
        UploadModel um = uploadService.storeOne(files, destinationFolder, max);
        accessHelperService.uploadFotoPerfil(idUser, um.getNuevoNombre());
        return um;
    }

   @GetMapping(
           path = "/get-foto-perfil/{idUser}",
           produces = "application/json; charset=utf-8")
    public Map<String, String> getFotoPerfil(
            @ApiParam(name = "idUser", value="id del usuario") @PathVariable int idUser)
           throws ControllerException {
        Map<String, String> elemento = new HashMap<>();
        elemento.put("foto",accessHelperService.getProfilePic(idUser));
        return elemento;
   }

   @ApiOperation( value = "AdminController::UploadPictures",
           notes = "sube una imagen al sistema")
   @PostMapping(path="/UploadPictures", produces = "application/json; charset=utf-8")
   public String upload(
       @ApiParam(name = "request", value = "MultipartFile del archivo")
       MultipartHttpServletRequest request,
       HttpServletResponse response){

       Enumeration<String> parameterNames = request.getParameterNames();
       while(parameterNames.hasMoreElements()) {
           String name = parameterNames.nextElement();
           String value = request.getParameter(name);
           logger.info("{} : {}", name, value);
       }

       Map<String, MultipartFile> fileMap = request.getFileMap();
       for (MultipartFile multipartFile : fileMap.values()) {
           logger.info(multipartFile.getOriginalFilename());
       }
       return "ok";
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
