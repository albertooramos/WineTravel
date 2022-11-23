package com.alberto.winetravel.service;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.domain.TipoExperiencias;
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

    public void addExperiencia(String nombre, String descripcion, String direccion, float precio, Ciudades ciudad, TipoExperiencias tipoExperiencia, String imagenExperiencia){
        Experiencias experiencia = new Experiencias();
        experiencia.setNombreExperiencia(nombre);
        experiencia.setDescripcionExperiencia(descripcion);
        experiencia.setDireccion(direccion);
        experiencia.setPrecio(precio);
        experiencia.setCiudad(ciudad);
        experienciasRepository.save(experiencia);
    }

    public void eliminarExperiencia(String nombre){
        Experiencias experiencia=experienciasRepository.getExperienciasBynombreExperiencia(nombre);
        experienciasRepository.delete(experiencia);
    }

    public void actualizarExperiencia(int idExperiencia, String nombre, String descripcion, String direccion, float precio){
// POR HACER obtener objeto experiencia a travas del id o el nombre. Editar esa experiencia, cambiando todos los campos y luego el update
    }
}
