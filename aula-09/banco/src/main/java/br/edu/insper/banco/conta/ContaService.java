package br.edu.insper.banco.conta;

import br.edu.insper.banco.cliente.Cliente;
import br.edu.insper.banco.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ClienteService clienteService;

    public List<Conta> getContas() {
        return contaRepository.findAll();
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

        return contaRepository.save(conta);
    }

    public Conta getConta(Integer id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteConta(Integer id) {
        contaRepository.deleteById(id);
    }

    public Conta saque(Integer id, float valor) {
        Conta conta = this.getConta(id);
        if (conta == null) {
            return null;
        }

        conta.saque(valor);
        return contaRepository.save(conta);
    }

    public Conta deposito(Integer id, float valor) {
        Conta conta = this.getConta(id);
        if (conta == null) {
            return null;
        }

        conta.deposito(valor);
        return contaRepository.save(conta);
    }
}
