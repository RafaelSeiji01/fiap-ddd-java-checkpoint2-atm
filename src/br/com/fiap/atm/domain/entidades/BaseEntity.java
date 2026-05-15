package br.com.fiap.atm.domain.entidades;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class BaseEntity {
    //super classe mae
    //protectde vai ser acessivel pelas classes filhas
    protected UUID id;
    protected LocalDate dataCriacao;

    //nao precisa de input para gerar os dados(por isso nao tem parametros)
    public BaseEntity() {
        this.id = UUID.randomUUID();  //ira gerar um id aleatorio
        this.dataCriacao = LocalDate.now(); //Geração de horario
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataCriacao () {
        return dataCriacao;
    }

    //esse metodo vai verificar se dois objetos sao considerados iguais
    // se os dois metodos tiveram o mesmo id, serao considerados iguais
    @Override
    public boolean equals (Object obj){
        //this é o objeto atual
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        //comparação de Id
        BaseEntity other = (BaseEntity) obj;
        return Objects.equals(this.id, other.id);
    }
}
