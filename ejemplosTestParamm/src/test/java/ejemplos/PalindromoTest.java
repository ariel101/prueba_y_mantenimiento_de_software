package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromoTest {
    Palindromo palindromo = new Palindromo();

    @ParameterizedTest
    @CsvSource({"SOMOS,true", "araña,false", "murcielago,false", "ana,true"})
    void buscaPalindromo(String valor, boolean resultado) {

        assertEquals(resultado, palindromo.buscaPalindromo(valor));
    }
}