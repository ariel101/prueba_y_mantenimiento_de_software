package springboot.conectionmysql.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Clients {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
}
