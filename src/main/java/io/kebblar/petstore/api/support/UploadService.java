/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Modulo:      UploadService
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Jueves 2 de Abril de 2020 (22_29)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion del Servicio de informe de salud
 *
 * Historia:    .
 *              20200402_2229 Creación del tipo
 *
 */
package io.kebblar.petstore.api.support;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.UploadException;

/**
 * Interface UploadService.
 */
public interface UploadService {

    /**
     * Procesa un conjunto de archivos que le son enviados desde el front.
     *
     * @param mpfArray MultipartFile[] arreglo de archivos enviados desde el front
     * @param destinationFolder String path to file destination
     * @param max long max size allowed for the file
     *
     * @return Lista de objetos de tipo UploadModel
     *
     * @throws UploadException Se dispara en caso de que el proceso de upload falle
     */
    public List<UploadModel> store(MultipartFile[] mpfArray, String destinationFolder, long max) throws UploadException;

    /**
     * Procesa un archivos que le es enviado desde el front.
     *
     * @param mpf MultipartFile archivo enviados desde el front
     * @param destinationFolder String path to file destination
     * @param max long max size allowed for the file
     *
     * @return Objetos de tipo UploadModel
     *
     * @throws UploadException Se dispara en caso de que el proceso de upload falle
     */
    public UploadModel storeOne(MultipartFile mpf, String destinationFolder, long max) throws UploadException;
}
