package com.eguerra.graph;

import java.util.*;

public class BFS {

    // Prevenir el null pointer exception
    public static<T> Optional<Node<T>> search(T valueFind, Node<T> startValue) {
        List<Node<T>> visitados = new ArrayList<>();
        List<String> waysRecorridos = new ArrayList<>();
        Queue<Node<T>> queue = new ArrayDeque<>();

        Node<T> actualNode;
        String way = "";
        String wayNode = "";
        while (!queue.isEmpty()) {
            actualNode = queue.peek();
            way += actualNode.getValue().toString();

            if (actualNode.getValue().equals(valueFind)) {
                //  Todo hacer algo
            }
            else if (actualNode.getNeighboars().isEmpty()) {
                visitados.add(actualNode);
                waysRecorridos.add(way);

                var pos = way.lastIndexOf(actualNode.getValue().toString());
                way = way.substring(0, pos);
                continue;
            } else {
                visitados.add(actualNode);
                queue.addAll(actualNode.getNeighboars())
            }
        }




        Queue<Node<T>> queue = new ArrayDeque<>(); // Frontera
        queue.add(startValue);

        Node<T> actualNode;
        Set<Node<T>> closed = new HashSet<>(); // Representar el espacio explorado


        while (!queue.isEmpty()) { // Paso 1: Verificar si puedo continuar
            actualNode = queue.peek(); // Expande el primer nodo que entra
            System.out.println("Visiando el nodo => " + actualNode.getValue());

            // Verifico si se encuentra en la meta
            if (actualNode.getValue().equals(valueFind)) {// Paso 2: Verifico si encontre la meta
                return Optional.of(actualNode);
            }
            else {
                closed.add(actualNode); //Agrego el nodo actual a, mi espacio explorado
                queue.addAll(actualNode.getNeighboars()); // Permito que se expanda el nodo actual
                queue.removeAll(closed); // Remuevo lo que tengo en mi espacio explorado
            }
        }
        return Optional.empty();
    }
}
