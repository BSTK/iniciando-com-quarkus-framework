package dev.bstk.dados;

public enum APIS {

    API_CONTAS("contas", "Api de Contas"),
    API_SALDOS("saldos", "Api de Saldos"),
    API_DADOS_PESSOAIS("dadosPessoais", "Api de Dados Pessoais");

    private final String id;
    private final String descricao;

    APIS(final String id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
