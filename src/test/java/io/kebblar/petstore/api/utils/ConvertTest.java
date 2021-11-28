package io.kebblar.petstore.api.utils;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ConvertTest {
    private Convert cnv = new Convert();

    @Test
    public void prueba() {
        String s = cnv.convertir(123456789);
        String toTest = "CIENTO VENTITRES MILLONES CUATROCIENTOS CINCUENTA Y SEIS MIL SETECIENTOS OCHENTA Y NUEVE";
        assertTrue(s.equals(toTest));
    }


    @Test
    public void prueba2() {
        String s = cnv.convertir(999000001);
        assertTrue(s.equals("to big"));
    }
}
