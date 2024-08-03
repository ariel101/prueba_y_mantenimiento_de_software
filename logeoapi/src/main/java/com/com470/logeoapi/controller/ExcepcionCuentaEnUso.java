package com.com470.logeoapi.controller;

@SuppressWarnings("serial")
public class ExcepcionCuentaEnUso  extends RuntimeException {
    public ExcepcionCuentaEnUso() {
        super("Cuenta en uso");
    }
}
