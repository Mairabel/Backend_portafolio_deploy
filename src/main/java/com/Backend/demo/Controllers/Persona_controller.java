package com.Backend.demo.Controllers;

import com.Backend.demo.Models.Persona;
import com.Backend.demo.Services.Persona_service;
import javax.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "http://localhost:8080")
public class Persona_controller {
    @Autowired
    private Persona_service persona_service;
    
    @PutMapping("/edit")
    public ResponseEntity<Persona> Edit_persona(@Valid @RequestBody Persona persona){
        Optional<Persona> persona_optional = persona_service.Get_persona(1);
        
        if(!persona_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        persona.setId_persona(persona_optional.get().getId_persona());
        persona_service.Add_persona(persona);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/get/id/{id_persona}")
    public ResponseEntity<Persona> Get_persona(@PathVariable("id_persona") int id_persona){
        Optional<Persona> persona_optional = persona_service.Get_persona(id_persona);
        
        if(!persona_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(persona_optional.get());
    }
}
