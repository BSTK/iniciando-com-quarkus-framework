package dev.bstk;

import dev.bstk.dados.Conta;
import dev.bstk.dados.DadosPessoais;
import dev.bstk.dados.Saldo;
import dev.bstk.helper.JSONHelper;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DadosConsultaService {

    public Conta conta() {
        return JSONHelper.fixure("", Conta.class);
    }

    public List<Conta> contas(final Integer quantidade) {
        List<Conta> contas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            contas.add(conta());
        }

        return contas;
    }

    public Saldo saldo() {
        return JSONHelper.fixure("", Saldo.class);
    }

    public List<Saldo> saldos(final Integer quantidade) {
        List<Saldo> saldos = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            saldos.add(saldo());
        }

        return saldos;
    }

    public DadosPessoais dadosPessoais() {
        return JSONHelper.fixure("", DadosPessoais.class);
    }

    public List<DadosPessoais> dadosPessoais(final Integer quantidade) {
        List<DadosPessoais> dadosPessoais = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            dadosPessoais.add(dadosPessoais());
        }

        return dadosPessoais;
    }
}
