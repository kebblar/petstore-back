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
 * Artefacto:   GraficaServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Ulises López
 * Fecha:       Tuesday 09 de Jun de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210609_1444 Implementación de clase
 *
 */
package io.kebblar.petstore.api.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ibm.icu.util.Calendar;

import io.kebblar.petstore.api.mapper.GraficaCompradorMapper;
import io.kebblar.petstore.api.mapper.GraficaMascotaMapper;
import io.kebblar.petstore.api.mapper.GraficaPaqueteriaMapper;
import io.kebblar.petstore.api.model.domain.GraficaTO;
import io.kebblar.petstore.api.model.domain.Chart;
import io.kebblar.petstore.api.model.domain.GraficaComprador;
import io.kebblar.petstore.api.model.domain.GraficaMascota;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * Servicio asociado a la entidad 'grafica'.
 *
 * <p>
 * Implementación de la interfaz {@link GraficaService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaMascota
 * @see GraficaService
 */

@Service("graficaService")
public class GraficaServiceImpl implements GraficaService {
    private static final Logger logger = LoggerFactory.getLogger(GraficaServiceImpl.class);

    private GraficaMascotaMapper graficaMapper;
    private GraficaPaqueteriaMapper graficaPaqueteriaMapper;
    private GraficaCompradorMapper graficaCompradorMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los servicios
     * adicionales a ser empleados en esta clase.
     *
     * @param graficaMapper mapper utilizado para llamar a metodos de persistencia
     */
    public GraficaServiceImpl(GraficaMascotaMapper graficaMapper, GraficaPaqueteriaMapper graficaPaqueteriaMapper,
            GraficaCompradorMapper graficaCompradorMapper) {
        this.graficaMapper = graficaMapper;
        this.graficaPaqueteriaMapper = graficaPaqueteriaMapper;
        this.graficaCompradorMapper = graficaCompradorMapper;
    }

    @Override
    public GraficaTO getMascotaMasVendida() throws BusinessException {
        try {
            GraficaTO graphs = new GraficaTO();
            List<Chart> graficas = graficaMapper.getAll();
            for (Chart chart : graficas) {
                chart.setMes(convertirFecha(chart.getMes()));
            }
            graphs.setChart(graficas);
            return graphs;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public GraficaTO getMascotaMasVendidaRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            GraficaTO graphs = new GraficaTO();
            List<Chart> graficas = graficaMapper.getMascotaPorRangoDeFechas(fechaIni, fechaFin);
            for (Chart chart : graficas) {
                chart.setMes(convertirFecha(chart.getMes()));
            }
            graphs.setChart(graficas);
            return graphs;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public GraficaTO getPaqueteria() throws BusinessException {
        try {
            GraficaTO graphs = new GraficaTO();
            List<Chart> graficas = graficaPaqueteriaMapper.getPaqueteria();
            for (Chart chart : graficas) {
                chart.setMes(convertirFecha(chart.getMes()));
            }
            graphs.setChart(graficas);
            return graphs;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public GraficaTO getPaqueteriaRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            GraficaTO graphs = new GraficaTO();
            List<Chart> graficas = graficaPaqueteriaMapper.getPaqueteriaPorRangoDeFechas(fechaIni, fechaFin);
            for (Chart chart : graficas) {
                chart.setMes(convertirFecha(chart.getMes()));
            }
            graphs.setChart(graficas);
            return graphs;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public String getCompradorAsiduo() throws BusinessException {
        try {
            String cadena = "";
            List<GraficaComprador> graficas = graficaCompradorMapper.getComprador();
            if (!graficas.isEmpty()) {
                cadena = formatearGraficaComprador(graficas);
                return cadena;
            }
            return cadena;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public String getCompradorAsiduoRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            String cadena = "";
            List<GraficaComprador> graficas = graficaCompradorMapper.getCompradorPorRangoDeFechas(fechaIni, fechaFin);
            if (!graficas.isEmpty()) {
                cadena = formatearGraficaComprador(graficas);
                return cadena;
            }
            return cadena;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    private String formatearGraficaComprador(List<GraficaComprador> graficas) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbData = new StringBuilder();
        String mes = "";
        String cadena;
        String cadenaTmp;
        String cadenaMes;
        sb.append("{\"chart\":{\"label\":[");
        for (int i = 0; i < graficas.size(); i++) {
            sb.append("\"" + graficas.get(i).getComprador() + "\",");
            sbData.append(graficas.get(i).getCantidad() + ",");
            mes = ("\"" + obtenerMes(graficas.get(i).getFecha()) + "\",");
        }
        cadenaTmp = sb.substring(0, sb.toString().length() - 1) + "],\"data\":[" + sbData.toString();
        cadenaMes = cadenaTmp.substring(0, cadenaTmp.toString().length() - 1) + "],\"mes\":[" + mes;
        cadena = cadenaMes.substring(0, cadenaMes.toString().length() - 1);
        System.out.println(cadena + "]}}");
        return cadena + "]}}";
    }

    private String obtenerMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        String mes = new SimpleDateFormat("MMMM").format(cal.getTime());
        return mes;
    }

    private String convertirFecha(String fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String mes = "";
        try {
            Date date = formatter.parse(fecha);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            mes = new SimpleDateFormat("M").format(cal.getTime());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return mes;
    }

}