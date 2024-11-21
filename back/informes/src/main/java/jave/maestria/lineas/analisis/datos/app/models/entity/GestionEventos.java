package jave.maestria.lineas.analisis.datos.app.models.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "gestion_eventos")
public class GestionEventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre_del_Evento", nullable = false, length = 100)
    private String nombreDelEvento;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Ubicacion", nullable = false, length = 100)
    private String ubicacion;

    // Campos para almacenar los valores calculados temporalmente
    @Transient
    private String mes;

    @Transient
    private Long cantidad;

    // Constructor para la consulta
    public GestionEventos(String mes, String nombreDelEvento, Long cantidad) {
        this.mes = mes;
        this.nombreDelEvento = nombreDelEvento;
        this.cantidad = cantidad;
    }

    public GestionEventos() {

    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDelEvento() {
        return nombreDelEvento;
    }

    public void setNombreDelEvento(String nombreDelEvento) {
        this.nombreDelEvento = nombreDelEvento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}


