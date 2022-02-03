package dev.bstk;

import dev.bstk.beanscondicional.Batch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@RequestScoped
@Path("/profile")
public class BatchResource {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BatchResource.class);

    @Inject
    protected Batch batch;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response ok() {
        batch.processar(Map.of("PARAM_QUANTIDADE", 10));
        return Response.ok("OK").build();
    }

}
