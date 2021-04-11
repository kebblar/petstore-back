/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.api.service
 * Modulo:      cinepolis
 * Tipo:        interfaz
 * Autor:       Gustavo Adolfo Arellano Sandoval
 * Fecha:       28 de Marzo de 2020
 * Version:     1.0-SNAPSHOT
 * .
 */
package io.kebblar.petstore.api.support;

import java.io.IOException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Interface JasperService.
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
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JRException the JR exception
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
     * @throws IOException Se dispara cuando 'inputFileName' no existe
     * @throws JRException the JR exception
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
     * @throws IOException Se dispara cuando 'inputFileName' no existe
     * @throws JRException the JR exception
     */
    String generatePdfFromCompiledJasperObject(JasperReport jasperReport, String dataFile, String outputFileName)
            throws IOException, JRException;
}
