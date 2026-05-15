package br.com.fiap.atm.domain.entidades;

public class ContaAcesso {
    private String senha = "123456";
    private Integer tentativas;
    private Boolean bloqueado;
    public static final Integer MAXIMO_TENTATIVAS = 3;

    public ContaAcesso(String senha) {
        this.senha = senha;
    }


    public void resetarTentativas(){
        this.tentativas = 0;
        this.bloqueado = false;

    }

    public Boolean validarSenha(String senha){
        if (this.bloqueado){
            System.out.println("Conta ja está bloqueada");
            return false; //retorna aqui o metodo de validação de senha
        }
        if (this.senha.equals(senha)) {
            resetarTentativas();
            System.out.println("Acesso liberado");
            return true; //validação de senha "Acertou a senha == true"

        } else {
            this.tentativas++;
            if (this.tentativas >= MAXIMO_TENTATIVAS) {
                this.bloqueado = true;
                System.out.println("Conta bloqueada por excesso de tentativas!");
            }
        }
            return false;

    }

    public Boolean isBloqueado(){
        return this.bloqueado; //verifica se a conta esta bloqueada ou nao
        //true == bloqueado
        //false == liberado
    }

}
