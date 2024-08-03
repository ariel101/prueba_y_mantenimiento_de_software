package com450.personas.repositories;

import com450.personas.models.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Personas, Long> {

}
