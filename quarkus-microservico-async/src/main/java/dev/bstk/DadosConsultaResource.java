package dev.bstk;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@ApplicationScoped
@Path("/dados-consulta")
public class DadosConsultaResource {

    @Inject
    protected DadosConsultaService dadosConsultaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response consulta() {
        Map<String, Object> dados = Map.of(
            "conta", dadosConsultaService.conta(),
            "saldo", dadosConsultaService.saldo(),
            "dadosPessoais", dadosConsultaService.dadosPessoais());

        return Response
            .status(Response.Status.OK)
            .entity(dados)
            .build();
    }

}
