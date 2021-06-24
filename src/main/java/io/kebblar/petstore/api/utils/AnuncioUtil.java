/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioUtil.java
 * Tipo:        Clase
 * AUTOR:       Maria Isabel Contreras Garcia
 * Fecha:       Jueves 20 de Mayo de 2021 (22_03)
 *
 * Historia:    .
 *              20210520_2203 Creación de esta utileroa
 *              20210520_2203 Se  agregan  metodos de  marca  de 
 *              agua y renderizado de imagen
 *
 */
package io.kebblar.petstore.api.utils;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.io.FilenameUtils;

import com.ibm.icu.text.SimpleDateFormat;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.BusquedaAdministracionRequest;
import io.kebblar.petstore.api.model.request.BusquedaRequest;

/**
 * <p>Descripción:</p>
 * Utilería de apoyo para los servicios asociados a la entidad'anuncio'. 
 *
 * @author Maria Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioUtil {
	
    private static final String TEMPLATE = "SELECT id_anuncio FROM mascota_valor_atributo WHERE id_valor_atributo = %d ";

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
        return folio+String.format("%04d", new Random().nextInt(10000));
    }

    /**
     * Método que permite validar las fechas de periodo enviadas.
     * <p>1. Valida que el periodo inicial sea posterior o igual a la fecha actual</p>
     * <p>2. Valida que la fecha de inicio no sea posterior a la fecha final</p>
     *
     * @param fechaInicioVigencia
     * @param fechaFinVigencia
     * @return
     */
    public static boolean validaFechasPeriodo(LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia){
        LocalDate fechaActual = LocalDate.now(ZoneId.of("America/Mexico_City"));
    	
        String sFechaIniVigencia= fechaInicioVigencia!=null ? fechaInicioVigencia.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")):null;
        String sFechaFinVigencia= fechaFinVigencia!=null ? fechaFinVigencia.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")):null;
        fechaInicioVigencia = (sFechaIniVigencia ==null)? null: LocalDate.parse(sFechaIniVigencia,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        fechaFinVigencia = (sFechaFinVigencia ==null)? null: LocalDate.parse(sFechaFinVigencia,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean fechasValidas = true;
        //Se valida que la fecha de inicio no sea anterior a la fecha actual
        if(fechaInicioVigencia!=null && fechaActual.isAfter(fechaInicioVigencia)){
            fechasValidas = false;
        } 
        //Se valida que la fecha de fin sno sea anterior a la fecha actual
        if(fechaFinVigencia!=null && fechaActual.isAfter(fechaFinVigencia)){
            fechasValidas = false;
        } 
        //Se valida que la fecha de fin no sea mayor fecha inicio
        if(fechaInicioVigencia!=null && fechaFinVigencia!=null 
                && fechaInicioVigencia.isAfter(fechaFinVigencia)){
            fechasValidas = false;
        } 
        return fechasValidas;  
    }
        
    /**
     * Método que concatena las condiciones de consulta a la cadena SQL.
     *
     * @param filtros
     * @return String que contiene toda la cadena para la sentencia SQL
     */
    public static List<String> busquedaFiltros(BusquedaAdministracionRequest filtros) {
        StringBuilder consultaBase = new StringBuilder("SELECT * FROM anuncio WHERE id IS NOT NULL");
        List<String> response = new ArrayList<>();
        int getPageSize = filtros.getTamPaginas();
        int getPageNumber = filtros.getNumPaginas();
        
        String startRow = Integer.toString((getPageNumber-1)*getPageSize) ;
        String pageSize = Integer.toString(getPageSize);
        if (filtros.getIdCategoria() != 0) {
            consultaBase.append(" AND id_categoria = ").append(filtros.getIdCategoria());
        }
        if (filtros.getFolio() != null && !filtros.getFolio().isEmpty()) {
            consultaBase.append(" AND folio LIKE '").append(filtros.getFolio()).append("%' ");
        }
        if (filtros.getEstatus() != 0) {
            consultaBase.append(" AND id_estatus = ").append(filtros.getEstatus());
        }
        if (filtros.getTitulo() != null && filtros.getTitulo() != "") {
            consultaBase.append(" AND UPPER( titulo) LIKE ").append(" '%").append(filtros.getTitulo().toUpperCase()).append("%'");
        }
        if (filtros.getFechaFinVigencia() != null && !filtros.getFechaFinVigencia().toString().isEmpty() ) {
            consultaBase.append(" AND fecha_fin_vigencia <= ").append("'").append(filtros.getFechaFinVigencia()).append("'");
        }
        if (filtros.getFechaInicioVigencia() != null && !filtros.getFechaInicioVigencia().toString().isEmpty()) {
            consultaBase.append(" AND fecha_inicio_vigencia >= ").append("'").append(filtros.getFechaInicioVigencia()).append("'");
        }
        response.add(consultaBase.toString());
        consultaBase.append(" ORDER BY fecha_alta DESC ");
        consultaBase.append(" LIMIT ").append(startRow).append(",").append(pageSize);
        response.add(consultaBase.toString());
        return response;
        
    }
    
    /**
     * Filtra la búsqueda de usuario final.
     *
     * @param filtros
     * @return Lista de strings
     */
    public static List<String> busqueda(BusquedaRequest filtros) {
        StringBuilder consultaBase = new StringBuilder("SELECT * FROM anuncio WHERE id_estatus = ").append(AnuncioEstatusEnum.PUBLICADO.getId());
        List<String> response = new ArrayList<>();
        int getPageSize = filtros.getTamPaginas();
        int getPageNumber = filtros.getNumPaginas();
        
        String startRow = getPageNumber >= 1 ? Integer.toString((getPageNumber-1)*getPageSize) : Integer.toString(getPageNumber);
        String pageSize = Integer.toString(getPageSize);
        if (filtros.getIdCategoria() != null && filtros.getIdCategoria() != 0 ) {
            consultaBase.append(" AND id_categoria = ").append(filtros.getIdCategoria());
        }
        if (filtros.getPrecio() != null && filtros.getPrecio() != BigDecimal.ZERO) {
            consultaBase.append(" AND precio <= ").append(filtros.getPrecio());
        }
        if(filtros.getAtributos() != null && !filtros.getAtributos().isEmpty()) {
            consultaBase.append(" AND id IN (");
            int i=1;
            StringBuilder sb = new StringBuilder();
            int size = filtros.getAtributos().size();
            
            for (Integer atributo : filtros.getAtributos()) {
                if (atributo != 0 ) {
                    sb.append("(");
                    sb.append(String.format(TEMPLATE, atributo));
                    sb.append(")");
                    sb.append((i++<size)?" INTERSECT ":"");
                }
            }
            consultaBase.append(sb).append(")");   
        }
        response.add(consultaBase.toString());
        consultaBase.append(" ORDER BY fecha_alta DESC ");
        consultaBase.append(" LIMIT ").append(startRow).append(",").append(pageSize);
        response.add(consultaBase.toString());
        return response;
    }
    
    /**
     * Método privado que permite realizar validaciones de negocio para confirmar el guardado.
     *
     * @param request Clase que contiene los campos a validar
     * @throws BusinessException - xcepcion lanzada con el mensaje de error correspondiente
     */
    public static void validaCampos(AnuncioRequest request) throws BusinessException {
        //Validacion de campos obligatorios
        if(request.getMascotaValorAtributo()==null || request.getMascotaValorAtributo().isEmpty()) {
            throw new BusinessException("Error de datos","El registro de un anuncio debe tener al menos un atributo asociado",4091,"CVE_4091",HttpStatus.CONFLICT);
        }
        if(request.getIdCategoria()==0) {
            throw new BusinessException("Error de datos","Categoria no valida",4091,"CVE_4091",HttpStatus.CONFLICT);
        }
        //Validacion de fechas de vigencia
        if(!AnuncioUtil.validaFechasPeriodo(request.getFechaInicioVigencia(), request.getFechaFinVigencia())) {
            throw new BusinessException("Error de datos","Fechas de vigencia no validas",4091,"CVE_4091",HttpStatus.CONFLICT);
        }   
    }
    
    /**
     * Metodo que permite renderizar una imagen y agregar marca de agua.
     *
     * @param nomEmpresa Nombre de la empresa o cadena que acompañara a la marca de agua
     * @param logoSistema Logotipo de la empresa que ira como marca de agua
     * @param imagenBase Imagen que se renderizara y se agregara marca de agua
     * @param altoImagen Altura de las imagenes a la que se realizara el renderizado
     * @return
     */
    public static void renderizarYMarcaDeAgua(String destinationFolder, String nomEmpresa, String uuidImagenBase, int altoImagen) {
            ImageIcon logoSistema=new ImageIcon(destinationFolder+File.separator+"logo.png");
            ImageIcon imagenBase=new ImageIcon(destinationFolder+File.separator+uuidImagenBase);
            //Se agrega marca de agua al logotipo del sistema
            ImageIcon watermarkLogo = logoSistema;
            BufferedImage bi = makeTransparent(watermarkLogo.getImage(), 50);
            //Se renderiza la imagen proporcionada
            BufferedImage imagenRender = renderizar(imagenBase.getImage(), altoImagen);
            BufferedImage bufferedImage = new BufferedImage(imagenRender.getWidth(), imagenRender.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(imagenRender, 0, 0, null);
            graphics.setFont(new Font("Arial", Font.BOLD, 15));
            //Se agrega la leyenda de la empresaunicode caracter (c) is \u00a9 
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
                e.printStackTrace();
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
