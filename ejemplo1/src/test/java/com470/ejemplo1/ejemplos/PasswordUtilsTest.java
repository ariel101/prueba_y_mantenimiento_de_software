package com470.ejemplo1.ejemplos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {
    PasswordUtils passwordUtils = new PasswordUtils();

    @Test
    void compruebaPasswordDebilMenosDeOcho() {

        assertEquals(PasswordUtils.SecurityLevel.WEAK.);
    }

    @Test
    void compruebaPasswordDebilMenosDeOcho() {

        assertEquals(passwordUtils.SecurityLevel.WEAK.compruebaPassword("12345"));
    }

    @Test
    void compruebaPasswordDebilMenosDeOcho() {

        assertEquals(passwordUtils.SecurityLevel.WEAK.compruebaPassword("12345"));
    }


}