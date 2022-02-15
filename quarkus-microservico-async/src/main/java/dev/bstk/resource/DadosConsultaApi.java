package dev.bstk.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dados-consulta")
public class DadosConsultaApi {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String consulta() {
        return "Dados Consulta Api";
    }

}
