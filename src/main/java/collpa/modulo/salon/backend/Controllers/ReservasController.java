package collpa.modulo.salon.backend.Controllers;

import collpa.modulo.salon.backend.Entities.Reservas;
import collpa.modulo.salon.backend.Services.IReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservasController {

    @Autowired
    private IReservasService reservasService;

    @GetMapping("/reservas")
    public List<Reservas> getAllReservas(){
        return reservasService.getAllReservas();
    }

    @GetMapping("/reservas/{id}")
    public Optional<Reservas> getReservaById(@PathVariable Long id){
        return reservasService.getReservasById(id);
    }

    @PostMapping("/reservas")
    public Reservas postReserva(@RequestBody Reservas reserva){
        reservasService.postReservas(reserva);
        return reserva;
    }

    @PutMapping("/reservas/{id}")
    public Reservas putReserva(@RequestBody Reservas reserva, @PathVariable Long id){
        return reservasService.putReservas(reserva, id);
    }

    @PatchMapping("/reservas/{id}")
    public Reservas patchReserva(@RequestBody Reservas reserva, @PathVariable Long id){
        return reservasService.patchReservas(reserva, id);
    }

    @DeleteMapping("/reservas/{id}")
    public String deleteReservas(@PathVariable Long id){
        reservasService.deleteReservas(id);
        return "Reserva con id=" + id + " eliminado correctamente";
    }

}
