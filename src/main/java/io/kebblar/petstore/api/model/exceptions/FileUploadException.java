package io.kebblar.petstore.api.model.exceptions;

public class FileUploadException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public FileUploadException(long max, long size) {
        super(
            "Error al subir un archivo",
            "Limite excedido. Max: "+max+". Peso: " + size,
            2006,
            "CVE_4091",
            HttpStatus.BAD_REQUEST);
    }
    public FileUploadException(String msg) {
        super(
            "Error al subir un archivo",
            msg,
            2006,
            "CVE_4091",
            HttpStatus.BAD_REQUEST);
    }
}
