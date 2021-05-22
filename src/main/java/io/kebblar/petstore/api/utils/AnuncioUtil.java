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
 *              20210520_2203 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import com.ibm.icu.text.SimpleDateFormat;

/**
 * <p>Descripción:</p>
 * Utileria de apoyo para los servicios asociados a la entidad'anuncio'. 
 *
 * @author Maria Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioUtil {

	/**
	 * <p>Metodo que permite genera un SKU para la entidad de 'anuncio'.</p>
	 * <p>El SKU se conformara por 
	 * yyMMddHHmm0000, siendo los ultimos 4 ceros un random rellenado con espacios a la izquierda
	 * teniendo un total de 14 posiciones. </p>
	 * @return String de 14 posiciones.
	 */
	public static String generaSku() {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyMMddHHmm");
		Random random = new Random();
		String sku=dateFormat.format(new Date());
		return sku+String.format("%04d", random.nextInt(10000));
	}

	/**
	 * Metodo que permite validar las fechas de periodo enviadas.
	 * <p>1. Valida que el periodo inicial sea posterior o igual a la fecha actual</p>
	 * <p>2. Valida que la fecha de inicio no sea posterior a la fecha final</p>
	 * @param fechaInicioVigencia
	 * @param fechaFinVigencia
	 * @return
	 */
	public static boolean validaFechasPeriodo(Date fechaInicioVigencia, Date fechaFinVigencia){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
			String sFechaBase=dateFormat.format(new Date());
			String sFechaIniVigencia=fechaInicioVigencia!=null ? dateFormat.format(fechaInicioVigencia):null;
			String sFechaFinVigencia=fechaFinVigencia!=null?dateFormat.format(fechaFinVigencia):null;
			
			Date fechaBase = dateFormat.parse(sFechaBase);
			fechaInicioVigencia = sFechaIniVigencia!=null?dateFormat.parse(sFechaIniVigencia):null;
			fechaFinVigencia = sFechaFinVigencia!=null?dateFormat.parse(sFechaFinVigencia):null;
			boolean fechasValidas = true;
			//Se valida que la fecha de inicio no sea anterior a la fecha actual
			if(fechaInicioVigencia!=null && fechaBase.after(fechaInicioVigencia)){
				fechasValidas = false;
			} 
			//Se valida que la fecha de fin sno sea anterior a la fecha actual
			if(fechaFinVigencia!=null && fechaBase.after(fechaFinVigencia)){
				fechasValidas = false;
			} 
			//Se valida que la fecha de fin no sea mayor fecha inicio
			if(fechaInicioVigencia!=null && fechaFinVigencia!=null 
					&& fechaInicioVigencia.after(fechaFinVigencia)){
				fechasValidas = false;
			} 
			return fechasValidas;
		} catch (ParseException ex) {
		
		}
		return false;
	}
	
	/**
	 * Metodo que permite comparar dos fechas entre si
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
		
		}
		return 0;
	}

}
