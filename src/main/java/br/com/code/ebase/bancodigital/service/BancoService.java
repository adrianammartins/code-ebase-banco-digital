package br.com.code.ebase.bancodigital.service;

import br.com.code.ebase.bancodigital.model.Cliente;
import br.com.code.ebase.bancodigital.model.ContaCorrente;
import br.com.code.ebase.bancodigital.model.ContaPoupanca;
import br.com.code.ebase.bancodigital.repository.ClienteRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BancoService {
    private ClienteRepository clienteRepository = new ClienteRepository();
    private Scanner scanner = new Scanner(System.in);
    private boolean validarCPF(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") && !clienteRepository.cpfExiste(cpf);
    }

    private boolean validarNome(String nome) {
        return nome.matches("[a-zA-Z\\s]{2,100}");
    }

    private boolean validarDataNascimento(String dataNascimento) {
        try {
            LocalDate data = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return ChronoUnit.YEARS.between(data, LocalDate.now()) >= 18;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean validarEndereco(String endereco) {
        return endereco.length() >= 10;
    }

    public void cadastrarCliente() {
        String cpf, nome, dataNascimento, endereco, categoria;
        do {
            System.out.println("Digite o CPF (xxx.xxx.xxx-xx): ");
            cpf = scanner.nextLine();
        } while (!validarCPF(cpf));

        do {
            System.out.println("Digite o Nome: ");
            nome = scanner.nextLine();
        } while (!validarNome(nome));

        do {
            System.out.println("Digite a Data de Nascimento (DD/MM/AAAA): ");
            dataNascimento = scanner.nextLine();
        } while (!validarDataNascimento(dataNascimento));

        do {
            System.out.println("Digite o Endereço (mínimo 10 caracteres): ");
            endereco = scanner.nextLine();
        } while (!validarEndereco(endereco));

        do {
            System.out.println("Escolha a Categoria (Comum, Super, Premium): ");
            categoria = scanner.nextLine();
        } while (!categoria.matches("Comum|Super|Premium"));

        Cliente cliente = new Cliente(cpf, nome, dataNascimento, endereco, categoria);
        clienteRepository.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void processarOperacoes() {
        cadastrarCliente();
        System.out.println("Clientes cadastrados: ");
        for (Cliente c : clienteRepository.listarClientes()) {
            System.out.println("CPF: " + c.getCpf() + " | Nome: " + c.getCategoria());
        }
    }
      /*  cadastrarCliente();
        Cliente cliente1 = clienteRepository.listarClientes().get(0);
        ContaCorrente cc = new ContaCorrente(cliente1);
        ContaPoupanca cp = new ContaPoupanca(cliente1);

        cc.depositar(500);
        cc.descontarTaxa();
        System.out.println("Saldo Conta Corrente: R$" + cc.getSaldo());

        cp.depositar(1000);
        cp.aplicarRendimento();
        System.out.println("Saldo Conta Poupança: R$" + cp.getSaldo());
    }*/
}
