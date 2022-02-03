package dev.bstk.producer.moedas;

import static dev.bstk.producer.moedas.Moeda.*;

public class ConversorMoedaReal implements ConversorMoeda {

    @Override
    public Moeda de() {
        return REAL;
    }

    @Override
    public double converter(final Moeda para, final double valor) {
        if (DOLAR.equals(para)) { return valor * 0.19; }
        if (EURO.equals(para)) { return valor * 0.17; }
        if (PESO.equals(para)) { return valor * 19.99; }
        return -1;
    }

}
