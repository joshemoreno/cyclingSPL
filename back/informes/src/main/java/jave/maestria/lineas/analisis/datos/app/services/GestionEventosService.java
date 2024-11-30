package jave.maestria.lineas.analisis.datos.app.services;


import jave.maestria.lineas.analisis.datos.app.models.entity.GestionEventos;
import jave.maestria.lineas.analisis.datos.app.models.repository.GestionEventoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GestionEventosService {


    private final GestionEventoRepository repository;

    public GestionEventosService(GestionEventoRepository repository) {
        this.repository = repository;
    }

    public Map<String, List<GestionEventos>> obtenerEventosPorMes() {
        // Llamamos al repositorio para obtener los eventos agrupados
        List<Object[]> eventos = repository.contarEventosAgrupados(); // Resultado de la consulta

        // Agrupamos los eventos por mes
        Map<String, List<GestionEventos>> eventosPorMes = new HashMap<>();

        // Mapeo de números de mes a nombres de mes
        String[] nombresMeses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        // Procesamos los resultados y los agrupamos por mes
        for (Object[] evento : eventos) {
            Integer mes = (Integer) evento[0]; // El mes (número)
            String nombreDelEvento = (String) evento[1]; // Nombre del evento
            Long cantidad = (Long) evento[2]; // Cantidad de eventos

            // Convertimos el número del mes al nombre
            String mesNombre = nombresMeses[mes - 1]; // Ajuste para que el mes 1 sea "Enero"

            // Creamos un objeto GestionEventos con los datos obtenidos
            GestionEventos gestionEvento = new GestionEventos();
            gestionEvento.setMes(mesNombre); // Establecemos el nombre del mes
            gestionEvento.setNombreDelEvento(nombreDelEvento); // Establecemos el nombre del evento
            gestionEvento.setCantidad(cantidad); // Establecemos la cantidad de eventos

            // Agrupamos los eventos por mes
            eventosPorMes.computeIfAbsent(mesNombre, k -> new ArrayList<>()).add(gestionEvento);
        }

        return eventosPorMes;
    }
}
