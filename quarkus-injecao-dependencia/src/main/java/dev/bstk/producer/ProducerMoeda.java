package dev.bstk.producer;

import dev.bstk.producer.moedas.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

public class ProducerMoeda {

    @Produces
    @Dependent
    @Named("conversorReal")
    public ConversorMoeda conversorReal() {
        return new ConversorMoedaReal();
    }

    @Produces
    @RequestScoped
    @Named("conversorDolar")
    public ConversorMoeda conversorDolar() {
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
}
