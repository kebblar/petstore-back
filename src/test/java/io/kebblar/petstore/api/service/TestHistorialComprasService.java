/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      TestHistorialComprasService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:38:53
 */
package io.kebblar.petstore.api.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.mapper.HistorialComprasMapper;
import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>TestHistorialComprasService class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class TestHistorialComprasService {
    @Mock
    private HistorialComprasMapper historialMapper;

    private HistorialComprasService historialService;

    /**
     * <p>prepara.</p>
     */
    @Before
    public void prepara() {
        this.historialService = new HistorialComprasServiceImpl(historialMapper);
    }

    /**
     * <p>Test.</p>
     *
     * @throws java.sql.SQLException if any.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    @Test
    public void Test() throws SQLException, BusinessException{
        List<HistorialCompras> getLista = new ArrayList<HistorialCompras>();
        HistorialCompras compra = new HistorialCompras("abc","2020-10-10",0,1,"foo","paypal","gus@aol.com",
                "foo.com","goo.com");
        getLista.add(compra);
        when(historialMapper.getAll(1)).thenReturn(getLista);
        assert(historialService.getAll(1).get(0).getCveOrden() == "abc");
    }

}
