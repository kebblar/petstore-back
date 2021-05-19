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
 * Fecha:       15 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *
 */
package io.kebblar.petstore.api.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.ProcessPDFException;

/**
 * <p>
 * Implementación Metodos para crear una factura en PDF 
 * 
 * <p>
 * Todos los métodos de esta clase disparan {@link ProcessPDFException}
 * 
 * @author dalvarez
 * @see io.kebblar.petstore.api.service.OrdenCompraServiceImpl
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CreatePDF {
	
	private final static String newLine = System.getProperty("line.separator");

	private static final Logger logger = LoggerFactory.getLogger(CreatePDF.class);
	
	public static void createPDFOrdenCompra(UsuarioDetalle usuarioDetalle,Usuario usuario, DatosOrden ordenCompra) throws ProcessPDFException {
		try {
			String dest = "upload/";
			String IMAGE = "src/main/resources/Factura.png";
			String namePDF= getNamePDF(usuarioDetalle.getId());
			PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest+namePDF));
			PageSize pageSize = PageSize.A4.rotate();
			Document doc = new Document(pdfDoc, pageSize);

			PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
			canvas.addImageFittedIntoRectangle(ImageDataFactory.create(IMAGE), pageSize, true);

			doc.add(new Paragraph(newLine));
			
			Table tablePetstore = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
			tablePetstore.addCell(createTextCellBold("Dirección:"));
			tablePetstore.addCell(createTextCell(1, 3, "Av Revolución Col Mixcoac CDMX"));
			tablePetstore.addCell(createTextCell(1, 4, newLine));
			tablePetstore.addCell(createTextCellBold("Teléfono:"));
			tablePetstore.addCell(createTextCell(1, 3, "5555555555"));
			tablePetstore.addCell(createTextCell(1, 4, newLine));

			
			doc.add(tablePetstore);


			Table table3 = new Table(UnitValue.createPercentArray(6)).useAllAvailableWidth();
			table3.addCell(createTextCell(1,4,newLine));
			table3.addCell(createTextCell("001"));
			table3.addCell(createTextCell(getFecha()));
			table3.addCell(createTextCell(1,6,newLine).setMinHeight(30));
			doc.add(table3);

			Table table4 = new Table(UnitValue.createPercentArray(6)).useAllAvailableWidth();

			table4.addCell(createTextCell(1, 3, getNombreCompleto(usuarioDetalle)));
			table4.addCell(createTextCell(newLine));
			table4.addCell(createTextCell(1, 2, String.valueOf(usuarioDetalle.getId())));
			table4.addCell(createTextCell(1, 6, "Dirección:"));
			table4.addCell(createTextCell(1, 6, usuarioDetalle.getTelefonoCelular()));
			table4.addCell(createTextCell(1, 6, usuario.getCorreo()));
			table4.addCell(createTextCell(1,6,newLine).setMinHeight(30));
			doc.add(table4);

			//doc.add(new Paragraph(newLine));

			Table tableDetalle = new Table(UnitValue.createPercentArray(9)).useAllAvailableWidth();
			tableDetalle.addCell(createTextCell(newLine));
			tableDetalle.addCell(createTextCell(1, 4, ordenCompra.getDescripcion()));
			tableDetalle.addCell(createTextCell(1, 1, "1", TextAlignment.CENTER));
			tableDetalle.addCell(createTextCell(1, 1, String.valueOf(ordenCompra.getPrecio()), TextAlignment.CENTER));
			tableDetalle.addCell(createTextCell(newLine));
			tableDetalle.addCell(createTextCell(String.valueOf(ordenCompra.getPrecio())));
			doc.add(tableDetalle);

			Table tableEspacio = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();
			tableEspacio.addCell(createTextCell(150, newLine));
			doc.add(tableEspacio);

			Table tableTotal = new Table(UnitValue.createPercentArray(9)).useAllAvailableWidth();
			tableTotal.addCell(createTextCell(1, 8, newLine));
			tableTotal.addCell(createTextCell(String.valueOf(ordenCompra.getPrecio())));
			tableTotal.addCell(createTextCell(1, 8, newLine));
			tableTotal.addCell(createTextCell(""));
			tableTotal.addCell(createTextCell(1, 8, newLine));
			tableTotal.addCell(createTextCell(""));
			tableTotal.addCell(createTextCell(1, 8, newLine));
			tableTotal.addCell(createTextCell(String.valueOf(ordenCompra.getPrecio())));

			doc.add(tableTotal);
			doc.close();

		} catch (Exception e) {
			System.out.println("Error: " + e);
			throw new ProcessPDFException("Error al generar Factura PDF", e.getMessage());
		}
	}

	private static Cell createTextCell(int col1, int col2, String text, TextAlignment alight) {
		Cell cell = new Cell(col1, col2);
		cell.setBorder(Border.NO_BORDER);
		Paragraph p = new Paragraph(text);
		p.setTextAlignment(alight);
		cell.add(p);
		return cell;
	}

	private static Cell createTextCell(int col1, int col2, String text) {
		Cell cell = new Cell(col1, col2);
		cell.setBorder(Border.NO_BORDER);
		cell.add(new Paragraph(text));
		return cell;
	}

	private static Cell createTextCell(String text) {
		Cell cell = new Cell();
		cell.setBorder(Border.NO_BORDER);
		cell.add(new Paragraph(text));
		return cell;
	}

	private static Cell createTextCell(int height, String text) {
		Cell cell = new Cell();
		cell.setBorder(Border.NO_BORDER);
		cell.setMinHeight(height);
		cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		cell.add(new Paragraph(text));
		return cell;
	}

	private static Cell createTextCellBold(String text) {
		Cell cell = new Cell();
		cell.setBorder(Border.NO_BORDER);
		Paragraph p = new Paragraph(text);
		p.setBold();
		cell.add(p);
		return cell;
	}
	
	
	private static String getNamePDF(int id) {
		String nombre= String.valueOf(id)+UUID.randomUUID().toString()+".pdf";
		//String uid = UUID.randomUUID().toString();
	     logger.error("Nombre generado: " + nombre);
	    return nombre;
	}
	
	private static String getFecha(){
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now)); 
		return dtf.format(now);
	}
	
	
	private static String getNombreCompleto(UsuarioDetalle usuarioDetalle) {
		return usuarioDetalle.getNombre()+ " "+usuarioDetalle.getApellidoPaterno()+ " " +usuarioDetalle.getApellidoMaterno();
	}

}
