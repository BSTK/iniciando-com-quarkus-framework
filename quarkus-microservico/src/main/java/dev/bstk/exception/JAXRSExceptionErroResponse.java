package dev.bstk.exception;

public class JAXRSExceptionErroResponse {

    private final String titulo;
    private final String descricao;

    public JAXRSExceptionErroResponse(final String titulo,
                                      final String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}
