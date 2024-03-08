package com.eguerra.cspProblems;

import com.eguerra.Constraint;

import java.util.Map;
import java.util.*;
public class AustraliaColoringConstraint extends Constraint<String, String> {

    // Australia tiene restricciones binaria
    private String place1, place2;

    public AustraliaColoringConstraint(String place1, String place2) {
        super(List.of(place1, place2));
        this.place1 = place1;
        this.place2 = place2;
    }

    @Override
    public boolean isSatisfied(Map<String, String> assignament) {
        // Debo de chequear
        // Verificar si la variable, no se le ha asignado un valor
        if(!assignament.containsKey(place1) || !assignament.containsKey(place2)) {
            return  true;
        }

        // Verificar que los valores asignados a las variables no sean iguales
        return !assignament.get(place1).equals((place2));
    }
}
