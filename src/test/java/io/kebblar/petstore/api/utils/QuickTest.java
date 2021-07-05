package io.kebblar.petstore.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.Tika;

public class QuickTest {
    private static Tika tika = new Tika();
    private static final String base="/Users/garellano/tempito/fher/entrada/";
    
    public static void main(String...argv) throws Exception {
        detecta("FLV","in_01.flv");
        detecta("MP4","in_02.mp4");
        detecta("OGV","in_03.ogv");
        detecta("MPG","in_04.mpeg");
        detecta("AVI","in_05.avi");
        detecta("MOV","in_07.mov");
        detecta("3GP","in_12.3gp");
        detecta("AVI","in_09.avi");
        detecta("TS","in_10.ts");
        detecta("AVI","in_11.avi");
    }

    private static void detecta(String extension, String in) {
        String file = base + in;
        String mimeType = "no-pude-detectar-el-tipo-mime";
        try {
            File initialFile = new File(file);
            InputStream stream = new FileInputStream(initialFile);
            mimeType = tika.detect(stream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(extension + "--->"+ mimeType);
    }

}
