package dev.bstk;

import dev.bstk.validador.Validador;
import dev.bstk.validador.ValidadorCEP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/validadores")
public class ValidadoresResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidadoresResource.class);

    @Inject
    @Named("ValidadorCEP")
    protected Validador validadorCEP;

    @Inject
    @Named("ValidadorCPF")
    protected Validador validadorCPF;

    @Inject
    @Named("ValidadorCNPJ")
    protected Validador validadorCNPJ;

    @Inject
    protected ValidadorCEP validadorCEPII;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String validar() {
        LOGGER.info("CEP: 06824140 = [ {} ]\n", validadorCEP.valido("06824140"));
        LOGGER.info("CEP_II: 06824140 = [ {} ]\n", validadorCEPII.valido("06824140"));

        LOGGER.info("CPF: 06824104011 = [ {} ]\n", validadorCPF.valido("06824104011"));
        LOGGER.info("CNPJ: 0682410401188 = [ {} ]\n", validadorCNPJ.valido("0682410401188"));

        return "Ok";
    }
}