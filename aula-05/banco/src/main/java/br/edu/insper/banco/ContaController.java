package br.edu.insper.banco;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ContaController {

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
        conta.setId(contas.values().size());

        contas.put(conta.getId(), conta);
        return "Cliente salvo com sucesso";
    }


}
