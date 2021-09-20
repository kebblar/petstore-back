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
 * Nombre:      TestAdministracionComprasService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:37:31
 */
package io.kebblar.petstore.api.service;

import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.mapper.AdministracionComprasMapper;
import io.kebblar.petstore.api.model.domain.AdministracionCompras;
import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>TestAdministracionComprasService class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAdministracionComprasService {
    @Mock
    private AdministracionComprasMapper historialMapper;

    private AdministracionComprasService historialService;

    /**
     * <p>prepara.</p>
     */
    @Before
    public void prepara() {
        this.historialService = new AdministracionComprasServiceImpl(historialMapper);
    }

    /**
     * <p>testSent.</p>
     *
     * @throws java.sql.SQLException if any.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    @Test
    public void testSent() throws SQLException, BusinessException{
        // Cuando sale bien la prueba
        List<HistorialCompras> getLista = new ArrayList<>();
        HistorialCompras compra = new HistorialCompras("abc","2020-10-10",0,1,"foo","paypal","gus@aol.com",
                "foo.com","goo.com");
        getLista.add(compra);
        when(historialMapper.sent(1,"abc")).thenReturn(1);
        assert(historialService.sent(1,"abc").equals("{\"succed\": \"true\"}"));

    }

    @Test(expected = BusinessException.class)
    public void testSentFailed() throws SQLException, BusinessException{
        // cuando ocurre un problema
        when(historialMapper.sent(0, "yyy")).thenThrow(new SQLException());
        historialService.sent(0, "yyy");

    }

    /**
     * <p>testGetAll.</p>
     *
     * @throws java.sql.SQLException if any.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    @Test
    public void testGetAll() throws SQLException, BusinessException{
        List<AdministracionCompras> getLista = new ArrayList<AdministracionCompras>();
        AdministracionCompras compra = new AdministracionCompras(true,"cve_orden","nueva colonia","mascota foo","foo.com","2020-10-10","calle goo numero 80", "84444");
        getLista.add(compra);
        when(historialMapper.getAll()).thenReturn(getLista);
        assert(historialService.getAll().get(0).getCveOrden() == "foo.com");
    }

    @Test(expected = BusinessException.class)
    public void testGetAllFailed() throws SQLException, BusinessException{
        when(historialMapper.getAll()).thenThrow(new SQLException());
        historialService.getAll();
    }
}
