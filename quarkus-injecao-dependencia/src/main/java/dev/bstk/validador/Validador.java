package dev.bstk.validador;

import java.util.regex.Pattern;

public interface Validador {

    Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    boolean valido(final Object data);

}
