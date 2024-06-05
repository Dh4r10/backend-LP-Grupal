package collpa.modulo.salon.backend.Controllers;

import collpa.modulo.salon.backend.Entities.Mesa;
import collpa.modulo.salon.backend.Services.IMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mesa")
public class MesaController {

    @Autowired
    private IMesaService mesaService;

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/{id}")
    public Optional<Mesa> getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id);
    }

    @PostMapping
    public Mesa postMesa(@RequestBody Mesa mesa) {
        mesaService.postMesa(mesa);
        return mesa;
    }

    @PutMapping("/{id}")
    public Mesa putMesa(@RequestBody Mesa mesa, @PathVariable Long id) {
        return mesaService.putMesa(mesa, id);
    }

    @PatchMapping("/{id}")
    public Mesa patchMesa(@RequestBody Mesa mesa, @PathVariable Long id) {
        return mesaService.patchMesa(mesa, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
        return "Mesa con id=" + id + " eliminado correctamente";
    }

}
