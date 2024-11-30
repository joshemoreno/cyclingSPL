package jave.maestria.lineas.analisis.datos.app.controllers;


import jave.maestria.lineas.analisis.datos.app.services.GestionUsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/gestion-usuarios")
public class GestionUsuariosController {
    private final GestionUsuariosService gestionUsuariosService;

    public GestionUsuariosController(GestionUsuariosService gestionUsuariosService) {
        this.gestionUsuariosService = gestionUsuariosService;
    }



    @GetMapping("/planes-usuario")
    public ResponseEntity<Map<String, Object>> contarUsuariosPorPlan() {
        // Llamamos al servicio para obtener la respuesta con el formato adecuado
        Map<String, Object> response = gestionUsuariosService.obtenerUsuariosPorPlan();

        // Devolvemos la respuesta con el formato esperado
        return ResponseEntity.ok(response);
    }
}
