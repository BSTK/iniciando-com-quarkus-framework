package dev.bstk.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JAXRSExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    private static final String EXCEPTION_MENSAGEM = "Dados inválidos!";

    @Override
    public Response toResponse(IllegalArgumentException ex) {
        return Response
            .serverError()
            .type(MediaType.APPLICATION_JSON)
            .status(Response.Status.BAD_REQUEST)
            .entity(new ErroResponse(EXCEPTION_MENSAGEM, ex.getMessage()))
            .build();
    }

    public static class ErroResponse {
        private final String titulo;
        private final String descricao;

        public ErroResponse(final String titulo,
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

}
