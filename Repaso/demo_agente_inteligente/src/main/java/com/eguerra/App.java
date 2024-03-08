package com.eguerra;

import com.eguerra.graph.BFS;
import com.eguerra.graph.Node;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Node<String> zona1 = new Node<String>("Zona 1");
        Node<String> zona2 = new Node<String>("Zona 2");
        Node<String> zona5 = new Node<String>("Zona 5");
        Node<String> zona4 = new Node<String>("Zona 4");
        Node<String> zona10 = new Node<String>("Zona 10");
        Node<String> zona15 = new Node<String>("Zona 15");
        Node<String> zona16 = new Node<String>("Zona 16");

        zona1.connectNeighboar(zona2);
        zona1.connectNeighboar(zona5);
        zona1.connectNeighboar(zona4);
        zona5.connectNeighboar(zona4);
        zona4.connectNeighboar(zona10);
        zona10.connectNeighboar(zona15);
        zona15.connectNeighboar(zona16);


        BFS.search("Zona 16", zona2);

    }
}

/*
* 1. Representacion del problema    -> Grafo
* 2. Representacion del nodo        -> Posibles nodos
* 3. Ejecucion del metodo busqueda ->
*/