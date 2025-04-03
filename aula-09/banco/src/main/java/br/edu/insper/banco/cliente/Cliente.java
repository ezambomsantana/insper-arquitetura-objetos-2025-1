package br.edu.insper.banco.cliente;

import br.edu.insper.banco.conta.Conta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private float renda;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "principal")
    @JsonIgnore
    private List<Conta> contasPrincipal;

    @OneToMany(mappedBy = "dependente")
    @JsonIgnore
    private List<Conta> contasDependente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        this.renda = renda;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Conta> getContasPrincipal() {
        return contasPrincipal;
    }

    public void setContasPrincipal(List<Conta> contasPrincipal) {
        this.contasPrincipal = contasPrincipal;
    }

    public List<Conta> getContasDependente() {
        return contasDependente;
    }

    public void setContasDependente(List<Conta> contasDependente) {
        this.contasDependente = contasDependente;
    }
}