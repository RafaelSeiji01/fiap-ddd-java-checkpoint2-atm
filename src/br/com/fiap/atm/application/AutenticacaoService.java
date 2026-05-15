package br.com.fiap.atm.application;

import br.com.fiap.atm.domain.entidades.Conta;

public class AutenticacaoService {
    private Conta conta;

    public AutenticacaoService(Conta conta) {
        this.conta = conta;
    }

    public Boolean autorizar(String senha){
        if (this.conta == null) {
            System.out.println("Erro no serviço: Nenhuma conta foi vinculada a este serviço.");
            return false;
        }

        Boolean estaAutorizado = this.conta.getContaAcesso().validarSenha(senha);
        if (estaAutorizado) {
            System.out.println("Serviço de Autorização: Acesso liberado.");
        } else {
            System.out.println("Serviço de Autorização: Acesso negado.");
        }

        return estaAutorizado;
    }
}
