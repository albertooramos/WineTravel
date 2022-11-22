package com.alberto.winetravel.domain;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TipoExperiencias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipoExperiencia;
    @NonNull
    private String nombreTipoExperiencia;


    public int getIdTipoExperiencia() {
        return idTipoExperiencia;
    }

    public void setIdTipoExperiencia(int idTipoExperiencia) {
        this.idTipoExperiencia = idTipoExperiencia;
    }

    public String getNombreTipoExperiencia() {
        return nombreTipoExperiencia;
    }

    public void setNombreTipoExperiencia(String nombreTipoExperiencia) {
        this.nombreTipoExperiencia = nombreTipoExperiencia;
    }
}
