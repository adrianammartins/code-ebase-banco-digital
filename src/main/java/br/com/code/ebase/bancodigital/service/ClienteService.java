package br.com.code.ebase.bancodigital.service;

import br.com.code.ebase.bancodigital.model.Cliente;
import br.com.code.ebase.bancodigital.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public boolean existeCPFNoBanco(String cpf) {
        return clienteRepository.findByCpf(cpf).isPresent();
    }

    public boolean validarNome(String nome) {
        return nome.matches("[a-zA-Z\\s]{2,100}");
    }

    public boolean validarDataNascimento(String dataNascimento) {
        try {
            LocalDate data = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return ChronoUnit.YEARS.between(data, LocalDate.now()) >= 18;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean validarEndereco(String endereco) {
        return endereco.length() >= 10;
    }

    public boolean validarCliente(String cpf, String nome, String dataNascimento, String endereco, String categoria) {
        return  !existeCPFNoBanco(cpf) &&
                validarNome(nome) && validarDataNascimento(dataNascimento) &&
                validarEndereco(endereco) && categoria.matches("Comum|Super|Premium");
    }

    public void adicionarCliente(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {

        return clienteRepository.findAll();
    }
    public Cliente buscarCliente(String cpf) {
        return clienteRepository.findByCpf(cpf).get();
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /*public boolean atualizarParcialmenteCliente(String cpf, Map<String, Object> updates) {
        return clienteRepository.atualizarParcialmenteCliente(cpf, updates);
    }*/

    public boolean deletarCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf).get();
        clienteRepository.delete(cliente);
        return true;
    }



    /*public void processarOperacoes() {
        cadastrarCliente();
        System.out.println("Clientes cadastrados: ");
        for (Cliente c : clienteRepository.listarClientes()) {
            System.out.println("CPF: " + c.getCpf() + " | Nome: " + c.getCategoria());
        }
    }*/
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
