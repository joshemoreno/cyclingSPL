package jave.maestria.lineas.analisis.datos.app.models.entity;


import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "gestion_usuarios")
@Data
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
    private Plan plan;

    public enum Plan {
        basic,
        estandar,
        premium
    }

    public GestionUsuarios() {}

    public GestionUsuarios(Plan plan, Long cantidad) {
        this.plan = plan;
        this.cantidad = cantidad;
    }

    @Transient
    private Long cantidad;
}

