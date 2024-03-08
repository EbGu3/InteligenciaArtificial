package com.eguerra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Problema, se da en realacion
// con su variable con respecto al dominio
public class CSP<V, D> {

    // Control de variables, dominio y restricciones
    private List<V> _variables;
    private Map<V, List<D>> _dominios; // Asignacion, donde cada variable, puede tener compatiblidad con distintos valores para un domino D
    private Map<V, List<Constraint<V, D>>> _constraint = new HashMap<>(); // Puede haber una restriccion, para cada variable... donde tenemos restricciones las cuales trabajan sobre los tipos de datos abrastractos, al incio no estan configuradas

    public CSP(List<V> variables, Map<V, List<D>> dominios) {
        this._variables = variables;
        this._dominios = dominios;

        // Prefabricar el listado de constraint de acuerdo a cada una de las variables que recibo
        for (V variable: variables) {
            _constraint.put(variable, new ArrayList<Constraint<V, D>>()); // Para cada variable, inicializo como vacio el constrain

            // Cada variable debe de tener un domino asingado
            if (!dominios.containsKey(variable)){
                throw  new IllegalArgumentException("La variable = " + variable + " no contiene un domiminio");
            }
        }
    }

    public  void setConstraint(Constraint<V, D> newConstraint) {
        // Depende de la variable o variables que forman parte del constraint
        for (V variable:newConstraint._variables) {
            // Variable que se encuentra en el constraint sea parte del csp
            if (this._variables.contains((variable))) {
                throw new IllegalArgumentException("La variable " +  variable + " no se encuentra en el csp");
            }
            _constraint.get(variable).add(newConstraint);
        }
    }

    // TODO: Que una variable sea consistente con una asignacion
    public  boolean isConsistente(V variable, Map<V, D> assigmente) {
        // Obtener las limitantes especificas de cada variable
        for (var constraint: this._constraint.get(variable)) {
            if (!constraint.isSatisfied(assigmente)) {
                return  false; //No se satisface un constraint
            }
        }
        return  true; // TODO: se satisface el constraint
    }

    public Map<V, D> backtrack() {
        return  backtrack(new HashMap<>());
    }

    public  Map<V, D> backtrack(Map<V, D> assigment) {
        // TODO: Condicion de escape. Si cada variable tiene un valor
        if (_variables.size() == assigment.size()) {
            return assigment;
        }

        // TODO: Seleccionar una variable no asignada
        var variableNoAsignada = _variables
                                        .stream()
                                        .filter(variable -> !assigment.containsKey(variable))
                                        .findFirst()
                                        .get();

        //  TODO: Iterar a travez de los valores del domino que pertencezca a la variable

        for (D domineValue: _dominios.get(variableNoAsignada)) {
            System.out.println("Variable: " + variableNoAsignada + ", " + "Valor Dominio: " + domineValue);

            // TODO: Probar la asignacion
            //    1. Crear una copia de la asginacion anterior
            Map<V, D> tempAssigment = new HashMap<>(assigment);
            //    2. Probar (asginar un valor)
            tempAssigment.put(variableNoAsignada, domineValue);
            //    3. Verificar la consistencia de la asignacion, es decir que cumpla con los constraint
            if (isConsistente(variableNoAsignada, tempAssigment)) {
                Map<V, D> resultado = backtrack(tempAssigment);

                if (resultado != null) {
                    // TODO: Se encontro solucion
                    return resultado;
                }
            }
        }
        // TODO: No se encontro solucion
        return null;
    }
}
