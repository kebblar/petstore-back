/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   GraficasMontoCategoriaMapper.java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Cloudstore
 * Fecha:       17 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.GraficasMontoCategoria;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad OrdenCompra
 *
 * @author Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see DatosOrden
 */
@Repository
public interface GraficasMontoCategoriaMapper {

    static final String Campos_Grafica = "orden.cve_orden_compra, orden.importe_total, orden.fecha_hora_comprar, anuncio.id_categoria";
    
    @Select("SELECT " + Campos_Grafica + " FROM petstore.orden_compra as orden\n" + 
    		"inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra\n" + 
    		"inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio;")
    List<GraficasMontoCategoria> getAll() throws SQLException ;

}