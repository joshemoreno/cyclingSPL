package jave.maestria.lineas.gestion.eventos.app.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jave.maestria.lineas.gestion.eventos.app.models.entity.Eventos;
import jave.maestria.lineas.gestion.eventos.app.models.repositories.EventosRepository;

@Service
public class EventosServiceImpl implements IEventosservice {

    @Autowired
    private EventosRepository eventRepository;

    @Override
    public List<Eventos> listaEventos() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Eventos> buscarId(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        eventRepository.deleteById(id);
    }
    
    @Override
    public Eventos guardar(Eventos evento) {
        return eventRepository.save(evento);
    }

    @Override
    public Eventos crearEvento(String nombre, int numero, String email) {
        Eventos evento = new Eventos();
        evento.setNombreDelEvento(nombre);
        evento.setNumero(numero);
        evento.setCorreo(email);
        return eventRepository.save(evento);
    }
    
    @Override
    public Eventos actualizarEvento(Long id, Eventos evento) {
        return eventRepository.findById(id).map(e -> {
            e.setNombreDelEvento(evento.getNombreDelEvento());
            e.setNumero(evento.getNumero());
            e.setCorreo(evento.getCorreo());
            e.setFecha(evento.getFecha());
            e.setUbicacion(evento.getUbicacion());
            return eventRepository.save(e);
        }).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
    }
}