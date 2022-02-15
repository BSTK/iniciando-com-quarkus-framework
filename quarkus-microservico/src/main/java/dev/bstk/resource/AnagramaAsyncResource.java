package dev.bstk.resource;

import dev.bstk.resource.response.AnagramaResponse;
import dev.bstk.service.AnagramaService;
import org.eclipse.microprofile.context.ManagedExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/anagramas-async")
public class AnagramaAsyncResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnagramaAsyncResource.class);

    @Inject
    protected ManagedExecutor managedExecutor;

    @Inject
    protected AnagramaService anagramaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{nome:[a-zA-Z]*}/anagrama")
    public void anagrama(@Suspended final AsyncResponse response,
                         @PathParam("nome") final String nome) {
        managedExecutor.submit(() -> {
            LOGGER.info("** EXECUTANDO EM UMA TREAD DIFERENTE **");
            final var anagrama = anagramaService.obterAnagrama(nome);
            response.resume(anagrama);
        });
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{nome:[a-zA-Z]*}/anagrama-rx")
    public CompletionStage<AnagramaResponse> anagrama(@PathParam("nome") final String nome) {
        final CompletableFuture<AnagramaResponse> responseCompletableFuture = new CompletableFuture<>();

        managedExecutor.submit(() -> {
            LOGGER.info("@@ EXECUTANDO EM UMA TREAD DIFERENTE II @@");
            final var anagrama = anagramaService.obterAnagrama(nome);
            responseCompletableFuture.complete(anagrama);
        });

        return responseCompletableFuture;
    }
}
