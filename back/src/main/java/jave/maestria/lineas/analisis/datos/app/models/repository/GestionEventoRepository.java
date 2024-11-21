package jave.maestria.lineas.analisis.datos.app.models.repository;


import jave.maestria.lineas.analisis.datos.app.models.entity.GestionEventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestionEventoRepository extends JpaRepository<GestionEventos, Long> {



    @Query("SELECT MONTH(e.fecha) AS mes, " +
            "e.nombreDelEvento AS nombreEvento, " +
            "COUNT(e.id) AS cantidad " +
            "FROM GestionEventos e " +
            "GROUP BY MONTH(e.fecha), e.nombreDelEvento " +
            "ORDER BY mes ASC, cantidad DESC")
    List<Object[]> contarEventosAgrupados();
}
