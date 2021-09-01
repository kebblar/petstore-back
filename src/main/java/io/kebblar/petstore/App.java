/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.config
 * Modulo:      petstore
 * Tipo:        clase
 * Autor:       Gustavo Adolfo Arellano Sandoval (garellanos)
 * Fecha:       31 de agosto 2021
 * Version:     0.0.2-SNAPSHOT
 * .
 * Clase encargada de ...
 */
package io.kebblar.petstore;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("io.kebblar.petstore.api.mapper")
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        logger.info("Iniciando contexto de Spring, by Goose");
        SpringApplication.run(App.class, args);
    }
}