/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Modulo:      HealthService
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Jueves 2 de Abril de 2020 (22_29)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion del Servicio de informe de salud
 *
 * Historia:    .
 *              20200402_2229 Creación del tipo
 *
 */
package io.kebblar.petstore.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Interface HealthService.
 */
public interface HealthService {

    /**
     * Retorna la resultante de la ejecición de un comando del sistema operativo.
     *
     * @param data String Comando del sistema operativo
     * @return Map estructira de tipo diccionario con la resultante de la ejecución
     * @throws IOException Signals that an I/O exception has occurred.
     */
    Map<String, String> getInfo(String data) throws IOException;

    /**
     * Retorna cierto numero de lineas del log especificado por el
     * parámetro que recibe el método.
     *
     * @param last int numero de lineas del log a retornar
     *
     * @return Lista de cadenas con el numero de lineas del log
     *         determinado por el parámetro dado
     */
    List<String> getLog(int last);
}
