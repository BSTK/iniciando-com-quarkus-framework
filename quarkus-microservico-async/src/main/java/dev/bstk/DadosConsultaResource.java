package dev.bstk;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/dados-consulta")
public class DadosConsultaResource {

    @Inject
    protected DadosConsultaService dadosConsultaService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String consulta() {
        return "Dados Consulta Api";
    }

}
