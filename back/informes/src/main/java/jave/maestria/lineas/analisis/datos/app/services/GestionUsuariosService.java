package jave.maestria.lineas.analisis.datos.app.services;


import jave.maestria.lineas.analisis.datos.app.models.entity.GestionUsuarios;
import jave.maestria.lineas.analisis.datos.app.models.repository.GestionUsuariosRepository;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GestionUsuariosService {


    private final GestionUsuariosRepository repository;

    public GestionUsuariosService(GestionUsuariosRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> obtenerUsuariosPorPlan() {
        // Llamamos al repositorio para obtener los usuarios agrupados por plan
        List<GestionUsuarios> usuarios = repository.contarUsuariosPorPlan();

        // Creamos un mapa para devolver los resultados con la clave "data"
        Map<String, Object> response = new HashMap<>();
        response.put("data", usuarios);

        // Retornamos el mapa como la respuesta
        return response;
    }
}
