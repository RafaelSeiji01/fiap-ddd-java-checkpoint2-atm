package br.com.fiap.atm.presentation;

import br.com.fiap.atm.application.AutenticacaoService;
import br.com.fiap.atm.application.ContaService;
import br.com.fiap.atm.domain.entidades.Conta;
import br.com.fiap.atm.domain.valueObject.Dinheiro;

import java.math.BigDecimal;
import java.util.Scanner;

public class TerminalBancarioController {

    Scanner input = new Scanner(System.in);

    private ContaService contaService;
    private AutenticacaoService autenticacaoService;

    public TerminalBancarioController(ContaService contaService, AutenticacaoService autenticacaoService) {
        this.contaService = contaService;
        this.autenticacaoService = autenticacaoService;
    }

    public void exibirMenuPrincipal(){
        System.out.println("[1] Consultar Saldo");
        System.out.println("[2] Fazer Depósito");
        System.out.println("[3] Fazer Saque");
        System.out.println("[4] Histórico de Movimentações");
        System.out.println("[5] Sair");
    }

    public void exibirSaldo() {
        System.out.println("--- SALDO ATUAL ---");
        Dinheiro saldo = contaService.obterSaldo();
        System.out.println("Seu saldo é: R$ " + saldo.getValor());
    }

    public void exibirMovimentacoes() {
        System.out.println("--- EXTRATO DE MOVIMENTAÇÕES ---");
        contaService.obterMovimentacoes().forEach(movimentacao -> {
            System.out.println(movimentacao.toString());
        });
    }

    public void realizarSaque() {
        System.out.println("--- FAZER SAQUE ---");
        System.out.print("Digite o valor que deseja sacar: ");
        double valorDigitado = input.nextDouble();

        Dinheiro valorSaque = new Dinheiro(BigDecimal.valueOf(valorDigitado));
        contaService.realizarSaque(valorSaque);
    }

    public void realizarDeposito() {
        System.out.println("--- FAZER DEPÓSITO ---");
        System.out.print("Digite o valor que deseja depositar: ");
        double valorDigitado = input.nextDouble();

        Dinheiro valorDeposito = new Dinheiro(BigDecimal.valueOf(valorDigitado));
        contaService.realizarDeposito(valorDeposito);
    }
}
