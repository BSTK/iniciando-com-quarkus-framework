package dev.bstk.dtos;

import dev.bstk.producer.ConversorMoeda;
import dev.bstk.producer.Moeda;

public class Resultado {

    private final Moeda de;
    private final Moeda para;
    private final Double resultado;

    public Resultado(final ConversorMoeda conversor) {
        this.de = conversor.getDe();
        this.para = conversor.getPara();
        this.resultado = conversor.converter();
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
