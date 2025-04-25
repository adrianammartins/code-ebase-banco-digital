package br.com.code.ebase.bancodigital.service;

import br.com.code.ebase.bancodigital.model.Cartao;
import br.com.code.ebase.bancodigital.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CartaoService {
    private final Map<Long, Cartao> cartoes = new HashMap<>();

    public void adicionarCartao(Cartao cartao) {
        //subtituir isso por cartaoRepository.save(cartao)
        cartoes.put(cartao.getId(), cartao);
    }

    public List<Cartao> listarCartoes() {
        return new ArrayList<>(cartoes.values());
    }

    public Cartao buscarCartao(Long id) {
        return cartoes.get(id);
    }

    public boolean atualizarCartao(Long id, Cartao cartaoAtualizado) {
        if (cartoes.containsKey(id)) {
            cartaoAtualizado.setId(id);
            cartoes.put(id, cartaoAtualizado);
            return true;
        }
        return false;
    }

    public boolean atualizarParcialmenteCartao(Long id, Map<String, Object> updates) {
        Cartao cartao = cartoes.get(id);
        /*if (cartao != null) {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "limite":
                        cartao.setLimite((Double) value);
                        break;
                    case "validade":
                        cartao.setValidade((String) value);
                        break;
                }
            });
            return true;
        }*/
        return false;
    }

    public boolean deletarCartao(Long id) {
        return cartoes.remove(id) != null;
    }
}
