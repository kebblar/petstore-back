package io.kebblar.petstore.api.utils;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WaterMark {
    private static final String RUTA="/Users/garellano/Desktop/peliculas/";

    public static void main(String[] args) {
        new WaterMark().addWatermarkOnImage();
    }

    public void addWatermarkOnImage() {
        File newFile = new File(RUTA + "campo2.jpg");
        File watermarkImageFile = new File(RUTA + "01.jpg");
        File origFile = new File(RUTA + "campo.jpg");

        ImageIcon watermarkImage = new ImageIcon(watermarkImageFile.getPath());
        BufferedImage bi = makeTransparent(watermarkImage.getImage(), 600);

        ImageIcon icon = new ImageIcon(origFile.getPath());

        // create BufferedImage object of same width and height as of original image
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);

        // create graphics object and add original image to it
        Graphics graphics = bufferedImage.getGraphics();
        graphics.drawImage(icon.getImage(), 0, 0, null);

        // set font for the watermark text
        graphics.setFont(new Font("Arial", Font.BOLD, 30));

        // unicode characters for (c) is \u00a9
        String watermark = "\u00a9 JavaXp.com";

        // add the watermark text
        graphics.drawString(watermark, 0, icon.getIconHeight() / 2);
        graphics.drawImage(bi, 100, 100, bi.getWidth(), bi.getHeight(), null);
        graphics.drawImage(bi, 600, 600, bi.getWidth(), bi.getHeight(), null);
        graphics.dispose();

        try {
            ImageIO.write(bufferedImage, "jpg", newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newFile.getPath() + " created successfully!");
    }

    public BufferedImage makeTransparent(Image originalImage, int ancho) {
        double h = originalImage.getHeight(null);
        double w = originalImage.getWidth(null);
        double radio = h / w;
        int largo = (int) (ancho * radio);
        BufferedImage resizedImage = new BufferedImage(ancho, largo, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g.drawImage(originalImage, 0, 0, ancho, largo, null);
        g.dispose();
        return resizedImage;
    }

}
