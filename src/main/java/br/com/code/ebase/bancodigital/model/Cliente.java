package br.com.code.ebase.bancodigital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "NOME", nullable = false)
    private String nome;

    @CPF
    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private String dataNascimento;

    @Column(name = "ENDERECO", nullable = true)
    private String endereco;

    @Column(name = "CATEGORIA", nullable = true)
    private String categoria;
}

