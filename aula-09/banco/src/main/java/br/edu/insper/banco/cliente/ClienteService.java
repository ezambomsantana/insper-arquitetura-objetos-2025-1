package br.edu.insper.banco.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> getClientes(String nome, Float renda, Pageable pageable) {
        return clienteRepository.buscarClientePorNomeERenda(nome, renda, pageable);
    }

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente getCliente(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public Cliente removerCliente(String cpf) {
        Cliente cliente = getCliente(cpf);
        clienteRepository.delete(cliente);
        return cliente;
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
        return clienteRepository.save(clienteEditar);
    }

}
