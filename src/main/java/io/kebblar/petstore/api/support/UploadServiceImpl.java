/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.support
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      UploadServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:32:11
 */
package io.kebblar.petstore.api.support;

import static io.kebblar.petstore.api.model.enumerations.EnumMessage.*;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.exceptions.CustomException;

import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.kebblar.petstore.api.mapper.UploadMapper;
import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.utils.WaterMark;

/**
 * Clase encargada de gestionar los archivos que se suben desde el cliente web.
 *
 * @author garellano
 * @version $Id: $Id
 */
@Service
public class UploadServiceImpl implements UploadService {
    /** logger. */
    private final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    /** tika. */
    private final Tika tika = new Tika();
    
    private UploadMapper uploadMapper;
    
    public UploadServiceImpl(UploadMapper uploadMapper) {
        this.uploadMapper = uploadMapper;
    }

    /** {@inheritDoc} */
    @Override
    public List<UploadModel> store(int idAnuncio, MultipartFile[] mpfArray, String destinationFolder, long max) throws ServiceException {
        List<UploadModel> lista = new ArrayList<>();
        for (MultipartFile mpf : mpfArray) {
            lista.add(storeOne(idAnuncio, mpf, destinationFolder, max));
        }
        return lista;
    }

    /**
     * Valida.
     *
     * @param mpf the mpf
     * @throws ServiceException the upload exception
     */
    private String valida(MultipartFile mpf, long max) throws ServiceException {
        long peso = mpf.getSize();
        if (peso>max) {
            throw new CustomException(FILE_MAX_UPLOAD, peso, max);
        }

        String mimeType = "no-pude-detectar-el-tipo-mime";
        try {
            mimeType = this.tika.detect(mpf.getInputStream());
        } catch (IOException e) {
            throw new CustomException(e, UPLOAD_SERVICE_LOG);
            // AQUI, ADEMÁS, VALIDAR QUE EL MIME TYPE ES DE UNA IMAGEN Y NO UNA COSA RARA, COMO UN VIRUS
            // SI SE DETECTA UN ARCHIVO RARO, LANZAR UNA EXCEPCIÓN Y GRABAR EN LA BITACORA UN INCIDENTE GRAVE
        }
        logger.info("{}<-------------- mime type", mimeType);
        return mimeType;
    }
    
    private String calculateExt(String fullName) {
        String ext = FilenameUtils.getExtension(fullName);
        if(ext.trim().length()<1) ext = "png";
        return ext;
    }
    private int calculaIdTipo(String ext) throws CustomException {
        int tipoMedia=0;
        switch (ext) {
            case "image/jpg":
            case "image/jpeg":
                tipoMedia = 1;
                break;
            case "image/png":
                tipoMedia = 2;
                break;
            case "video/mp4":
                tipoMedia = 4;
                break;
            case "video/avi":
                tipoMedia = 5;
                break;
            default:
                throw new CustomException(NOT_VALID_IMAGE);
        }
        return tipoMedia;
    }

    /**
     * {@inheritDoc}
     *
     * Store one.
     */
    public UploadModel storeOne(int idAnuncio, MultipartFile mpf, String destinationFolder, long max) throws ServiceException {
        UUID uuid = UUID.randomUUID();
        String ext = this.calculateExt(mpf.getOriginalFilename());
        String newName = uuid.toString() + "." + ext;
        //int idAnuncio = 2; // CAMBIAR PRONTO AL ID CORRECTO
        String mimeType = valida(mpf, max);
        UploadModel uploadModel = new UploadModel(
                0,
                idAnuncio,
                mpf.getOriginalFilename(),
                newName,
                getMd5(mpf),
                mimeType,
                calculaIdTipo(mimeType),
                new Date(),
                mpf.getSize(),
                true);
        String uploadModelString = uploadModel.toString();
        logger.info("Upload model: {}", uploadModelString);
        Path filepath = Paths.get(destinationFolder, newName); //destinationFolder
        //Path filepath = Paths.get("/Users/garellano/Desktop/peliculas", newName);
        try {
            mpf.transferTo(filepath);
            WaterMark.getInstance().addWatermarkOnImage(destinationFolder, newName, "logo.png", "_"+newName);
            // AQUI EN ESTA LINEA HAY QUE GUARDAR EL OBJETO "uploadModel" en la base...
            // Algo asi como la siguiente linea:
            // poner: storageMapper.insert(uploadModel)
            if(uploadMapper!=null) uploadMapper.insertMedia(uploadModel);
            return uploadModel;
        } catch (IllegalStateException | IOException e) {
            throw new CustomException(e, UPLOAD_SERVICE_LOG);
        }
    }

    /**
     * Gets the md 5.
     *
     * @param mpf the mpf
     * @return the md 5
     * @throws ServiceException the upload exception
     */
    private static String getMd5(MultipartFile mpf) throws ServiceException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(mpf.getBytes());
            BigInteger container = new BigInteger(1, messageDigest);
            String hashtext = container.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0".concat(hashtext);
            }
            return hashtext;
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new CustomException(e, UPLOAD_SERVICE_LOG);
        }
    }

}
