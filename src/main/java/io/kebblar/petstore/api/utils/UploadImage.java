/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      UploadImage
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:22:35
 */
package io.kebblar.petstore.api.utils;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.FileUploadException;
import io.kebblar.petstore.api.model.exceptions.InternalServerException;
import io.kebblar.petstore.api.model.exceptions.UploadException;
import io.kebblar.petstore.api.model.response.InformacionMedia;
import io.kebblar.petstore.api.support.UploadService;
import io.kebblar.petstore.api.support.UploadServiceImpl;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>Descripción:</p>
 * Servicio para cargar una imagen a los ficheros al sistema
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class UploadImage {

    private final Tika tika = new Tika();
    @Value("${app.max-file-size}")
    private long max;
    @Value("${app.destination-folder-video}")
    private String destinationFolderVideo;
    @Value("${app.destination-folder}")
    private String destinationFolder;
    @Value("${app.imagen-tam}")
    private int imagenAltura;
    UploadService uploadService;

    public UploadImage() {
        this.uploadService = new UploadServiceImpl();
    }

    public InformacionMedia guardarImagen(String uuid, MultipartFile file) throws BusinessException {
        String contentType = "no-pude-detectar-el-tipo-mime";
        try {
            contentType = tika.detect(file.getInputStream());
        } catch (IOException e) {
            throw new InternalServerException("Error al leer el archivo", e.toString());
        }
        long size = file.getSize();
        if (size > max) {
            throw new FileUploadException(size, max);
        }
        try {
            int tipoMedia=0;
            String carpetaDestino=destinationFolder;
            switch (contentType) {
                case "image/jpg":
                case "image/jpeg":
                    tipoMedia = 1;
                    break;
                case "image/png":
                    tipoMedia = 2;
                    break;
                case "video/mp4":
                    tipoMedia = 4;
                    carpetaDestino = destinationFolderVideo;
                    break;
                case "video/avi":
                    tipoMedia = 5;
                    carpetaDestino = destinationFolderVideo;
                    break;
                default:
                    throw new FileUploadException("Formato de imagen no valido. Solo se aceptan: jpg, jpeg, png, mp4, avi");
            }
            UploadModel upload = uploadService.storeOne(file, carpetaDestino, max);
            InformacionMedia imagenEnt= new InformacionMedia(uuid,upload.getNuevoNombre(),tipoMedia);
            //Renderizacion de imagen con marca de agua
            if(tipoMedia!=4 && tipoMedia!=5) {
                AnuncioUtil.renderizarYMarcaDeAgua(destinationFolder,"petstore.com", uuid, imagenAltura);
            }
            return imagenEnt;
        }catch (UploadException e) {
            throw new FileUploadException(e.getShortMessage());
        }
    }
}
