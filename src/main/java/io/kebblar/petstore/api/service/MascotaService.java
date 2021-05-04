/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      Mascota
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_50)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio asociado a la entidad 'mascota'. 
 *
 * Historia:    .
 *              20210521_0950 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.Criterio;
import io.kebblar.petstore.api.model.domain.Mascota;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * Interfaz que define los métodos de negocio asociados a la entidad
 * de dominio "Mascota"
 *
 * @author garellano
 */
public interface MascotaService {

    /**
     * <p>Retorna un objeto de tipo mascota cuyo ID es igual al paraámetro dado.
     *
     * @param id Identificador (llave) del objeto de tipo "Mascota".
     * @return Objeto de tipo "Mascota"
     * @throws BusinessException
     */
    Mascota getById(int id) throws BusinessException;

    /**
     * <p>Retorna una lista de objetos de tipo "Mascota" que contiene
     * la totalidad de objetos existentes en la base de datos.
     *
     * @return Lista de objetos de tipo "Mascota".
     * @throws BusinessException
     */
    List<Mascota> getAll() throws BusinessException;

    /**
     * <p>Retorna una lista de enteros que representan los ID's de
     * las mascotas que satisfacen los criterios definidos en el
     * objeto "criterios".
     *
     * @param criterios Lista de objetos de tipo "Criterio"
     * @return Lista de enteros
     */
    List<Integer> getByCriteria(List<Criterio> criterios);

    /**
     * <p>Inserta en la base un objeto de tipo "Mascota".
     *
     * @param mascota Objeto de tipo Mascota en donde el ID no es envado.
     * @return Retorna el ID de la mascota insertada.
     */
    int insert(Mascota mascota);

    /**
     * <p>Actualiza en la base un objeto de tipo "Mascota".
     *
     * @param mascota Objeto de tipo Mascota en donde el ID es la llave en la base de datos.
     * @return Retorna el ID de la mascota a ser actualizada.
     */
    int update(Mascota mascota);

    /**
     * <p>Elimina en la base un objeto de tipo "Mascota".
     * @param id Identificador de la mascota a ser eliminada de la base de datos.
     *
     * @return Retorna el ID de la mascota que fué eliminada.
     */
    int delete(int id);

    /**
     * <p>Retorna la suma de dos enteros
     *
     * @param a primer entero
     * @param b segundo entero
     * @return suma de los enteros dados
     */
    int suma(int a, int b);
}
