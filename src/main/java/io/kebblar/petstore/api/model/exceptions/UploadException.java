package io.kebblar.petstore.api.model.exceptions;

public class UploadException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    
    public UploadException(Exception e) {
        super(
            "Error en el servicio de envio de carga de archivos",
            e.getMessage(),
            1020,
            "CVE_1020",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    public UploadException(long max, long peso) {
        super(
            "Error en el servicio de envio de carga de archivos",
            String.format("Limite excedido. Max: %d. Upload: %d", max, peso),
            1020,
            "CVE_1020",
            HttpStatus.INTERNAL_SERVER_ERROR);        
    }
    
    public UploadException() {
        super(
            "Error en el servicio de envio de carga de archivos",
            "Tipo mime desconocido",
            1020,
            "CVE_1020",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
