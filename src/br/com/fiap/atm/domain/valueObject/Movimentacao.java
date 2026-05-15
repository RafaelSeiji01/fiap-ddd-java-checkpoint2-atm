package br.com.fiap.atm.domain.valueObject;

import br.com.fiap.atm.domain.entidades.BaseEntity;
import br.com.fiap.atm.domain.enumeration.TipoMovimentacao;

import java.time.LocalDateTime;

public class Movimentacao extends BaseEntity {

    private LocalDateTime dataHora;
    private Dinheiro valor;
    //vai buscar quais contas filhas é
    private TipoMovimentacao tipo;

    public Movimentacao(Dinheiro valor, TipoMovimentacao tipo, LocalDateTime dataHora) {
        this.valor = valor;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Dinheiro getValor() {
        return valor;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Operação: " + this.tipo + " | Valor: R$ " + this.valor.getValor();
    }
}
