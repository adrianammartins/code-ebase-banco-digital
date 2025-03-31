package br.com.code.ebase.bancodigital.model;

import lombok.Data;

@Data

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String categoria;

    public Cliente(String nome, String cpf, String dataNascimento, String endereco, String categoria) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }

    public String getCpf() {
        return cpf;
    }
}
