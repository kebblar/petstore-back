/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Convert.java
 * Tipo:        clase
 * AUTOR:       Daniel Alvarez
 * Fecha:       Domingo 13 Junio de 2021 (17_50)
 *
 * Historia:    .
 *              20210504_1950 Creación de éste pojo
 *
 */
package io.kebblar.petstore.api.utils;

import java.util.regex.Pattern;


/**
 * Clase de soporte para convertir cantidades numericas a letras formato String
 *
 * @author Daniel Alvarez
 * @version 1.0
 */
public class Convert {

    private static final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private static final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private static final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};

    public static String ok(int n) {
        if (n<0) return "MENOS "+ok(-n);
        if (n>=0 && n<21) return UNIDADES[n];
        if (n>=21 && n<100) return DECENAS[(n/10)-2] + ((n%10)==0 || (n/10)-2==0 ? "" : "Y ") + ok(n%10);
        if (n==100) return "CIEN";
        if (n>100 && n<1000) return CENTENAS[(n/100)-1] + ok(n%100);
        if (n>=1000 && n<1000000) return (n/1000)>2 ? (ok(n/1000) + " MIL " + ok(n%1000)) : "MIL " + ok(n%1000) ;
        if (n>=1000000 && n<999000000) return ok(n/1000000) + " MILLONES " + ok(n%1000000);
        return "to big";
    }

    /**
     * Método para transformar cantidades a cadena  String
     * @param cifra numerica
     * @param valor opcional para convertir cifra a letras mayusculas
     * @return String cadena convertida
     */
    public static String convertirNumero(String numero, boolean mayusculas) {
        String literal = "";
        String parte_decimal;
        numero = numero.replace(".", ",");
        if (numero.indexOf(",") == -1) {
            numero = numero + ",00";
        }
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            String Num[] = numero.split(",");
            parte_decimal = "y " + Num[1] + "/100 Pesos.";
            if (Integer.parseInt(Num[0]) == 0) {
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {
                literal = getDecenas(Num[0]);
            } else {
                literal = getUnidades(Num[0]);
            }
            if (mayusculas) {
                return (literal + parte_decimal).toUpperCase();
            } else {
                return (literal + parte_decimal);
            }
        } else {
            return literal = null;
        }
    }
    
    /**
     * Método para transformar las unidades de una cifra de número a letras 
     * @param unidades de una cifra
     * @return String cadena convertida
     */
    private static String getUnidades(String numero) {
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }
    
    /**
     * Método para transformar las decenas de una cifra de número a letras 
     * @param decenas de una cifra
     * @return String cadena convertida
     */
    private static String getDecenas(String num) {
        int n = Integer.parseInt(num);
        if (n < 10) {
            return getUnidades(num);
        } else if (n > 19) {
            String u = getUnidades(num);
            if (u.equals("")) {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {
            return DECENAS[n - 10];
        }
    }
    
    /**
     * Método para transformar las centenas de una cifra de número a letras 
     * @param centenas de una cifra
     * @return String cadena convertida
     */
    private static String getCentenas(String num) {
        if (Integer.parseInt(num) > 99) {
            if (Integer.parseInt(num) == 100) {
                return " cien ";
            } else {
                return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            }
        } else {
            return getDecenas(Integer.parseInt(num) + "");
        }
    }
    
    /**
     * Método para transformar los miles de una cifra de número a letras 
     * @param miles de una cifra
     * @return String cadena convertida
     */
    private static String getMiles(String numero) {
        String c = numero.substring(numero.length() - 3);
        String m = numero.substring(0, numero.length() - 3);
        String n = "";
        if (Integer.parseInt(m) == 1) {
            n = getCentenas(m);
            return "mil " + getCentenas(c);
        } else if (Integer.parseInt(m) > 0 && Integer.parseInt(m) != 1 ) {
            n = getCentenas(m);
            return n + "mil " +getCentenas(c);
        } else {
              return "" + getCentenas(c);
        }
    }
    
    /**
     * Método para transformar millones de una cifra de número a letras 
     * @param millones de una cifra
     * @return String cadena convertida
     */
    private static String getMillones(String numero) {
        String miles = numero.substring(numero.length() - 6);
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if (millon.length() > 1) {
            n = getCentenas(millon) + "millones ";
        } else {
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);
    }

}
