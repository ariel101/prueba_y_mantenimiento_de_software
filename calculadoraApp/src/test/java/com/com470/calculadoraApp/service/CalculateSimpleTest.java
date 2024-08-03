package com.com470.calculadoraApp.service;

import com.com470.calculadoraApp.model.OperationModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateSimpleTest {
    CalculateSimple calculateSimple = new CalculateSimple();

    @Test
    void add() {
        OperationModel operationModel = new OperationModel(5,6);
        int resultadoEsperado = 11;
        int resultado = calculateSimple.add(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void subtract() {
        OperationModel operationModel = new OperationModel(9,4);
        int resultadoEsperado = 5;
        int resultado = calculateSimple.subtract(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void multiply() {
        OperationModel operationModel = new OperationModel(5,4);
        int resultadoEsperado = 20;
        int resultado = calculateSimple.multiply(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void divide() {
        OperationModel operationModel = new OperationModel(50,5);
        int resultadoEsperado = 10;
        double resultado = calculateSimple.divide(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void factorial() {
        OperationModel operationModel = new OperationModel(5);
        int resultadoEsperado = 120;
        int resultado = calculateSimple.factorial(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void fibonacci() {
        OperationModel operationModel = new OperationModel(8);
        int resultadoEsperado = 21;
        int resultado = calculateSimple.fibonacci(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void sqrt() {
        OperationModel operationModel = new OperationModel(9);
        int resultadoEsperado = 3;
        double resultado = calculateSimple.sqrt(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void power() {
        OperationModel operationModel = new OperationModel(4);
        int resultadoEsperado = 16;
        int resultado = calculateSimple.power(operationModel);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    void clearSimple() {
        OperationModel operationModel = new OperationModel(3,4);
        OperationModel resultadoEsperado = new OperationModel(0,0);
        OperationModel resultado = calculateSimple.clearSimple(operationModel);
        assertEquals(resultadoEsperado.getA(),resultado.getA());
        assertEquals(resultadoEsperado.getB(), resultado.getB());
    }

    @Test
    void clearAdvanced() {

        OperationModel operationModel = new OperationModel(4);
        OperationModel resultadoEsperado = new OperationModel(0);
        OperationModel resultado = calculateSimple.clearAdvanced(operationModel);
        assertEquals(resultadoEsperado.getC(), resultado.getC());
    }
}