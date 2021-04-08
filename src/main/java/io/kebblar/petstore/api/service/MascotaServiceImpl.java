package io.kebblar.petstore.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.Criterio;
import io.kebblar.petstore.api.model.Mascota;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Override
    public List<Mascota> getAll() throws BusinessException {
        return null;
    }

    @Override
    public List<Integer> getPetsByCriteria(List<Criterio> criterios) {
        return null;
    }

    @Override
    public Mascota getMascota(int id) throws BusinessException {
        Mascota mascota = new Mascota(id, "Perico", "Ave parlanchina");
        return mascota;
    }

    @Override
    public int insertaMascota(Mascota mascota) {
        return 172;
    }

}
