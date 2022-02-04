package dev.bstk.service;

import dev.bstk.resource.request.AnagramaRequest;
import dev.bstk.resource.response.AnagramaResponse;

import javax.enterprise.context.RequestScoped;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class AnagramaService {

    private static final Map<String, AnagramaResponse> ANAGRAMAS = new HashMap<>();

    public AnagramaResponse obterAnagrama(final String nome) {
        if (!ANAGRAMAS.containsKey(nome)) {
            throw new IllegalArgumentException("Não possui anagrama para : " + nome);
        }

        return ANAGRAMAS.get(nome);
    }

    public AnagramaResponse novoAnagrama(final AnagramaRequest request) {
        if (ANAGRAMAS.containsKey(request.getNome())) {
            throw new IllegalArgumentException("Já existe anagrama cadastrado para : " + request.getNome());
        }

        AnagramaResponse anagramaResponse = to(request);
        ANAGRAMAS.put(request.getNome(), anagramaResponse);

        return anagramaResponse;
    }

    private AnagramaResponse to(final AnagramaRequest request) {
        return new AnagramaResponse();
    }

}
