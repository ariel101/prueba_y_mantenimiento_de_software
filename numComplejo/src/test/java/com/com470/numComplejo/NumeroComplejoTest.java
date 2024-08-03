package com.com470.numComplejo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumeroComplejoTest {

    //NumeroComplejo numeroComplejo = new NumeroComplejo(4,6);

    /*
    @Test
    void getParteReal() {
    }

    @Test
    void getParteImaginaria() {
    }
    */

    @ParameterizedTest
    @CsvSource({
            "3, 4, 1, 2, 4, 6", // parteReal1, parteImaginaria1, parteReal2, parteImaginaria2, resultadoSumaParteReal, resultadoSumaParteImaginaria
            "5, 6, 2, 3, 7, 9",
            "2, 3, 1, 1, 3, 4"
    })
    void sumar(int parteReal1, int parteImaginaria1, int parteReal2, int parteImaginaria2,
               int resultadoSumaParteReal, int resultadoSumaParteImaginaria) {

        NumeroComplejo numero1 = new NumeroComplejo(parteReal1, parteImaginaria1);
        NumeroComplejo numero2 = new NumeroComplejo(parteReal2, parteImaginaria2);
        NumeroComplejo resultadoEsperado = new NumeroComplejo(resultadoSumaParteReal, resultadoSumaParteImaginaria);

        NumeroComplejo resultadoSuma = numero1.sumar(numero2);

        assertEquals(resultadoEsperado.getParteReal(), resultadoSuma.getParteReal());
        assertEquals(resultadoEsperado.getParteImaginaria(), resultadoSuma.getParteImaginaria());
        System.out.println("Suma: (" + parteReal1 + " + " + parteImaginaria1 + "i) + (" + parteReal2 + " + " + parteImaginaria2 + "i) = " +
                resultadoSuma.getParteReal() + " + " + resultadoSuma.getParteImaginaria() + "i");
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 1, 2, 2, 2", // parteReal1, parteImaginaria1, parteReal2, parteImaginaria2, resultadoRestaParteReal, resultadoRestaParteImaginaria
            "5, 6, 2, 3, 3, 3",
            "2, 3, 1, 1, 1, 2"
    })
    void restar(int parteReal1, int parteImaginaria1, int parteReal2, int parteImaginaria2,
                int resultadoRestaParteReal, int resultadoRestaParteImaginaria) {

        NumeroComplejo numero1 = new NumeroComplejo(parteReal1, parteImaginaria1);
        NumeroComplejo numero2 = new NumeroComplejo(parteReal2, parteImaginaria2);
        NumeroComplejo resultadoEsperado = new NumeroComplejo(resultadoRestaParteReal, resultadoRestaParteImaginaria);

        NumeroComplejo resultadoResta = numero1.restar(numero2);

        assertEquals(resultadoEsperado.getParteReal(), resultadoResta.getParteReal());
        assertEquals(resultadoEsperado.getParteImaginaria(), resultadoResta.getParteImaginaria());
        System.out.println("Resta: (" + parteReal1 + " + " + parteImaginaria1 + "i) - (" + parteReal2 + " + " + parteImaginaria2 + "i) = " +
                resultadoResta.getParteReal() + " + " + resultadoResta.getParteImaginaria() + "i");
    }
}