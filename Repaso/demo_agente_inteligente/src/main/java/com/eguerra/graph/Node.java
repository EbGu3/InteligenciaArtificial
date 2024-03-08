package com.eguerra.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Node<T> {

    private T value; // Valor que almacena el nodo
    private Set<Node<T>> neighboars; //Vecinos con los que se conecta

    public Node(T value) {
        this.value = value;
        this.neighboars = new HashSet<>();
    }

    public T getValue() {
        return this.value;
    }

    /**
     * Retorna en una coleccion los vecinos del nodo.
     * @return Collecion inmutable
     */
    public Set<Node<T>> getNeighboars() {
        return Collections.unmodifiableSet(this.neighboars);
    }

    public void connectNeighboar(Node<T> nodeNeighboar) {
        if (this == nodeNeighboar) throw  new IllegalArgumentException("Un nodo intenta referenciarse a si mismo");

        this.neighboars.add(nodeNeighboar); // Nodo actual conectado con nodeNeighboar
        nodeNeighboar.neighboars.add(this); // nodeNeighboar conectado con el nodo actual
    }

    public String toString() {
        return this.value.toString();
    }
}
