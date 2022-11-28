package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Usuarios;
import com.alberto.winetravel.response.StringResponse;
import com.alberto.winetravel.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    //@GetMapping
    //public @ResponseBody Iterable<Usuarios> getUsuarios(){
        //return usuariosService.getUsuarios();
    //}

    @PostMapping(path = "/add")
    public @ResponseBody StringResponse addUsuario(@RequestParam String email, @RequestParam String password, @RequestParam String nombre){
        usuariosService.addUsuario(email, password, nombre);
        return new StringResponse("Usuario guardado");
    }

    @GetMapping("/getUsuarioByEmail")
    public @ResponseBody Usuarios getUsuariosByEmail(@RequestParam String email){
        return usuariosService.getUsuarioByEmail(email);
    }

    @PostMapping(path = "/update")
    public @ResponseBody StringResponse updateUsuario(@RequestParam String email, @RequestParam String password){
        usuariosService.actualizarPassword(email, password);
        return new StringResponse("Usuario Actualizado");
    }
}
