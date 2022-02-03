package dev.bstk.beanscondicional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class BatchProcessamentoOCI implements Batch {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchProcessamentoOCI.class);

    @Override
    public void processar(Map<String, Object> parametros) {
        LOGGER.info("[ BatchProcessamentoOCI ] - Processado");
        LOGGER.info("[ BatchProcessamentoOCI ] - Processado");
    }

}
