package dev.bstk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/autores")
@Produces(MediaType.TEXT_PLAIN)
public class AutoresResource {

    final String[] autoresFiccaoCientifica = {
        "Jules Verne (1828-1905)",
        "Aldous Huxley (1894-1963)",
        "Arthur C. Clarke (1917-2008)",
        "Isaac Asimov (1920-1992)",
        "HG Wells (1866-1946)",
        "George Orwell (1903-1950)",
        "Geoffrey Hoyle (1941 – presente)",
        "Philip K. Dick (1928-1982)",
        "Douglas Adams (1952-2011)"
    };

    @GET
    public Response autoresFiccaoCientifica() {
        return Response
            .ok(String.join("\n", autoresFiccaoCientifica))
            .build();
    }

    @GET
    @Path("/{index}")
    public Response autoresFiccaoCientifica(@PathParam("index") final int index) {
        if (index < 0 || index > autoresFiccaoCientifica.length) {
            return Response
                .status(Status.BAD_REQUEST)
                .build();
        }

        return Response
            .ok(autoresFiccaoCientifica[index])
            .build();
    }
}
