/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ContadorMapper.java
 * Tipo:        interface
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_29)
 *
 * Historia:    .
 *              20210506_0929 Creación de éste Mapper
 *
 */

package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Contador'.
 *
 * @author  luz
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface ContadorMapper {
    @Select("SELECT table_rows FROM information_schema.tables WHERE table_schema = #{databaseName} AND table_name = #{tableName}")
    int getTableCount(String databaseName, String tableName) throws SQLException;

}
