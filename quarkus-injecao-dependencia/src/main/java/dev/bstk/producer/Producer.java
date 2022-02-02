package dev.bstk.producer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class Producer {

    @Produces
    @Named("converterStringInteger")
    public ConverterString<Integer> converterStringInteger() {
        return new ConverterString<>() {
            @Override
            public String id() {
                return "ConverterString_Integer";
            }

            @Override
            public String descricao() {
                return "Converte uma String em um Inteiro";
            }

            @Override
            public Integer converter(String valor) {
                return Integer.valueOf(valor);
            }
        };
    }

    @Produces
    @Named("converterStringByte")
    public ConverterString<Byte> converterStringByte() {
        return new ConverterString<>() {
            @Override
            public String id() {
                return "ConverterString_Byte";
            }

            @Override
            public String descricao() {
                return "Converte uma String num Byte";
            }

            @Override
            public Byte converter(String valor) {
                return Byte.valueOf(valor);
            }
        };
    }

    @Produces
    @Named("converterStringArray")
    public ConverterString<String[]> converterStringArray() {
        return new ConverterString<>() {
            @Override
            public String id() {
                return "ConverterString_String[]";
            }

            @Override
            public String descricao() {
                return "Converte uma String em Array de Strings";
            }

            @Override
            public String[] converter(String valor) {
                return valor.split(" ");
            }
        };
    }

    @Produces
    @Named("converterStringArrayHifen")
    public ConverterString<String[]> converterStringArrayHifen() {
        return new ConverterString<>() {
            @Override
            public String id() {
                return "ConverterStringArrayHifen_String[]";
            }

            @Override
            public String descricao() {
                return "Converte uma String em Array de Strings | Separador Hifen";
            }

            @Override
            public String[] converter(String valor) {
                return valor.split("-");
            }
        };
    }
}
