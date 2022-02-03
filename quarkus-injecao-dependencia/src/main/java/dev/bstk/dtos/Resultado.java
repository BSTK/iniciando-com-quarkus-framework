package dev.bstk.dtos;

import dev.bstk.producer.moedas.Moeda;

public class Resultado {

    private final Moeda de;
    private final Moeda para;
    private final Double resultado;

    public Resultado(final Moeda de,
                     final Moeda para,
                     final Double resultado) {
        this.de = de;
        this.para = para;
        this.resultado = resultado;
    }

    public Moeda getDe() {
        return de;
    }

    public Moeda getPara() {
        return para;
    }

    public Double getResultado() {
        return resultado;
    }

}
