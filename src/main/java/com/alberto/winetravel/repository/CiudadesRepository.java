package com.alberto.winetravel.repository;

import com.alberto.winetravel.domain.Ciudades;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CiudadesRepository extends CrudRepository<Ciudades, Integer> {
    Ciudades getCiudadesByNombreCiudad(String nombre);
}
