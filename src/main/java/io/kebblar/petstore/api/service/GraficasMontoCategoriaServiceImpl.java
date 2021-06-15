/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   GraficasMontoCategoriaServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Cloudstore
 * Fecha:       15 de Junio de 2021 (16_02)
 *
 * Historia:    .
 *              20210615_1602 Creación
 *
 */
package io.kebblar.petstore.api.service;

import java.sql.SQLException;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itextpdf.layout.element.List;

import ch.qos.logback.classic.Logger;
import io.kebblar.petstore.api.mapper.GraficasMontoCategoriaMapper;
import io.kebblar.petstore.api.model.domain.GraficasMontoCategoria;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * Implementación de la interfaz {@link OrdenCompraService}.
 * 
 * Todos los métodos de esta clase disparan {@link BusinessException}
 * 
 * @author dalvarez
 * @see io.kebblar.petstore.api.model.domain.DatosOrden
 * @see io.kebblar.petstore.api.service.OrdenCompraService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service
public class GraficasMontoCategoriaServiceImpl implements GraficasMontoCategoriaService {
	
    private GraficasMontoCategoriaMapper graficasMontoCategoriaMapper;
    

    @Override
    public java.util.List<GraficasMontoCategoria> getAll() throws BusinessException {
        try {
            return graficasMontoCategoriaMapper.getAll();
        } catch (SQLException e) {
            throw new BusinessException("Error en obtener todos los datos para la gráfica",e.getMessage());
        }
    }

    
}
