package collpa.modulo.salon.backend.Services;

import collpa.modulo.salon.backend.Entities.Delivery;

import java.util.List;
import java.util.Optional;

public interface IDeliveryService {

    List<Delivery> getAllDeliveries();
    Optional<Delivery> getDeliveryById(Long id);
    void postDelivery(Delivery request);
    Delivery putDelivery(Delivery request, Long id);
    Delivery patchDelivery(Delivery request, Long id);
    void deleteDelivery(Long id);

}
