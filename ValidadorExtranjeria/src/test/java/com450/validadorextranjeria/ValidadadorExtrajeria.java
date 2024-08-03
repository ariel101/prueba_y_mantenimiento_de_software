package com450.validadorextranjeria;

public class ValidadadorExtrajeria {
    public boolean validar(String number) {
        if (number==null) return false;
        return number.length()==10 && number.contains("E-");

    }
}
