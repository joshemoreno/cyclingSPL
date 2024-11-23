package jave.maestria.lineas.gestion.usuarios.models.repository;

import jave.maestria.lineas.gestion.usuarios.models.entity.GestionUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGestionUsuariosRepository extends JpaRepository <GestionUsuarios, Long> {
    Optional<GestionUsuarios> findByEmail(String email);
}
