package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {

    String nome;
    LocalDate dataNascimento;
    String endereco;
    ArrayList<Carro> carros = new ArrayList<>();

    @Override
    public String toString() {
        return "Nome: " + nome + " Data : " + dataNascimento;
    }
}
