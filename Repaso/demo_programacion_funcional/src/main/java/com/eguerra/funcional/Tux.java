package com.eguerra.funcional;

public class Tux implements MyFuncionalInterface {
    @Override
    public String doSomething(String parametro) {
        return "Hola soy Tux 🐶 => Tu peticion es = " + parametro;
    }
}
