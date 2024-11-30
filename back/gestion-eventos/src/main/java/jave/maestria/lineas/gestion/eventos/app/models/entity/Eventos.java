package jave.maestria.lineas.gestion.eventos.app.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "gestion_eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_del_evento", nullable = false)
    private String nombreDelEvento;
    private Date fecha;
    private String ubicacion;

}