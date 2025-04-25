package br.com.code.ebase.bancodigital.repository;

import br.com.code.ebase.bancodigital.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

    /*private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {

        clientes.add(cliente);
    }

    public boolean cpfExiste(String cpf) {

        return clientes.stream().anyMatch(c -> c.getCpf().equals(cpf));
    }

    public List<Cliente> listarClientes() {

        return clientes;
    }
    public Cliente buscarCliente(String cpf) {
        return clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }
    public boolean atualizarCliente(String cpf, Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.set(i, clienteAtualizado);
                return true;
            }
        }
        return false;
    }

    public boolean atualizarParcialmenteCliente(String cpf, Map<String, Object> updates) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente == null) {
            return false;
        }
        updates.forEach((key, value) -> {
            switch (key) {
                case "nome": cliente.setNome((String) value); break;
                case "dataNascimento": cliente.setDataNascimento((String) value); break;
                case "endereco": cliente.setEndereco((String) value); break;
                case "categoria": cliente.setCategoria((String) value); break;
            }
        });
        return true;
    }

    public boolean deletarCliente(String cpf) {
        return clientes.removeIf(c -> c.getCpf().equals(cpf));
    }*/
}
