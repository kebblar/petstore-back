/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      QuickTest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:39:39
 */
package io.kebblar.petstore.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.Tika;

/**
 * <p>QuickTest class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
public class QuickTest {
    private static Tika tika = new Tika();
    private static final String base="/Users/garellano/tempito/fher/entrada/";

    /**
     * <p>main.</p>
     *
     * @param argv a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
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
