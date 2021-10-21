package io.kebblar.petstore.api.utils;
import io.kebblar.petstore.api.utils.AnuncioUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class AnuncioUtilTest {

    @Test
    public void generaFolioTest () {
        assert(AnuncioUtil.generaFolio().matches("[0-9]{14}"));
    }

    @Test
    public void validaFechasTest() {
        Date inicio = java.sql.Date.valueOf(LocalDate.now().plusMonths(2));
        Date fin = java.sql.Date.valueOf(LocalDate.now().plusMonths(3));
        assert(AnuncioUtil.validaFechasPeriodo(inicio,fin));
        assert(!AnuncioUtil.validaFechasPeriodo(fin,inicio));
        assert(AnuncioUtil.validaFechasPeriodo(null, null));
        inicio = java.sql.Date.valueOf(LocalDate.now().minusMonths(3));
        fin = java.sql.Date.valueOf(LocalDate.now().minusMonths(2));
        assert(!AnuncioUtil.validaFechasPeriodo(inicio,fin));
    }

    @Test
    public void comparaFechasTest() {
        Date inicio = java.sql.Date.valueOf(LocalDate.now());
        Date fin = java.sql.Date.valueOf(LocalDate.now().plusMonths(1));
        assert (AnuncioUtil.comparafechas(inicio,fin)!=0);
        inicio = fin;
        assert (AnuncioUtil.comparafechas(inicio,fin)==0);
    }

}
