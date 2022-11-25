package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.response.StringResponse;
import com.alberto.winetravel.service.CiudadesService;
import com.alberto.winetravel.service.ExperienciasService;
import com.alberto.winetravel.service.TipoExperienciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiencias")
public class ExperienciasController {

    @Autowired
    ExperienciasService experienciasService;
    @Autowired
    CiudadesService ciudadesService;
    @Autowired
    TipoExperienciasService tipoExperienciasService;

    @GetMapping
    public @ResponseBody Iterable<Experiencias> getExperiencias() {
        return experienciasService.getExperiencias();
    }

    @PostMapping(path = "/add")
    public @ResponseBody StringResponse addExperiencias(@RequestParam String nombre, @RequestParam String descripcion,
                                                        @RequestParam String direccion, @RequestParam Float precio,
                                                        @RequestParam String ciudad, @RequestParam String tipoExperiencia,
                                                        @RequestParam String imagenExperiencia) {
        experienciasService.addExperiencia(nombre, descripcion, direccion, precio, ciudadesService.getCiudadByNombre(ciudad),
                tipoExperienciasService.getTipoExpericiaByNombre(tipoExperiencia),
                imagenExperiencia);
        return new StringResponse("Experiencia guardada");
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody StringResponse deleteExperiencia(@RequestParam String nombre) {
        experienciasService.eliminarExperiencia(nombre);
        return new StringResponse("Experiencia eliminada");
    }

    @PostMapping(path = "/update")
    public @ResponseBody StringResponse updateExperiencia(@RequestParam int idExperiencia, @RequestParam String nombre, @RequestParam String descripcion,
                                                  @RequestParam String direccion, @RequestParam Float precio){
        experienciasService.actualizarExperiencia(idExperiencia, nombre, descripcion, direccion, precio);
        return new StringResponse("Experiencia Actualizada");
    }
}
