/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.api.service
 * Modulo:      cinepolis
 * Tipo:        clase
 * Autor:       Gustavo Adolfo Arellano Sandoval (garellanos)
 * Fecha:       28 de Marzo de 2020
 * Version:     1.0-SNAPSHOT
 * .
 * Clase encargada de gestionar los archivos que se suben desde el cliente web
 */
package io.kebblar.petstore.api.support;

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

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.UploadException;

/**
 * Clase encargada de gestionar los archivos que se suben desde el cliente web.
 *
 * @author garellano
 */
@Service
public class UploadServiceImpl implements UploadService {
    /** logger. */
    private Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    /** tika. */
    private Tika tika = new Tika();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UploadModel> store(MultipartFile[] mpfArray, String destinationFolder, long max) throws UploadException {
        List<UploadModel> lista = new ArrayList<>();
        for (MultipartFile mpf : mpfArray) {
            lista.add(storeOne(mpf, destinationFolder, max));
        }
        return lista;
    }

    /**
     * Valida.
     *
     * @param mpf the mpf
     * @throws UploadException the upload exception
     */
    private void valida(MultipartFile mpf, long max) throws UploadException {
        long peso = mpf.getSize();
        if (peso>max) {
            UploadException ue = new UploadException("Limite excedido. Max: "+max+". Upload: " + peso + ".");
            throw ue;
        }

        String mimeType = "no-pude-detectar-el-tipo-mime";
        try {
            mimeType = this.tika.detect(mpf.getInputStream());
        } catch (IOException e) {
            throw new UploadException("Tipo mime dexonocido");
            // AQUI, ADEMÁS, VALIDAR QUE EL MIME TYPE ES DE UNA IMAGEN Y NO UNA COSA RARA, COMO UN VIRUS
            // SI SE DETECTA UN ARCHIVO RARO, LANZAR UNA EXCEPCIÓN Y GRABAR EN LA BITACORA UN INCIDENTE GRAVE
        }
        logger.info("{}<-------------- mime type", mimeType);
    }

    /**
     * Store one.
     *
     * @param mpf the mpf
     * @return the upload model
     * @throws UploadException the upload exception
     */
    private UploadModel storeOne(MultipartFile mpf, String destinationFolder, long max) throws UploadException {
        UUID uuid = UUID.randomUUID();
        String newName = uuid.toString() + ".png";
        int autoIncremental = 0;
        valida(mpf, max);
        UploadModel uploadModel = new UploadModel(
                autoIncremental,
                mpf.getOriginalFilename(),
                newName,
                getMd5(mpf),
                new Date(),
                mpf.getSize(),
                true);
        String uploadModelString = uploadModel.toString();
        logger.info("Upload model: {}", uploadModelString);
        Path filepath = Paths.get(destinationFolder, newName);
        //Path filepath = Paths.get("/Users/garellano/Desktop/peliculas", newName);
        try {
            mpf.transferTo(filepath);
            // AQUI EN ESTA LINEA HAY QUE GUARDAR EL OBJETO "uploadModel" en la base...
            // Algo asi como la siguiente linea:
            // poner: storageMapper.insert(uploadModel)
            return uploadModel;
        } catch (IllegalStateException | IOException e) {
            throw new UploadException(e.getMessage());
        }
    }

    /**
     * Gets the md 5.
     *
     * @param mpf the mpf
     * @return the md 5
     * @throws UploadException the upload exception
     */
    private static String getMd5(MultipartFile mpf) throws UploadException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(mpf.getBytes());
            BigInteger container = new BigInteger(1, messageDigest);
            String hashtext = container.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0".concat(hashtext);
            }
            return hashtext;
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new UploadException(e.getMessage());
        }
    }

}
