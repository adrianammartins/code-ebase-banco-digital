package br.com.code.ebase.bancodigital.controller;

import br.com.code.ebase.bancodigital.model.Cliente;
import br.com.code.ebase.bancodigital.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/add")
    public ResponseEntity<String> addCliente(@RequestBody Cliente cliente) {
        if (clienteService.validarCliente(cliente.getCpf(), cliente.getNome(),
                cliente.getDataNascimento(), cliente.getEndereco(),
                cliente.getCategoria()))
        {
            clienteService.adicionarCliente(cliente);
            return ResponseEntity.ok("Cliente cadastrado com sucesso!");
        }
        return ResponseEntity.badRequest().body("Dados inválidos!");
    }

    @GetMapping ("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable String cpf) {
        Cliente cliente = clienteService.buscarCliente(cpf);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<String> atualizarCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {
        if (clienteService.atualizarCliente(cliente) != null) {
            return ResponseEntity.ok("Cliente atualizado com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }

    /*@PatchMapping("/{cpf}")
    public ResponseEntity<String> atualizarParcialmenteCliente(@PathVariable String cpf, @RequestBody Map<String, Object> updates) {
        if (clienteService.atualizarParcialmenteCliente(cpf, updates)) {
            return ResponseEntity.ok("Cliente atualizado parcialmente com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }*/

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deletarCliente(@PathVariable String cpf) {
        if (clienteService.deletarCliente(cpf)) {
            return ResponseEntity.ok("Cliente removido com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}
