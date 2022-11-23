package com.alberto.winetravel.repository;

import com.alberto.winetravel.domain.Ciudades;
import com.alberto.winetravel.domain.TipoExperiencias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoExperienciasRepository extends CrudRepository<TipoExperiencias, Integer> {
    TipoExperiencias getTipoExperienciasByNombreTipoExperiencia(String tipoExperiencia);
}

