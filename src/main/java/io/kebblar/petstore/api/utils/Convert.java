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

	private static final String[] UNIDADES = {"", "UN ", "DOS ", "TRES ", "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ", "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE"};
	private static final String[] DECENAS  = {"VENTI", "TREINTA ", "CUARENTA ", "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ", "CIEN "};
	private static final String[] CENTENAS = {"CIENTO ", "DOSCIENTOS ", "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ", "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};
	 
	/**
         * Método para transformar cantidades a cadena  String
         * @param cifra numerica
         * @param valor opcional para convertir cifra a letras mayusculas
         * @return String cadena convertida
         */
	 public static String convertir(int n) {
	      if (n<0) return "MENOS "+convertir(-n);
	      if (n>=0 && n<21) return UNIDADES[n];
	      if (n>=21 && n<100) return DECENAS[(n/10)-2] + ((n%10)==0 || (n/10)-2==0 ? "" : "Y ") + convertir(n%10);
	      if (n==100) return "CIEN";
	      if (n>100 && n<1000) return CENTENAS[(n/100)-1] + convertir(n%100);
	      if (n>=1000 && n<1000000) return (n/1000)>2 ? (convertir(n/1000) + " MIL " + convertir(n%1000)) : "MIL " + convertir(n%1000) ;
	      if (n>=1000000 && n<999000000) return convertir(n/1000000) + " MILLONES " + convertir(n%1000000);
	      return "to big";
	  }
	
}
