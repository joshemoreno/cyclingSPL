package jave.maestria.lineas.gestion.usuarios.models.entity;

import jakarta.persistence.*;
import jave.maestria.lineas.gestion.usuarios.models.enums.Plan;
import lombok.Data;

@Entity
@Data
@Table(name = "gestion_usuarios")
public class GestionUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String password;
    @Enumerated(EnumType.STRING)
    private Plan plan;


}
