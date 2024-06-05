package collpa.modulo.salon.backend.Services;

import collpa.modulo.salon.backend.Entities.Reservas;

import java.util.List;
import java.util.Optional;

public interface IReservasService {

    List<Reservas> getAllReservas();
    Optional<Reservas> getReservasById(Long id);
    void postReservas(Reservas request);
    Reservas putReservas(Reservas request, Long id);
    Reservas patchReservas(Reservas request, Long id);
    void deleteReservas(Long id);

}
