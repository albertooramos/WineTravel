package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.TipoExperiencias;
import com.alberto.winetravel.response.StringResponse;
import com.alberto.winetravel.service.TipoExperienciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoExperiencias")
public class TipoExperienciasController {
    @Autowired
    TipoExperienciasService tipoExperienciasService;

    @GetMapping
    public @ResponseBody Iterable<TipoExperiencias> getTipoExperiencias(){
        return tipoExperienciasService.getTipoExperiencias();
    }

    @PostMapping(path = "/add")
    public @ResponseBody StringResponse addTipoExperiencia(@RequestParam String nombre){
        tipoExperienciasService.addTipoExperiencia(nombre);
        return new StringResponse("Tipo de experiencia guardada");
    }
}
