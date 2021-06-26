package io.kebblar.petstore.api.utils;

public class StringUtils {
    public static void main(String...s) {
        System.out.println(limpia("+82 (54) 16@91-3070#"));
    }

    public static String limpia(String s) {
        String result = "";
        int len = s.length();
        for(int i=0; i<len; i++) {
            result = result + separa(s.charAt(i));
        }
        return result.replaceAll("@", "");
    }

    private static char separa(char s) {
        if(s>47 && s<=57) return s;
        return '@';
    }
}
