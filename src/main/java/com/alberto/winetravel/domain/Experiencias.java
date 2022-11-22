package com.alberto.winetravel.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Experiencias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idExperiencia;
    @NonNull
    private String nombreExperiencia;
    private String descripcionExperiencia;
    private float precio;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudades ciudad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_experiencia")
    private TipoExperiencias tipoExperiencias;

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    @NonNull
    public String getNombreExperiencia() {
        return nombreExperiencia;
    }

    public void setNombreExperiencia(@NonNull String nombreExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
    }

    public String getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(String descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public TipoExperiencias getTipoExperiencias() {
        return tipoExperiencias;
    }

    public void setTipoExperiencias(TipoExperiencias tipoExperiencias) {
        this.tipoExperiencias = tipoExperiencias;
    }
}
