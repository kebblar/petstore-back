package io.kebblar.petstore.api.support;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import io.kebblar.petstore.api.model.exceptions.BusinessException;

@Service
public class QRServiceImpl implements QRService {
    private Logger logger = LoggerFactory.getLogger(QRServiceImpl.class);

    @Override
    public BufferedImage generateQRCodeImage(String barcodeText) throws BusinessException {
        try {
            logger.info("Processing: " + barcodeText);
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch(Exception e) {
            throw new BusinessException(e.toString(), e.toString());
        }
    }

    @Override
    public byte[] getQRBytes(String text) throws BusinessException {
        try {
            BufferedImage data = this.generateQRCodeImage(text);
            return toByteArray(data, "png");
        } catch(Exception e) {
            throw new BusinessException(e.toString(), e.toString());
        }
    }

    @Override
    public String getQRBytesBase64(String textToEncode) throws BusinessException {
        try {
            BufferedImage data = this.generateQRCodeImage(textToEncode);
            return Base64.getEncoder().encodeToString(toByteArray(data, "jpg"));
        } catch(Exception e) {
            throw new BusinessException(e.toString(), e.toString());
        }
    }

    private byte[] toByteArray(BufferedImage bi, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        return baos.toByteArray();
    }
}
