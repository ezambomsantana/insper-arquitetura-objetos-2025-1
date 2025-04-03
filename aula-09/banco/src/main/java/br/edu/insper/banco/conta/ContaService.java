package br.edu.insper.banco.conta;

import br.edu.insper.banco.cliente.Cliente;
import br.edu.insper.banco.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ContaService {

    private HashMap<Integer, Conta> contas = new HashMap<>();

    @Autowired
    private ClienteService clienteService;

    public HashMap<Integer, Conta> getContas() {
        return contas;
    }

    public Conta salvarConta(Conta conta) {
        Cliente cliente = clienteService.getCliente(conta.getPrincipal().getCpf());
        if (cliente == null) {
            return null;
        }
        conta.setPrincipal(cliente);

        if (conta.getDependente() != null) {
            Cliente dependente = clienteService.getCliente(conta.getDependente().getCpf());
            if (dependente == null) {
                return null;
            }
            conta.setDependente(dependente);
        }

        conta.setId(contas.size());

        contas.put(conta.getId(), conta);
        return conta;
    }

    public Conta getConta(Integer id) {
        return contas.get(id);
    }

    public void deleteConta(Integer id) {
        contas.remove(id);
    }

    public Conta saque(Integer id, float valor) {
        Conta conta = this.getConta(id);
        if (conta == null) {
            return null;
        }

        conta.saque(valor);
        return conta;
    }

    public Conta deposito(Integer id, float valor) {
        Conta conta = this.getConta(id);
        if (conta == null) {
            return null;
        }

        conta.deposito(valor);
        return conta;
    }
}
