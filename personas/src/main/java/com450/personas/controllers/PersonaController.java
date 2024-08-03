package com450.personas.controllers;

import com450.personas.models.Personas;
import com450.personas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping(path = "/api/v1/personas/form")
public class PersonaController {
    Personas personas = new Personas();

    @Autowired
    private PersonaService personaService;
    @GetMapping("/personas")
    public String getAll(Model model){
        List<Personas> personas = personaService.getPersonas();
        model.addAttribute("personas",personas);
        //personaService.getPersonas();
        return "personas";
    }

    @GetMapping("/{buscarId}")
    public Optional<Personas> getAllById(@PathVariable("buscarId") Long id){
        return personaService.getPersonasId(id);
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("persona", new Personas());
        return "formulario";
    }

    @PostMapping("/formulario")
    public String registrar(@ModelAttribute("personas") Personas personas){
        //logger.info("Received product data: {}", personas);
        //return personaService.guardarModificar(personas);
        personaService.guardarModificar(personas);
        return "redirect:/personas";

    }

    @PutMapping("/{updateId}")
    public Personas actualizar(@PathVariable("updateId") Long id, @RequestBody Personas personas){
        return personaService.actualizarPersona(id, personas);
    }

    @DeleteMapping("/{personaId}")
    public void eliminar(@PathVariable("personaId") Long personaId){

        personaService.eliminar(personaId);
    }
}
