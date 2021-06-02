/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      HistorialComprasService
 * Tipo:        interface
 * Autor:       Luis Martinez
 * Fecha:       Martes 19 de mayo del 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio asociado a la entidad 'AdministracionCompras'.
 *
 * Historia:    .
 *              20210421_0935 Generado por LMtz
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'HistorialCompras'.
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
public interface HistorialComprasService {

    /**
     * Método utilizado para obtener todas las compras hechas por un usuario.
     *
     * @param int idUsuario contiene el id del usuario a buscar.
     * @return Lista de compras hechas por el usuario pasado como parametro.
     * @throws BusinessException es disparada por una regla de negocio
     */
    List<HistorialCompras> getAll(int idUsuario) throws BusinessException;

}