package com.eguerra;

import com.eguerra.cspProblems.AustraliaColoringConstraint;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        // Planear el CSP
        //Variables, Listado de estados
        List<String> variables = List.of("Wastern Australia",
                "North Territory",
                "Queensland",
                "South Australia",
                "New South Wakes",
                "Victoria",
                "Tasmania"
        );

        //Dominios, Asignarle los dominos a las variables
        Map<String, List<String>> dominios = new HashMap<>();
        for (var variable:variables) {
            dominios.put(variable, List.of("rojo", "verde", "azul"));
        }

        CSP<String, String> problema = new CSP<>(variables, dominios);

        //Restricciones
        problema.setConstraint(new AustraliaColoringConstraint("Wastern Australia", "North Territory")); //North Territory, no es compatible con North Territory
        problema.setConstraint(new AustraliaColoringConstraint("Wastern Australia", "South Australia"));
        problema.setConstraint(new AustraliaColoringConstraint("North Territory", "South Australia"));
        problema.setConstraint(new AustraliaColoringConstraint("North Territory", "Queensland"));
        problema.setConstraint(new AustraliaColoringConstraint("South Australia", "Queensland"));
        problema.setConstraint(new AustraliaColoringConstraint("New South Wakes", "Queensland"));
        problema.setConstraint(new AustraliaColoringConstraint("New South Wakes", "South Australia"));
        problema.setConstraint(new AustraliaColoringConstraint("Victoria", "New South Wakes"));
        problema.setConstraint(new AustraliaColoringConstraint("Victoria", "Victoria"));
        problema.setConstraint(new AustraliaColoringConstraint("Victoria", "South Australia"));
        problema.setConstraint(new AustraliaColoringConstraint("Victoria", "Tasmania"));

        var solution = problema.backtrack();
        System.out.println(solution);
    }
}