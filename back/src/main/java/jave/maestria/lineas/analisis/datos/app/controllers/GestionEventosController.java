package jave.maestria.lineas.analisis.datos.app.controllers;


import jave.maestria.lineas.analisis.datos.app.models.entity.GestionEventos;
import jave.maestria.lineas.analisis.datos.app.services.GestionEventosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gestion-eventos")
public class GestionEventosController {
    private final GestionEventosService gestionEventosService;

    public GestionEventosController( GestionEventosService gestionEventosService) {
        this.gestionEventosService = gestionEventosService;
    }



    @GetMapping("/por-mes")
    public ResponseEntity<Map<String, List<GestionEventos>>> obtenerEventosPorMes() {
        Map<String, List<GestionEventos>> eventosPorMes = gestionEventosService.obtenerEventosPorMes();
        return ResponseEntity.ok(eventosPorMes);
    }
}
