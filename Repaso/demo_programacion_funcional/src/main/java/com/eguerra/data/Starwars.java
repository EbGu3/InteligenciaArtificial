package com.eguerra.data;

import javax.swing.plaf.SplitPaneUI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Starwars {

    List<String> Jedis;

    public  Starwars() {
        this.setJedis();
    }

    public void setJedis() {
        Jedis = List.of("Yoda", "Bebe Yoda", "Widun", "Padawan", "Anakin", "Luke", "Rey");
    }

    public  void printTradicionalList () {
        for (int i = 0; i < Jedis.size(); i++) {
            var jedi = Jedis.get(i);
            System.out.println(jedi);
        }
    }

    public void printClasicList () {
        Jedis.forEach(System.out::println);
    }

    /// Esto es mas elegante :D
    public void removerNotJediWithPredicateFuncion () {
        // stream, representa un flujo de datos finitos o infinitos
        // codigo declarativo
        var jedis = Jedis.stream()
                .filter(jedi -> !jedi.equals("Rey")) //Operacion Map
                .peek(System.out::println) // Operacion Map, de auditoria, para ver que tiene el filtrp
                .map(jedi -> jedi.toString().toUpperCase()) // Operacion Map
                .collect(Collectors.toList()); // Operacion Reduce

        Jedis = jedis;
    }

}
