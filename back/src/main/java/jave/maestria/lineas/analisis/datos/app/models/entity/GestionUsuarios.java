package jave.maestria.lineas.analisis.datos.app.models.entity;


import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "gestion_usuarios")
public class GestionUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "Rol", nullable = false)
    private Rol rol;

    public enum Rol {
        basic,
        estandar,
        premium
    }

    // Constructor por defecto
    public GestionUsuarios() {}

    // Constructor para la consulta personalizada
    public GestionUsuarios(Rol rol, Long cantidad) {
        this.rol = rol;
        this.cantidad = cantidad;
    }

    // Campos no persistentes
    @Transient
    private Long cantidad;

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    // Getters y Setters de los demás campos
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

