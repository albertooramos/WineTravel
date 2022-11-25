package com.alberto.winetravel.service;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.domain.TipoExperiencias;
import com.alberto.winetravel.domain.Usuarios;
import com.alberto.winetravel.repository.ExperienciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ExperienciasService {
    @Autowired
    ExperienciasRepository experienciasRepository;

    public Iterable<Experiencias> getExperiencias() {
        return experienciasRepository.findAll();
    }

    public Experiencias getExperienciaByidExperiencia(int idExperiencia) {
        return experienciasRepository.getExperienciasByidExperiencia(idExperiencia);
    }

    public void addExperiencia(String nombre, String descripcion, String direccion, float precio, Ciudades ciudad, TipoExperiencias tipoExperiencia, String imagenExperiencia) {
        Experiencias experiencia = new Experiencias();
        experiencia.setNombreExperiencia(nombre);
        experiencia.setDescripcionExperiencia(descripcion);
        experiencia.setDireccion(direccion);
        experiencia.setPrecio(precio);
        experiencia.setCiudad(ciudad);
        experiencia.setTipoExperiencias(tipoExperiencia);
        experiencia.setImagenExperiencia(imagenExperiencia);
        experienciasRepository.save(experiencia);
    }

    public void eliminarExperiencia(String nombre) {
        Experiencias experiencia = experienciasRepository.getExperienciasBynombreExperiencia(nombre);
        experienciasRepository.delete(experiencia);
    }

    public void actualizarExperiencia(int idExperiencia, String nombre, String descripcion, String direccion, float precio) {
        Experiencias experiencia = experienciasRepository.getExperienciasByidExperiencia(idExperiencia);
        experiencia.setNombreExperiencia(nombre);
        experiencia.setDescripcionExperiencia(descripcion);
        experiencia.setDireccion(direccion);
        experiencia.setPrecio(precio);
        experienciasRepository.save(experiencia);
    }
}