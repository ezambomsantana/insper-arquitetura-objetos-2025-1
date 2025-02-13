package org.example;


import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Console console = System.console();
        System.out.println("Digite o texto:");
        String var1 = console.readLine();
        System.out.print("Digite o texto:");
        String var3 = console.readLine();
        System.out.println(var1);

        int valor = Integer.parseInt(var3);


        int var2 = var1.length();

        System.out.println(var2);

        if (var2 > 5) {
            System.out.println("maior 5");
        } else if (var2 > 10) {
            System.out.println("maior 10");
        } else {
            System.out.println("qualquer coisa");
        }

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        for (int i = 0 ; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

        for (Integer s : lista) {
            System.out.println(s);
        }

        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        for (String s : set) {
            System.out.println(s);
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");

        for (String k : map.keySet()) {
            String v = map.get(k);
            System.out.println(v);
        }


        Filme filme = new Filme();
        filme.nome = "Filme";
        filme.ano = 2000;
        filme.atores.add("aaaa");
        filme.atores.add("");
        filme.addAtores("ator-1");
        filme.addAtores("");

    }
}