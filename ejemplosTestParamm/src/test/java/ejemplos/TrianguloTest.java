package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {

    @ParameterizedTest
    @CsvSource({
            "3,4,5,Escaleno",
            "5,5,5,Equilatero",
            "4,4,7,Isoceles"
    })
    void tipoTriangulo(int a, int b, int c, String tipoEsperado) {
        Triangulo resultado = new Triangulo();
        String resul = resultado.tipoTriangulo(a,b,c);
        assertEquals(tipoEsperado, resul);
    }
}