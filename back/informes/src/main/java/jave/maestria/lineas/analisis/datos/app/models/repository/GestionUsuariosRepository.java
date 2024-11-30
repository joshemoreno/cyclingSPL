package jave.maestria.lineas.analisis.datos.app.models.repository;

import jave.maestria.lineas.analisis.datos.app.models.entity.GestionUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestionUsuariosRepository extends JpaRepository<GestionUsuarios, Long> {



    @Query("SELECT new GestionUsuarios(u.plan, COUNT(u.id)) " +
            "FROM GestionUsuarios u " +
            "GROUP BY u.plan")
    List<GestionUsuarios> contarUsuariosPorPlan();

}
