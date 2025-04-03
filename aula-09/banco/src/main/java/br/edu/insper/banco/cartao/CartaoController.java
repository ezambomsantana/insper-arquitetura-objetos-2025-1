package br.edu.insper.banco.cartao;

import br.edu.insper.banco.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping("/cartao")
    public HashMap<String, Cartao> getCartoes() {
        return cartaoService.getCartoes();
    }

    @PostMapping("/cartao")
    public String salvarCartao(@RequestBody Cartao cartao) {
        Cartao cartaoRetorno = cartaoService.salvarCartao(cartao);
        if (cartaoRetorno != null) {
            return "Cartão salvo com sucesso";
        }
        return "Erro ao salvar o cartão";
    }

    @GetMapping("/cartao/{numeroCartao}")
    public Cartao getCartao(@PathVariable String numeroCartao) {
        return cartaoService.getCartao(numeroCartao);
    }

    @GetMapping("/cartao/{numeroCartao}/status")
    public StatusCartaoDTO statusCartao(@PathVariable String numeroCartao) {
        return cartaoService.getStatusCartao(numeroCartao);
    }


    @PutMapping("/cartao/{numeroCartao}/bloquear")
    public Cartao bloquearCartao(@PathVariable String numeroCartao) {
        return cartaoService.bloquearCartao(numeroCartao);
        //try {
        //    return cartaoService.bloquearCartao(numeroCartao);
        //} catch (CartaoNotFoundException exception) {
        //    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado");
        //}
    }

}
