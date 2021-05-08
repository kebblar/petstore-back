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
 * Autor:       Francisco Javier Moreno Romero
 * Fecha:       07/05/2021 08:34 pm
 * Version:     1.0-SNAPSHOT
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

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints 
 * de gestión del POJO Usuario.
 * 
 * <p>Todos los métodos de esta clase disparan {@link FileUploadController}
 * 
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no 
 * llevan  javadoc  debido a que la  documentación  Swagger  API 
 * cumple con ese objetivo.
 * 
 * 
 * @author javier
 * @version 1.0-SNAPSHOT
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
    @PostMapping(path = "/upload.json", produces = "application/json; charset=utf-8")
    public List<UploadModel> handleFileUploadWithKDMCopy(@RequestParam("files") MultipartFile[] files) throws UploadException {
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
