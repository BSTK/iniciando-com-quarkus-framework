package dev.bstk;

import dev.bstk.producer.ConverterString;
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
@Path("/producer")
public class ProducerResource {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ProducerResource.class);

    @Inject
    @Named("converterStringByte")
    protected ConverterString<Byte> converterStringByte;

    @Inject
    @Named("converterStringArray")
    protected ConverterString<String[]> converterStringArray;

    @Inject
    @Named("converterStringInteger")
    protected ConverterString<Integer> converterStringInteger;

    @Inject
    @Named("converterStringArrayHifen")
    protected ConverterString<String[]> converterStringArrayHifen;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ok() {
        LOGGER.info("converterStringByte('AAQ') = [ {} ]", converterStringByte.converter("9"));
        LOGGER.info("[ {} ]", converterStringByte.descricao());
        System.out.println("\n");

        LOGGER.info("converterStringInteger('10') = [ {} ]", converterStringInteger.converter("10"));
        LOGGER.info("[ {} ]", converterStringInteger.descricao());
        System.out.println("\n");

        LOGGER.info("converterStringArray('AAQ 1_000 DDD') = [ {} {} {} ]", (Object[]) converterStringArray.converter("AAQ 1_000 DDD"));
        LOGGER.info("[ {} ]", converterStringArray.descricao());
        System.out.println("\n");

        LOGGER.info("converterStringArray('BBB-CCC-DD10') = [ {} {} {} ]", (Object[]) converterStringArrayHifen.converter("BBB-CCC-DD10"));
        LOGGER.info("[ {} ]", converterStringArrayHifen.descricao());
        System.out.println("\n");

        return "OK";
    }
}
