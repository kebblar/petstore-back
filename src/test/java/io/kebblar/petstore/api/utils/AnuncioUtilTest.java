package io.kebblar.petstore.api.utils;

import org.junit.Test;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class AnuncioUtilTest {

    @Test
    public void generaFolioTest () {
        assert(AnuncioUtil.generaFolio().matches("[0-9]{14}"));
    }
    
    private Date calc(LocalDate valor) {
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = valor.atStartOfDay(systemTimeZone);
        return Date.from(zonedDateTime.toInstant());
    }

    @Test
    public void validaFechasTest() {
        Date inicio = calc(LocalDate.now().plusMonths(2));
        Date fin = calc(LocalDate.now().plusMonths(3));
        assert(AnuncioUtil.validaFechasPeriodo(inicio,fin));
        assert(!AnuncioUtil.validaFechasPeriodo(fin,inicio));
        assert(AnuncioUtil.validaFechasPeriodo(null, null));
        inicio = calc(LocalDate.now().minusMonths(3));
        fin = calc(LocalDate.now().minusMonths(2));
        assert(!AnuncioUtil.validaFechasPeriodo(inicio,fin));
    }

    @Test
    public void comparaFechasTest() {
        Date inicio = calc(LocalDate.now());
        Date fin = calc(LocalDate.now().plusMonths(1));
        assert (AnuncioUtil.comparafechas(inicio,fin)!=0);
        inicio = fin;
        assert (AnuncioUtil.comparafechas(inicio,fin)==0);
    }

}
