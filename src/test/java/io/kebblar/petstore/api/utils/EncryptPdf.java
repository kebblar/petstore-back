/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      EncryptPdf
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:39:21
 */
package io.kebblar.petstore.api.utils;

//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
//import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

//import com.lowagie.text.Document;
//import com.lowagie.text.Image;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfContentByte;
//import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;

/**
 * <p>EncryptPdf class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
public class EncryptPdf {
    //private static final String base = "/Users/garellano/Desktop/";
    //private static final String path = base + "archivo-pdf-generado.pdf";
    //private static final String imagen = base + "work/hola/logo.png";


    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     * @throws java.lang.Exception if any.
     */
    public static void main(String[] args) throws Exception {
        EncryptPdf enc = new EncryptPdf();
        enc.ok();
    }
    /**
     * <p>ok.</p>
     *
     * @throws java.lang.Exception if any.
     */
    public void ok() throws Exception {

    }

    /**
     * <p>protectDocument.</p>
     *
     * @param path a {@link java.lang.String} object.
     * @param userPassword a {@link java.lang.String} object.
     * @throws java.io.IOException if any.
     */
    public static void protectDocument(String path, String userPassword) throws IOException {
//        File file = new File(path);
//        PDDocument document = PDDocument.load(file);
//
//        AccessPermission ap = new AccessPermission();
//        StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", userPassword, ap);
//        spp.setEncryptionKeyLength(128);
//        spp.setPermissions(ap);
//        document.protect(spp);
//
//        System.out.println("PDF Document encrypted Successfully.");
//
//        document.save(path);
//        document.close();
    }

}
