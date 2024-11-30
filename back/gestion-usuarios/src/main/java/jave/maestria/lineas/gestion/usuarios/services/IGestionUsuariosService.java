package jave.maestria.lineas.gestion.usuarios.services;

import jave.maestria.lineas.gestion.usuarios.models.entity.GestionUsuarios;

import java.util.Optional;

public interface IGestionUsuariosService {

    public Iterable<GestionUsuarios> findAll();

    public Optional<GestionUsuarios> findById(Long id);

    public GestionUsuarios crear (GestionUsuarios gestionUsuarios);

    public GestionUsuarios editar(Long id, GestionUsuarios gestionUsuarios);

    public void deleteById(Long id);
}
