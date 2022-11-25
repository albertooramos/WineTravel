package com.alberto.winetravel.repository;

import com.alberto.winetravel.domain.Reservas;
import org.springframework.data.repository.CrudRepository;

public interface ReservasRepository extends CrudRepository<Reservas, Integer> {
    Reservas getReservasByIdReserva(int id);

}
