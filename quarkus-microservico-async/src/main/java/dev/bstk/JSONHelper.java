package dev.bstk;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class JSONHelper {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private JSONHelper() { }

    public static Object fixure(final String pathFixture) {
        try {
            validarCaminhoArquivoFixtureResource(pathFixture);
            final var json = new File("src/main/resources" + pathFixture);
            return JSON_MAPPER.readValue(json, Object.class);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Não foi possivél localizar o json de Fixture!", ex);
        }
    }

    private static void validarCaminhoArquivoFixtureResource(final String arquivoResourceJson) {
        if (Objects.isNull(arquivoResourceJson)
            || arquivoResourceJson.isEmpty()
            || arquivoResourceJson.isBlank()) {
            throw new IllegalArgumentException("Caminho arquivo json não pode ser nulo ou vazio!");
        }

        if (Boolean.FALSE.equals(arquivoResourceJson.startsWith("/"))) {
            throw new IllegalArgumentException("Caminho arquivo json deve iniciar com: '/'!");
        }

        if (Boolean.FALSE.equals(arquivoResourceJson.endsWith(".json"))) {
            throw new IllegalArgumentException("Caminho arquivo json ter a extensão .json!");
        }
    }
}
