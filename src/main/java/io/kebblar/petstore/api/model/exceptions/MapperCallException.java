package io.kebblar.petstore.api.model.exceptions;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapperCallException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    private static final Logger logger = LoggerFactory.getLogger(MapperCallException.class);

    public MapperCallException(String shortMessage, String technicalDescription) {
        super(
            shortMessage,
            buildMessage(technicalDescription),
            4001,
            "CVE_4001",
            HttpStatus.BAD_REQUEST);
    }

    private static String buildMessage(String technicalDescription) {
        String uid = UUID.randomUUID().toString();
        logger.error("UID:: " + technicalDescription);
        return "Codigo de error: " + uid;
    }
}
