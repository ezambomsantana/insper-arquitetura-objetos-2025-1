package br.edu.insper.banco.conta;

import br.edu.insper.banco.cliente.Cliente;
import br.edu.insper.banco.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ContaController {

    @Autowired
    private ClienteService clienteService;

    private HashMap<Integer, Conta> contas = new HashMap<>();

    @GetMapping("/conta")
    public HashMap<Integer, Conta> getContas() {
        return contas;
    }

    @PostMapping("/conta")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarConta(@RequestBody Conta conta) {
        if (conta.getNumeroConta() == null) {
            return "Nome não pode ser nulo";
        }

        if (conta.getAgencia() == null) {
            return "CPF não pode ser nulo";
        }
        Cliente cliente = clienteService.getCliente(conta.getPrincipal().getCpf());
        if (cliente == null) {
            return "Erro ao criar conta, cliente não encontrado";
        }

        conta.setPrincipal(cliente);
        conta.setId(contas.values().size());

        contas.put(conta.getId(), conta);
        return "Cliente salvo com sucesso";
    }


}
