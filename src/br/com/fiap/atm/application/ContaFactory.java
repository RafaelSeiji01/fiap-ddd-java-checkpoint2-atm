package br.com.fiap.atm.application;

import br.com.fiap.atm.domain.entidades.Cliente;
import br.com.fiap.atm.domain.entidades.Conta;
import br.com.fiap.atm.domain.entidades.ContaCorrente;
import br.com.fiap.atm.domain.entidades.ContaPoupanca;
import br.com.fiap.atm.domain.valueObject.Dinheiro;

public class ContaFactory {

    private static ContaFactory instance;

    public static ContaFactory getInstance() {
        // sem esse if pode dar nullpointerexception
        if (instance == null) {
            instance = new ContaFactory();
        }
        return instance;
    }

    private ContaFactory() {
    }

    public Conta criarContaCorrente(Cliente cliente, Dinheiro saldo){
        return new ContaCorrente(cliente, saldo);
    }

    public Conta criarContaPoupanca(Cliente cliente, Dinheiro saldo){
        return new ContaPoupanca(cliente, saldo) {

        };

    }


}
