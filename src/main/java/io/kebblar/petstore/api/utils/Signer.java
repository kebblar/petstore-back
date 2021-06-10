package io.kebblar.petstore.api.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

import org.apache.commons.io.IOUtils;
import org.apache.commons.ssl.PKCS8Key;
public class Signer {

    private String privateKeyFile;
    private String certificateFile;
    private String password = "password";
    private String file;
    
    
    public Signer(String privateKeyFile, String certFile, String file) {
        this.privateKeyFile = privateKeyFile;
        this.certificateFile = certFile;
        this.file = file;
    }

    
    public String signPdf() throws Exception{
        String hash = createSum(this.file);
        String signedFile = signWithPrivateKey(hash);
        return signedFile;
        
    }
    
    // Usando un certificado, se encripta un texto que luego se va a poder desencriptar
    // con una llave privada y el password de esa lave privada
    public String signWithCert(String text) throws Exception {
        X509Certificate cert =  (X509Certificate)getCertificateFromString(this.certificateFile);
        PublicKey publicKey = cert.getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return toHexString(cipher.doFinal(text.getBytes()));
    }
    
    public String createSum(String fileName) throws NoSuchAlgorithmException, IOException {
        InputStream fis =  new FileInputStream(fileName);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("SHA-256");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        byte[] digestion = complete.digest();

        return toHexString(digestion);
    }
    
    /**
     * Convierte un arreglo de bytes en una cadena hexadecimal.
     *
     * @param hash Arreglo de bytes a ser convertido a cadena.
     *
     * @return Cadena asociada al arreglo dado
     */
    private static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        // Show me the result, baby
        return hexString.toString();
    }
    
    
    // Usa el certificado para verifcar que cierto texto encriptado con una llave privada es válido.
    public String verifySignature(String textoEncriptado) throws Exception {
        String certData = readFile(this.certificateFile);
        Certificate cer = getCertificateFromString(certData);
        return decrypt(textoEncriptado.getBytes(), cer);
    }
    
    private String decrypt(byte[] textoEncriptadoEnBytes, Certificate cer) throws Exception {
        return decrypt(textoEncriptadoEnBytes, cer.getPublicKey());
    }
    
    private String decrypt(byte[] textoEncriptadoEnBytes, PublicKey publicKey) throws Exception {
        byte[] textoEncriptadoEnBytesDecodedBase64 = Base64.getDecoder().decode(textoEncriptadoEnBytes);
        byte[] decripted = decryptWithPublicKey(textoEncriptadoEnBytesDecodedBase64, publicKey);
        return convert(decripted);
    }
    
    public byte[] getTextoEncriptadoFromPrivateKeyFile(String texto, String privateKeyFile, String password) throws GeneralSecurityException, IOException {
        PrivateKey pk = getPrivateKeyFromFile(privateKeyFile, password);
        Signature firma = Signature.getInstance("NONEwithRSA"); // MD5withRSA,SHA256withRSA,NONEwithRSA
        firma.initSign(pk);
        // Aqui calculo el SHA-256 en vez de usar el que me da este algoritmo
        firma.update(texto.getBytes());
        return Base64.getEncoder().encode(firma.sign());
    }

    /**   **/
    /**
     * Usando la llave privada y un password, se encripta un texto que luego va a poder ser
     * desencriptado con el certificado o la llave púbkica que el certfcado tiene dentro.
     *
     * @param privateKeyFile Archivo del FileSystem con el contenido de una llave privada
     * @param textoParaEncripcion Texto que será encriptado
     * @param privateKeyFile1
     * @param password1
     * @param password Clave secreta asociada a la llave privada
     *
     * @return Texto encriptado
     * @throws Exception Envolvente para IOSexception y SecurityException
     *
     * @see {@link #signWithPrivateKey2}
     */
    public String signWithPrivateKey(String textoParaEncripcion) throws Exception {
        byte[] textoEncriptadoEnBytes = getTextoEncriptadoFromPrivateKeyFile(
                textoParaEncripcion, this.privateKeyFile, this.password);
        return convert(textoEncriptadoEnBytes);
    }

    // Usando la llave privada de desencripta lo que encripto una llave publica
    public byte[] decodeWithPrivateKey(byte[] text, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(text);
    }

    private String convert(byte[] source) {
        return new String(source);
    }
    private String readFile(String path) throws IOException {
        Path ruta1 = Paths.get(path);
        //Path ruta2 = new File(path).toPath();
        //byte[] encoded = FileUtils.readFileToByteArray(new File(path));
        byte[] encoded = Files.readAllBytes(ruta1);
        return new String(encoded, Charset.defaultCharset());
    }
    private byte[] decryptWithPublicKey(byte[] text, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(text);
    }
    private Certificate getCertificateFromString(String certificateString) throws CertificateException, FileNotFoundException {
        InputStream stream = new ByteArrayInputStream(certificateString.getBytes(StandardCharsets.UTF_8));
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        return cf.generateCertificate(stream);
    }
    private byte[] getPrivateKeyBytes(String privateKeyFile) throws IOException {
        File initialFile = new File(privateKeyFile);
        InputStream privateKeyInputStream = new FileInputStream(initialFile);
        return IOUtils.toByteArray(privateKeyInputStream);
    }

    private PrivateKey getPrivateKeyFromFile(String privateKeyFile, String password) throws GeneralSecurityException, IOException {
        byte[] clavePrivada = getPrivateKeyBytes(privateKeyFile);
        PKCS8Key pkcs8 = new PKCS8Key(clavePrivada, password.toCharArray());
        return pkcs8.getPrivateKey();
    }




}

/*
openssl genrsa -out ok.key 1024
openssl req -new -x509 -key ok.key -out ok.cer -days 365
*/
