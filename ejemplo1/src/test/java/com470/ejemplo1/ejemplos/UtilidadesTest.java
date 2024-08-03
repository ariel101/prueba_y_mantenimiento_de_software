package com470.ejemplo1.ejemplos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadesTest {
    Utilidades utilidades = new Utilidades();

    @Test
    void holaMundo() {
        String resultado = utilidades.holaMundo("Hola","Mundo");
        assertEquals("HolaMundo",resultado);
    }

    @Test
    void holaMundoNull() {
        String resultado = utilidades.holaMundo(null,"Mundo");
        assertEquals(null,resultado);
    }


}