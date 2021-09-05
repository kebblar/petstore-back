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
 * Nombre:      GraficaServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:45:02
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

import io.kebblar.petstore.api.mapper.GraficaCompradorMapper;
import io.kebblar.petstore.api.mapper.GraficaMascotaMapper;
import io.kebblar.petstore.api.mapper.GraficaPaqueteriaMapper;
import io.kebblar.petstore.api.model.domain.ChartData;
import io.kebblar.petstore.api.model.domain.ChartWrapper;
import io.kebblar.petstore.api.model.domain.Grafica;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'grafica'.
 *
 * <p>
 * Implementación de la interfaz {@link io.kebblar.petstore.api.service.GraficaService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Grafica
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
     * @param graficaPaqueteriaMapper a {@link io.kebblar.petstore.api.mapper.GraficaPaqueteriaMapper} object.
     * @param graficaCompradorMapper a {@link io.kebblar.petstore.api.mapper.GraficaCompradorMapper} object.
     */
    public GraficaServiceImpl(
            GraficaMascotaMapper graficaMapper,
            GraficaPaqueteriaMapper graficaPaqueteriaMapper,
            GraficaCompradorMapper graficaCompradorMapper) {
        logger.debug("Invoking GraficaServiceImpl constructor");
        this.graficaMapper = graficaMapper;
        this.graficaPaqueteriaMapper = graficaPaqueteriaMapper;
        this.graficaCompradorMapper = graficaCompradorMapper;
    }

    /** {@inheritDoc} */
    @Override
    public ChartWrapper getMascotaMasVendida() throws BusinessException {
        try {
            List<Grafica> graficas = graficaMapper.getAll();
            if (!graficas.isEmpty()) {
                return build2(graficas);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public ChartWrapper getMascotaMasVendidaRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            List<Grafica> graficas = graficaMapper.getMascotaPorRangoDeFechas(fechaIni, fechaFin);
            if (!graficas.isEmpty()) {
                return build2(graficas);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public ChartWrapper getPaqueteria() throws BusinessException {
        try {
            List<Grafica> graficas = graficaPaqueteriaMapper.getPaqueteria();
            if (!graficas.isEmpty()) {
                return build2(graficas);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public ChartWrapper getPaqueteriaRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            List<Grafica> graficas = graficaPaqueteriaMapper.getPaqueteriaPorRangoDeFechas(fechaIni, fechaFin);
            if (!graficas.isEmpty()) {
                return build2(graficas);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public ChartWrapper getCompradorAsiduo() throws BusinessException {
        try {
            List<Grafica> graficas = graficaCompradorMapper.getComprador();
            if (!graficas.isEmpty()) {
                return build2(graficas);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public ChartWrapper getCompradorAsiduoRango(String fechaIni, String fechaFin) throws BusinessException {
        try {
            List<Grafica> graficas = graficaCompradorMapper.getCompradorPorRangoDeFechas(fechaIni, fechaFin);
            if (!graficas.isEmpty()) {
                return build2(graficas);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    private String obtenerMes(Date fecha) {
        return new SimpleDateFormat("MMMM").format(fecha);
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
