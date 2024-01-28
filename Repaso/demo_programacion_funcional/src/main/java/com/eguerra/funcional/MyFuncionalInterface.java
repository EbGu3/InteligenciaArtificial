package com.eguerra.funcional;

// Interfaz, es un contrato,
// que obliga a una clase a
// implementar los metodos
// habilitando el polimorfismo
@FunctionalInterface
public interface MyFuncionalInterface {
    String doSomething(String parametro);
}
