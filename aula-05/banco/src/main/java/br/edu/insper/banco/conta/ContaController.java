package br.edu.insper.banco.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/conta")
    public HashMap<Integer, Conta> getContas() {
        return contaService.getContas();
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
        Conta novaConta = contaService.salvarConta(conta);
        if (novaConta != null) {
            return "Cliente salvo com sucesso";
        } else{
            return "Erro ao criar conta";
        }
    }

    @GetMapping("/conta/{id}")
    public Conta conta(@PathVariable Integer id) {
        return contaService.getConta(id);
    }


    @DeleteMapping("/conta/{id}")
    public void deleteConta(@PathVariable Integer id) {
        contaService.deleteConta(id);
    }

    @PostMapping("/conta/{id}/saque")
    public Conta saque(@PathVariable Integer id, @RequestBody String valor) {
        return contaService.saque(id, Float.valueOf(valor));
    }

    @PostMapping("/conta/{id}/deposito")
    public Conta deposito(@PathVariable Integer id, @RequestBody String valor) {
        return contaService.deposito(id, Float.valueOf(valor));
    }


}
