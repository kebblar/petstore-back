package io.kebblar.petstore.api.support;

import java.awt.image.BufferedImage;

public interface QRService {
    BufferedImage generateQRCodeImage(String barcodeText) throws Exception;
}
