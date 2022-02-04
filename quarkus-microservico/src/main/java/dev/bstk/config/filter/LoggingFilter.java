package dev.bstk.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Provider
@Priority(1)
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        LOGGER.info("** LoggingFilter.filter(ContainerRequestContext) **");

        final var inputStream = new BufferedInputStream(requestContext.getEntityStream());
        final var inputContent = new byte[inputStream.available()];
        final var read = inputStream.read(inputContent);

        final var dados = new String(inputContent, StandardCharsets.UTF_8);

        LOGGER.info("Dados = [ {} ]", dados);
        LOGGER.info("Tamanho bytes lidos = [ {} ]", read);
        LOGGER.info("Tamanho mensagem = [ {} ]", inputContent.length);

        requestContext.setEntityStream(new ByteArrayInputStream(inputContent));
    }

    @Override
    public void filter(final ContainerRequestContext requestContext,
                       final ContainerResponseContext responseContext) {
        LOGGER.info("** LoggingFilter.filter(ContainerRequestContext, ContainerResponseContext) **");

        LOGGER.info("UriInfo    = [ {} ]", requestContext.getUriInfo());
        LOGGER.info("Method     = [ {} ]", requestContext.getMethod());
        LOGGER.info("MediaType  = [ {} ]", requestContext.getMediaType());
        LOGGER.info("Entity     = [ {} ]", responseContext.getEntity());
    }
}
