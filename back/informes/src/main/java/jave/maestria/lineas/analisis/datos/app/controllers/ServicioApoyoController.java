package jave.maestria.lineas.analisis.datos.app.controllers;

import jave.maestria.lineas.analisis.datos.app.models.entity.ServicioApoyo;
import jave.maestria.lineas.analisis.datos.app.services.ServicioApoyoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/servicios-apoyo")
public class ServicioApoyoController {
    private final ServicioApoyoService servicioApoyoService;

    public ServicioApoyoController(ServicioApoyoService servicioApoyoService) {
        this.servicioApoyoService = servicioApoyoService;
    }

    @GetMapping("/obtenerTodos")
    public List<ServicioApoyo> obtenerTodos() {
        return servicioApoyoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioApoyo> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicioApoyoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServicioApoyo> guardar(@RequestBody ServicioApoyo servicioApoyo) {
        return new ResponseEntity<>(servicioApoyoService.guardar(servicioApoyo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicioApoyoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/test")
    public ResponseEntity<String> testPatch(

            @RequestBody ServicioApoyo servicioActualizado)
    {
        return ResponseEntity.ok("PATCH endpoint funcionando correctamente" + servicioActualizado );
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ServicioApoyo> actualizarServicio(
            @RequestBody ServicioApoyo servicioActualizado) {
        return servicioApoyoService.actualizarServicio(servicioActualizado)
                .map(servicio -> ResponseEntity.ok(servicio))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ticketsTipoBicicleta")
    public ResponseEntity<Map<String, List<ServicioApoyo>>> obtenerTicketsPorTipoDeBicicleta() {
        Map<String, List<ServicioApoyo>> response = servicioApoyoService.ticketsTipoBicicleta();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/obtenerPorEstado")
    public ResponseEntity<Map<String, List<ServicioApoyo>>> obtenerPorEstado() {
        Map<String, List<ServicioApoyo>> resultados = servicioApoyoService.obtenerPorEstado();
        return ResponseEntity.ok(resultados);
    }
}
