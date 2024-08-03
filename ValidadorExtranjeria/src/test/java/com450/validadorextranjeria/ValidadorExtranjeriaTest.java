package com450.validadorextranjeria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorExtranjeriaTest {

    @Test
    void TestElCIExtrajeriaTiene10Caracteres() {
        ValidadadorExtrajeria validadadorExtrajeria = new ValidadadorExtrajeria();
        boolean resultado = validadadorExtrajeria.validar("E-12345678");
        assertTrue(resultado);
    }

    @Test
    void TestElCIExtrajeriaTieneMenos10Caracteres() {
        ValidadadorExtrajeria validadadorExtrajeria = new ValidadadorExtrajeria();
        boolean resultado = validadadorExtrajeria.validar("34567890");
        assertFalse(resultado);
    }
    @Test
    void TestElCIExtrajeriaTieneNull() {
        ValidadadorExtrajeria validadadorExtrajeria = new ValidadadorExtrajeria();
        boolean resultado = validadadorExtrajeria.validar(null);
        assertFalse(resultado);
    }

    @Test
    void TestElCIExtrajeriaTieneCaracteresyE() {
        ValidadadorExtrajeria validadadorExtrajeria = new ValidadadorExtrajeria();
        boolean resultado = validadadorExtrajeria.validar("E-34567890");
        assertTrue(resultado);
    }
}
