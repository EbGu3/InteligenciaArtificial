package com.eguerra;

import java.util.List;
import java.util.Map;

// TODO: Son las restricciones
// V: tipo de dato de variables
// D: tipo de dato de dominio
public abstract class Constraint<V, D> {
    protected List<V> _variables;  // INFO: En este momento no sabemos si es binario o unario

    public  Constraint(List<V> variables) {
        this._variables = variables;
    }

    // Verificar si es contraint
    // ha sido satisfecho por la logica
    // del problema
    // Map<V, D) -> COMBINACION DE VARIABLE CON EL DOMINIO
    public abstract boolean isSatisfied(Map<V, D> assignament);
}
