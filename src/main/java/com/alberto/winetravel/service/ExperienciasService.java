package com.alberto.winetravel.service;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.repository.ExperienciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ExperienciasService {
    @Autowired
    ExperienciasRepository experienciasRepository;

    public Iterable<Experiencias> getExperiencias(){
        return experienciasRepository.findAll();
    }

    public void addExperiencia(String nombre, String descripcion, String direccion, float precio){
        Experiencias experiencia = new Experiencias();
        experiencia.setNombreExperiencia(nombre);
        experiencia.setDescripcionExperiencia(descripcion);
        experiencia.setDireccion(direccion);
        experiencia.setPrecio(precio);
        experienciasRepository.save(experiencia);
    }

    public void eliminarExperiencia(String nombre){
        Experiencias experiencia=experienciasRepository.getExperienciasByNombre(nombre);
        experienciasRepository.delete(experiencia);
    }

    public void actualizarExperiencia(String nombre, String descripcion, String direccion, float precio){

    }
}
