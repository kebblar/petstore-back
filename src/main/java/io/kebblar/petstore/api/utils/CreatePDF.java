/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   CreatePDF.java
 * Tipo:        clase
 * AUTOR:       Daniel Alvarez Morales
 * Fecha:       20 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *
 */
package io.kebblar.petstore.api.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.ProcessPDFException;
import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import io.kebblar.petstore.api.model.response.DireccionConNombre;

/**
 * Implementación Metodos para crear una factura en PDF
 *
 * Todos los métodos de esta clase disparan {@link ProcessPDFException}
 *
 * @author dalvarez
 * @see io.kebblar.petstore.api.service.OrdenCompraServiceImpl
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CreatePDF {
	
    private final static String newLine = System.getProperty("line.separator");
    private static final Color headerBg = new DeviceRgb(54,120,182);
    
    /**
     * Método para crear una facttura con los articulos de compra. Factura en formato PDF
     * @param usuarioDetalle
     * @param usuario
     * @param ordenCompra
     * @param ubicación del documento
     * @param url
     * @param nombrePdf
     * @param listCarrito
     * @param direcciones
     * @param cveSMS 
     * @return nombre del documento 
     * @throws ProcessPDFException
     */
    public static String createPDFOrdenCompra(UsuarioDetalle usuarioDetalle, Usuario usuario,
        DatosOrden ordenCompra, String dest, String url,  String nombrePdf,
        List<CarritoDatosFactura> listCarrito, List<DireccionConNombre> direcciones) throws ProcessPDFException {
        
    	String pdf="";

        try {
            pdf= nombrePdf + ".pdf";
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest+pdf));
            PageSize pageSize = PageSize.A4.rotate();
            Document doc = new Document(pdfDoc, pageSize);

            doc.add(getHeader());
            doc.add(getTitle(ordenCompra));
            doc.add(getDatosFactura(usuarioDetalle, usuario, doc, direcciones));
            doc.add(getTitulosDetalle());
            doc.add(getDetalleFactura(ordenCompra,listCarrito));
            doc.add(getTotal(ordenCompra));
            doc.add(getBarcode(url, pdf, nombrePdf, pdfDoc));

            doc.close();
            pdfDoc.close();
            return pdf;
        } catch (Exception e) {
            throw new ProcessPDFException("Error al generar Factura PDF", e.getMessage());
        }
    }

    /**
     * Metodo para crear tabla con la cabezera de la factura
     * @return Tabla itext a ser añadida al docuento PDF
     * @throws ProcessPDFException
     */
    private static Table getHeader() throws ProcessPDFException {
        Table tableHeader = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
        tableHeader.addCell(createTextCellTitles("PETSTORE", 26F, ColorConstants.BLACK, TextAlignment.LEFT, StandardFonts.COURIER_BOLD));
        tableHeader.addCell(createTextCellTitles("FACTURA", 20F, headerBg, TextAlignment.RIGHT, StandardFonts.HELVETICA_BOLD));
        return tableHeader;
    }

    /**
     * Método para crear celdas de una tabla para la factura
     * @param texto
     * @param tamaño
     * @param color
     * @param alineación
     * @param tipo de letra
     * @return Celda itext a ser añadida al docuento PDF
     * @throws ProcessPDFException
     */
    private static Cell createTextCellTitles(String text, float size, Color color, TextAlignment alignment, String fontType) throws ProcessPDFException {
        Cell cell = new Cell();
        try {
            PdfFont font = PdfFontFactory.createFont(fontType);
            Paragraph p = new Paragraph(text);
            p.setBold();
            p.setFontSize(size);
            p.setFontColor(color);
            cell.setFont(font);
            cell.setTextAlignment(alignment);
            cell.setBorder(Border.NO_BORDER);
            cell.add(p);
            return cell;
        } catch (IOException e) {
            throw new ProcessPDFException("Error ProcessPDFException: ",e.getMessage());
        }
    }

    /**
     * Método para crear tabla con titulos de la factura
     * @param ordenCompra
     * @return Tabla itext a ser añadida al docuento PDF
     */
    private static Table getTitle(DatosOrden ordenCompra) {
        Table tablePetstore = new Table(UnitValue.createPercentArray(6)).useAllAvailableWidth();
        tablePetstore.addCell(createTextCellBold("Dirección:", true));
        tablePetstore.addCell(createTextCell(1, 3, "Av Revolución Col Mixcoac CDMX", TextAlignment.LEFT, true));
        tablePetstore.addCell(createTextCell(1, 2, newLine, TextAlignment.CENTER, true));
        tablePetstore.addCell(createTextCellBold("Teléfono:", true));
        tablePetstore.addCell(createTextCell(1, 1, "5555555555",TextAlignment.LEFT, true));
        tablePetstore.addCell(createTextCell(1, 2, newLine, TextAlignment.CENTER, true));
        tablePetstore.addCell(createTextCellBold("No DE FACTURA:", ColorConstants.WHITE, headerBg,TextAlignment.CENTER));
        tablePetstore.addCell(createTextCellBold("FECHA:", ColorConstants.WHITE, headerBg,TextAlignment.CENTER));
        tablePetstore.addCell(createTextCell(1,4,newLine, TextAlignment.CENTER, true));
        tablePetstore.addCell(createTextCell(ordenCompra.getCveOrdenCompra(), TextAlignment.CENTER, false));
        tablePetstore.addCell(createTextCell(getFecha(), TextAlignment.CENTER, false));
        tablePetstore.addCell(createTextCell(1,6,newLine,TextAlignment.CENTER, true).setMinHeight(25));
        return tablePetstore;
    }

    /**
     * Metodo para crear tabla con los titulos del detalle de  la factura
     * @return Tabla itext a ser añadida al docuento PDF
     */
    private static Table getTitulosDetalle() {
        Table tableDetalle = new Table(UnitValue.createPercentArray(9)).useAllAvailableWidth();
        tableDetalle.addCell(createTextCellBold("DESCRIPCIÓN",ColorConstants.WHITE, headerBg,TextAlignment.LEFT,1,4));
        tableDetalle.addCell(createTextCellBold("CANT.",ColorConstants.WHITE, headerBg,TextAlignment.LEFT,1,1));
        tableDetalle.addCell(createTextCellBold("PRECIO UNITARIO",ColorConstants.WHITE, headerBg,TextAlignment.LEFT,1,2));
        tableDetalle.addCell(createTextCellBold("IMPORTE",ColorConstants.WHITE, headerBg,TextAlignment.LEFT,1,2));
        return tableDetalle;
    }
    
	/**
	 * Método para crear talba con los datos de la factura 
	 * @param usuarioDetalle
	 * @param usuario
	 * @param documento
	 * @param direcciones
	 * @return Tabla itext a ser añadida al docuento PDF
	 */
    private static Table getDatosFactura(UsuarioDetalle usuarioDetalle, Usuario usuario, Document doc,
            List<DireccionConNombre>direcciones) {
        Table table4 = new Table(UnitValue.createPercentArray(6)).useAllAvailableWidth();
        table4.addCell(createTextCellBold("FACTURAR A:", ColorConstants.WHITE, headerBg,TextAlignment.LEFT,1,3));
        table4.addCell(createTextCell(newLine,TextAlignment.CENTER, true));
        table4.addCell(createTextCellBold("ID CLIENTE:", ColorConstants.WHITE, headerBg,TextAlignment.CENTER));
        table4.addCell(createTextCellBold("TÉRMINOS:", ColorConstants.WHITE, headerBg,TextAlignment.CENTER));
        table4.addCell(createTextCell(1, 3, getNombreCompleto(usuarioDetalle),TextAlignment.LEFT,true));
        table4.addCell(createTextCell(newLine,TextAlignment.CENTER, true));
        table4.addCell(createTextCell(String.valueOf(usuarioDetalle.getId()),TextAlignment.CENTER, false));
        table4.addCell(createTextCell("El producto puede incurrir en tiempos largos de entrega",TextAlignment.CENTER, false));
        table4.addCell(createTextCell(1, 6, "Dirección: "+getDireccion(direcciones),TextAlignment.LEFT, true));
        table4.addCell(createTextCell(1, 6, "Teléfono: "+usuarioDetalle.getTelefonoCelular(),TextAlignment.LEFT, true));
        table4.addCell(createTextCell(1, 6, "Correo eléctronico: "+usuario.getCorreo(),TextAlignment.LEFT, true));
        table4.addCell(createTextCell(1,6,newLine,TextAlignment.LEFT, true).setMinHeight(25));
        return table4;
    }

    /**
     * Método para generar tabla con el codigo de baras de la factura
     * @param url
     * @param pdf
     * @param nombrePdf
     * @param documento
     * @return Tabla itext a ser añadida al docuento PDF
     * @throws ProcessPDFException
     */
    private static Table getBarcode(String url, String pdf, String nombrePdf, PdfDocument pdfDoc) throws ProcessPDFException {
        Table tablebc = new Table(UnitValue.createPercentArray(9)).useAllAvailableWidth();
        tablebc.addCell(generateBarcodeQR(pdfDoc,url+pdf,tablebc,1,1));
        tablebc.addCell(generateBarcode(pdfDoc,nombrePdf,tablebc,1,4));
        tablebc.addCell(createTextCell(1, 4, newLine, TextAlignment.CENTER, true));
        return tablebc;
    }

    /**
     * Método para generar tabla con el total de la compra
     * @param ordenCompra
     * @return Tabla itext a ser añadida al docuento PDF
     */
    private static Table getTotal(DatosOrden ordenCompra) {
        Table tableTotal = new Table(UnitValue.createPercentArray(9)).useAllAvailableWidth();
        tableTotal.addCell(createTextCell(1, 3, newLine, TextAlignment.CENTER,true));
        tableTotal.addCell(createTextCell(1, 4, Convert.convertir((int)ordenCompra.getTotal()), TextAlignment.CENTER,true));
        tableTotal.addCell(createTextCellBold("SUBTOTAL:",ColorConstants.WHITE, headerBg,TextAlignment.LEFT,1,1));
        tableTotal.addCell(createTextCellBold(String.valueOf(ordenCompra.getTotal()),ColorConstants.WHITE, headerBg,TextAlignment.RIGHT,1,1));
        tableTotal.addCell(createTextCell(1, 7, newLine, TextAlignment.CENTER,true));
        tableTotal.addCell(createTextCellBold("TOTAL:",ColorConstants.WHITE, headerBg,TextAlignment.LEFT,1,1));
        tableTotal.addCell(createTextCellBold(String.valueOf(ordenCompra.getTotal()),ColorConstants.WHITE, headerBg,TextAlignment.RIGHT,1,1));
        return tableTotal;
    }

    /**
     * Método para generar tabla con el detalle de productos de la compra
     * @param ordenCompra
     * @param listCarrito
     * @return Tabla itext a ser añadida al docuento PDF
     */
    private static Table getDetalleFactura(DatosOrden ordenCompra, List<CarritoDatosFactura> listCarrito) {
        Table tableDetalle = new Table(UnitValue.createPercentArray(9)).useAllAvailableWidth();
        for (CarritoDatosFactura carrito : listCarrito) {
            tableDetalle.addCell(createTextCell(1, 4, carrito.getTitulo(),TextAlignment.LEFT, false));
            tableDetalle.addCell(createTextCell(1, 1, "1", TextAlignment.CENTER, false));
            tableDetalle.addCell(createTextCell(1, 2, String.valueOf(carrito.getPrecio()), TextAlignment.CENTER, false));
            tableDetalle.addCell(createTextCell(1, 2, String.valueOf(carrito.getPrecio()),TextAlignment.CENTER, false).setMinHeight(25));
        }
        return tableDetalle;
    }

    /**
     * Método para generar celdas con columnas, alineación y borde personalizados.
     * @param columna 1
     * @param columna 2
     * @param texto
     * @param alineación
     * @param borde en la tabla
     * @return Celda itext a ser añadido a la tabla PDF
     */
    private static Cell createTextCell(int col1, int col2, String text, TextAlignment alight, boolean border) {
        Cell cell = new Cell(col1, col2);
        if(border) {
            cell.setBorder(Border.NO_BORDER);
        }
        Paragraph p = new Paragraph(text);
        p.setTextAlignment(alight);
        cell.add(p);
        return cell;
    }

    /**
     * Método para generar celdas con alineación y borde personalizados.
     * @param texto
     * @param alineación
     * @param borde
     * @return Celda itext a ser añadido a la tabla PDF
     */
    private static Cell createTextCell(String text , TextAlignment alignment, boolean border) {
        Cell cell = new Cell();
        if(border) {
            cell.setBorder(Border.NO_BORDER);
        }
        cell.setTextAlignment(alignment);
        cell.add(new Paragraph(text));
        return cell;
    }

    /**
     * Método para generar celdas con borde personalizado.
     * @param texto
     * @param borde
     * @return Celda itext a ser añadido a la tabla PDF
     */
    private static Cell createTextCellBold(String text, boolean border) {
        Cell cell = new Cell();
        if(border) {
            cell.setBorder(Border.NO_BORDER);
        }
        Paragraph p = new Paragraph(text);
        p.setBold();
        cell.add(p);
        return cell;
    }

    /**
     * Método para generar celdas con color y alineación personalizado.
     * @param texto
     * @param color en texto
     * @param colorBackground
     * @param alineación
     * @return Celda itext a ser añadido a la tabla PDF
     */
    private static Cell createTextCellBold(String text,Color color, Color colorBackground, TextAlignment alignment) {
        Cell cell = new Cell();
        Paragraph p = new Paragraph(text);
        p.setBold();
        p.setFontColor(color);
        cell.setBackgroundColor(colorBackground);
        cell.setTextAlignment(alignment);
        cell.add(p);
        return cell;
    }

    /**
     * Método para generar celdas con color, alineación y columnas personalizadas.
     * @param texto
     * @param color
     * @param colorBackground
     * @param alineación
     * @param columna 1
     * @param columna 2
     * @return Celda itext a ser añadido a la tabla PDF
     */
    private static Cell createTextCellBold(String text,Color color, Color colorBackground, TextAlignment alignment,int col1, int col2) {
        Cell cell = new Cell(col1, col2);
        Paragraph p = new Paragraph(text);
        p.setBold();
        p.setFontColor(color);
        cell.setBackgroundColor(colorBackground);
        cell.setTextAlignment(alignment);
        cell.add(p);
        return cell;
    }

    /**
     * Método para obtener nombre de pdf dinamico
     * @param id de usuario
     * @return nombre del pdf
     */
    public static String getNamePDF(int id) {
        return String.valueOf(id)+UUID.randomUUID().toString();
    }

    /**
     * Método para obtener la fecha actual del sistema
     * @return fecha
     */
    private static String getFecha(){
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /**
     * Método para generar codigo de barras
     * @param pdfDoc
     * @param código
     * @param Tabla pdf
     * @param col1
     * @param col2
     * @return Celda itext a ser añadido a la tabla PDF
     * @throws ProcessPDFException
     */
    private static Cell generateBarcode(PdfDocument pdfDoc, String code, Table tablebc, int col1, int col2)
            throws ProcessPDFException {
        Cell cell = new Cell(col1, col2);
        Barcode128 code128 = new Barcode128(pdfDoc);
        code128.setCode(code);
        code128.setCodeType(Barcode128.CODE128);
        PdfFormXObject xObject = code128.createFormXObject(ColorConstants.BLACK, ColorConstants.BLACK, pdfDoc);
        xObject.makeIndirect(pdfDoc);
        Image rect = new Image(xObject);
        cell.setBorder(Border.NO_BORDER);
        cell.setMargins(20f, 20f, 0f, 20f);
        cell.add(rect);
        return cell;
    }

    /**
     * Método para generar código de barras QR
     * @param pdfDoc
     * @param código
     * @param Tabla pdf
     * @param col1
     * @param col2
     * @return Celda itext a ser añadido a la tabla PDF
     * @throws ProcessPDFException
     */
    private static Cell generateBarcodeQR(PdfDocument pdfDoc, String code, Table tablebc, int col1, int col2)
            throws ProcessPDFException {
        Cell cell = new Cell(col1, col2);
        BarcodeQRCode qrCode = new BarcodeQRCode(code);
        PdfFormXObject barcodeObject = qrCode.createFormXObject(ColorConstants.BLACK, pdfDoc);
        barcodeObject.makeIndirect(pdfDoc);
        Image imgQR = new Image(barcodeObject);
        imgQR.scaleToFit(75, 75);
        cell.setBorder(Border.NO_BORDER);
        cell.add(imgQR);
        return cell;
    }

    /**
     * Método para obtener el nombre completo de un usuario
     * @param usuarioDetalle
     * @return Nombre de usuario
     */
    private static String getNombreCompleto(UsuarioDetalle usuarioDetalle) {
    	return usuarioDetalle.getNombre() + " " + usuarioDetalle.getApellidoPaterno() + " " + usuarioDetalle.getApellidoMaterno();
    }

    /**
     * Método para obtener la dirección de envío de un usuario
     * @param direcciones
     * @return dirección del usuario
     */
    private static String getDireccion(List<DireccionConNombre> direcciones) {
        String dir = "";
        if(direcciones.size() >0 ) {
            DireccionConNombre dirNombre= direcciones.get(0);
            dir= dirNombre.getCalleNumero()+" "+dirNombre.getColonia()+ " "
            +dirNombre.getMunicipioNombre() + " "+dirNombre.getEstadoNombre() + " "
            +dirNombre.getCp();
        }
        return dir;
    }
    
    /**
     * Método para proteger archivo PDF
     * @param path de la ubicación del documento pdf
     * @param userPassword
     * @throws IOException
     */
    public static void protectDocument(String path, String userPassword) throws IOException {
    	
        File file = new File(path);
        PDDocument document = PDDocument.load(file);
        AccessPermission ap = new AccessPermission();
        StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", userPassword, ap);
        spp.setEncryptionKeyLength(128);
        spp.setPermissions(ap);
        document.protect(spp);
        document.save(path);
        document.close();
    }
    
    
}