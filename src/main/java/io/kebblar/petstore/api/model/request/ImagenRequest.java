/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
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

    /**
     * <p>Constructor for ImagenRequest.</p>
     */
    public ImagenRequest() {
    }

    /**
     * <p>Constructor for ImagenRequest.</p>
     *
     * @param id a int.
     * @param files an array of {@link org.springframework.web.multipart.MultipartFile} objects.
     */
    public ImagenRequest(int id, MultipartFile[] files) {
        this.id = id;
        this.files = files;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }
    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * <p>Getter for the field <code>files</code>.</p>
     *
     * @return an array of {@link org.springframework.web.multipart.MultipartFile} objects.
     */
    public MultipartFile[] getFiles() {
        return files;
    }
    /**
     * <p>Setter for the field <code>files</code>.</p>
     *
     * @param files an array of {@link org.springframework.web.multipart.MultipartFile} objects.
     */
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ImagenRequest [id=" + id + ", files=" + Arrays.toString(files) + "]";
    }
}
