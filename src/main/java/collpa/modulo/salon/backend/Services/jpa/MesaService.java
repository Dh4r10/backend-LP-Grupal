package collpa.modulo.salon.backend.Services.jpa;

import collpa.modulo.salon.backend.Entities.Mesa;
import collpa.modulo.salon.backend.Repositories.MesaRepository;
import collpa.modulo.salon.backend.Services.IMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService implements IMesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }

    public void postMesa(Mesa request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        if (request.getReservado() == null) {
            request.setReservado(false);
        }

        mesaRepository.save(request);
    }

    public Mesa putMesa(Mesa request, Long id) {
        Mesa mesa = mesaRepository.findById(id).get();

        mesa.setNumero(request.getNumero());
        mesa.setCapacidad(request.getCapacidad());
        mesa.setReservado(request.getReservado());
        mesa.setTipoMesa(request.getTipoMesa());
        mesa.setEstado(request.getEstado());
        mesa.setEstado(request.getEstado());

        return mesaRepository.save(mesa);
    }

    public Mesa patchMesa(Mesa request, Long id) {
        Mesa mesa = mesaRepository.findById(id).get();

        if (request.getNumero() == null) {
            mesa.setNumero(mesa.getNumero());
        } else {
            mesa.setNumero(request.getNumero());
        }

        if (request.getCapacidad() == null) {
            mesa.setCapacidad(mesa.getCapacidad());
        } else {
            mesa.setCapacidad(request.getCapacidad());
        }

        if (request.getReservado() == null) {
            mesa.setReservado(mesa.getReservado());
        } else {
            mesa.setReservado(request.getReservado());
        }

        if (request.getTipoMesa() == null) {
            mesa.setTipoMesa(mesa.getTipoMesa());
        } else {
            mesa.setTipoMesa(request.getTipoMesa());
        }

        if (request.getEstado() == null) {
            mesa.setEstado(mesa.getEstado());
        } else {
            mesa.setEstado(request.getEstado());
        }

        return mesaRepository.save(mesa);
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }

}
