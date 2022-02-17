package dev.bstk;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
public class DadosConsultaService {

    private static final Object CONTA = JSONHelper.fixure("/mocks/conta.json");
    private static final Object SALDO = JSONHelper.fixure("/mocks/saldo.json");
    private static final Object DADOS_PESSOAS = JSONHelper.fixure("/mocks/dados-pessoais.json");

    public Object conta() {
        sleep(2);
        return CONTA;
    }

    public Object saldo() {
        sleep(1);
        return SALDO;
    }

    public Object dadosPessoais() {
        sleep(2);
        return DADOS_PESSOAS;
    }

    public List<Object> contas(final Integer quantidade) {
        return gerarDados(quantidade, CONTA);
    }

    public List<Object> saldos(final Integer quantidade) {
        return gerarDados(quantidade, SALDO);
    }

    public List<Object> dadosPessoais(final Integer quantidade) {
        return gerarDados(quantidade, DADOS_PESSOAS);
    }

    private List<Object> gerarDados(final Integer quantidade, Object dado) {
        return IntStream
            .rangeClosed(0, quantidade)
            .boxed()
            .map(integer -> dado)
            .collect(Collectors.toUnmodifiableList());
    }

    private void sleep(final long segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
