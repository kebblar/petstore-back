/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.support
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      JasperService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:29:08
 */
package io.kebblar.petstore.api.support;

import java.io.IOException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Interface JasperService.
 *
 * @author garellano
 * @version $Id: $Id
 */
public interface JasperService {

    /**
     * Genera un archivo de tipo PDF en la ruta absoluta especificada por
     * 'outputFileName' Y populado con los datos que provienen del atrchivo
     * 'dataFile' y la plantilla jrxml definida en 'inputFileName' y cuya ruta NO
     * deberá contener la extensión '.jrxml'.
     *
     * <p>Nota: Cada archivo '.jrxml' será compilado en un nuevo archivo '.jasper' (si
     * es que éste NO existe) y el PDF final será generado a partir de tal archivo
     * compilado.
     *
     * @param inputFileName  String Nombre del archivo .jrxml
     * @param dataFile       String Nombre del archivo de datos json
     * @param outputFileName String Nombre del archivo pdf resultante
     * @return String El md5 del pdf generado
     * @throws java.io.IOException Signals that an I/O exception has occurred.
     * @throws net.sf.jasperreports.engine.JRException the JR exception
     */
    String generatePdfFromCompiledJrxmlFilename(String inputFileName, String dataFile, String outputFileName)
            throws IOException, JRException;

    /**
     * Genera un archivo de tipo PDF en la ruta absoluta especificada por
     * 'outputFileName' y populado con los datos que provienen del atrchivo
     * 'dataFile' y el archivo compilado .jasper definido en 'inputFileName' y cuya
     * ruta NO deberá contener la extensión '.jasper'.
     *
     * @param inputFileName  String Nombre del archivo .jasper
     * @param dataFile       String Nombre del archivo de datos json
     * @param outputFileName String Nombre del archivo pdf resultante
     * @return String El md5 del pdf generado
     * @throws java.io.IOException Se dispara cuando 'inputFileName' no existe
     * @throws net.sf.jasperreports.engine.JRException the JR exception
     */
    String generatePdfFromCompiledJasperFilename(String inputFileName, String dataFile, String outputFileName)
            throws IOException, JRException;

    /**
     * Genera un archivo de tipo PDF en la ruta absoluta especificada por
     * 'outputFileName' y populado con los datos que provienen del atrchivo
     * 'dataFile' y el objeto Jaspereport dado en 'jasperReport'.
     *
     * @param jasperReport   JasperReport Objeto jasper
     * @param dataFile       String Nombre del archivo de datos json
     * @param outputFileName String Nombre del archivo pdf resultante
     * @return String El md5 del pdf generado
     * @throws java.io.IOException Se dispara cuando 'inputFileName' no existe
     * @throws net.sf.jasperreports.engine.JRException the JR exception
     */
    String generatePdfFromCompiledJasperObject(JasperReport jasperReport, String dataFile, String outputFileName)
            throws IOException, JRException;
}
