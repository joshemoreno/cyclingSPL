package jave.maestria.lineas.gestion.eventos.app.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jave.maestria.lineas.gestion.eventos.app.models.entity.Eventos;
import jave.maestria.lineas.gestion.eventos.app.models.repositories.EventosRepository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {
   
}