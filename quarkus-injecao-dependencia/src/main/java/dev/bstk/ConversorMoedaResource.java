package dev.bstk;

import dev.bstk.dtos.Resultado;
import dev.bstk.producer.ConversorMoeda;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@RequestScoped
@Path("/conversor-moeda")
public class ConversorMoedaResource {

    @Inject
    @Named("ConversorRealDolar")
    protected ConversorMoeda conversorRealDolar;

    @Inject
    @Named("ConversorRealEuro")
    protected ConversorMoeda conversorRealEuro;

    @Inject
    @Named("ConversorRealPeso")
    protected ConversorMoeda conversorRealPeso;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok() {
        return Response
            .status(Response.Status.OK)
            .entity(Arrays.asList(
                new Resultado(conversorRealDolar),
                new Resultado(conversorRealEuro),
                new Resultado(conversorRealPeso)
            ))
            .build();
    }

}
