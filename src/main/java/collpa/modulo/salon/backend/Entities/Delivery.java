package collpa.modulo.salon.backend.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "delivery")
@SQLDelete(sql = "UPDATE delivery SET estado = false WHERE id = ?")
public class Delivery {

    // CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn(name = "pedido_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PE_DE"))
	private Pedido pedidoId;

    @Column(nullable = false, length = 40)
    private String direccion;

    @Column(nullable = false, length = 9)
    private String numeroContacto;

    @Column(nullable = false)
    private Boolean estado;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", direccion='" + direccion + '\'' +
                ", numeroContacto='" + numeroContacto + '\'' +
                ", estado=" + estado +
                '}';
    }
}
