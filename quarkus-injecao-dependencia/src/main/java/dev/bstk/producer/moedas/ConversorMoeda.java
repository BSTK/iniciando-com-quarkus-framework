package dev.bstk.producer.moedas;

public interface ConversorMoeda {

    Moeda de();

    double converter(final Moeda para, final double valor);
}
