/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Mascota.java
 * Tipo:        clase
 * AUTOR:       Edgar Uribe (EU)
 * Fecha:       Martes 04 de Mayo del 2021 (09 10)
 *
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TablasContador;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
/**
 * <p>Definición de la interfaz de servicios para 'Contador'.
 * 
 * @author  edgarum
 * @see     
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface ContadorService {
    /**
     * <p>Crea un objeto de tipo {@link int} sin ningun parametro de entrada.
     * 
     * @param void.
     * @return Objeto de tipo {@link int} que es creado.
     * @throws BusinessException
     */
    int getUsuarioDetalleCounter() throws BusinessException;
   
    /**
     * <p>Crea un objeto de tipo {@link int} sin ningun parametro de entrada.
     * 
     * @param void.
     * @return Objeto de tipo {@link int} que es creado.
     * @throws BusinessException
     */
    int getUsuarioCounter() throws BusinessException;
    
    /**
     * <p>Crea un objeto de tipo {@link int} sin ningun parametro de entrada.
     * 
     * @param void.
     * @return Objeto de tipo {@link int} que es creado.
     * @throws BusinessException
     */
    int getPaisCounter() throws BusinessException;
    
    /**
     * <p>Crea un objeto de tipo {@link int} sin ningun parametro de entrada.
     * 
     * @param void.
     * @return Objeto de tipo {@link int} que es creado.
     * @throws BusinessException
     */
    int getEstadoCounter() throws BusinessException;
    
    /**
     * <p>Crea un objeto de tipo {@link int} sin ningun parametro de entrada.
     * 
     * @param void.
     * @return Objeto de tipo {@link int} que es creado.
     * @throws BusinessException
     */
    int getMunicipioCounter() throws BusinessException;

    /**
     * <p>Crea un objeto de tipo {@link Integer} tomando como parametro una cadena.
     * 
     * @param Objeto de tipo {@link String} con la información de la tabla requerida.
     * @return Objeto de tipo {@link Integer} que es creado.
     * @throws BusinessException
     */
    Integer getTableCounter(String tabla) throws BusinessException;
    
    /**
     * <p>Crea un objeto de tipo {@link String} recibiendo como parametro un objeto de tipo tablasContador.
     * 
     * @param Objeto de tipo {@link TablasContador} con la información de la tabla requerida.
     * @return Objeto de tipo {@link String} que es creado.
     * @throws BusinessException
     */
    String getTableCounter2(TablasContador contador) throws BusinessException;
}
