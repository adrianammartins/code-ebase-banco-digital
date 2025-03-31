package br.com.code.ebase.bancodigital.repository;

import br.com.code.ebase.bancodigital.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean cpfExiste(String cpf) {
        return clientes.stream().anyMatch(c -> c.getCpf().equals(cpf));
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
}
