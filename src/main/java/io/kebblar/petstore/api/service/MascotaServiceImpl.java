/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      MascotaServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:46:52
 */
package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.model.domain.Criterio;
import io.kebblar.petstore.api.model.domain.Mascota;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.MascotaService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Mascota
 * @see     io.kebblar.petstore.api.service.MascotaService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service
public class MascotaServiceImpl implements MascotaService {


    /**
     * <p>Constructor for MascotaServiceImpl.</p>
     */
    public MascotaServiceImpl() {
    }

    /** {@inheritDoc} */
    @Override
    public List<Mascota> getAll() throws BusinessException {
        Mascota mascota1 = new Mascota(1, "Perico", "Ave parlanchina");
        Mascota mascota2 = new Mascota(2, "Perro", "Perro Mordelón");
        List<Mascota> lista = new ArrayList<>();
        lista.add(mascota1);
        lista.add(mascota2);
        return lista;
    }

    /** {@inheritDoc} */
    @Override
    public List<Integer> getByCriteria(List<Criterio> criterios) {
        List<Integer> lista = new ArrayList<>();
        lista.add(6);
        lista.add(2);
        lista.add(7);
        return lista;
    }

    /** {@inheritDoc} */
    @Override
    public Mascota getById(int id) throws BusinessException {
        Mascota mascota = new Mascota(id, "Perico", "Ave parlanchina");
        return mascota;
    }

    /** {@inheritDoc} */
    @Override
    public int insert(Mascota mascota) {
        return 172;
    }

    /** {@inheritDoc} */
    @Override
    public int update(Mascota mascota) {
        return 321;
    }

    /** {@inheritDoc} */
    @Override
    public int delete(int id) {
        return id;
    }

    /** {@inheritDoc} */
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

}
