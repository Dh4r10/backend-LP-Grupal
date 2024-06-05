package collpa.modulo.salon.backend.Services.jpa;

import collpa.modulo.salon.backend.Entities.Pedido;
import collpa.modulo.salon.backend.Repositories.PedidoRepository;
import collpa.modulo.salon.backend.Services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    public void postPedido(Pedido request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        pedidoRepository.save(request);
    }

    public Pedido putPedido(Pedido request, Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();

        pedido.setFecha(request.getFecha());
        pedido.setTipoPedido(request.getTipoPedido());

        if (request.getEstado() == null) {
            pedido.setEstado(pedido.getEstado());
        } else {
            pedido.setEstado(request.getEstado());
        }

        return pedidoRepository.save(pedido);
    }

    public Pedido patchPedido(Pedido request, Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();

        if (request.getFecha() == null) {
            pedido.setFecha(pedido.getFecha());
        } else {
            pedido.setFecha(request.getFecha());
        }

        if (request.getTipoPedido() == null) {
            pedido.setTipoPedido(pedido.getTipoPedido());
        } else {
            pedido.setTipoPedido(request.getTipoPedido());
        }

        if (request.getEstado() == null) {
            pedido.setEstado(pedido.getEstado());
        } else {
            pedido.setEstado(request.getEstado());
        }

        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }

}
