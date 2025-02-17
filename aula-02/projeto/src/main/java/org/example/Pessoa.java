package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private ArrayList<Carro> carros = new ArrayList<>();

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void addCarro(Carro carro) {
        if (carro != null && carro.ano > 2022) {
            carros.add(carro);
        }
        calculaIdade();
    }

    public int calculaIdade() {
        if (dataNascimento != null) {
            return Period.between(dataNascimento, LocalDate.now()).getYears();
        }

        Carro carro = new Carro();
        carro.setModelo("X");

        addCarro(carro);
    }



    @Override
    public String toString() {
        return "Nome: " + nome + " Data : " + dataNascimento;
    }
}
