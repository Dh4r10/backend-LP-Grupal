package collpa.modulo.salon.backend.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@SQLDelete(sql = "UPDATE reservas SET estado = false WHERE id = ?")
public class Reservas {

    // CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Integer numeroPersonas;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Column(nullable = false)
    private LocalDateTime prorroga;

    @Column(nullable = false)
    private Boolean estado;

    // GETTERS Y SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDateTime getProrroga() {
        return prorroga;
    }

    public void setProrroga(LocalDateTime prorroga) {
        this.prorroga = prorroga;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "id=" + id +
                ", numeroPersonas=" + numeroPersonas +
                ", fechaReserva=" + fechaReserva +
                ", prorroga=" + prorroga +
                ", estado=" + estado +
                '}';
    }
}
