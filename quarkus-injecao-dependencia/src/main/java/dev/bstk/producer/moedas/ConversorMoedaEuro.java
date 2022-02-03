package dev.bstk.producer.moedas;

import static dev.bstk.producer.moedas.Moeda.*;

public class ConversorMoedaEuro implements ConversorMoeda {

    @Override
    public Moeda de() {
        return EURO;
    }

    @Override
    public double converter(final Moeda para, final double valor) {
        if (REAL.equals(para)) { return valor * 5.96; }
        if (DOLAR.equals(para)) { return valor * 1.13; }
        if (PESO.equals(para)) { return valor * 118.99; }
        return -1;
    }

}
