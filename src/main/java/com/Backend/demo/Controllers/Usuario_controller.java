package com.Backend.demo.Controllers;

import com.Backend.demo.Models.Usuario;
import com.Backend.demo.Models.Persona;
import com.Backend.demo.Repositories.Persona_repository;
import com.Backend.demo.Repositories.Usuario_repository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:8080")
public class Usuario_controller {
    @Autowired
    private Usuario_repository usuario_repository;
    @Autowired
    private Persona_repository persona_repository;
    
    @GetMapping("/get/id/{id_usuario}")
    public ResponseEntity<Usuario> Get_usuario(@PathVariable("id_usuario") int id_usuario){
        Optional<Usuario> usuario_optional = usuario_repository.findById(id_usuario);
        
        if(!usuario_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(usuario_optional.get());
    }
    
    @GetMapping("/autenticar/{nombre}/{clave}")
    public boolean Add_autenticar(@PathVariable("nombre") String nombre, @PathVariable("clave") String clave){
        Optional<Persona> persona_optional = persona_repository.findById(1);
        Usuario user = persona_optional.get().getUsuario();
        return user.getNombre().equals(nombre) && user.getClave().equals(clave);
    }
}
