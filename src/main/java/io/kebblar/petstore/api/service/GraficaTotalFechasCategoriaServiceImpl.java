/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      GraficaTotalFechasCategoriaServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:45:38
 */
package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.GraficaTotalFechasCategoriaMapper;
import io.kebblar.petstore.api.model.domain.GraficaTotalFechasCategoria;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'GraficaTotalFechasCategoria'.
 *
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.GraficaTotalFechasCategoriaService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see GraficaTotalFechasCategoria
 */
@Service("GraficaTotalFechasCategoriaService")
public class GraficaTotalFechasCategoriaServiceImpl implements GraficaTotalFechasCategoriaService {
    private static final Logger logger = LoggerFactory.getLogger(GraficaServiceImpl.class);

    private GraficaTotalFechasCategoriaMapper graficaTotalFechasCategoriaMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los servicios
     * adicionales a ser empleados en esta clase.
     *
     * @param graficaTotalFechasCategoriaMapper a {@link io.kebblar.petstore.api.mapper.GraficaTotalFechasCategoriaMapper} object.
     */
    public GraficaTotalFechasCategoriaServiceImpl(GraficaTotalFechasCategoriaMapper graficaTotalFechasCategoriaMapper) {
        logger.debug("Invoking GraficaTotalFechasCategoriaServiceImpl constructor");
        this.graficaTotalFechasCategoriaMapper = graficaTotalFechasCategoriaMapper;
    }

    /** {@inheritDoc} */
    @Override
    public String getTotalPorCategoria() throws BusinessException {
        try {
            String cadena = "";
            List<GraficaTotalFechasCategoria> datos = graficaTotalFechasCategoriaMapper.getTotalCategoria();
            if (!datos.isEmpty()) {
                cadena = obtenerJSONDatos(datos);
                return cadena;
            }
            return cadena;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String getTotalPorCategoriaFiltroFechas(String fechaIni, String fechaFin) throws BusinessException {
        try {
            String cadena = "";
            List<GraficaTotalFechasCategoria> datos = graficaTotalFechasCategoriaMapper.getTotalCategoriaFiltroFechas(fechaIni, fechaFin);
            if (!datos.isEmpty()) {
                cadena = obtenerJSONDatos(datos);
                return cadena;
            }
            return cadena;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    private List<String> obtenerEtiquetasMeses(List<GraficaTotalFechasCategoria> datos){
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

    private Long[][] obtenerArregloDatos(
            List<GraficaTotalFechasCategoria> datos,
            List<String> fechas,
            List<String> categorias){
        Long[][] arregloDatos = new Long[categorias.size()][fechas.size()];
        //System.out.print(arregloDatos[0][0]);
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            Arrays.fill(arregloDatos[i], new Long(0));
        }
        //System.out.print(arregloDatos[0][0]);
        for (int i = 0; i <= datos.size() - 1; i++) {
            String anio = Integer.toString(datos.get(i).getAnio());
            String mes = obtenerNombreMes(datos.get(i).getMes());
            String fecha = mes+"-"+anio;
            int indice_fecha = fechas.indexOf(fecha);
            int indice_categoria = categorias.indexOf(datos.get(i).getCategoria());
            arregloDatos [indice_categoria][indice_fecha] = datos.get(i).getTotalVenta();
            }
        return arregloDatos;
    }

    private String obtenerJSONDatos(
            List<GraficaTotalFechasCategoria> datos){
        String cadena = "{\"chartdata\": {\"labels\": [\"";
        List<String> fechas = obtenerEtiquetasMeses(datos);
        List<String> categorias = Arrays.asList("CANINOS","FELINOS",
                        "ARACNIDOS","REPTILES","PECES","AVES","ROEDORES");
        List<String> colores = Arrays.asList("#96590C","#FF6400",
                "#FF00D4","#96FF33","#00FFA2","#85DBFC","#FFFA5A");
        String cadena_fechas = StringUtils.join(fechas, "\",\"");
        //System.out.println(cadena_fechas);
        cadena = cadena + cadena_fechas + "\"], \"yAxisID\": \"yAxis\", \"datasets\": [ ";
        Long[][] arregloDatos = obtenerArregloDatos(datos,fechas,categorias);
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            cadena = cadena + "{ \"label\": \"" + categorias.get(i)+"\", ";
            cadena = cadena + "\"backgroundColor\": \"" + colores.get(i)+"\",\"data\":[";
            List<Long> totales = new ArrayList<Long>();
            for (int j = 0; j <= arregloDatos[i].length - 1; j++) {
                totales.add(arregloDatos[i][j]);
            }
            //System.out.println(totales);
            String cadena_totales = StringUtils.join(totales, ",");
            cadena = cadena + cadena_totales +"]},";
            }
        //System.out.println(cadena);
        cadena = cadena.substring(0,cadena.length()-1);
        //System.out.println(cadena);
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

