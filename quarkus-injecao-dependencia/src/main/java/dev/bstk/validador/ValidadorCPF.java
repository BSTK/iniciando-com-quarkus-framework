package dev.bstk.validador;

import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("ValidadorCPF")
public class ValidadorCPF implements Validador {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidadorCPF.class);

    private static final int TAMANHO_CPF_VALIDO = 11;

    @Override
    public boolean valido(final Object data) {
        LOGGER.info("@@@ ValidadorCPF @@@");
        String cpf = String.valueOf(data);

        if (StringUtil.isNullOrEmpty(cpf)) {
            return false;
        }

        return PATTERN.matcher(cpf).matches()
            && cpf.length() == TAMANHO_CPF_VALIDO;
    }

}
