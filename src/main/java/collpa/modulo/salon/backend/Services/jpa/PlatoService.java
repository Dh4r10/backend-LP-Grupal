package collpa.modulo.salon.backend.Services.jpa;

import collpa.modulo.salon.backend.Entities.Plato;
import collpa.modulo.salon.backend.Repositories.PlatoRepository;
import collpa.modulo.salon.backend.Services.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService implements IPlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    public Optional<Plato> getPlatoById(Long id) {
        return platoRepository.findById(id);
    }

    public void postPlato(Plato request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        platoRepository.save(request);
    }

    public Plato putPlato(Plato request, Long id) {
        Plato plato = platoRepository.findById(id).get();

        plato.setNombre(request.getNombre());
        plato.setDescripcion(request.getDescripcion());
        plato.setTipoPlato(request.getTipoPlato());
        plato.setPrecio(request.getPrecio());
        plato.setImagen(request.getImagen());

        if (request.getEstado() == null) {
            plato.setEstado(plato.getEstado());
        } else {
            plato.setEstado(request.getEstado());
        }

        return platoRepository.save(plato);
    }

    public Plato patchPlato(Plato request, Long id){
        Plato plato = platoRepository.findById(id).get();

        if (request.getNombre() == null) {
            plato.setNombre(plato.getNombre());
        } else {
            plato.setNombre(request.getNombre());
        }

        if (request.getDescripcion() == null) {
            plato.setDescripcion(plato.getDescripcion());
        } else {
            plato.setDescripcion(request.getDescripcion());
        }

        if (request.getTipoPlato() == null) {
            plato.setTipoPlato(plato.getTipoPlato());
        } else {
            plato.setTipoPlato(request.getTipoPlato());
        }

        if (request.getPrecio() == null) {
            plato.setPrecio(plato.getPrecio());
        } else {
            plato.setPrecio(request.getPrecio());
        }

        if (request.getImagen() == null) {
            plato.setImagen(plato.getImagen());
        } else {
            plato.setImagen(request.getImagen());
        }

        if (request.getEstado() == null) {
            plato.setEstado(plato.getEstado());
        } else {
            plato.setEstado(request.getEstado());
        }

        return platoRepository.save(plato);
    }

    public void deletePlato(Long id) {
        platoRepository.deleteById(id);
    }

}
