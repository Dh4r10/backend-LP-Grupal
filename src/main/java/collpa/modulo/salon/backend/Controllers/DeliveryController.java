package collpa.modulo.salon.backend.Controllers;

import collpa.modulo.salon.backend.Entities.Delivery;
import collpa.modulo.salon.backend.Services.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    @Autowired
    private IDeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Optional<Delivery> getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id);
    }

    @PostMapping
    public Delivery postDelivery(@RequestBody Delivery delivery) {
        deliveryService.postDelivery(delivery);
        return delivery;
    }

    @PutMapping("/{id}")
    public Delivery putDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        return deliveryService.putDelivery(delivery, id);
    }

    @PatchMapping("/{id}")
    public Delivery patchDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        return deliveryService.patchDelivery(delivery, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return "Delivery con id=" + id + " eliminado correctamente";
    }

}
