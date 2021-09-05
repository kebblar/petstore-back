/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AdministracionComprasServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:41:12
 */
package io.kebblar.petstore.api.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.mapper.AdministracionComprasMapper;
import io.kebblar.petstore.api.model.domain.AdministracionCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'AdministracionCompras'.
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
@Service
public class AdministracionComprasServiceImpl implements AdministracionComprasService{
    private static final Logger logger = LoggerFactory.getLogger(AdministracionComprasServiceImpl.class);
    private AdministracionComprasMapper mapper;

    public AdministracionComprasServiceImpl(AdministracionComprasMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AdministracionCompras> getAll() throws BusinessException {
        try {
            return mapper.getAll();
        }catch(Exception sql) {
            logger.error(sql.getMessage());
            throw new BusinessException("error de base de datos",
                    "ocurrio un error al acceder a la base de datos",500,"500",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String sent(int estadoEnvio, String cveCompra) throws BusinessException {
        try {
            mapper.sent(estadoEnvio, cveCompra);
            return "{\"succed\": \"true\"}";
        }catch(Exception sql) {
            logger.error(sql.getMessage());
            throw new BusinessException("cve no encontrado o estado del envio invalido",
                    "ocurrio un error al actualizar el estado del envio porque el cve no existe o porque el estado envio no es valido",500,"500",
                    HttpStatus.NOT_FOUND);
        }

    }

}
