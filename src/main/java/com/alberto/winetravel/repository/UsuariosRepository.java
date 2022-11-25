package com.alberto.winetravel.repository;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.domain.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Integer> {
     List<Usuarios> getUsuariosByEmailUsuario(String emailUsuario);
     Usuarios getUsuariosByidUsuario(int idUsuario);
}
