package dev.bstk.validador;

import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("ValidadorCNPJ")
public class ValidadorCNPJ implements Validador {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidadorCNPJ.class);

    private static final int TAMANHO_CPF_VALIDO = 14;

    @Override
    public boolean valido(final Object data) {
        LOGGER.info("*** ValidadorCNPJ ***");
        String cnpj = String.valueOf(data);

        if (StringUtil.isNullOrEmpty(cnpj)) {
            return false;
        }

        return PATTERN.matcher(cnpj).matches()
            && cnpj.length() == TAMANHO_CPF_VALIDO;
    }

}
