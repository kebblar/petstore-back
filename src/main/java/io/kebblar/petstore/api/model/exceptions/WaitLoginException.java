package io.kebblar.petstore.api.model.exceptions;

public class WaitLoginException extends BusinessException {
    private static final long serialVersionUID = 8948866486775990561L;
    
    private final static String detailedMensaje = "El usuario ha sido bloqueado por los próximos %d minutos y %d segundos debido a que alcanzó el máximo numero de intentos fallidos de ingreso al sistema.";
    private final static String shortMensaje = "Usuario bloqueado";
    
    public WaitLoginException(long seconds) {
        super(
            shortMensaje,
            calc(seconds),
            1024,
            "CVE_1024",
            HttpStatus.BAD_REQUEST);
    }

    private static String calc(long seconds) {
        long minutes = seconds/60;
        long seg = seconds%60;
        return String.format(detailedMensaje, minutes, seg);
    }

}
