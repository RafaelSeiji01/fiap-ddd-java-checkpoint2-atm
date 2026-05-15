package br.com.fiap.atm.domain.entidades;

public class Cliente extends BaseEntity{

    private String nomeCompleto;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Cliente (String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public String obterPrimeiroNome(){
        //validação de nome para que nao seja vazio
        if (this.nomeCompleto == null || this.nomeCompleto.trim().isEmpty()){
            return "";
        }
        //retirando espações em branco
        String[] partesDoNome = this.nomeCompleto.trim().split(" ");

        // Retorna a primeira posição do array
        return partesDoNome[0];

    }
}
