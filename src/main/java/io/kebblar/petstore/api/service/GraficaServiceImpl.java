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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ibm.icu.util.Calendar;

import io.kebblar.petstore.api.mapper.GraficaCompradorMapper;
import io.kebblar.petstore.api.mapper.GraficaMascotaMapper;
import io.kebblar.petstore.api.mapper.GraficaPaqueteriaMapper;
import io.kebblar.petstore.api.model.domain.ChartData;
import io.kebblar.petstore.api.model.domain.ChartWrapper;
import io.kebblar.petstore.api.model.domain.Grafica;
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
 * @see Grafica
 * @see GraficaService
 */

@Service("graficaService")
public class GraficaServiceImpl implements GraficaService {
    private static final Logger logger = LoggerFactory.getLogger(GraficaServiceImpl.class);

    private GraficaMascotaMapper graficaMapper;
    private GraficaPaqueteriaMapper graficaPaqueteriaMapper;
    private GraficaCompradorMapper graficaCompradorMapper;
    Gson gson = new Gson();

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
    public String getMascotaMasVendida() throws BusinessException {
        try {
            List<Grafica> graficas = graficaMapper.getAll();
            if (!graficas.isEmpty()) {
                ChartWrapper y = build2(graficas);

                return gson.toJson(y);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
        return null;
    }

    @Override
    public String getMascotaMasVendidaRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            List<Grafica> graficas = graficaMapper.getMascotaPorRangoDeFechas(fechaIni, fechaFin);
            if (!graficas.isEmpty()) {
                ChartWrapper y = build2(graficas);
                System.out.println("Cadena Json : " + gson.toJson(y));
                return gson.toJson(y);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
        return null;
    }

    @Override
    public String getPaqueteria() throws BusinessException {
        try {
            List<Grafica> graficas = graficaPaqueteriaMapper.getPaqueteria();
            if (!graficas.isEmpty()) {
                ChartWrapper y = build2(graficas);
                System.out.println("Cadena Json : " + gson.toJson(y));
                return gson.toJson(y);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
        return null;
    }

    @Override
    public String getPaqueteriaRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            List<Grafica> graficas = graficaPaqueteriaMapper.getPaqueteriaPorRangoDeFechas(fechaIni, fechaFin);
            if (!graficas.isEmpty()) {
                ChartWrapper y = build2(graficas);
                System.out.println("Cadena Json : " + gson.toJson(y));
                return gson.toJson(y);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
        return null;
    }

    @Override
    public String getCompradorAsiduo() throws BusinessException {
        try {
            List<Grafica> graficas = graficaCompradorMapper.getComprador();
            if (!graficas.isEmpty()) {
                ChartWrapper y = build2(graficas);
                System.out.println("Cadena Json : " + gson.toJson(y));
                return gson.toJson(y);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
        return null;
    }

    @Override
    public String getCompradorAsiduoRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            List<Grafica> graficas = graficaCompradorMapper.getCompradorPorRangoDeFechas(fechaIni, fechaFin);
            if (!graficas.isEmpty()) {
                ChartWrapper y = build2(graficas);
                System.out.println("Cadena Json : " + gson.toJson(y));
                return gson.toJson(y);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
        return null;
    }

    private String obtenerMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        String mes = new SimpleDateFormat("MMMM").format(cal.getTime());
        return mes;
    }

    private ChartWrapper build2(List<Grafica> grafica) {
        List<String> label = new ArrayList<>();
        List<Long> data = new ArrayList<>();
        Set<String> mes = new HashSet<>();
        for(Grafica gp : grafica) {
            label.add(gp.getEtiqueta());
            mes.add(obtenerMes(gp.getFecha()));
            data.add(gp.getCantidad());
        }
        ChartData chartData = new ChartData(label, data, mes);
        return new ChartWrapper(chartData);
    }  

}