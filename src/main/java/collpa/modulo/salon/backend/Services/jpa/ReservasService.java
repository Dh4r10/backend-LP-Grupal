package collpa.modulo.salon.backend.Services.jpa;

import collpa.modulo.salon.backend.Entities.Reservas;
import collpa.modulo.salon.backend.Repositories.ReservasRepository;
import collpa.modulo.salon.backend.Services.IReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService implements IReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reservas> getAllReservas() {
        return reservasRepository.findAll();
    }

    public Optional<Reservas> getReservasById(Long id) {
        return reservasRepository.findById(id);
    }

    public void postReservas(Reservas request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        reservasRepository.save(request);
    }

    public Reservas putReservas(Reservas request, Long id) {
        Reservas reserva = reservasRepository.findById(id).get();

        reserva.setNumeroPersonas(request.getNumeroPersonas());
        reserva.setFechaReserva(request.getFechaReserva());
        reserva.setProrroga(request.getProrroga());

        if (request.getEstado() == null) {
            reserva.setEstado(reserva.getEstado());
        } else {
            reserva.setEstado(request.getEstado());
        }

        return reservasRepository.save(reserva);
    }

    public Reservas patchReservas(Reservas request, Long id) {
        Reservas reserva = reservasRepository.findById(id).get();

        if (request.getNumeroPersonas() == null) {
            reserva.setNumeroPersonas(reserva.getNumeroPersonas());
        } else {
            reserva.setNumeroPersonas(request.getNumeroPersonas());
        }

        if (request.getFechaReserva() == null) {
            reserva.setFechaReserva(reserva.getFechaReserva());
        } else {
            reserva.setFechaReserva(request.getFechaReserva());
        }

        if (request.getProrroga() == null) {
            reserva.setProrroga(reserva.getProrroga());
        } else {
            reserva.setProrroga(request.getProrroga());
        }

        if (request.getEstado() == null) {
            reserva.setEstado(reserva.getEstado());
        } else {
            reserva.setEstado(request.getEstado());
        }

        return reservasRepository.save(reserva);
    }

    public void deleteReservas(Long id) {
        reservasRepository.deleteById(id);
    }

}
