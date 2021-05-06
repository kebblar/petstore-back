/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      Estado
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Estado 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * <p>Descripción:</p>
 * Interface 'ContadorMapper' MyBatis asociado a la entidad Contador 
 *
 * @author Gustavo A. Arellano
 * @see     io.kebblar.petstore.api.mapper.ContadorMapper
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface ContadorMapper {
	
	/**
     * Obtiene una lista de registros para contador de registros en la tabla.
     *
     * @return Lista de total de registros en la tabla enviada como parametro.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Select("SELECT table_rows FROM information_schema.tables WHERE table_schema = #{databaseName} AND table_name = #{tableName}") 
    int getTableCount(String databaseName, String tableName) throws SQLException;

}
