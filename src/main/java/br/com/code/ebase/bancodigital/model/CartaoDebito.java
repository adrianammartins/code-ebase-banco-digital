package br.com.code.ebase.bancodigital.model;

import jakarta.persistence.Entity;

@Entity
public class CartaoDebito extends Cartao {
    private double limiteDiario;
    private double gastoDiario;

    public CartaoDebito() {
        this.limiteDiario = 1000;
        this.gastoDiario = 0;
    }

    public boolean pagar(double valor) {
        if ((gastoDiario + valor) <= limiteDiario) {
            gastoDiario += valor;
            return true;
        }
        return false;
    }

    public void ajustarLimiteDiario(double novoLimite) {
        this.limiteDiario = novoLimite;
    }
}
