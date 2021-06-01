package io.kebblar.petstore.api.utils;

public class Convert {
    private static final String[] UNIDADES = {"", "UN ", "DOS ", "TRES ", "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ", "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE"};
    private static final String[] DECENAS  = {"VENTI", "TREINTA ", "CUARENTA ", "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ", "CIEN "};
    private static final String[] CENTENAS = {"CIENTO ", "DOSCIENTOS ", "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ", "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};
        
    public static String ok(int n) {
        if (n<0) return "MENOS "+ok(-n);
        if (n>=0 && n<21) return UNIDADES[n];
        if (n>=21 && n<100) return DECENAS[(n/10)-2] + ok(n%10);
        if (n>=100 && n<1000) return CENTENAS[(n/100)-1] + ok(n%100);
        if (n>=1000 && n<1000000) return ok(n/1000) + " MIL " + ok(n%1000);
        if (n>=1000000 && n<999000000) return ok(n/1000000) + " MILLONES " + ok(n%1000000);
        return "to big";
    }
    
}
