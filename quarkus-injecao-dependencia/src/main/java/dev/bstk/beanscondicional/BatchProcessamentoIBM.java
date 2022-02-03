package dev.bstk.beanscondicional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class BatchProcessamentoIBM implements Batch {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchProcessamentoIBM.class);

    @Override
    public void processar(Map<String, Object> parametros) {
        LOGGER.info("[ BatchProcessamentoIBM ] - Processado");
    }

}
