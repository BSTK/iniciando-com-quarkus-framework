package dev.bstk.resource;

import io.quarkus.runtime.configuration.ProfileManager;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    @ConfigProperty(
        name = "quarkus.application.name",
        defaultValue = "NOME_APP_DEFAULT")
    protected String nomeAplicacao;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var profileAtivo = ProfileManager.getActiveProfile();
        var caminhoAplicacao = ConfigProvider
            .getConfig()
            .getConfigValue("quarkus.resteasy.path")
            .getRawValue();

        LOGGER.info("profileAtivo = [ {} ]", profileAtivo);
        LOGGER.info("caminhoAplicacao = [ {} ]", caminhoAplicacao);

        return String.format("Hello RESTEasy: %s", nomeAplicacao);
    }
}
