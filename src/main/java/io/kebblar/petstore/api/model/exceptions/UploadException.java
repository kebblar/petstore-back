package io.kebblar.petstore.api.model.exceptions;

public class UploadException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public UploadException(String msg) {
        super(
            "Error en el servicio de envio de carga de archivos",
            msg,
            2022,
            "CVE_2022",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
