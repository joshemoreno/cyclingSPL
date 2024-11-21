package jave.maestria.lineas.gestion.usuarios.models.entity;

import jakarta.persistence.*;
import jave.maestria.lineas.gestion.usuarios.models.enums.Rol;

@Entity
@Table(name = "gestion_usuarios")
public class GestionUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @Enumerated(EnumType.STRING) // Guardar el nombre del enum como texto
    private Rol rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
