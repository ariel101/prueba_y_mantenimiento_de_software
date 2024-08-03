package com.com470.ExamenApi.repositories;

import com.com470.ExamenApi.models.Examen;

import java.util.List;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}
