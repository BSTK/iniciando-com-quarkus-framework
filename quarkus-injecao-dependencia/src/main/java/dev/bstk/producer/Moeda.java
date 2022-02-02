package dev.bstk.producer;

public enum Moeda {

    REAL {
        @Override
        Double converte(ConversorMoeda conversor) {
            if (!REAL.equals(conversor.getDe())) {
                throw new IllegalArgumentException("Conversão inválida!");
            }

            if (DOLAR.equals(conversor.getPara())) {
                return conversor.getValor() * 0.19;
            }

            if (EURO.equals(conversor.getPara())) {
                return conversor.getValor() * 0.17;
            }

            if (PESO.equals(conversor.getPara())) {
                return conversor.getValor() * 19.99;
            }

            throw new IllegalArgumentException("Moeda inválida");
        }
    },
    DOLAR {
        @Override
        Double converte(ConversorMoeda conversor) {
            if (!DOLAR.equals(conversor.getDe())) {
                throw new IllegalArgumentException("Conversão inválida!");
            }

            if (REAL.equals(conversor.getPara())) {
                return conversor.getValor() * 5.26;
            }

            if (EURO.equals(conversor.getPara())) {
                return conversor.getValor() * 0.88;
            }

            if (PESO.equals(conversor.getPara())) {
                return conversor.getValor() * 105.11;
            }

            throw new IllegalArgumentException("Moeda inválida");
        }
    },
    EURO {
        @Override
        Double converte(ConversorMoeda conversor) {
            if (!EURO.equals(conversor.getDe())) {
                throw new IllegalArgumentException("Conversão inválida!");
            }

            if (REAL.equals(conversor.getPara())) {
                return conversor.getValor() * 5.96;
            }

            if (DOLAR.equals(conversor.getPara())) {
                return conversor.getValor() * 1.13;
            }

            if (PESO.equals(conversor.getPara())) {
                return conversor.getValor() * 118.99;
            }

            throw new IllegalArgumentException("Moeda inválida");
        }
    },
    PESO {
        @Override
        Double converte(ConversorMoeda conversor) {
            if (!PESO.equals(conversor.getDe())) {
                throw new IllegalArgumentException("Conversão inválida!");
            }

            if (REAL.equals(conversor.getPara())) {
                return conversor.getValor() * 0.050;
            }

            if (EURO.equals(conversor.getPara())) {
                return conversor.getValor() * 0.0084;
            }

            if (DOLAR.equals(conversor.getPara())) {
                return conversor.getValor() * 0.0095;
            }

            throw new IllegalArgumentException("Moeda inválida");
        }
    };

    abstract Double converte(ConversorMoeda conversor);
}
