package br.edu.insper.banco.cartao;

import br.edu.insper.banco.cliente.Cliente;
import br.edu.insper.banco.conta.Conta;
import br.edu.insper.banco.conta.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

@Service
public class CartaoService {

    private HashMap<String, Cartao> cartoes = new HashMap<>();

    @Autowired
    private ContaService contaService;

    public HashMap<String, Cartao> getCartoes() {
        return cartoes;
    }

    public Cartao salvarCartao(Cartao cartao) {
        Conta conta = contaService.getConta(cartao.getConta().getId());
        if (conta == null) {
            return null;
        }

        cartao.setStatusCartao(Cartao.StatusCartao.VALIDO);
        cartao.setConta(conta);
        cartoes.put(cartao.getNumeroCartao(), cartao);
        return cartao;
    }

    public Cartao getCartao(String numeroCartao) {
        return cartoes.get(numeroCartao);
    }

    public StatusCartaoDTO getStatusCartao(String numeroCartao) {
        Cartao cartao = getCartao(numeroCartao);
        if (cartao != null) {

            if (cartao.getStatusCartao().equals(Cartao.StatusCartao.VALIDO) &&
                    cartao.getDataValidade().isBefore(LocalDate.now())) {
                cartao.setStatusCartao(Cartao.StatusCartao.VENCIDO);
            }

            return new StatusCartaoDTO(cartao.getNumeroCartao(), cartao.getStatusCartao());
        }
        return null;
    }

    public Cartao bloquearCartao(String numeroCartao) {
        Cartao cartao = getCartao(numeroCartao);
        if (cartao != null && cartao.getStatusCartao().equals(Cartao.StatusCartao.VALIDO)) {
            cartao.setStatusCartao(Cartao.StatusCartao.BLOQUEADO);
            return cartao;
        } else if (cartao == null) {
            throw new CartaoNotFoundException();
        }
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cartão já está bloqueado ou vencido");
    }
}
