package io.kebblar.petstore.api.model.exceptions;

public class BadCredentialsException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;
    private final static String mensaje = "Las credenciales proporcionadas son inválidas. Usted tiene %d intentos mas antes de que su usuario quede bloqueado.";

    public BadCredentialsException(int counter, int maxAllowed) {
        super(
            "Las credenciales proporcionadas son inválidas",
            String.format(mensaje, maxAllowed-counter),
            1003,
            "CVE_1003",
            HttpStatus.UNAUTHORIZED);
    }
    public BadCredentialsException() {
        super(
            "Las credenciales proporcionadas son inválidas",
            "Favor de capturar credenciales válidas",
            1003,
            "CVE_1003",
            HttpStatus.UNAUTHORIZED);
    }

}
