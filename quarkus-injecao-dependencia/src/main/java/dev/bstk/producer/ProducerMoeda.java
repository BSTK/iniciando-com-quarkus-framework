package dev.bstk.producer;

import dev.bstk.producer.moedas.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

public class ProducerMoeda {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerMoeda.class);

    @Produces
    @Dependent
    public ConversorMoedaReal conversorReal(final InjectionPoint point) {
        LOGGER.info("@Produce [ conversorReal ]");
        LOGGER.info("@InjectionPoint [ Annotated: {} ]", point.getAnnotated());
        LOGGER.info("@InjectionPoint [ Bean: {} ]", point.getBean());
        LOGGER.info("@InjectionPoint [ Qualifiers: {} ]", point.getQualifiers());
        LOGGER.info("@InjectionPoint [ Type: {}]", point.getType());
        LOGGER.info("@InjectionPoint [ Member: {} ]", point.getMember());

        return new ConversorMoedaReal();
    }

    @Produces
    @RequestScoped
    public ConversorMoedaDolar conversorDolar() {
        LOGGER.info("@Produce [ conversorDolar ]");
        return new ConversorMoedaDolar();
    }

    @Produces
    @ApplicationScoped
    public ConversorMoedaEuro conversorEuro() {
        return new ConversorMoedaEuro();
    }

    @Produces
    @Singleton
    public ConversorMoedaPeso conversorPeso() {
        return new ConversorMoedaPeso();
    }

    public void disposeConversorMoeda(@Disposes ConversorMoeda conversorMoeda) {
        LOGGER.warn("@Disposes [ conversorMoeda ] = [ {} ]", conversorMoeda);
    }

}
