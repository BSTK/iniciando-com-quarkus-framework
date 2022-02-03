package dev.bstk.producer.moedas;

import static dev.bstk.producer.moedas.Moeda.*;

public class ConversorMoedaPeso implements ConversorMoeda {

    @Override
    public Moeda de() {
        return PESO;
    }

    @Override
    public double converter(final Moeda para, final double valor) {
        if (REAL.equals(para)) { return valor * 0.050; }
        if (EURO.equals(para)) { return valor * 0.0084; }
        if (DOLAR.equals(para)) { return valor * 0.0095; }
        return -1;
    }

}
