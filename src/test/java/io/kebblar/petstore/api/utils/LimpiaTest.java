/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      LimpiaTest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:39:30
 */
package io.kebblar.petstore.api.utils;

import org.junit.Test;
import io.kebblar.petstore.api.service.AnuncioServiceImpl;

/**
 * <p>LimpiaTest class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
public class LimpiaTest {

    /**
     * <p>pba.</p>
     */
    @Test
    public void pba() {
        prueba("hola",
                "hola");

        prueba("ñ",
                "n");

        prueba("       gús ta  v&o   lanñd o",
               "gus-ta-v-o-lannd-o");

        prueba("",
               "");

        prueba("           ",
               "");

        prueba("      ñ    ñ    ",
               "n-n");

        prueba("       &",
               "-");

        prueba("      $   $    ",
               "-");

        prueba("       áéíóúñ   ",
               "aeioun");

        prueba("      ÁÉÍÓÚÑ     ",
               "aeioun");

        prueba("      ÁÉÍ ÓÚÑ     ",
               "aei-oun");
    }

    private void prueba(String cadena, String esperada) {
        String result = AnuncioServiceImpl.limpia(cadena);
        boolean test = esperada.equals(result);
        if(!test) {
            System.out.println(cadena);
            System.out.println(result);
        }
        assert(test);
    }
}
