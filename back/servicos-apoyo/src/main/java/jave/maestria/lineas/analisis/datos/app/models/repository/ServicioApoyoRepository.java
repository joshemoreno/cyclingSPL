package jave.maestria.lineas.analisis.datos.app.models.repository;

import jave.maestria.lineas.analisis.datos.app.models.entity.ServicioApoyo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioApoyoRepository  extends JpaRepository<ServicioApoyo, Long> {

    @Query("SELECT new ServicioApoyo(a.tipoDeBicicleta, COUNT(a.id)) " +
            "FROM ServicioApoyo a " +
            "GROUP BY a.tipoDeBicicleta " +
            "ORDER BY COUNT(a.id) DESC")
    List<ServicioApoyo> findticketsTipoBicicleta();

    @Query("SELECT new ServicioApoyo(a.estado, COUNT(a.id)) " +
            "FROM ServicioApoyo a " +
            "GROUP BY a.estado " +
            "ORDER BY COUNT(a.id) DESC")
    List<ServicioApoyo> findCantidadPorEstado();

}
