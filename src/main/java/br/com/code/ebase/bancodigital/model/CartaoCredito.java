package br.com.code.ebase.bancodigital.model;

public class CartaoCredito {
    private double limite;
    private double saldoUtilizado;

    public CartaoCredito(String categoria) {
        switch (categoria) {
            case "Comum" -> this.limite = 1000;
            case "Super" -> this.limite = 5000;
            case "Premium" -> this.limite = 10000;
            default -> this.limite = 1000;
        }
        this.saldoUtilizado = 0;
    }

    public boolean pagar(double valor) {
        if ((saldoUtilizado + valor) <= limite) {
            saldoUtilizado += valor;
            return true;
        }
        return false;
    }
}
