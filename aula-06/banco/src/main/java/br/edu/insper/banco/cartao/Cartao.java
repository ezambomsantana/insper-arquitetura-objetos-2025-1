package br.edu.insper.banco.cartao;

import br.edu.insper.banco.conta.Conta;

import java.time.LocalDate;

public class Cartao {

    enum TipoCartao {
        DEBITO, CREDITO
    }
    enum StatusCartao {
        VALIDO, BLOQUEADO, VENCIDO
    }

    private String numeroCartao;
    private String cvv;
    private TipoCartao tipoCartao;
    private LocalDate dataValidade;
    private StatusCartao statusCartao;
    private Conta conta;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public TipoCartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public StatusCartao getStatusCartao() {
        return statusCartao;
    }

    public void setStatusCartao(StatusCartao statusCartao) {
        this.statusCartao = statusCartao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
