package io.kebblar.petstore.api.utils;

public class LimpiadorTexto {

    /**
     * Limpia una cadena de caracteres "raras" y regresa la misma
     * cadena (en minúsculas) sustituyendo las letras "raras" por guiones medios.
     *
     * @param original Cadena original de tipo String
     * @return  Cadena limpia
     */
    public static String limpia(String original) {
        String unEspacio = " ";
        String dosEspacios = "  ";
        String guionMedio = "-";
        String dosGuionesMedios = "--";
        String letrasValidas = "0123456789abcdefghijklmnopqrstuvwxyz-";

        // Quita espacios al inicio y al final. Además, manda a minusculas
        String source = original.trim().toLowerCase();

        int i;
        // Colapsa espacios juntos en un solo espacio
        do {
            i = source.indexOf(dosEspacios);
            source = source.replace(dosEspacios, unEspacio);
        } while (i>0);

        // Cambia espacios simples restantes por guion medio
        source = source.replace(unEspacio, guionMedio);

        // Cambia minúsculas acentuadas por minúsculas sin acento
        // No necesito cambiar las mayúsculas porque la cadena está en lowercase
        source = source.replace('á', 'a');
        source = source.replace('é', 'e');
        source = source.replace('í', 'i');
        source = source.replace('ó', 'o');
        source = source.replace('ú', 'u');
        source = source.replace('ñ', 'n');

        // Cambia lo que NO esté en "letrasValidas" por -
        i = source.length();
        StringBuilder result = new StringBuilder();
        for(int j=0; j<i; j++) {
            char test = source.charAt(j);
            result = (letrasValidas.indexOf(test)<1)?result.append(guionMedio):result.append(test);
        }
        // elimina repeticiones de guiones mendios consecutivos
        source = result.toString();
        do {
            i = source.indexOf(dosGuionesMedios);
            source = source.replace(dosGuionesMedios, guionMedio);
        } while (i>=0);
        return source;
    }

}
