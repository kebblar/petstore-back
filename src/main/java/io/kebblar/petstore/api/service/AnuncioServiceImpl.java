package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.AnuncioImagenResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("anuncioService")
public class AnuncioServiceImpl implements AnuncioService {

    @Override
    public DetalleAnuncioResponse detalleAnuncio(int id) throws BusinessException {

        if (id == 1) {
            List<AnuncioImagenResponse> l1 = new ArrayList<>();
            l1.add(new AnuncioImagenResponse(1, id, "f59b0c41-c534-47d9-afb9-7c5230b9767f.png", "camaleon 1"));
            l1.add(new AnuncioImagenResponse(4, id, "22c84708-a3e6-4486-8b04-3221f71b8e38.png", "camaleon 2"));

            DetalleAnuncioResponse d1 = new DetalleAnuncioResponse();
            d1.setId(id);
            d1.setTitulo("Camaleon de velo macho 15 cm");
            d1.setImagenes(l1);
            d1.setPrecio(new BigDecimal("459.03"));

            return d1;
        }
            List<AnuncioImagenResponse> l2 = new ArrayList<>();
            l2.add(new AnuncioImagenResponse(1,id, "22c84708-a3e6-4486-8b04-3221f71b8e38.png", "bicho 1"));

            DetalleAnuncioResponse d2 = new DetalleAnuncioResponse();
            d2.setTitulo("Perro pastor aleman de 4 meses");
            d2.setId(id);
            d2.setPrecio(new BigDecimal("2300.8"));
            d2.setImagenes(l2);

            return d2;
    }
}
