package dev.bstk.eventos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;

public class EventoListenerNovoUsuarioCriado {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventoListenerNovoUsuarioCriado.class);

    public void handlerSync(@Observes EventoNovoUsuarioCriado evento) {
        LOGGER.info("** SYNC - EventoListenerProtocoloAlterado **");
        LOGGER.info("Evento: [ EventoNovoUsuarioCriado ]");
        LOGGER.info("Dados: [ {} ]", evento);

        System.out.println("\n");
    }

    public void handlerAsync(@Observes EventoNovoUsuarioCriado evento) {
        LOGGER.info("** ASYNC - EventoListenerProtocoloAlterado **");
        LOGGER.info("Evento: [ EventoNovoUsuarioCriado ]");
        LOGGER.info("Dados: [ {} ]", evento);

        System.out.println("\n");
    }
}
