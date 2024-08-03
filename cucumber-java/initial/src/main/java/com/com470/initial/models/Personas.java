package com.com470.initial.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Personas {

    @Id
    private Long id;
    private String nombre;
    private int edad;
}
