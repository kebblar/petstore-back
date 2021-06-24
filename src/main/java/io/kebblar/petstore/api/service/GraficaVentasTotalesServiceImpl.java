/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   GraficaVentasTotalesServiceImpl.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Francisco Espinosa
 * Fecha:       Tuesday 23 de Jun de 2021 (10_00)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210623_1000 Implementación de clase
 *
 */
package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.GraficaVentasTotalesMapper;
import io.kebblar.petstore.api.model.domain.GraficaVentasTotales;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'GraficaVentasTotales'.
 *
 * <p>Implementación de la interfaz {@link GraficaVentasTotalesService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaVentasTotales
 */
@Service("GraficaVentasTotalesService")
public class GraficaVentasTotalesServiceImpl implements GraficaVentasTotalesService {

    private GraficaVentasTotalesMapper graficaVentasTotalesMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los servicios
     * adicionales a ser empleados en esta clase.
     *
     * @param graficaVentasTotalesMapper mapper utilizado para llamar a metodos de persistencia
     */    
    public GraficaVentasTotalesServiceImpl(GraficaVentasTotalesMapper graficaVentasTotalesMapper) {
        this.graficaVentasTotalesMapper = graficaVentasTotalesMapper;
    }

    @Override
    public String getTotalImporteVentas() throws DatabaseException {
        try {
            String cadena = "";
            List<GraficaVentasTotales> datos = graficaVentasTotalesMapper.getTotalVentas();
            if (!datos.isEmpty()) {
                cadena = obtenerJSONDatosImporte(datos);
            }
            return cadena;
        } catch (Exception e) {
            throw new DatabaseException("Error al obtener los datos para la gráfica importe total de ventas");
        }
    }

    @Override
    public String getTotalImporteVentasFiltroFechas(String fechaIni, String fechaFin) throws DatabaseException {
        try {
            String cadena = "";
            List<GraficaVentasTotales> datos = graficaVentasTotalesMapper.getTotalVentasFiltroFechas(fechaIni, fechaFin);
            if (!datos.isEmpty()) {
                cadena = obtenerJSONDatosImporte(datos);
            }
            return cadena;
        } catch (Exception e) {
            throw new DatabaseException("Error al obtener los datos para la gráfica importe total de ventas con filtro de fecha");
        }
    }
    
    @Override
    public String getNumeroOrdenesTotalVentas() throws DatabaseException {
        try {
            String cadena = "";
            List<GraficaVentasTotales> datos = graficaVentasTotalesMapper.getTotalVentas();
            if (!datos.isEmpty()) {
            	cadena = obtenerJSONDatosNumeroOrdenes(datos);
            }
            return cadena;
        } catch (Exception e) {
            throw new DatabaseException("Error al obtener los datos para la gráfica total de número de órdenes de ventas");
        }
    }

    @Override
    public String getNumeroOrdenesTotalVentasFiltroFechas(String fechaIni, String fechaFin) throws DatabaseException {
        try {
            String cadena = "";
            List<GraficaVentasTotales> datos = graficaVentasTotalesMapper.getTotalVentasFiltroFechas(fechaIni, fechaFin);
            if (!datos.isEmpty()) {
                cadena = obtenerJSONDatosNumeroOrdenes(datos);
            }
            return cadena;
        } catch (Exception e) {
            throw new DatabaseException("Error al obtener los datos para la gráfica total de número de órdenes de ventas con filtro de fecha");
        }
    }
    
    private List<String> obtenerEtiquetasMeses(List<GraficaVentasTotales> datos) {
        List <String> etiquetas = new ArrayList<String>();
        for (int i = 0; i <= datos.size() - 1; i++) {
            String anio = Integer.toString(datos.get(i).getAnio());
            String mes = obtenerNombreMes(datos.get(i).getMes());
            String fecha = mes+"-"+anio;
            if (!etiquetas.contains(fecha)) {
                etiquetas.add(fecha);
            }
        }
        return etiquetas;
    }
    
    private Integer[][] obtenerArregloDatosNumeroOrdenes(
        List<GraficaVentasTotales> datos,
        List<String> fechas,
        List<String> categorias) {
        Integer[][] arregloDatos = new Integer[categorias.size()][fechas.size()];
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            Arrays.fill(arregloDatos[i], new Integer(0));
        }
        for (int i = 0; i <= datos.size() - 1; i++) {
            String anio = Integer.toString(datos.get(i).getAnio());
            String mes = obtenerNombreMes(datos.get(i).getMes());
            String fecha = mes+"-"+anio;
            int indice_fecha = fechas.indexOf(fecha);
            arregloDatos [0][indice_fecha] = datos.get(i).getCantidad_ordenes();
        }    
        return arregloDatos;
    }
    
    private Long[][] obtenerArregloDatosImporte(
        List<GraficaVentasTotales> datos,
        List<String> fechas,
        List<String> categorias) {
        Long[][] arregloDatos = new Long[categorias.size()][fechas.size()];
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            Arrays.fill(arregloDatos[i], new Long(0));
        }
        for (int i = 0; i <= datos.size() - 1; i++) {
            String anio = Integer.toString(datos.get(i).getAnio());
            String mes = obtenerNombreMes(datos.get(i).getMes());
            String fecha = mes+"-"+anio;
            int indice_fecha = fechas.indexOf(fecha);
            arregloDatos [0][indice_fecha] = datos.get(i).getTotal_venta();
        }
        return arregloDatos;
    }
    
    private String obtenerJSONDatosNumeroOrdenes(
        List<GraficaVentasTotales> datos) {
        String cadena = "{\"chartdata\": {\"labels\": [\"";
        List<String> fechas = obtenerEtiquetasMeses(datos);
        List<String> categorias = Arrays.asList("Número total de órdenes de compra");
        List<String> colores = Arrays.asList("#00FFA2","#FF6400",
            "#FF00D4","#96590C","#00FFA2","#85DBFC","#FFFA5A");
        String cadena_fechas = StringUtils.join(fechas, "\",\"");
        cadena = cadena + cadena_fechas + "\"], \"yAxisID\": \"yAxis\", \"datasets\": [ ";
        Integer[][] arregloDatos = obtenerArregloDatosNumeroOrdenes(datos,fechas,categorias);
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            cadena = cadena + "{ \"fill\": \"false\", \"label\": \"" + categorias.get(i)+"\", ";
            cadena = cadena + "\"backgroundColor\": \"" + colores.get(i)+"\",\"data\":[";
            List<Integer> totales = new ArrayList<Integer>();
            for (int j = 0; j <= arregloDatos[i].length - 1; j++) {
                totales.add(arregloDatos[i][j]);
            }
            String cadena_totales = StringUtils.join(totales, ",");
            cadena = cadena + cadena_totales +"]},";
        }
        cadena = cadena.substring(0,cadena.length()-1);
        return cadena+"]}}";
    }
    
    private String obtenerJSONDatosImporte(
        List<GraficaVentasTotales> datos) {
        String cadena = "{\"chartdata\": {\"labels\": [\"";
        List<String> fechas = obtenerEtiquetasMeses(datos);
        List<String> categorias = Arrays.asList("Importe total de ventas");
        List<String> colores = Arrays.asList("#96FF33","#FF6400",
            "#FF00D4","#96590C","#00FFA2","#85DBFC","#FFFA5A");
        String cadena_fechas = StringUtils.join(fechas, "\",\"");
        cadena = cadena + cadena_fechas + "\"], \"yAxisID\": \"yAxis\", \"datasets\": [ ";
        Long[][] arregloDatos = obtenerArregloDatosImporte(datos,fechas,categorias);
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            cadena = cadena + "{ \"label\": \"" + categorias.get(i)+"\", ";
            cadena = cadena + "\"backgroundColor\": \"" + colores.get(i)+"\",\"data\":[";
            List<Long> totales = new ArrayList<Long>();
            for (int j = 0; j <= arregloDatos[i].length - 1; j++) {
                totales.add(arregloDatos[i][j]);
            }
            String cadena_totales = StringUtils.join(totales, ",");
            cadena = cadena + cadena_totales +"]},";
        }
        cadena = cadena.substring(0,cadena.length()-1);
    	return cadena+"]}}";
    }

    private String obtenerNombreMes(int mes) {
        String cadena_mes = "";    				
        switch(mes) {
        case 1: cadena_mes = "Enero";
        break;
        case 2: cadena_mes = "Febrero";
        break;
        case 3: cadena_mes = "Marzo";
        break;
        case 4: cadena_mes = "Abril";
        break;
        case 5: cadena_mes = "Mayo";
        break;
        case 6: cadena_mes = "Junio";
        break;
        case 7: cadena_mes = "Julio";
        break;
        case 8: cadena_mes = "Agosto";
        break;
        case 9: cadena_mes = "Septiembre";
        break;
        case 10: cadena_mes = "Octubre";
        break;
        case 11: cadena_mes = "Noviembre";
        break;
        case 12: cadena_mes = "Diciembre";
        break;
        }
        return cadena_mes;
    }

}
