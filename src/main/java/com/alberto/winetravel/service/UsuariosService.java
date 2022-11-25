package com.alberto.winetravel.service;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.domain.Usuarios;
import com.alberto.winetravel.repository.CiudadesRepository;
import com.alberto.winetravel.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    public Iterable<Usuarios> getUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios getUsuariosByidUsuario(int idUsuario){
        return usuariosRepository.getUsuariosByidUsuario(idUsuario);
    }
    public void addUsuario(String email, String password, String nombreUsuario) {
        Usuarios usuario = new Usuarios();
        usuario.setEmailUsuario(email);
        usuario.setPassword(password);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setAdmin(false);
        usuariosRepository.save(usuario);
    }

    public Usuarios getUsuarioByEmail(String email){
        return usuariosRepository.getUsuariosByEmailUsuario(email).get(0);
    }

    public void actualizarPassword(String email, String password){
        Usuarios usuario=usuariosRepository.getUsuariosByEmailUsuario(email).get(0);
        usuario.setPassword(password);
        usuariosRepository.save(usuario);
    }
}
