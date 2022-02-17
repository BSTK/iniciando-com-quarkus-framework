package dev.bstk;

import org.eclipse.microprofile.context.ManagedExecutor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
@Path("/dados-consulta")
public class DadosConsultaResource {

    @Inject
    protected ManagedExecutor managedExecutor;

    @Inject
    protected DadosConsultaService dadosConsultaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Response> consulta() {
        CompletionStage<Response> completionStage = new CompletableFuture<>();

        managedExecutor.submit(() -> {
            Map<String, Object> dados = Map.of(
                "conta", dadosConsultaService.conta(),
                "saldo", dadosConsultaService.saldo(),
                "dadosPessoais", dadosConsultaService.dadosPessoais());

            Response response = Response
                .status(Response.Status.OK)
                .entity(dados)
                .build();

            ((CompletableFuture) completionStage).complete(response);
        });

        return completionStage;
    }

    @GET
    @Path("/conta")
    @Produces(MediaType.APPLICATION_JSON)
    public void conta(@Suspended final AsyncResponse async) {
        managedExecutor.submit(() -> {
            Response response = Response
                .status(Response.Status.OK)
                .entity(dadosConsultaService.conta())
                .build();

            async.resume(response);
        });
    }

}
