package io.kebblar.petstore.api.support;

import java.awt.image.BufferedImage;

import io.kebblar.petstore.api.model.exceptions.BusinessException;

public interface QRService {
    BufferedImage generateQRCodeImage(String barcodeText) throws BusinessException;
    byte[] getQRBytes(String text) throws BusinessException ;
    String getQRBytesBase64(String textToEncode) throws BusinessException;
}
