package com.alberto.winetravel.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReserva;

    @NonNull
    private int numeroPersonas;

    @ManyToOne
    @JoinColumn(name = "id_experiencias")
    private Experiencias experiencia;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public Experiencias getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencias experiencia) {
        this.experiencia = experiencia;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
