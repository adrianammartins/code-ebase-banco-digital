package br.com.code.ebase.bancodigital.controller;

import br.com.code.ebase.bancodigital.model.ContaBancaria;
import br.com.code.ebase.bancodigital.model.ContaCorrente;
import br.com.code.ebase.bancodigital.model.ContaPoupanca;
import br.com.code.ebase.bancodigital.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping("/corrente")
    public ResponseEntity<String> criarContaCorrente(@RequestBody ContaCorrente conta) {
        contaService.adicionarContaCorrente(conta);
        return ResponseEntity.ok("Conta criada com sucesso!");
    }

    @PostMapping("/poupanca")
    public ResponseEntity<String> criarContaPoupanca(@RequestBody ContaPoupanca conta) {
        contaService.adicionarContaPoupanca(conta);
        return ResponseEntity.ok("Conta criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<ContaBancaria>> listarContas() {
        return ResponseEntity.ok(contaService.listarContas());
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarConta(@PathVariable Long id, @RequestBody ContaBancaria conta) {
        if (contaService.atualizarConta(id, conta)) {
            return ResponseEntity.ok("Conta atualizada com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }

    /*@PatchMapping("/{id}")
    public ResponseEntity<String> atualizarParcialmenteConta(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        if (contaService.atualizarParcialmenteConta(id, updates)) {
            return ResponseEntity.ok("Conta atualizada parcialmente com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarConta(@PathVariable Long id) {
        if (contaService.deletarConta(id)) {
            return ResponseEntity.ok("Conta removida com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }

}
