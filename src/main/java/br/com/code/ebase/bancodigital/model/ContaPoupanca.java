package br.com.code.ebase.bancodigital.model;

import jakarta.persistence.Entity;

@Entity
public class ContaPoupanca extends ContaBancaria{
    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.taxaRendimento = calcularRendimento(cliente.getCategoria());
    }

    private double calcularRendimento(String categoria) {
        return switch (categoria) {
            case "Comum" -> 0.005;
            case "Super" -> 0.007;
            case "Premium" -> 0.009;
            default -> 0.005;
        };
    }

    public void aplicarRendimento() {
        saldo += saldo * taxaRendimento;
    }

}
