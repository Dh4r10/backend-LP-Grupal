package collpa.modulo.salon.backend.Services.jpa;

import collpa.modulo.salon.backend.Entities.Delivery;
import collpa.modulo.salon.backend.Repositories.DeliveryRepository;
import collpa.modulo.salon.backend.Services.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    public void postDelivery(Delivery request) {
        if (request.getEstado() == null){
            request.setEstado(true);
        }

        deliveryRepository.save(request);
    }

    public Delivery putDelivery(Delivery request, Long id) {
        Delivery delivery = deliveryRepository.findById(id).get();

        delivery.setPedido(request.getPedido());
        delivery.setDireccion(request.getDireccion());
        delivery.setNumeroContacto(request.getNumeroContacto());

        if (request.getEstado() == null){
            delivery.setEstado(delivery.getEstado());
        } else {
            delivery.setEstado(request.getEstado());
        }

        return deliveryRepository.save(delivery);
    }

    public Delivery patchDelivery(Delivery request, Long id) {
        Delivery delivery = deliveryRepository.findById(id).get();

        if (request.getPedido() == null) {
            delivery.setPedido(delivery.getPedido());
        } else {
            delivery.setPedido(request.getPedido());
        }

        if (request.getDireccion() == null){
            delivery.setDireccion(delivery.getDireccion());
        } else {
            delivery.setDireccion(request.getDireccion());
        }

        if (request.getNumeroContacto() == null){
            delivery.setNumeroContacto(delivery.getNumeroContacto());
        } else {
            delivery.setNumeroContacto(request.getNumeroContacto());
        }

        if (request.getEstado() == null){
            delivery.setEstado(delivery.getEstado());
        } else {
            delivery.setEstado(request.getEstado());
        }

        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

}
