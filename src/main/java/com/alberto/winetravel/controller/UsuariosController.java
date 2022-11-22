package com.alberto.winetravel.controller;

import com.alberto.winetravel.domain.Usuarios;
import com.alberto.winetravel.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping
    public @ResponseBody Iterable<Usuarios> getUsuarios(){
        return usuariosService.getUsuarios();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addUsuario(@RequestParam String email, @RequestParam String password, @RequestParam String nombre){
        usuariosService.addUsuario(email, password, nombre);
        return "Usuario guardado";
    }

    @GetMapping("/getUsuarioByEmail")
    public @ResponseBody Usuarios getUsuariosByEmail(@RequestParam String email){
        return usuariosService.getUsuarioByEmail(email);
    }

    @PostMapping(path = "/update")
    public @ResponseBody String updateUsuario(@RequestParam String email, @RequestParam String password){
        usuariosService.actualizarPassword(email, password);
        return "Usuario Actualizado";
    }
}
