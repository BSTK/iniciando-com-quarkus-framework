package dev.bstk.config.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.interceptor.Interceptor;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Provider
@Priority(Interceptor.Priority.APPLICATION)
public class EscritaLeituraRequestInterceptor implements ReaderInterceptor, WriterInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(EscritaLeituraRequestInterceptor.class);

    @Override
    public void aroundWriteTo(WriterInterceptorContext interceptorContext) throws IOException, WebApplicationException {
        LOGGER.info("** EscritaLeituraRequestInterceptor [ aroundWriteTo( WriterInterceptorContext ) ] **");

        final var outputStream = interceptorContext.getOutputStream();
        final var outputStreamEncriptado = encryptPayload(outputStream);

        interceptorContext.setOutputStream(outputStreamEncriptado);
        interceptorContext.proceed();
    }

    @Override
    public Object aroundReadFrom(final ReaderInterceptorContext interceptorContext) throws IOException, WebApplicationException {
        LOGGER.info("** EscritaLeituraRequestInterceptor [ aroundReadFrom( ReaderInterceptorContext ) ] **");

        final var inputStream = interceptorContext.getInputStream();
        final var inputStreamDecriptado = decryptPayload(inputStream);
        interceptorContext.setInputStream(inputStreamDecriptado);

        return interceptorContext.proceed();
    }

    /// TODO: LÓGICA PARA ENCRIPTAR DADOS
    public OutputStream encryptPayload(final OutputStream stream) { return stream; }

    /// TODO: LÓGICA PARA DEENCRIPTAR DADOS
    public InputStream decryptPayload(final InputStream inputStream){ return inputStream; }

}
