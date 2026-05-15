package br.com.fiap.atm.domain.valueObject;

import java.math.BigDecimal;

public class Dinheiro {
    private BigDecimal valor;

    public Dinheiro(BigDecimal novoValor) {
        this.valor = novoValor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Boolean menorQue(Dinheiro outro){
        return this.valor.compareTo(outro.valor) <= 0;
    }

    public Boolean maiorQue(Dinheiro outro) {
        return this.valor.compareTo(outro.valor) >= 0;
    }

    public Dinheiro somar(Dinheiro outro) {
        BigDecimal novoValor = this.valor.add(outro.valor);
        return new Dinheiro(novoValor);
    }

    public Dinheiro subtrair(Dinheiro outro){
        BigDecimal novoValor = this.valor.subtract(outro.valor);
        return new Dinheiro(novoValor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Dinheiro other = (Dinheiro) obj;
        return this.valor.compareTo(other.valor) == 0;
    }


}
