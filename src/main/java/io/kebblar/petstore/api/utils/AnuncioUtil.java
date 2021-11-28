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
 * Nombre:      AnuncioUtil
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:    .
 *              20210520_2203 Creación de esta utileroa
 *              20210520_2203 Se  agregan  metodos de  marca  de
 *              agua y renderizado de imagen
 */
package io.kebblar.petstore.api.utils;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Descripción:</p>
 * Utilería de apoyo para los servicios asociados a la entidad'anuncio'.
 *
 * @author Maria Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioUtil {

    private static final Logger logger = LoggerFactory.getLogger(AnuncioUtil.class);
    private static final SecureRandom random = new SecureRandom();

    /**
     * Constructor sin parámetros.
     */
    public AnuncioUtil(){

    }

    /**
     * <p>Método que permite genera un folio para la entidad de 'anuncio'.</p>
     * <p>El folio se conformara por
     * yyMMddHHmm0000, siendo los ultimos 4 ceros un random rellenado con espacios a la izquierda
     * teniendo un total de 14 posiciones. </p>
     *
     * @return String de 14 posiciones.
     */
    public static String generaFolio() {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyMMddHHmm");
        String folio=dateFormat.format(new Date());
        int num = random.nextInt(10000);
        String clave = String.format("%04d", num);
        return folio+clave;
    }

    /**
     * Método que permite validar las fechas de periodo enviadas.
     * <p>1. Valida que el periodo inicial sea posterior o igual a la fecha actual</p>
     * <p>2. Valida que la fecha de inicio no sea posterior a la fecha final</p>
     *
     * @param fechaInicioVigencia a {@link java.util.Date} object.
     * @param fechaFinVigencia a {@link java.util.Date} object.
     * @return a boolean.
     */
    public static boolean validaFechasPeriodo(Date fechaInicioVigencia, Date fechaFinVigencia){
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        String sFechaBase=dateFormat.format(new Date());
        String sFechaIniVigencia=fechaInicioVigencia!=null ? dateFormat.format(fechaInicioVigencia):null;
        String sFechaFinVigencia=fechaFinVigencia!=null?dateFormat.format(fechaFinVigencia):null;

        try {
            Date fechaBase = dateFormat.parse(sFechaBase);
            fechaInicioVigencia = sFechaIniVigencia != null ? dateFormat.parse(sFechaIniVigencia) : null;
            fechaFinVigencia = sFechaFinVigencia != null ? dateFormat.parse(sFechaFinVigencia) : null;
        //Se valida que la fecha de inicio no sea anterior a la fecha actual
            if(fechaInicioVigencia!=null && fechaBase.after(fechaInicioVigencia)) return false;
            //Se valida que la fecha de fin sno sea anterior a la fecha actual
            if(fechaFinVigencia!=null && fechaBase.after(fechaFinVigencia)) return false;
            //Se valida que la fecha de fin no sea mayor fecha inicio
            return fechaInicioVigencia == null || fechaFinVigencia == null || !fechaInicioVigencia.after(fechaFinVigencia);
        }catch (ParseException p) {
            logger.error("Ha ocurrido un problema de parseo");
        }
    return false;
    }

    /**
     * Metodo que permite comparar dos fechas entre si.
     *
     * @param fechaBase Fecha que se tomara como base para comparar
     * @param fechaAComparar Fecha con la que se compara la fecha base
     * @return Si la fecha Base es igual a la fecha a compara, regresa 0
     * Si la fecha base es anterior a la fecha a comparar, regresa un valor menor a 0
     * Si la fecha base es posterior a la fecha a comparar, regresa un valor mayor a 0
     */
    public static int comparafechas(Date fechaBase, Date fechaAComparar){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
            String sFechaBase=dateFormat.format(fechaBase);
            String sFechaAComparar=dateFormat.format(fechaAComparar);
            fechaBase = dateFormat.parse(sFechaBase);
            fechaAComparar = dateFormat.parse(sFechaAComparar);
            return fechaBase.compareTo(fechaAComparar);
        } catch (ParseException ex) {
            logger.error("Ha ocurrido un problema de parseo");
        }
        return 0;
    }

    /**
     * Metodo que permite renderizar una imagen y agregar marca de agua.
     *
     * @param nomEmpresa Nombre de la empresa o cadena que acompañara a la marca de agua
     * @param altoImagen Altura de las imagenes a la que se realizara el renderizado
     * @param destinationFolder a {@link java.lang.String} object.
     * @param uuidImagenBase a {@link java.lang.String} object.
     */
    public static void renderizarYMarcaDeAgua(String destinationFolder, String nomEmpresa, String uuidImagenBase, int altoImagen) {
            ImageIcon logoSistema=new ImageIcon(destinationFolder+File.separator+"logo.png");
            ImageIcon imagenBase=new ImageIcon(destinationFolder+File.separator+uuidImagenBase);
            //Se agrega marca de agua al logotipo del sistema
            BufferedImage bi = makeTransparent(logoSistema.getImage(), 50);
            //Se renderiza la imagen proporcionada
            BufferedImage imagenRender = renderizar(imagenBase.getImage(), altoImagen);
            BufferedImage bufferedImage = new BufferedImage(imagenRender.getWidth(), imagenRender.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(imagenRender, 0, 0, null);
            graphics.setFont(new Font("Arial", Font.BOLD, 15));
            //Se agrega la leyenda de la empresa unicode caracter (c) is \u00a9
            String watermark = "\u00a9 "+nomEmpresa;
            //Se calcula la poscion de la marca de agua con base al tamaño de la iamgen
            int posicionLeyendaX=imagenRender.getWidth()-((int)(imagenRender.getWidth()*0.30));
            int posicionLeyendaY=imagenRender.getHeight()-((int)(imagenRender.getHeight()*0.1));
            int posicionIconoX=imagenRender.getWidth()-((int)(imagenRender.getWidth()*0.25));
            int posicionIconoY=imagenRender.getHeight()-((int)(imagenRender.getHeight()*0.25));
            graphics.drawString(watermark, posicionLeyendaX,posicionLeyendaY);
            graphics.drawImage(bi, posicionIconoX,posicionIconoY, bi.getWidth(), bi.getHeight(), null);
            graphics.drawImage(bi, 600, 600, bi.getWidth(), bi.getHeight(), null);
            graphics.dispose();
            //Se reescribe la imagen renderizada y con marca de agua
            try {
                Path filepath = Paths.get(destinationFolder, uuidImagenBase);
                ImageIO.write(bufferedImage, FilenameUtils.getExtension(uuidImagenBase), filepath.toFile());
                bufferedImage.flush();
            } catch (Exception e) {
                logger.error(e.toString());
            }
    }

    /**
     * Metodo que permite que una imagen tenga marca de agua.
     *
     * @param originalImage Imagen que sera la marca de agua
     * @param ancho  Medida a lo ancho a la que se renderizara la imagen
     * @return BufferedImage Imagen como marca de agua
     */
    public static BufferedImage makeTransparent(Image originalImage, int ancho) {
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

    /**
     * Metodo que permite regresar una imagen renderizada con base a la altura proporcionada.
     *
     * @param originalImage Imagen a renderizar
     * @param alto Altura que se tomara como referencia para el renderizado
     * @return BufferedImage Imagen renderizada
     */
    public static BufferedImage renderizar(Image originalImage, int alto) {
        double h = originalImage.getHeight(null);
        double w = originalImage.getWidth(null);
        double radio = h / w;
        int ancho = (int) (alto / radio);
        BufferedImage resizedImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, ancho, alto, null);
        g.dispose();
        return resizedImage;
    }

}
