package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    Fibonacci fibonacci =  new Fibonacci();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void fibonacci(int n) {
        String resultado = fibonacci.fibonacci(n);
        String esperado1 = "0,1,1";
        String esperado2 = "0,1,1,2,3";
        String esperado3 = "0,1,1,2,3,5";
        switch (n){
            case 1:
                assertEquals(esperado1, resultado);
                break;
            case 3:
                assertEquals(esperado2, resultado);
                break;
            case 5:
                assertEquals(esperado3, resultado);
                break;
            default:
        }
    }
}