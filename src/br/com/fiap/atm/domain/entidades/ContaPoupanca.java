package br.com.fiap.atm.domain.entidades;

import br.com.fiap.atm.domain.valueObject.Dinheiro;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    private static final Double RENDIMENTO_MENSAL = 0.01; //1%

    @Override
    public void aplicarRegraDeTaxa() {

    }

    public ContaPoupanca(Cliente cliente, Dinheiro saldo) {
        super(cliente, null, saldo, 0.0);
    }
}
