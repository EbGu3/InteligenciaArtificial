package com.eguerra;

import com.eguerra.data.Starwars;
import com.eguerra.data.StreamsDemo;
import com.eguerra.funcional.MyFuncionalInterface;
import com.eguerra.funcional.Pickachu;
import com.eguerra.funcional.Tux;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        var ejemplo = 3;

        if (ejemplo == 1) {
            // Ejemplo 1
            doSomethingTrandicional();
            doSomethingClassic();
            doSomethingFuncional();


            var pikachu = new Pickachu();
            doSomethingHideOrder(pikachu::pika);
            doSomethingHideOrder(pikachu::impactrueno);
            return;
        }

        if (ejemplo == 2) {
            // Ejemplo 2

            var instanciaStarwars = new Starwars();
            instanciaStarwars.printTradicionalList();
            System.out.println("------");
            instanciaStarwars.removerNotJediWithPredicateFuncion();
            instanciaStarwars.printClasicList();
            return;
        }

        if (ejemplo == 3)  {

            System.out.println("Iniciando Proceso");
            var numerosPrimos = StreamsDemo.createRadomList(Integer.valueOf(args[0]))
                                .parallelStream()
                                .filter(num -> StreamsDemo.isPrimeNumber(num))
                                .sorted()
                                .collect(Collectors.toList());

            System.out.println("Finalizando proceso");
            System.out.println("Primer numero primo = " + numerosPrimos.stream().findFirst());
            /*
            var primos = IntStream.range(0, 100)
                                    .boxed()
                                    .filter(num -> StreamsDemo.isPrimeNumber(num))
                                    .collect(Collectors.toList());

            System.out.println(primos);
            */

            //var randomNumbers = StreamsDemo.createRadomList(10);
            //System.out.println("Lista desordeanda");
            //System.out.println(randomNumbers);

            //System.out.println("Lista ordeanda");
            //System.out.println(StreamsDemo.sortListClasic(randomNumbers));
        }


    }

    public  static  void doSomethingTrandicional()
    {
        // Primer nivel
        // Sigo en programacion, orientada a objetos
        // Una clase que implementa una interfaz
        var instaciaTux = new Tux();
        System.out.println(
                instaciaTux.doSomething("Amo a Ivanna")
        );
    }

    public  static  void doSomethingClassic () {
        // Segundo nivel
        // Clase anonima, implementacion en linea de una interfaz
        // Clase anonima es donde, No necesito programar un clase clase con nombre
        var duke = new MyFuncionalInterface() {
            @Override
            public String doSomething(String parametro) {
                return "Hola soy duke 🐟 => Quieres = " + parametro;
            }
        };

        System.out.println(
                duke.doSomething("Ivanna es la mejor")
        );
    }

    public  static  void doSomethingFuncional() {
        // Tercera forma
        // Expresion landam, define la estructura de una funcional
        // Consentrarme solo en la funcion
        // Cumplir con al regla de la interfaz
        // Funcion anonima, porque es respeta el unico metodo de la
        // interfaz funcional

        MyFuncionalInterface clippy = (String param) -> {
          return  "Hola soy Clippy 🦈 => Tu peticion es => " + param;
        };

        MyFuncionalInterface wilbert = (peticion) -> {
            return  "Hola soy Wilbert 🍕 => Tu peticion es => " + peticion;
        };

        doSomethingHideOrder(clippy);
        doSomethingHideOrder(wilbert);
        doSomethingHideOrder(x -> "Hola soy anonymus 😎 => Tu peticion es => " + x);
    }

    public  static  void doSomethingHideOrder (MyFuncionalInterface comportamiento) {
        // Permite utilizar composicion de funciones
        System.out.println(
                comportamiento.doSomething("Ivanna es mi princesa")
        );
    }
}
