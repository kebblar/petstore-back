package io.kebblar.petstore.api.model.exceptions;

import org.springframework.http.HttpStatus;

public class WaitLoginException extends BusinessException {
    private static final long serialVersionUID = 8948866486775990561L;
    private final static String mensaje = "El usuario ha sido bloqueado por los próximos %d minutos y %d segundos debido a que alcanzó el máximo numero de intentos fallidos de ingreso al sistema.";

    public WaitLoginException(long segundos) {
        super(
            "Usuario bloqueado",
            calc(segundos),
            1001,
            "CVE_1001",
            HttpStatus.BAD_REQUEST);
    }

    private static String calc(long segundos) {
        long minutos = segundos/60;
        long seg = segundos%60;
        return String.format(mensaje, minutos, seg);
    }

}
