package io.kebblar.petstore.api.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.Calculadora;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraTest {
    @Test
    public void pba() {
        Calculadora c = new Calculadora();
        int r = c.sum(2, 3);
        assert (r == 5);
    }

}
