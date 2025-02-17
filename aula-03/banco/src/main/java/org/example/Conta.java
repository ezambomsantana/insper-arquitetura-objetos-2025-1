package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Conta {

    private String numeroConta;
    private String agencia;
    private float saldo;
    private float limite;
    private Cliente principal;
    private Cliente dependente;
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public void saque(int valor) {

        if (this.saldo + this.limite >= valor) {
            this.saldo -= valor;

            Transacao transacao = new Transacao();
            transacao.setValor(valor);
            transacao.setTipo("saque");
            transacao.setHorario(LocalDateTime.now());
            this.transacoes.add(transacao);
        }

    }

    public void deposito(float valor) {
        this.saldo += valor;

        Transacao transacao = new Transacao();
        transacao.setValor(valor);
        transacao.setTipo("deposito");
        transacao.setHorario(LocalDateTime.now());
        this.transacoes.add(transacao);
    }

    public void defineLimite() {
        if (principal != null) {
            this.limite = this.principal.getRenda() / 2;
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public Cliente getPrincipal() {
        return principal;
    }

    public void setPrincipal(Cliente principal) {
        this.principal = principal;
    }

    public Cliente getDependente() {
        return dependente;
    }

    public void setDependente(Cliente dependente) {
        this.dependente = dependente;
    }
}
