package br.com.fiap.atm.domain.entidades;

import br.com.fiap.atm.domain.valueObject.Dinheiro;

import java.math.BigDecimal;
import java.nio.file.DirectoryNotEmptyException;

public class ContaCorrente extends Conta{


   private static final  Double TAXA_MANUNTECAO = -25.0;

    //A classe filha chama a classe mae para comecar a ser construida
    public ContaCorrente(Cliente cliente, Dinheiro saldo) {
        super(cliente, null,saldo,25.0);
    }

    @Override
    public void aplicarRegraDeTaxa() {
        // 3. Cole a lógica da taxa aqui dentro!
        java.math.BigDecimal valorDaTaxa = new java.math.BigDecimal("25.00");
        Dinheiro taxaDeManutencao = new Dinheiro(valorDaTaxa);

        // Deduz a taxa do saldo
        this.saldo = this.saldo.subtrair(taxaDeManutencao);
    }


}
