/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      AdministracionComprasService
 * Tipo:        interface
 * Autor:       Luis Martinez
 * Fecha:       Jueve 10 de junio del 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface para el servicio asociado a la entidad 'AdministracionCompras'.
 *
 * Historia:    .
 *              20210421_0935 Generado por LMtz
 *              20210610_0935 Actualizado por LMtz
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.AdministracionCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'AdministracionCompras'.
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
public interface AdministracionComprasService {

    /**
     * Método utilizado para obtener todas las compras hechas por los usuario.
     *
     * @return Lista de compras hechas por todos los usuarios.
     * @throws BusinessException es disparada por una regla de negocio.
     */
    List<AdministracionCompras> getAll() throws BusinessException;

    /**
     * Método utilizado para actualizar el estado de una compra.
     *
     * @param int estadoEnvio, el nuevo estado que queremos colocar.
     * @param String cveCompra, el cveCompra de la compra que queremos actualizar.
     * @return String que contiene un JSON que indica si todo salio bien o no.
     * @throws BusinessException es disparada por una regla de negocio
     */
    String sent(int estadoEnvio, String cveCompra) throws BusinessException;
}
