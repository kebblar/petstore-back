/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      ImagenRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:01:10
 */
package io.kebblar.petstore.api.model.request;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

/**
 * Implementacion del POJO de la entidad de 'ImagenRequest'.
 *
 * @author  Javier Chàvez
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ImagenRequest {

    private int id;//Identificador del anuncio
    private MultipartFile[] files;

    public ImagenRequest() {
    }

    public ImagenRequest(int id, MultipartFile[] files) {
        this.id = id;
        this.files = files;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public MultipartFile[] getFiles() {
        return files;
    }
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "ImagenRequest [id=" + id + ", files=" + Arrays.toString(files) + "]";
    }
}
