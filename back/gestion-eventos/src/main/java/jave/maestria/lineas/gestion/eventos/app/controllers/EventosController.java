package jave.maestria.lineas.gestion.eventos.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jave.maestria.lineas.gestion.eventos.app.models.entity.Eventos;
import jave.maestria.lineas.gestion.eventos.app.services.IEventosservice;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/eventos")
public class EventosController {

    @Autowired
    private IEventosservice eventosService;

    @PostMapping("/crear")
    @PreAuthorize("hasAnyRole('ROLE_STANDARD', 'ROLE_PREMIUM')")
    public Eventos crearEvento(@RequestBody Eventos evento) {
        return eventosService.guardar(evento);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ROLE_PREMIUM')")
    public void eliminarEvento(@PathVariable Long id) {
        eventosService.eliminar(id);
    }
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_STANDARD', 'ROLE_PREMIUM')")
    public List<Eventos> obtenerEventos() {
        return eventosService.listaEventos();
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_STANDARD', 'ROLE_PREMIUM')")
    public Optional<Eventos> obtenerEventoPorId(@PathVariable Long id) {
        return eventosService.buscarId(id);
    }
    
    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAnyRole('ROLE_STANDARD', 'ROLE_PREMIUM')")
    public Eventos actualizarEvento(@PathVariable Long id, @RequestBody Eventos evento) {
        return eventosService.actualizarEvento(id, evento);
    }
}