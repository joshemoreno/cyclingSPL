package jave.maestria.lineas.gestion.usuarios.controllers;

import jakarta.persistence.EntityNotFoundException;
import jave.maestria.lineas.gestion.usuarios.models.entity.GestionUsuarios;
import jave.maestria.lineas.gestion.usuarios.services.IGestionUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
public class GestionUsuariosController {

    @Autowired
    private IGestionUsuariosService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<GestionUsuarios> opt = service.findById(id);
        if (opt.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody GestionUsuarios gestionUsuarios){

        GestionUsuarios gestionUsuariosDb = service.crear(gestionUsuarios);

        return ResponseEntity.status(HttpStatus.CREATED).body(gestionUsuariosDb);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<?> editar(@RequestBody GestionUsuarios gestionUsuarios, @PathVariable Long id){

        try {
            GestionUsuarios gestionUsuarioEditado = service.editar(id, gestionUsuarios);

            return ResponseEntity.status(HttpStatus.CREATED).body(gestionUsuarioEditado);

        } catch (EntityNotFoundException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("mensaje", e.getMessage()));
        }
    }
}
