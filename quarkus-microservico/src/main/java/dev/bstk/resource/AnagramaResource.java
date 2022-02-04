package dev.bstk.resource;

import dev.bstk.resource.request.AnagramaRequest;
import dev.bstk.resource.response.AnagramaResponse;
import dev.bstk.service.AnagramaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/anagramas")
public class AnagramaResource {

    @Inject
    protected AnagramaService anagramaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{nome:[a-zA-Z]*}/anagrama")
    public AnagramaResponse anagrama(@PathParam("nome") final String nome) {
        return anagramaService.obterAnagrama(nome);
    }

    @POST
    @Path("/novo-anagrama")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AnagramaResponse anagrama(final AnagramaRequest request) {
        return anagramaService.novoAnagrama(request);
    }

}
