package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        Pessoa p = new Pessoa();
        p.setNome("Eduardo");
        p.setDataNascimento(LocalDate.of(1986, 3,7));
        p.setEndereco("Rua xyz");
        int idade = p.calculaIdade();

        System.out.println(idade);
        System.out.println(p);

        Pessoa p2 = new Pessoa();
        p2.setNome("Luiz");
        idade = p2.calculaIdade();
        System.out.println(p.getNome());
        System.out.println(p2.getNome());

        System.out.println(p2.equals(p));

        Carro carro = new Carro();
        carro.placa = "XYZ1234";
        carro.ano = 2020;
        carro.modelo = "Onix";

        p.addCarro(carro);
        p.addCarro(null);



    }
}