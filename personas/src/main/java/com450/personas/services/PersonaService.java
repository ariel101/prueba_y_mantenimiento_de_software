package com450.personas.services;

import com450.personas.models.Personas;
import com450.personas.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public List<Personas> getPersonas(){
        return personaRepository.findAll();
    }

    public Optional<Personas> getPersonasId(Long id){
        return personaRepository.findById(id);
    }

    public Personas guardarModificar(Personas personas){
        personaRepository.save(personas);
        return personas;
    }

    public Personas actualizarPersona(Long id, Personas personas){
        Optional<Personas> personas1 = personaRepository.findById(id);
        if(personas1.isPresent()){
            Personas personas2 = personas1.get();
            personas2.setNombre(personas.getNombre());
            personas2.setApellido(personas.getApellido());
            personas2.setProfesion(personas.getProfesion());
            personas2.setCorreo(personas.getCorreo());

            return personaRepository.save(personas2);
        }
        else{
            throw new IllegalArgumentException("La persona con ID " + id + " no existe.");
        }

    }

    public void eliminar(Long id){
        personaRepository.deleteById(id);
    }
}
