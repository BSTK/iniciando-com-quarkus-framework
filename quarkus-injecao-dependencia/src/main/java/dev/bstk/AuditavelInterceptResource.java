package dev.bstk;

import dev.bstk.aop.Auditavel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/intercept")
public class AuditavelInterceptResource {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AuditavelInterceptResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response ok() {
        executarLogica();
        executarLogica();
        executarLogicaOK();
        executarLogicaOK();
        return Response.ok("OK").build();
    }

    @Auditavel
    public void executarLogica() {
        LOGGER.info("** AuditavelInterceptResource **");
        LOGGER.info("[ executarLogica ]");
    }

    @Auditavel
    public String executarLogicaOK() {
        LOGGER.info("** AuditavelInterceptResource **");
        LOGGER.info("[ executarLogica ]");
        return "Valor Retornado = executarLogicaOK()";
    }
}
