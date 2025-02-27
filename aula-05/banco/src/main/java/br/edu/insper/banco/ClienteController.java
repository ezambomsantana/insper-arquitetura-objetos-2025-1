package br.edu.insper.banco;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ClienteController {

    private HashMap<String, Cliente> clientes = new HashMap<>();

    @GetMapping("/cliente")
    public HashMap<String, Cliente> getClientes() {
        return clientes;
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

        clientes.put(cliente.getCpf(), cliente);
        return "Cliente salvo com sucesso";
    }

    @GetMapping("/cliente/{cpf}")
    public Cliente getCliente(@PathVariable String cpf) {
        return clientes.get(cpf);
    }


    @DeleteMapping("/cliente/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirCliente(@PathVariable String cpf) {
        Cliente cliente = clientes.remove(cpf);
        if (cliente != null) {
            return "Cliente removido com sucesso";
        }
        return "Cliente não encontrado";
    }

    @PutMapping("/cliente/{cpf}")
    public String editarCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {
        Cliente clienteEditar = clientes.get(cpf);

        if (clienteEditar != null) {

            if (cliente.getNome() != null) {
                clienteEditar.setNome(cliente.getNome());
            }

            if (cliente.getRenda() != clienteEditar.getRenda()) {
                clienteEditar.setRenda(cliente.getRenda());
            }
            return "Cliente alterado com sucesso";

        }

        return "cliente não encontrado";
    }

}
