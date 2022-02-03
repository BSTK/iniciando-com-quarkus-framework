package dev.bstk.eventos;

import java.time.LocalDateTime;

public class EventoNovoUsuarioCriado {

    private final String usuarioEmail;
    private final String usuarioApelido;
    private final LocalDateTime dataHoraOcorrencia;

    public EventoNovoUsuarioCriado(final String usuarioEmail,
                                   final String usuarioApelido,
                                   final LocalDateTime dataHoraOcorrencia) {
        this.usuarioEmail = usuarioEmail;
        this.usuarioApelido = usuarioApelido;
        this.dataHoraOcorrencia = dataHoraOcorrencia;
    }

    public LocalDateTime getDataHoraOcorrencia() {
        return dataHoraOcorrencia;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public String getUsuarioApelido() {
        return usuarioApelido;
    }

    @Override
    public String toString() {
        return "EventoNovoUsuarioCriado {" +
            "usuarioEmail='" + usuarioEmail + '\'' +
            ", usuarioApelido='" + usuarioApelido + '\'' +
            ", dataHoraOcorrencia=" + dataHoraOcorrencia +
            '}';
    }
}
