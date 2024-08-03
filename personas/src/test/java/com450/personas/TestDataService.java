package com450.personas;

import com450.personas.models.Personas;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestDataService {

    private final String jdbcUrl = "jdbc:mysql://localhost:3306/dbtests";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "root";

    public List<Personas> obtenerDatosDePrueba() {
        List<Personas> personas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test_personas LIMIT 10");

            while (resultSet.next()) {
                Personas persona = new Personas();
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setProfesion(resultSet.getString("profesion"));
                persona.setCorreo(resultSet.getString("correo"));
                personas.add(persona);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return personas;
    }
}

