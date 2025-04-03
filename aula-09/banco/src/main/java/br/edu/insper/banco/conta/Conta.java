package br.edu.insper.banco.conta;

import br.edu.insper.banco.cliente.Cliente;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numeroConta;
    private String agencia;
    private float saldo;
    private float limite;

    @ManyToOne
    @JoinColumn(name = "id_principal")
    private Cliente principal;
    @ManyToOne
    @JoinColumn(name = "id_dependente")
    private Cliente dependente;
   // private ArrayList<Transacao> transacoes = new ArrayList<>();

    public Conta() {

    }

    public Conta(String numeroConta, String agencia, Cliente principal) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.principal = principal;
    }

    public void saque(float valor) {

        if (this.saldo + this.limite >= valor) {
            this.saldo -= valor;

          //  addTransacao(valor, "saque");
        }

    }

    private void addTransacao(float valor, String tipo) {
        Transacao transacao = new Transacao();
        transacao.setValor(valor);
        transacao.setTipo(tipo);
        transacao.setHorario(LocalDateTime.now());
    //    this.transacoes.add(transacao);
    }

    public void deposito(float valor) {
        this.saldo += valor;

        addTransacao(valor, "deposito");
    }

    public void defineLimite() {
        if (principal != null) {
            this.limite = this.principal.getRenda() / 2;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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