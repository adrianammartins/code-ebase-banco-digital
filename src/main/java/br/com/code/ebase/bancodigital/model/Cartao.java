package br.com.code.ebase.bancodigital.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CARTAO")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ativo")
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
