package br.com.code.ebase.bancodigital.model;

import jakarta.persistence.Entity;

@Entity
public class ContaCorrente extends ContaBancaria {
    private double taxaManutencao;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.taxaManutencao = calcularTaxa(cliente.getCategoria());
    }

    private double calcularTaxa(String categoria) {
        return switch (categoria) {
            case "Comum" -> 12.0;
            case "Super" -> 8.0;
            case "Premium" -> 0.0;
            default -> 12.0;
        };
    }

    public void descontarTaxa() {
        saldo -= taxaManutencao;
    }
}
