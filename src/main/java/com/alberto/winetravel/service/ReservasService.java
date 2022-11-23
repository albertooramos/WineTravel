package com.alberto.winetravel.service;

import com.alberto.winetravel.domain.Experiencias;
import com.alberto.winetravel.domain.Reservas;
import com.alberto.winetravel.domain.Usuarios;
import com.alberto.winetravel.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class ReservasService {
    @Autowired
    ReservasRepository reservasRepository;

    public Iterable<Reservas> getReservas(){
        return reservasRepository.findAll();
    }

    public void addReserva(Experiencias experiencia, Usuarios usuario, int numero){
        Reservas reserva = new Reservas();
        reserva.setNumeroPersonas(numero);
        reserva.setExperiencia(experiencia);
        reserva.setUsuario(usuario);
        reservasRepository.save(reserva);
    }

    public void eliminarReserva(int id){
        Reservas reserva=reservasRepository.getReservasByIdReserva(id);
        reservasRepository.delete(reserva);
    }

    public void actualizarReserva(int idReserva, int numero){
        Reservas reserva=reservasRepository.getReservasByIdReserva(idReserva);
        reserva.setNumeroPersonas(numero);
        reservasRepository.save(reserva);
    }
}
