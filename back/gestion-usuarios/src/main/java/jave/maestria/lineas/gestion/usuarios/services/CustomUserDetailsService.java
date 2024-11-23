package jave.maestria.lineas.gestion.usuarios.services;

import jave.maestria.lineas.gestion.usuarios.models.entity.GestionUsuarios;
import jave.maestria.lineas.gestion.usuarios.models.repository.IGestionUsuariosRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IGestionUsuariosRepository userRepository;

    public CustomUserDetailsService(IGestionUsuariosRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        GestionUsuarios userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        return User.builder()
                .username(userEntity.getNombre())
                .password(userEntity.getPassword())
                .authorities(String.valueOf(userEntity.getPlan()))
                .build();
    }
}
