package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.domain.Reservas;
import com.alberto.winetravel.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    ReservasService reservasService;

    @GetMapping
    public @ResponseBody Iterable<Reservas> getReservas(){
        return reservasService.getReservas();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addReservas(@RequestParam int numero){
        reservasService.addReserva(numero);
        return "Reserva guardada";
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteReserva(@RequestParam int id) {
        reservasService.eliminarReserva(id);
        return "Experiencia eliminada";
    }

    @PostMapping(path = "/update")
    public @ResponseBody String updateReserva(@RequestParam int numero){
        reservasService.actualizarReserva(numero);
        return "Reserva Actualizada";
    }
}
