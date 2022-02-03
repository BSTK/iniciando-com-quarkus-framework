package dev.bstk.eventos;

public class EventoProtocoloAlterado {

    private final String id;
    private final String descricao;

    public EventoProtocoloAlterado(final String id,
                                   final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "EventoProtocoloAlterado {" +
            "id='" + id + '\'' +
            ", descricao='" + descricao + '\'' +
            '}';
    }
}
