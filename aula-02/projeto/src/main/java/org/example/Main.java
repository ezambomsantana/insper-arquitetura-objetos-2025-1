package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Pessoa p = new Pessoa();
        p.nome = "Eduardo";
        p.dataNascimento = LocalDate.now();
        p.endereco = "Rua xyz";
        System.out.println(p);

        Pessoa p2 = new Pessoa();
        p2.nome = "Luiz";
        System.out.println(p.nome);
        System.out.println(p2.nome);

        System.out.println(p2.equals(p));

        Carro carro = new Carro();
        carro.placa = "XYZ1234";
        carro.ano = 2020;
        carro.modelo = "Onix";

        p.carros.add(carro);

        System.out.println(p.carros.get(0).modelo);

        for (Carro c : p.carros) {
            System.out.println(c.modelo);
        }

    }
}