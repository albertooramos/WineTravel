package com.alberto.winetravel.repository;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.domain.Experiencias;
import org.springframework.data.repository.CrudRepository;

public interface ExperienciasRepository extends CrudRepository<Experiencias, Integer> {
    Experiencias getExperienciasBynombreExperiencia(String nombreExperiencia);
    Experiencias getExperienciasByIdExperiencia(int idExperiencia);
}
