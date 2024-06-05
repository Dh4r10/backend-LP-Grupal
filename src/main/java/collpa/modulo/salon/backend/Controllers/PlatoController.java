package collpa.modulo.salon.backend.Controllers;

import collpa.modulo.salon.backend.Entities.Plato;
import collpa.modulo.salon.backend.Services.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlatoController {

    @Autowired
    private IPlatoService platoService;

    @GetMapping("/plato")
    public List<Plato> getAllPlatos() {
        return platoService.getAllPlatos();
    }

    @GetMapping("/plato/{id}")
    public Optional<Plato> getPlatoById(@PathVariable Long id) {
        return platoService.getPlatoById(id);
    }

    @PostMapping("/plato")
    public Plato postPlato(@RequestBody Plato plato) {
        platoService.postPlato(plato);
        return plato;
    }

    @PutMapping("/plato/{id}")
    public Plato putPlato(@RequestBody Plato plato, @PathVariable Long id) {
        return platoService.putPlato(plato, id);
    }

    @PatchMapping("/plato/{id}")
    public Plato patchPlato(@RequestBody Plato plato, @PathVariable Long id) {
        return platoService.patchPlato(plato, id);
    }

    @DeleteMapping("/plato/{id}")
    public String deletePlato(@PathVariable Long id) {
        platoService.deletePlato(id);
        return "Plato con id=" + id + " eliminado correctamente";
    }

}
