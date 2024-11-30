package jave.maestria.lineas.gestion.eventos.app.services;

import java.util.List;
import java.util.Optional;

import jave.maestria.lineas.gestion.eventos.app.models.entity.Eventos;

public interface IEventosservice {
    List<Eventos> listaEventos();
    Optional<Eventos> buscarId(Long id);
    Eventos guardar(Eventos evento);
    void eliminar(Long id);
    Eventos actualizarEvento(Long id, Eventos evento);
}