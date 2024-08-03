package com470.ejemplo1.ejemplos;

public class PasswordUtils {
    public enum SecurityLevel {
        WEAK,MEDIUM,STRONG
    }
    public SecurityLevel compruebaPassword(String password) {
        //return null;
        //return SecurityLevel.WEAK;
        if (password.length()<8) {
            return SecurityLevel.WEAK;
        }

        if (password.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }

        if (password.matches("[a-zA-Z0-9]+")) {
            return SecurityLevel.MEDIUM;
        }
        return SecurityLevel.STRONG;
    }

    public boolean esMayorQue10(int num) {
        if (num>10) {
            return true;
        }
        else {
            return false;
        }
    }
}
