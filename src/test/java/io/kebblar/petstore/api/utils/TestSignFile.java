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
 * Nombre:      TestSignFile
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:39:48
 */
package io.kebblar.petstore.api.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * <p>TestSignFile class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class TestSignFile {

    /**
     * <p>Test.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void Test() throws Exception{
        String currentDirectory = System.getProperty("user.dir");
        Signer firmador =  new Signer(currentDirectory + "/src/main/resources/keys/ok.key",
                currentDirectory + "/src/main/resources/keys/ok.cer",
                currentDirectory + "/upload/DO_NOT_DELETE.txt");
        String signedPdf = firmador.signPdf();
        String hashPdfOriginal = firmador.verifySignature(signedPdf);
        String hashPdfCalculated = firmador.createSum(currentDirectory + "/upload/DO_NOT_DELETE.txt");
        assert(hashPdfOriginal.equals(hashPdfCalculated));
    }
}
