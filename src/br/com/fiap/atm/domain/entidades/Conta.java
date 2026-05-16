package br.com.fiap.atm.domain.entidades;

import br.com.fiap.atm.domain.valueObject.Movimentacao;
import br.com.fiap.atm.domain.enumeration.StatusConta;
import br.com.fiap.atm.domain.valueObject.Dinheiro;
import br.com.fiap.atm.domain.enumeration.TipoMovimentacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Conta extends BaseEntity{

    protected Cliente cliente;
    protected Dinheiro saldo;
    protected Double taxa;
    protected StatusConta status;
    protected LocalDate dataAbertura;
    protected ContaAcesso contaAcesso;
    protected List<Movimentacao> movimentacoes = new java.util.ArrayList<>();

    //contrutor para deixar ja modelado
    public Conta(Cliente cliente, ContaAcesso contaAcesso, Dinheiro saldo, Double taxa) {
        super(); //chama o construtor da baseEntity , que nao precisa de parametros
        this.cliente = cliente;
        this.contaAcesso = contaAcesso;
        this.saldo = saldo;
        this.taxa = taxa;

        if (contaAcesso == null) {
            this.contaAcesso = new ContaAcesso("123456");
        } else {
            this.contaAcesso = contaAcesso;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Dinheiro getSaldo() {
        return saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public StatusConta getStatus() {
        return status;
    }

    public ContaAcesso getContaAcesso() {
        return contaAcesso;
    }
    public List<Movimentacao> getMovimentacoes() {
        return this.movimentacoes;
    }


    public void realizarSaque(Dinheiro valor){
        //é utilizada o metodo do objto Dinheiro para verificação
        if(this.saldo.menorQue(valor)){
            System.out.println("Saldo insuficiente");
            return;
        }

        if(this.status == StatusConta.BLOQUEADA) {
            System.out.println("Não é possível sacar de uma conta bloqueada.");
            return;
        }
        sacar(valor);
        registrarMovimentacao(valor,TipoMovimentacao.SAQUE);
        System.out.println("Valor retirado com Sucesso");

    }

    public void realizarDeposito(Dinheiro valor) {
        Dinheiro zero = new Dinheiro(BigDecimal.ZERO);
        //esse menorque vai pegar <=
        if (valor == null || valor.menorQue(zero)){
            System.out.println("Deposito Negado: valor deve ser maior que 0");
            return;
        }

        depositar(valor);
        registrarMovimentacao(valor,TipoMovimentacao.DEPOSITO);
        System.out.println("Valor depositado com Sucesso");
    }

    public abstract void aplicarRegraDeTaxa();

    private void registrarMovimentacao(Dinheiro valor, TipoMovimentacao tipo) {
        Movimentacao mov = new Movimentacao( valor, tipo,LocalDateTime.now());
        this.movimentacoes.add(mov);
    }

    private void sacar(Dinheiro valor){
        this.saldo = this.saldo.subtrair(valor);
    }

    private void depositar(Dinheiro valor){
        this.saldo = this.saldo.somar(valor);
    }

}
