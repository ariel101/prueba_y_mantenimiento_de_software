package com470.ejemplo1.ejemplos;

public class Utilidades {

    public String holaMundo(String uno, String dos){
        if(uno==null && dos==null){
            return null;
        }
        return uno.concat(" ").concat(dos);
    }
}
