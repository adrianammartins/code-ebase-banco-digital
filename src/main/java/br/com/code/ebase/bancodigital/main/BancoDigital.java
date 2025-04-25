package br.com.code.ebase.bancodigital.main;

import br.com.code.ebase.bancodigital.model.Cliente;
import br.com.code.ebase.bancodigital.service.ClienteService;
import java.util.Scanner;

public class BancoDigital {
    public static void main(String[] args) {
        /*BancoService service = new BancoService();
        service.processarOperacoes();*/


        /*
        ClienteService service = new ClienteService(null);
        Scanner scanner = new Scanner(System.in);

        String cpf, nome, dataNascimento, endereco, categoria;
        do {
            System.out.print("Digite o CPF (xxx.xxx.xxx-xx): ");
            cpf = scanner.nextLine();
        } while (!service.existeCPFNoBanco(cpf));

        do {
            System.out.print("Digite o Nome: ");
            nome = scanner.nextLine();
        } while (!service.validarNome(nome));

        do {
            System.out.print("Digite a Data de Nascimento (DD/MM/AAAA): ");
            dataNascimento = scanner.nextLine();
        } while (!service.validarDataNascimento(dataNascimento));

        do {
            System.out.print("Digite o Endereço (mínimo 10 caracteres): ");
            endereco = scanner.nextLine();
        } while (!service.validarEndereco(endereco));

        do {
            System.out.print("Escolha a Categoria (Comum, Super, Premium): ");
            categoria = scanner.nextLine();
        } while (!categoria.matches("Comum|Super|Premium"));

        Cliente cliente = new Cliente(null, cpf, nome, dataNascimento, endereco, categoria);
        service.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");

        System.out.println("Clientes cadastrados: ");
        for (Cliente c : service.listarClientes()) {
            System.out.println("CPF: " + c.getCpf() + " | Categoria: " + c.getCategoria());
        }*/
    }

}
