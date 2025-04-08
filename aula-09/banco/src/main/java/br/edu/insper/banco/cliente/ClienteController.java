package br.edu.insper.banco.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public Page<Cliente> getClientes(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Float renda,
            Pageable pageable) {
        return clienteService.getClientes(nome, renda, pageable);
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarCliente(@RequestBody Cliente cliente) {
        if (cliente.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome é obrigatório.");
        }

        if (cliente.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF é obrigatório");
        }

        clienteService.salvarCliente(cliente);
        return "Cliente salvo com sucesso";
    }

    @GetMapping("/cliente/{cpf}")
    public Cliente getCliente(@PathVariable String cpf) {
        Cliente cliente = clienteService.getCliente(cpf);
        if (cliente != null) {
            return cliente;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/cliente/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirCliente(@PathVariable String cpf) {
        Cliente cliente = clienteService.removerCliente(cpf);
        if (cliente != null) {
            return "Cliente removido com sucesso";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/cliente/{cpf}")
    public String editarCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {

        Cliente clienteRetorno = clienteService.editarCliente(cpf, cliente);
        if (clienteRetorno != null) {
            return "Cliente alterado com sucesso";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
