package br.com.code.ebase.bancodigital.service;

import br.com.code.ebase.bancodigital.model.ContaBancaria;
import br.com.code.ebase.bancodigital.model.ContaCorrente;
import br.com.code.ebase.bancodigital.model.ContaPoupanca;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContaService {
    private final Map<Long, ContaBancaria> contas = new HashMap<>();
    private long idCounter = 1;

    public void adicionarContaCorrente(ContaCorrente conta) {
        conta.setId(idCounter++);
        contas.put(conta.getId(), conta);
    }

    public void adicionarContaPoupanca(ContaPoupanca conta) {
        conta.setId(idCounter++);
        contas.put(conta.getId(), conta);
    }

    public List<ContaBancaria> listarContas() {
        return new ArrayList<>(contas.values());
    }

    public ContaBancaria buscarConta(Long id) {
        return contas.get(id);
    }

    public boolean atualizarConta(Long id, ContaBancaria contaAtualizada) {
        if (contas.containsKey(id)) {
            contaAtualizada.setId(id);
            contas.put(id, contaAtualizada);
            return true;
        }
        return false;
    }

    /*public boolean atualizarParcialmenteConta(Long id, Map<String, Object> updates) {
        ContaBancaria conta = contas.get(id);
        if (conta != null) {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "saldo":
                        conta.setSaldo((Double) value);
                        break;
                    case "tipo":
                        conta.setTipo((String) value);
                        break;
                }
            });
            return true;
        }
        return false;
    }*/

    public boolean deletarConta(Long id) {
        return contas.remove(id) != null;
    }
}
