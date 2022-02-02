package dev.bstk.producer;

public interface ConverterString<T> {

    String id();

    String descricao();

    T converter(final String valor);
}
