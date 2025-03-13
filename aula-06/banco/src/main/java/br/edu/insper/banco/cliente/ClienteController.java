package br.edu.insper.banco.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public HashMap<String, Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarCliente(@RequestBody Cliente cliente) {
        if (cliente.getNome() == null) {
            return "Nome não pode ser nulo";
        }

        if (cliente.getCpf() == null) {
            return "CPF não pode ser nulo";
        }

        clienteService.salvarCliente(cliente);
        return "Cliente salvo com sucesso";
    }

    @GetMapping("/cliente/{cpf}")
    public Cliente getCliente(@PathVariable String cpf) {
        return clienteService.getCliente(cpf);
    }


    @DeleteMapping("/cliente/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirCliente(@PathVariable String cpf) {
        Cliente cliente = clienteService.removerCliente(cpf);
        if (cliente != null) {
            return "Cliente removido com sucesso";
        }
        return "Cliente não encontrado";
    }

    @PutMapping("/cliente/{cpf}")
    public String editarCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {

        Cliente clienteRetorno = clienteService.editarCliente(cpf, cliente);
        if (clienteRetorno != null) {
            return "Cliente alterado com sucesso";
        }
        return "cliente não encontrado";
    }

}
