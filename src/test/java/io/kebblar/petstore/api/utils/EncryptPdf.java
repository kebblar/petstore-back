package io.kebblar.petstore.api.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncryptPdf {
    private static final String base = "/Users/garellano/Desktop/";
    private static final String path = base + "archivo-pdf-generado.pdf";
    private static final String imagen = base + "work/hola/logo.png";


    public static void main(String[] args) throws Exception {
        EncryptPdf enc = new EncryptPdf();
        enc.ok();
    }
    public void ok() throws Exception {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        cb.beginText();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb.setFontAndSize(bf, 12);
        cb.setTextMatrix(0, 700);
        cb.showText("Gaby at position 0,700");
        cb.endText();
        cb.sanityCheck();

        Image gif = Image.getInstance(imagen);
        gif.setAbsolutePosition(0, 710);
        gif.scaleToFit(100, 135);
        document.add(gif);

        document.close();
        String userPassword = DigestEncoder.getRandomString(32);
        System.out.println(userPassword);
        protectDocument(path, userPassword);

        String sha256 = DigestEncoder.createChecksum(path);
        System.out.println(sha256);
        // shasum -a 256 archivo-pdf-generado.pdf

        //String rootPath = "/Users/garellano/emisor/";
        //Cript cry = new Cript(rootPath,rootPath+"ok.key",rootPath+"ok.cer");
        CryptoSupport cry = new CryptoSupport();
        String firma = cry.signWithPrivateKey(sha256);
        System.out.println(firma);

        //String decrypted = cry.decrypt(firma);
        //System.out.println(decrypted);
    }

    public static void protectDocument(String path, String userPassword) throws IOException {
        File file = new File(path);
        PDDocument document = PDDocument.load(file);

        AccessPermission ap = new AccessPermission();
        StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", userPassword, ap);
        spp.setEncryptionKeyLength(128);
        spp.setPermissions(ap);
        document.protect(spp);

        System.out.println("PDF Document encrypted Successfully.");

        document.save(path);
        document.close();
    }

}
