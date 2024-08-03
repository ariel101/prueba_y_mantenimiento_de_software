package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calculadora = new Calculadora();

    @ParameterizedTest
    @MethodSource("params")
    void suma(int a, int b) {
    }

    @ParameterizedTest
    @MethodSource("params")
    void resta(int a, int b) {
    }

    @ParameterizedTest
    @MethodSource("params")
    void multimplicacion(int a, int b) {
    }


    @ParameterizedTest
    @MethodSource("params")
    void division(int a, int b) {
    }

    static List<Object[]> params(){

        return Arrays.asList(new Object[][]{
                {4,6},
                {3,2},
                {1,0},
                {5,-2}
        });

    }
}