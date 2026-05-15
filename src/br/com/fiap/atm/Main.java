package br.com.fiap.atm;

import br.com.fiap.atm.application.AutenticacaoService;
import br.com.fiap.atm.application.ContaFactory;
import br.com.fiap.atm.application.ContaService;
import br.com.fiap.atm.domain.entidades.Cliente;
import br.com.fiap.atm.domain.entidades.Conta;
import br.com.fiap.atm.domain.valueObject.Dinheiro;
import br.com.fiap.atm.presentation.TerminalBancarioController;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String nomeCompleto = null;
        System.out.print("Para começar digite o seu nome Completo: ");
        nomeCompleto = input.nextLine();
        Cliente cliente = new Cliente(nomeCompleto);
        System.out.println("Cliente: " + cliente.getNomeCompleto());
        System.out.println("Primeiro Nome: " + cliente.obterPrimeiroNome());
        System.out.println("=========================================");
        System.out.println();
        System.out.println("BEM VINDO AO FIAP-BANK");
        System.out.println();


        System.out.print("Digite o saldo inicial para abertura da conta: R$ ");
        double valorInicialDigitado = input.nextDouble();


        Dinheiro saldoInicial = new Dinheiro(BigDecimal.valueOf(valorInicialDigitado));


        ContaFactory fabrica = ContaFactory.getInstance();
        Conta contaCliente = fabrica.criarContaCorrente(cliente, saldoInicial);

        ContaService contaService = new ContaService(contaCliente);
        AutenticacaoService autenticacaoService = new AutenticacaoService(contaCliente);
        TerminalBancarioController controller = new TerminalBancarioController(contaService, autenticacaoService);

        int opcao = 0;

        while (opcao != 5) {

            controller.exibirMenuPrincipal();
            System.out.print("Selecione a opção desejada: ");

            if (input.hasNextInt()) {
                opcao = input.nextInt();
                System.out.println();

            } else {
                System.out.println("Por favor, digite um número válido de 1 a 5.\n");
                input.next();
                continue;
            }

            // Mapeamento das ações baseadas na escolha do usuário
            switch (opcao) {
                case 1:
                    controller.exibirSaldo();
                    break;
                case 2:
                    controller.realizarDeposito();
                    break;
                case 3:
                    controller.realizarSaque();
                    break;
                case 4:
                    controller.exibirMovimentacoes();
                    break;
                case 5:
                    System.out.println("Sessão encerrada com segurança. Volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }

            System.out.println();
        }

        input.close();
    }

}
