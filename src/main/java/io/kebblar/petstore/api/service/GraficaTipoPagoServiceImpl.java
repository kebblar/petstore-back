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
 * Nombre:      GraficaTipoPagoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:45:18
 */
package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import io.kebblar.petstore.api.mapper.GraficaTipoPagoMapper;
import io.kebblar.petstore.api.model.domain.GraficaTipoPago;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'grafica'.
 *
 * <p>
 * Implementación de la interfaz {@link io.kebblar.petstore.api.service.GraficaTipoPagoService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author Diego González
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see GraficaTipoPago
 * @see GraficaTipoPagoService
 */
@Service("graficaTipoPagoService")
public class GraficaTipoPagoServiceImpl implements GraficaTipoPagoService {
    private static final Logger logger = LoggerFactory.getLogger(GraficaTipoPagoServiceImpl.class);

    private GraficaTipoPagoMapper graficaTipoPagoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los servicios
     * adicionales a ser empleados en esta clase.
     *
     * @param graficaTipoPagoMapper mapper utilizado para llamar a metodos de
     *                              persistencia
     */
    public GraficaTipoPagoServiceImpl(GraficaTipoPagoMapper graficaTipoPagoMapper) {
        logger.debug("Invoking GraficaTipoPagoServiceImpl constructor");
        this.graficaTipoPagoMapper = graficaTipoPagoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public String getMontoTotalTipoPago() throws BusinessException {
        try {
            String cadena = "";
            List<GraficaTipoPago> datos = graficaTipoPagoMapper.getAll();
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
    public String getMontoTipoPagoRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            String cadena = "";
            List<GraficaTipoPago> datos = graficaTipoPagoMapper.getTipoPagoPorRangoDeFechas(fechaIni, fechaFin);
            if (!datos.isEmpty()) {
                cadena = obtenerJSONDatos(datos);
                return cadena;
            }
            return cadena;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    private List<String> obtenerEtiquetasMeses(List<GraficaTipoPago> datos) {
        List<String> etiquetas = new ArrayList<String>();
        for (int i = 0; i <= datos.size() - 1; i++) {
            String anio = Integer.toString(datos.get(i).getAnio());
            String mes = obtenerNombreMes(datos.get(i).getMes());
            String fecha = mes + "-" + anio;
            if (!etiquetas.contains(fecha)) {
                etiquetas.add(fecha);
            }
        }
        return etiquetas;
    }

    private Long[][] obtenerArregloDatos(
            List<GraficaTipoPago> datos,
            List<String> fechas,
            List<String> tipoPago){
        Long[][] arregloDatos = new Long[tipoPago.size()][fechas.size()];
        System.out.print(arregloDatos[0][0]);
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            Arrays.fill(arregloDatos[i], new Long(0));
        }
        System.out.print(arregloDatos[0][0]);
        for (int i = 0; i <= datos.size() - 1; i++) {
            String anio = Integer.toString(datos.get(i).getAnio());
            String mes = obtenerNombreMes(datos.get(i).getMes());
            String fecha = mes+"-"+anio;
            int indice_fecha = fechas.indexOf(fecha);
            int indice_tipoPago = tipoPago.indexOf(datos.get(i).getTipoPago());
            arregloDatos [indice_tipoPago][indice_fecha] = datos.get(i).getTotalVenta();
            }
        return arregloDatos;
    }


    private String obtenerJSONDatos(List<GraficaTipoPago> datos) {
        String cadena = "{\"chartdata\": {\"labels\": [\"";
        List<String> fechas = obtenerEtiquetasMeses(datos);
        List<String> tipoPago = Arrays.asList("bitcoin", "paypal");
        List<String> colores = Arrays.asList("#00ffa2", "blue");
        String cadena_fechas = StringUtils.join(fechas, "\",\"");
        System.out.println(cadena_fechas);
        cadena = cadena + cadena_fechas + "\"], \"datasets\": [";
        Long[][] arregloDatos = obtenerArregloDatos(datos, fechas, tipoPago);
        for (int i = 0; i <= arregloDatos.length - 1; i++) {
            cadena = cadena + "{\"label\": \"" + tipoPago.get(i) + "\",";
            cadena = cadena + "\"backgroundColor\": \"" + colores.get(i) + "\",\"data\":[";
            List<Long> totales = new ArrayList<Long>();
            for (int j = 0; j <= arregloDatos[i].length - 1; j++) {
                totales.add(arregloDatos[i][j]);
            }
            System.out.println(totales);
            String cadena_totales = StringUtils.join(totales, ",");
            cadena = cadena + cadena_totales + "]},";
        }
        System.out.println(cadena);
        cadena = cadena.substring(0, cadena.length() - 1);
        System.out.println(cadena);
        return cadena + "]}}";
    }

    private String obtenerNombreMes(int mes) {
        String cadena_mes = "";
        switch (mes) {
        case 1:
            cadena_mes = "Enero";
            break;
        case 2:
            cadena_mes = "Febrero";
            break;
        case 3:
            cadena_mes = "Marzo";
            break;
        case 4:
            cadena_mes = "Abril";
            break;
        case 5:
            cadena_mes = "Mayo";
            break;
        case 6:
            cadena_mes = "Junio";
            break;
        case 7:
            cadena_mes = "Julio";
            break;
        case 8:
            cadena_mes = "Agosto";
            break;
        case 9:
            cadena_mes = "Septiembre";
            break;
        case 10:
            cadena_mes = "Octubre";
            break;
        case 11:
            cadena_mes = "Noviembre";
            break;
        case 12:
            cadena_mes = "Diciembre";
            break;
        }
        return cadena_mes;
    }

}
