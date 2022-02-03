package dev.bstk.producer.moedas;

import static dev.bstk.producer.moedas.Moeda.*;

public class ConversorMoedaDolar implements ConversorMoeda {

    @Override
    public Moeda de() {
        return DOLAR;
    }

    @Override
    public double converter(final Moeda para, final double valor) {
        if (REAL.equals(para)) { return valor * 5.26; }
        if (EURO.equals(para)) { return valor * 0.88; }
        if (PESO.equals(para)) { return valor * 105.11; }
        return -1;
    }

}
