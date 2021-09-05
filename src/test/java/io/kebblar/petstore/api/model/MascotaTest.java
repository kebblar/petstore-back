/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      MascotaTest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:37:12
 */
package io.kebblar.petstore.api.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.service.MascotaService;
import io.kebblar.petstore.api.service.MascotaServiceImpl;

/**
 * <p>MascotaTest class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MascotaTest {
    private MascotaService ms = new MascotaServiceImpl();

    /**
     * <p>pruebaSuma.</p>
     */
    @Test
    public void pruebaSuma() {
        int res=0;

        res = ms.suma(2, 3);
        assert(res==5);

        res = ms.suma(2, 0);
        assert(res==2);

        res = ms.suma(0, 0);
        assert(res==0);

//        res = ms.suma(-1, -1);
//        assert(res==-2);

    }
}
