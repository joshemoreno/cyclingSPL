package jave.maestria.lineas.analisis.datos.app.services;

import jave.maestria.lineas.analisis.datos.app.models.entity.ServicioApoyo;
import jave.maestria.lineas.analisis.datos.app.models.repository.ServicioApoyoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicioApoyoService {

    private final ServicioApoyoRepository servicioApoyoRepository;

    public ServicioApoyoService(ServicioApoyoRepository servicioApoyoRepository) {
        this.servicioApoyoRepository = servicioApoyoRepository;
    }

    public List<ServicioApoyo> obtenerTodos() {
        return servicioApoyoRepository.findAll();
    }

    public ServicioApoyo obtenerPorId(Long id) {
        return servicioApoyoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio de apoyo no encontrado con ID: " + id));
    }

    public ServicioApoyo guardar(ServicioApoyo servicioApoyo) {
        return servicioApoyoRepository.save(servicioApoyo);
    }

    public void eliminar(Long id) {
        servicioApoyoRepository.deleteById(id);
    }

    public Optional<ServicioApoyo> actualizarServicio(ServicioApoyo servicioActualizado) {
        Long idLong = servicioActualizado.getId() != null ? servicioActualizado.getId().longValue() : null;

        return servicioApoyoRepository.findById(idLong).map(servicioExistente -> {
            servicioExistente.setNombreDelCliente(servicioActualizado.getNombreDelCliente());
            servicioExistente.setTipoDeBicicleta(servicioActualizado.getTipoDeBicicleta());
            servicioExistente.setDescripcionProblema(servicioActualizado.getDescripcionProblema());
            servicioExistente.setEstado(servicioActualizado.getEstado());
            return servicioApoyoRepository.save(servicioExistente);
        });
    }


    public Map<String, List<ServicioApoyo>> ticketsTipoBicicleta() {
        List<ServicioApoyo> resultados = servicioApoyoRepository.findticketsTipoBicicleta();
        Map<String, List<ServicioApoyo>> response = new HashMap<>();
        response.put("data", resultados); // Mapeamos los resultados directamente como "data"
        return response;
    }

    public Map<String, List<ServicioApoyo>> obtenerPorEstado() {
        List<ServicioApoyo> resultados = servicioApoyoRepository.findCantidadPorEstado();
        Map<String, List<ServicioApoyo>> response = new HashMap<>();
        response.put("data", resultados); // Mapeamos los resultados directamente como "data"
        return response;
    }


}

