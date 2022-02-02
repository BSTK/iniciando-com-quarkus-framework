package dev.bstk.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class ProducerConversorMoeda {

    @Produces
    @RequestScoped
    @Named("ConversorRealDolar")
    public ConversorMoeda conversorRealDolar() {
        ConversorMoeda conversor = new ConversorMoeda();
        conversor.setDe(Moeda.REAL);
        conversor.setPara(Moeda.DOLAR);
        conversor.setValor(10.0);
        conversor.setDescricao("Converte Real para Dólar Americano");
        return conversor;
    }

    @Produces
    @ApplicationScoped
    @Named("ConversorRealEuro")
    public ConversorMoeda conversorRealEuro() {
        ConversorMoeda conversor = new ConversorMoeda();
        conversor.setDe(Moeda.REAL);
        conversor.setPara(Moeda.EURO);
        conversor.setValor(10.0);
        conversor.setDescricao("Converte Real para Euro");
        return conversor;
    }

    @Produces
    @Dependent
    @Named("ConversorRealPeso")
    public ConversorMoeda conversorRealPeso() {
        ConversorMoeda conversor = new ConversorMoeda();
        conversor.setDe(Moeda.REAL);
        conversor.setPara(Moeda.PESO);
        conversor.setValor(10.0);
        conversor.setDescricao("Converte Real para Pedo Argentino");
        return conversor;
    }
}
