package io.kebblar.petstore.api.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.service.MascotaService;
import io.kebblar.petstore.api.service.MascotaServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MascotaTest {
    private MascotaService ms = new MascotaServiceImpl();

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
