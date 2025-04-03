package br.edu.insper.banco.cliente;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ClienteService {

    private HashMap<String, Cliente> clientes = new HashMap<>();

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void salvarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    public Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }

    public Cliente removerCliente(String cpf) {
        return clientes.remove(cpf);
    }

    public Cliente editarCliente(String cpf, Cliente cliente) {
        Cliente clienteEditar = getCliente(cpf);

        if (clienteEditar != null) {

            if (cliente.getNome() != null) {
                clienteEditar.setNome(cliente.getNome());
            }

            if (cliente.getRenda() != clienteEditar.getRenda()) {
                clienteEditar.setRenda(cliente.getRenda());
            }
        }
        return clienteEditar;
    }

}
