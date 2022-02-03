package dev.bstk;

import dev.bstk.eventos.EventoNovoUsuarioCriado;
import dev.bstk.eventos.EventoProtocoloAlterado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.UUID;

@RequestScoped
@Path("/eventos")
public class EventoResource {

    protected static final Logger LOGGER = LoggerFactory.getLogger(EventoResource.class);

    @Inject
    protected BeanManager manager;

    @GET
    @Path("/sync")
    @Produces(MediaType.TEXT_PLAIN)
    public Response okSync() {
        manager.fireEvent(new EventoNovoUsuarioCriado(
            "usuario-a@gmail.com",
            "UsuarioAA",
            LocalDateTime.now()
        ));

        manager.fireEvent(new EventoProtocoloAlterado(
            UUID.randomUUID().toString(),
            "Adicionando endereço ao protocolo"
        ));

        manager.fireEvent(new EventoProtocoloAlterado(
            UUID.randomUUID().toString(),
            "Removendo data expiração"
        ));

        return Response.ok("OK-SYNC").build();
    }

    @GET
    @Path("/async")
    @Produces(MediaType.TEXT_PLAIN)
    public Response okAsync() {
        manager
            .getEvent()
            .fireAsync(new EventoNovoUsuarioCriado(
                "usuario-aync@gmail.com",
                "UsuarioAA-ASYNC",
                LocalDateTime.now()
            ));

        manager
            .getEvent()
            .fireAsync(new EventoProtocoloAlterado(
                UUID.randomUUID().toString(),
                "ASYNC - Encerrando protocolo"
            ));

        manager
            .getEvent()
            .fireAsync(new EventoProtocoloAlterado(
                UUID.randomUUID().toString(),
                "ASYNC - Repriorizando protocolo"
            ));

        return Response.ok("OK-ASYNC").build();
    }

}
