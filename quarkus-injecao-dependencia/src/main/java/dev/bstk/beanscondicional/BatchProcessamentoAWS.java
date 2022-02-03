package dev.bstk.beanscondicional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

public class BatchProcessamentoAWS implements Batch {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchProcessamentoAWS.class);

    @Override
    public void processar(Map<String, Object> parametros) {
        if (Objects.nonNull(parametros) && !parametros.isEmpty()) {
            Integer quantidade = (Integer) parametros.get("PARAM_QUANTIDADE");

            for (int i = 0; i < quantidade ; i++) {
                LOGGER.info("[ BatchProcessamentoAWS ] - Processando [ {} ]", i);
            }
        }
    }

}
