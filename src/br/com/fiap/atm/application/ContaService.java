package br.com.fiap.atm.application;

import br.com.fiap.atm.domain.entidades.Conta;
import br.com.fiap.atm.domain.valueObject.Dinheiro;
import br.com.fiap.atm.domain.valueObject.Movimentacao;

import java.util.List;

public class ContaService {

    private Conta conta;

    public ContaService(Conta conta) {
        this.conta = conta;
    }

    public void realizarDeposito(Dinheiro valor){
        this.conta.realizarDeposito(valor);
    }

    public void realizarSaque(Dinheiro valor){
        this.conta.realizarSaque(valor);
    }

    public Dinheiro obterSaldo(){
        return this.conta.getSaldo();
    }

    public List<Movimentacao> obterMovimentacoes(){
        if (this.conta == null) {
            return java.util.Collections.emptyList();
        }

        return this.conta.getMovimentacoes();
    }
}
