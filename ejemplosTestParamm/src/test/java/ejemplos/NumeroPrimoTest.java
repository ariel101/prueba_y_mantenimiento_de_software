package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumeroPrimoTest {
    NumeroPrimo numeroPrimo = new NumeroPrimo();

    @ParameterizedTest
    @CsvSource({"2,true", "6,false", "19,true","22,false"})
    void validate(int numero, boolean resultado) {

        assertEquals(resultado, numeroPrimo.validate(numero));
    }
}