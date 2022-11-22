package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.service.ExperienciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiencias")
public class ExperienciasController {

    @Autowired
    ExperienciasService experienciasService;

    @GetMapping
    public @ResponseBody Iterable<Experiencias> getExperiencias(){
        return experienciasService.getExperiencias();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addExperiencias(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String direccion, @RequestParam Float precio){
        experienciasService.addExperiencia(nombre, descripcion, direccion, precio);
        return "Experiencia guardada";
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteExperiencia(@RequestParam String nombre) {
        experienciasService.eliminarExperiencia(nombre);
        return "Experiencia eliminada";
    }

    @PostMapping(path = "/update")
    public @ResponseBody String updateExperiencia(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String direccion, @RequestParam Float precio){
        experienciasService.actualizarExperiencia(nombre, descripcion, direccion, precio);
        return "Experiencia Actualizada";
    }
}
