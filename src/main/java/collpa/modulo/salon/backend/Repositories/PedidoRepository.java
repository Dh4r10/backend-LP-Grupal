package collpa.modulo.salon.backend.Repositories;

import collpa.modulo.salon.backend.Entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
