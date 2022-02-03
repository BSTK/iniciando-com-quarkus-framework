package dev.bstk;

import dev.bstk.dtos.Resultado;
import dev.bstk.producer.moedas.ConversorMoedaDolar;
import dev.bstk.producer.moedas.ConversorMoedaPeso;
import dev.bstk.producer.moedas.ConversorMoedaReal;
import dev.bstk.producer.moedas.Moeda;
import dev.bstk.producer.qualifier.Qualifiers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    @Qualifiers.Real
    protected ConversorMoedaReal conversorMoedaReal;

    @Inject
    @Qualifiers.Peso
    protected ConversorMoedaPeso conversorMoedaPeso;

    @Inject
    @Qualifiers.Dolar
    protected ConversorMoedaDolar conversorMoedaDolar;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok() {
        var realParaEuro = new Resultado(conversorMoedaReal.de(), Moeda.EURO, conversorMoedaReal.converter(Moeda.EURO, 10.9));
        var dolarParaEuro = new Resultado(conversorMoedaDolar.de(), Moeda.EURO, conversorMoedaDolar.converter(Moeda.EURO, 10.9));
        var pesoParaEuro = new Resultado(conversorMoedaPeso.de(), Moeda.EURO, conversorMoedaPeso.converter(Moeda.EURO, 10.9));

        return Response
            .status(Response.Status.OK)
            .entity(Arrays.asList(
                realParaEuro,
                dolarParaEuro,
                pesoParaEuro
            ))
            .build();
    }

}
