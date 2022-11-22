package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.service.CiudadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudades")
public class CiudadesController {
    @Autowired
    CiudadesService ciudadesService;

    @GetMapping
    public @ResponseBody Iterable<Ciudades> getCiudades() {
        return ciudadesService.getCiudades();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addCiudad(@RequestParam String nombre) {
        ciudadesService.addCiudad(nombre);
        return "Ciudad guardada";
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteCiudad(@RequestParam String nombre) {
        ciudadesService.eliminarCiudad(nombre);
        return "Ciudad eliminada";
    }
}
