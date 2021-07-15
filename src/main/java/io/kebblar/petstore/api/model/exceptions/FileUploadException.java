package io.kebblar.petstore.api.model.exceptions;

public class FileUploadException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    private final static String detailedMensaje = "Limite excedido. Max: %d. Peso: %d";

    public FileUploadException(long max, long size) {
        super(
            "Error al subir un archivo",
            String.format(detailedMensaje, max, size),
            1007,
            "CVE_1007",
            HttpStatus.BAD_REQUEST);
    }
    public FileUploadException(String msg) {
        super(
            "Error al subir un archivo",
            msg,
            1008,
            "CVE_1008",
            HttpStatus.BAD_REQUEST);
    }
}
