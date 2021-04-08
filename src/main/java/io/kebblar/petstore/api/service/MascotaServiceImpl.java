package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.Criterio;
import io.kebblar.petstore.api.model.Mascota;
import io.kebblar.petstore.api.model.TickerWrapper;

@Service
public class MascotaServiceImpl implements MascotaService {
    
    private RestTemplate restTemplate;

    public MascotaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Mascota> getAll() throws BusinessException {
        Mascota mascota1 = new Mascota(1, "Perico", "Ave parlanchina");
        Mascota mascota2 = new Mascota(2, "Perro", "Perro Mordelón");
        List<Mascota> lista = new ArrayList<>();
        lista.add(mascota1);
        lista.add(mascota2);
        return lista;
    }

    @Override
    public List<Integer> getByCriteria(List<Criterio> criterios) {
        List<Integer> lista = new ArrayList<>();
        lista.add(6);
        lista.add(2);
        lista.add(7);
        return lista;
    }

    @Override
    public Mascota getById(int id) throws BusinessException {
        Mascota mascota = new Mascota(id, "Perico", "Ave parlanchina");
        return mascota;
    }

    @Override
    public int insert(Mascota mascota) {
        return 172;
    }

    @Override
    public int update(Mascota mascota) {
        return 321;
    }

    @Override
    public int delete(int id) {
        return id;
    }

    @Override
    public int suma(int a, int b) {
        int res=0;
        for(int i=0; i<a; i++) {
            res++;
        }
        for(int j=0; j<b; j++) {
            res++;
        }
        return res;
    }

    @Override
    public TickerWrapper callTickerMicroservice() {
        String url = "https://api.binance.com/api/v1/ticker/24hr?symbol=ETHUSDT";
        return restTemplate.getForObject(url, TickerWrapper.class);
    }

}
