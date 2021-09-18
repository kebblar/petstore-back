package io.kebblar.petstore.api.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import io.kebblar.petstore.Calculadora;
import io.kebblar.petstore.api.service.HealthServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraTest {
    @Test
    public void pba() {
        Calculadora c = new Calculadora();
        int r = c.sum(2, 3);
        assert (r == 5);
    }
    @Test
    public void pba2() {
        Environment dato = null;
        HealthServiceImpl hsi = new HealthServiceImpl(dato );
        int r = hsi.max(5, 3);
        assert (r == 5);
    }
}
