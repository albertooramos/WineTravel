package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.domain.Reservas;
import com.alberto.winetravel.response.StringResponse;
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
    public @ResponseBody StringResponse addReservas(@RequestParam int idExperiencia, @RequestParam int idUsuario, @RequestParam int numero){
        //POR HACER
        //reservasService.addReserva(idExperiencia, idUsuario, numero);//igual que hemos hecho en addExperiencias
        return new StringResponse("Reserva guardada");
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody StringResponse deleteReserva(@RequestParam int id) {
        reservasService.eliminarReserva(id);
        return new StringResponse("Experiencia eliminada");
    }

    @PostMapping(path = "/update")
    public @ResponseBody String updateReserva(@RequestParam int idReserva, @RequestParam int numero){
        reservasService.actualizarReserva(idReserva, numero);
        return "Reserva Actualizada";
    }
}
