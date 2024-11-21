package jave.maestria.lineas.gestion.usuarios.services;


import jakarta.persistence.EntityNotFoundException;
import jave.maestria.lineas.gestion.usuarios.models.entity.GestionUsuarios;
import jave.maestria.lineas.gestion.usuarios.models.repository.IGestionUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class GestionUsuariosServiceImpl implements IGestionUsuariosService{

    @Autowired
    private IGestionUsuariosRepository gestionUsuariosRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<GestionUsuarios> findAll() {
        return gestionUsuariosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GestionUsuarios> findById(Long id) {
        return Optional.ofNullable(gestionUsuariosRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public GestionUsuarios crear(GestionUsuarios gestionUsuarios) {
        return gestionUsuariosRepository.save(gestionUsuarios);
    }

    @Override
    @Transactional
    public GestionUsuarios editar(Long id, GestionUsuarios gestionUsuarios) {

        Optional<GestionUsuarios> opt = gestionUsuariosRepository.findById(id);
        if (opt.isEmpty()) {
            throw new EntityNotFoundException("Usuario no encontrado con id: " + id);
        }

        GestionUsuarios gestionUsuariosDb = opt.get();
        gestionUsuariosDb.setNombre(gestionUsuarios.getNombre());
        gestionUsuariosDb.setEmail(gestionUsuarios.getEmail());

        return gestionUsuariosRepository.save(gestionUsuariosDb);
    }

    @Override
    public void deleteById(Long id) {

        gestionUsuariosRepository.deleteById(id);
    }
}
