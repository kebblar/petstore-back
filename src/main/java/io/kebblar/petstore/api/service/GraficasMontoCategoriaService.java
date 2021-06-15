/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   GraficasMontoCategoriaService.java
 * Tipo:        interface
 * AUTOR:       Cloudstore
 * Fecha:       15 de Junio de 2021 (16_00)
 *
 * Historia:    .
 *              20210615_1600 Creación
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.domain.GraficasMontoCategoria;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

public interface GraficasMontoCategoriaService {
	/**
	   * <p>Método utilizado para consultar los datos para generar la gráfica montos por categoría
	   * 
	   * @param Objeto de tipo {@link GraficasMontoCategoria} con la información para la gráfica.
	   * @throws BusinessException
	   */
	List<GraficasMontoCategoria> getAll() throws BusinessException;

}
