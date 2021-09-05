/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CodeGeneratorTest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:39:13
 */
package io.kebblar.petstore.api.utils;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.ultrasist.ci.generator.GenCode;
import mx.com.ultrasist.ci.generator.model.Entidad;

/**
 * <p>CodeGeneratorTest class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
public class CodeGeneratorTest {
    private static Log logger = LogFactory.getLog(CodeGeneratorTest.class);

    /**
     * <p>main.</p>
     *
     * @param args a {@link java.lang.String} object.
     * @throws java.io.IOException if any.
     */
    public static void main(String... args) throws IOException {
        new CodeGeneratorTest();
    }

    /**
     * <p>Constructor for CodeGeneratorTest.</p>
     *
     * @throws java.io.IOException if any.
     */
    public CodeGeneratorTest() throws IOException {
        List<Entidad> listaCompleta =  GenCode.pop(
                "jdbc:mariadb://localhost:3306/petstore",
                "garellano",
                "garellano",
                "org.mariadb.jdbc.Driver");
        String[] seleccionTablas = {"usuario_completo"};
        go(seleccionTablas, listaCompleta);
    }

    private void doit(GenCode codeGenerator) {
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/Template.java.vm", "model"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateController.java.vm", "controller"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateMapper.java.vm", "mapper"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateService.java.vm", "service"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateServiceImpl.java.vm", "service"));
        logger.info("**************************************************************");
    }

    private void go(String[] tablas, List<Entidad> lista) throws IOException {
        //logger.info("Mostrando la lista total de tablas a procesar");
        //for (Entidad entity : lista) {
            //String jsonString = mapper.writeValueAsString(entity);
            //logger.info(entity.getTableCat());
            //logger.info(jsonString);
        //}

        logger.info("Creando mapper para json conversion");
        ObjectMapper mapper = new ObjectMapper();

        String all = mapper.writeValueAsString(lista);
        logger.info(all);

        List<Entidad> obj = mapper.readValue(all, new TypeReference<List<Entidad>>(){});
        List<Entidad> seleccion = GenCode.filter(obj, tablas);

        logger.info("Procesando sólo las tablas seleccionadas");
        for (Entidad entity : seleccion) {
            GenCode genCode = new GenCode(entity);
            this.doit(genCode);
            logger.info("-----------------------------------------------------------");
        }
        logger.info("Imprimiendo la seleccion en modo económico");
        logger.info(lista);
    }

}

/*
    String:1
    int:4
    short:5
    double:6
    float:7
    double:8

java.math.BigDecimal:2
java.math.BigDecimal:3
*/
