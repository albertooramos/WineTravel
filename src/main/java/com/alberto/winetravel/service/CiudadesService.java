package com.alberto.winetravel.service;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.repository.CiudadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CiudadesService {
    @Autowired
    CiudadesRepository ciudadesRepository;

    public Iterable<Ciudades> getCiudades() {
        return ciudadesRepository.findAll();
    }
    public Ciudades getCiudadByNombre(String nombreCiudad){
        return ciudadesRepository.getCiudadesByNombreCiudad(nombreCiudad);
    }
    public void addCiudad(String nombre) {
        Ciudades ciudad = new Ciudades();
        ciudad.setNombreCiudad(nombre);
        ciudadesRepository.save(ciudad);
    }

    public void eliminarCiudad(String nombre){
        Ciudades ciudad=ciudadesRepository.getCiudadesByNombreCiudad(nombre);
        ciudadesRepository.delete(ciudad);
    }
}
