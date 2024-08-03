package com.com470.logeoapi.controller;
@SuppressWarnings("serial")
public class ExcepcionUsuarioDesconocido  extends RuntimeException {
    public ExcepcionUsuarioDesconocido() {
        super("Usuario desconocido");
    }
}
