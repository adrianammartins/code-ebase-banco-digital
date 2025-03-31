package br.com.code.ebase.bancodigital.model;

public class Cartao {
    public boolean ativo;
    public String senha;

    public Cartao() {
        this.ativo = true;
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public void ativarDesativar() {
        this.ativo = !ativo;
    }
}
