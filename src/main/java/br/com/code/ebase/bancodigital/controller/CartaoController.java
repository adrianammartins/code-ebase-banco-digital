package br.com.code.ebase.bancodigital.controller;

import br.com.code.ebase.bancodigital.model.Cartao;
import br.com.code.ebase.bancodigital.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<String> criarCartao(@RequestBody Cartao cartao) {
        cartaoService.adicionarCartao(cartao);
        return ResponseEntity.ok("Cartão criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> listarCartoes() {
        return ResponseEntity.ok(cartaoService.listarCartoes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cartao> buscarCartao(@PathVariable Long id) {
        Cartao cartao = cartaoService.buscarCartao(id);
        return cartao != null ? ResponseEntity.ok(cartao) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCartao(@PathVariable Long id, @RequestBody Cartao cartao) {
        if (cartaoService.atualizarCartao(id, cartao)) {
            return ResponseEntity.ok("Cartão atualizado com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> atualizarParcialmenteCartao(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        if (cartaoService.atualizarParcialmenteCartao(id, updates)) {
            return ResponseEntity.ok("Cartão atualizado parcialmente com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCartao(@PathVariable Long id) {
        if (cartaoService.deletarCartao(id)) {
            return ResponseEntity.ok("Cartão removido com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}
