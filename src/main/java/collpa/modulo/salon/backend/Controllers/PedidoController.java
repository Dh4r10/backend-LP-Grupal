package collpa.modulo.salon.backend.Controllers;

import collpa.modulo.salon.backend.Entities.Pedido;
import collpa.modulo.salon.backend.Services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido postPedido(@RequestBody Pedido pedido) {
        pedidoService.postPedido(pedido);
        return pedido;
    }

    @PutMapping("/{id}")
    public Pedido putPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.putPedido(pedido, id);
    }

    @PatchMapping("/{id}")
    public Pedido patchPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.patchPedido(pedido, id);
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return "Delivery con id=" + id + " eliminado correctamente";

    }
}
