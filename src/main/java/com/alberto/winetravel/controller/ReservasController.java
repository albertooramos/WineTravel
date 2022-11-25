package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.domain.Reservas;
import com.alberto.winetravel.response.StringResponse;
import com.alberto.winetravel.service.ExperienciasService;
import com.alberto.winetravel.service.ReservasService;
import com.alberto.winetravel.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    ReservasService reservasService;
    @Autowired
    ExperienciasService experienciasService;
    @Autowired
    UsuariosService usuariosService;
    @GetMapping
    public @ResponseBody Iterable<Reservas> getReservas(){
        return reservasService.getReservas();
    }

    @PostMapping(path = "/add")
    public @ResponseBody StringResponse addReservas(@RequestParam int idExperiencia, @RequestParam int idUsuario, @RequestParam int numero){
        reservasService.addReserva(experienciasService.getExperienciaByidExperiencia(idExperiencia), usuariosService.getUsuariosByidUsuario(idUsuario), numero);
        return new StringResponse("Reserva guardada");
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody StringResponse deleteReserva(@RequestParam int id) {
        reservasService.eliminarReserva(id);
        return new StringResponse("Reserva eliminada");
    }

}
