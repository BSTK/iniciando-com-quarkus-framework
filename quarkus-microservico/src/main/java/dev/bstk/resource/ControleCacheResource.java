package dev.bstk.resource;

import org.jboss.resteasy.annotations.cache.Cache;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

@Path("/cache")
public class ControleCacheResource {

    private static final Random RANDOM = new Random();

    @GET
    @Path("/com")
    @Cache(maxAge = 3)
    @Produces(MediaType.TEXT_PLAIN)
    public Response okCom() {
        return Response
            .status(Response.Status.OK)
            .entity("Dados Com Cache = " + RANDOM.nextInt(100))
            .build();
    }

    @GET
    @NoCache
    @Path("/sem")
    @Produces(MediaType.TEXT_PLAIN)
    public Response okSem() {
        return Response
            .status(Response.Status.OK)
            .entity("Dados Sem Cache = " + RANDOM.nextInt(100))
            .build();
    }
}
