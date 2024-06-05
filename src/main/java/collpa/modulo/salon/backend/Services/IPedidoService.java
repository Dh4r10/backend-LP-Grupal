package collpa.modulo.salon.backend.Services;

import collpa.modulo.salon.backend.Entities.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {

    List<Pedido> getAllPedidos();
    Optional<Pedido> getPedidoById(Long id);
    void postPedido(Pedido request);
    Pedido putPedido(Pedido request, Long id);
    Pedido patchPedido(Pedido request, Long id);
    void deletePedido(Long id);

}
