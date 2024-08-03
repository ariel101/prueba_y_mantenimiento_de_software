package com.com470.logeoapi.service;

import com.com470.logeoapi.controller.ExcepcionCuentaEnUso;
import com.com470.logeoapi.controller.ExcepcionUsuarioDesconocido;
import com.com470.logeoapi.controller.ICuenta;
import com.com470.logeoapi.controller.IRepositorioCuentas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class GestorLoginTest {

    @Mock
    private IRepositorioCuentas repo;

    @Mock
    private ICuenta cuentaMock;

    @InjectMocks
    private GestorLogin gestorLogin;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAccesoDenegadoTrasTresIntentos() {
        when(repo.buscar(anyString())).thenReturn(cuentaMock);
        when(cuentaMock.estaEnUso()).thenReturn(false);
        when(cuentaMock.estaBloqueada()).thenReturn(false);
        when(cuentaMock.claveCorrecta(anyString())).thenReturn(false);

        for (int i = 0; i < 3; i++) {
            gestorLogin.acceder("usuario", "claveIncorrecta");
        }

        // Verificar que bloquearCuenta fue llamado una vez después de tres intentos fallidos
        verify(cuentaMock, times(1)).bloquearCuenta();
        // Verificar que el número de fallos es 3
        assertEquals(3, gestorLogin.getNumFallos());
    }

    @Test
    public void testBloquearTrasTresIntentos() {
        when(repo.buscar(anyString())).thenReturn(cuentaMock);
        when(cuentaMock.estaEnUso()).thenReturn(false);
        when(cuentaMock.estaBloqueada()).thenReturn(false);
        when(cuentaMock.claveCorrecta(anyString())).thenReturn(false);

        for (int i = 0; i < 3; i++) {
            gestorLogin.acceder("usuario", "claveIncorrecta");
        }

        verify(cuentaMock, times(1)).bloquearCuenta(); // Verificar que se llama una vez
        assertTrue(gestorLogin.getNumFallos() >= 3);
    }


    @Test
    public void testAccesoAlPrimero() {
        when(repo.buscar(anyString())).thenReturn(cuentaMock);
        when(cuentaMock.estaEnUso()).thenReturn(false);
        when(cuentaMock.estaBloqueada()).thenReturn(false);
        when(cuentaMock.claveCorrecta(anyString())).thenReturn(true);

        gestorLogin.acceder("usuario", "claveCorrecta");

        verify(cuentaMock, times(1)).entrarCuenta();
        assertEquals(0, gestorLogin.getNumFallos());
    }

    @Test
    public void testUsuarioEnUso() {
        when(repo.buscar(anyString())).thenReturn(cuentaMock);
        when(cuentaMock.estaEnUso()).thenReturn(true);

        Exception exception = assertThrows(ExcepcionCuentaEnUso.class, () -> {
            gestorLogin.acceder("usuario", "clave");
        });

        String expectedMessage = "Cuenta en uso";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testUsuarioDesconocido() {
        when(repo.buscar(anyString())).thenReturn(null);

        Exception exception = assertThrows(ExcepcionUsuarioDesconocido.class, () -> {
            gestorLogin.acceder("usuarioDesconocido", "clave");
        });

        String expectedMessage = "Usuario desconocido";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}