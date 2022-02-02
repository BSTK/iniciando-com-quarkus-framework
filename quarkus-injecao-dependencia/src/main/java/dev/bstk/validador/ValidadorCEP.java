package dev.bstk.validador;

import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("ValidadorCEP")
public class ValidadorCEP implements Validador {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidadorCEP.class);

    private static final int TAMANHO_CPF_VALIDO = 8;

    @Override
    public boolean valido(final Object data) {
        LOGGER.info("$$$ ValidadorCEP $$$");
        String cep = String.valueOf(data);

        if (StringUtil.isNullOrEmpty(cep)) {
            return false;
        }

        return PATTERN.matcher(cep).matches()
            && cep.length() == TAMANHO_CPF_VALIDO;
    }

}
