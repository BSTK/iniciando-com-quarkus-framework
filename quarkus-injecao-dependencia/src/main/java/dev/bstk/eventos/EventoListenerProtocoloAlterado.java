package dev.bstk.eventos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

public class EventoListenerProtocoloAlterado {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventoListenerProtocoloAlterado.class);

    public void handlerSync(@Observes EventoProtocoloAlterado evento) {
        LOGGER.info("** SYNC - EventoListenerProtocoloAlterado **");
        LOGGER.info("Evento: [ EventoProtocoloAlterado ]");
        LOGGER.info("Dados: [ {} ]", evento);

        System.out.println("\n");
    }

    public void handlerAsync(@ObservesAsync EventoProtocoloAlterado evento) {
        LOGGER.info("** ASYNC - EventoListenerProtocoloAlterado **");
        LOGGER.info("Evento: [ EventoProtocoloAlterado ]");
        LOGGER.info("Dados: [ {} ]", evento);

        System.out.println("\n");
    }

}
