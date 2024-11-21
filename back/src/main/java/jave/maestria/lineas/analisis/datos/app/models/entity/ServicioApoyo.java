package jave.maestria.lineas.analisis.datos.app.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios_apoyo")
public class ServicioApoyo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre_del_Cliente", nullable = false)
    private String nombreDelCliente;

    @Column(name = "Tipo_de_Bicicleta", nullable = false)
    private String tipoDeBicicleta;

    @Column(name = "Descripcion_Problema")
    private String descripcionProblema;

    @Column(name = "Estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public ServicioApoyo(String tipoDeBicicleta, Long cantidad) {
        this.tipoDeBicicleta = tipoDeBicicleta;
        this.cantidad = cantidad;
    }

    public ServicioApoyo(Estado estado, Long cantidad) {
        this.estado = estado;
        this.cantidad = cantidad;
    }

    public ServicioApoyo() {

    }


    @Transient // Esto indica que no es una columna persistente en la base de datos
    private Long cantidad;

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public enum Estado {
        pendiente,      // cambiado a minúsculas
        en_progreso,    // cambiado a minúsculas
        resuelto;       // cambiado a minúsculas

        public static Estado fromString(String text) {
            for (Estado e : Estado.values()) {
                if (e.name().equalsIgnoreCase(text)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("No enum constant for " + text);
        }
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public String getTipoDeBicicleta() {
        return tipoDeBicicleta;
    }

    public void setTipoDeBicicleta(String tipoDeBicicleta) {
        this.tipoDeBicicleta = tipoDeBicicleta;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
