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
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (19_14)
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Mapper
 *
 */
package io.kebblar.petstore.api.mapper;

public interface ContadorMapper {

import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Contador 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface ContadorMapper {
    @Select("SELECT table_rows FROM information_schema.tables WHERE table_schema = #{databaseName} AND table_name = #{tableName}") 
    int getTableCount(String databaseName, String tableName) throws SQLException;

}
