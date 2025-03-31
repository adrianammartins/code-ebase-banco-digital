package br.com.code.ebase.bancodigital.main;

import br.com.code.ebase.bancodigital.service.BancoService;

public class BancoDigital {
    public static void main(String[] args) {
        BancoService service = new BancoService();
        service.processarOperacoes();
    }
}
