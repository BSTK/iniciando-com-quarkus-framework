package dev.bstk.producer;

public class ConversorMoeda {

    private Moeda de;
    private Moeda para;
    private Double valor;
    private String descricao;

    public Moeda getDe() {
        return de;
    }

    public void setDe(Moeda de) {
        this.de = de;
    }

    public Moeda getPara() {
        return para;
    }

    public void setPara(Moeda para) {
        if (de.equals(para)) {
            throw new IllegalArgumentException("Não pode converter moedas iguais!");
        }

        this.para = para;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double converter() {
        return de.converte(this);
    }

}
