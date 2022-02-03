package dev.bstk.producer;

import dev.bstk.producer.moedas.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

public class ProducerMoeda {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerMoeda.class);

    @Produces
    @Dependent
    @Named("conversorReal")
    public ConversorMoeda conversorReal() {
        LOGGER.info("@Produce [ conversorReal ]");
        return new ConversorMoedaReal();
    }

    @Produces
    @RequestScoped
    @Named("conversorDolar")
    public ConversorMoeda conversorDolar() {
        LOGGER.info("@Produce [ conversorDolar ]");
        return new ConversorMoedaDolar();
    }

    @Produces
    @ApplicationScoped
    @Named("conversorEuro")
    public ConversorMoeda conversorEuro() {
        return new ConversorMoedaEuro();
    }

    @Produces
    @Singleton
    @Named("conversorPeso")
    public ConversorMoeda conversorPeso() {
        return new ConversorMoedaPeso();
    }

    public void disposeConversorMoeda(@Disposes ConversorMoeda conversorMoeda) {
        LOGGER.warn("@Disposes [ conversorMoeda ]");
    }

}
