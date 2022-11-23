package com.alberto.winetravel.service;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.domain.TipoExperiencias;
import com.alberto.winetravel.repository.CiudadesRepository;
import com.alberto.winetravel.repository.TipoExperienciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TipoExperienciasService {

    @Autowired
    TipoExperienciasRepository tipoExperienciasRepository;

    public Iterable<TipoExperiencias> getTipoExperiencias() {
        return tipoExperienciasRepository.findAll();
    }

    public TipoExperiencias getTipoExpericiaByNombre(String nombreTipoExperiencia){
        return tipoExperienciasRepository.getTipoExperienciasByNombreTipoExperiencia(nombreTipoExperiencia);
    }
    public void addTipoExperiencia(String nombre) {
        TipoExperiencias tipoExperiencias = new TipoExperiencias();
        tipoExperiencias.setNombreTipoExperiencia(nombre);
        tipoExperienciasRepository.save(tipoExperiencias);
    }

}
