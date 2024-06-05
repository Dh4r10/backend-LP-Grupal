package collpa.modulo.salon.backend.Services;

import collpa.modulo.salon.backend.Entities.Plato;

import java.util.List;
import java.util.Optional;

public interface IPlatoService {

    List<Plato> getAllPlatos();
    Optional<Plato> getPlatoById(Long id);
    void postPlato(Plato request);
    Plato putPlato(Plato request, Long id);
    Plato patchPlato(Plato request, Long id);
    void deletePlato(Long id);

}
