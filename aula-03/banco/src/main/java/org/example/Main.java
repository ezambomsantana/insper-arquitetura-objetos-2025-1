package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Eduardo");
        cliente.setCpf("1234");
        cliente.setRenda(1000);
        cliente.setDataNascimento(LocalDate.of(2020, 1, 1));

        Conta conta = new Conta();
        conta.setNumeroConta("123");
        conta.setAgencia("123");
        conta.setPrincipal(cliente);

        conta.defineLimite();
        conta.deposito(100);
        System.out.println(conta.getSaldo());
        conta.saque(200);
        System.out.println(conta.getSaldo());
        conta.saque(400);
        System.out.println(conta.getSaldo());

    }
}