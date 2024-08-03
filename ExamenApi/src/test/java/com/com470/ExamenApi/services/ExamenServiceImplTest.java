package com.com470.ExamenApi.services;

import com.com470.ExamenApi.models.Examen;
import com.com470.ExamenApi.repositories.ExamenRepository;
import com.com470.ExamenApi.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ExamenServiceImplTest {

    private static final String EXAMEN_NOMBRE = "Matemáticas";
    private static final Long EXAMEN_ID = 1L;
    private static final List<String> PREGUNTAS = Arrays.asList("Pregunta 1", "Pregunta 2");

    private Examen examen;
    @Mock
    ExamenRepository examenRepository;
    @Mock
    PreguntaRepository preguntaRepository;
    @InjectMocks
    ExamenServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        examen = new Examen();
        examen.setId(EXAMEN_ID);
        examen.setNombre(EXAMEN_NOMBRE);
        examen.setPreguntas(new ArrayList<>());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        when(examenRepository.findAll()).thenReturn(Collections.emptyList());

        Optional<Examen> examenOptional = service.findExamenPorNombre(EXAMEN_NOMBRE);

        assertFalse(examenOptional.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(examenRepository.findAll()).thenReturn(Arrays.asList(examen));
        when(preguntaRepository.findPreguntasPorExamenId(EXAMEN_ID)).thenReturn(PREGUNTAS);

        Examen examenConPreguntas = service.findExamenPorNombreConPreguntas(EXAMEN_NOMBRE);

        assertNotNull(examenConPreguntas);
        assertEquals(EXAMEN_ID, examenConPreguntas.getId());
        assertEquals(EXAMEN_NOMBRE, examenConPreguntas.getNombre());
        assertEquals(PREGUNTAS.size(), examenConPreguntas.getPreguntas().size());
        assertEquals(PREGUNTAS, examenConPreguntas.getPreguntas());
    }

    @Test
    void testPreguntasExamenVerify() {
        when(examenRepository.findAll()).thenReturn(Arrays.asList(examen));
        when(preguntaRepository.findPreguntasPorExamenId(EXAMEN_ID)).thenReturn(PREGUNTAS);

        Examen examenConPreguntas = service.findExamenPorNombreConPreguntas(EXAMEN_NOMBRE);

        assertNotNull(examenConPreguntas);
        verify(preguntaRepository).findPreguntasPorExamenId(EXAMEN_ID);
    }

    @Test
    void findExamenPorNombre() {
        when(examenRepository.findAll()).thenReturn(Arrays.asList(examen));

        Optional<Examen> examenOptional = service.findExamenPorNombre(EXAMEN_NOMBRE);

        assertTrue(examenOptional.isPresent());
        assertEquals(EXAMEN_NOMBRE, examenOptional.get().getNombre());
    }

    @Test
    void testGuardarExamen() {
        examen.setPreguntas(PREGUNTAS);
        when(examenRepository.guardar(any(Examen.class))).thenReturn(examen);

        Examen examenGuardado = service.guardar(examen);

        assertNotNull(examenGuardado);
        assertEquals(EXAMEN_ID, examenGuardado.getId());
        assertEquals(EXAMEN_NOMBRE, examenGuardado.getNombre());
        assertEquals(PREGUNTAS.size(), examenGuardado.getPreguntas().size());
        assertEquals(PREGUNTAS, examenGuardado.getPreguntas());

        verify(preguntaRepository).guardarVarias(anyList());
    }
}