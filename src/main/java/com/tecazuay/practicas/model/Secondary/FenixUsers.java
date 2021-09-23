package com.tecazuay.practicas.model.Secondary;


import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Immutable
@Table(name="vroles_persona")
public class FenixUsers implements Serializable {
    @Id
    @Column(name = "id_persona", nullable = false,updatable = false)
    private Long id_persona;

    private String apellidos;

    private String nombres;

    private String cedula;

    private String rol_nombre;

    public FenixUsers(Long id_persona, String apellidos, String nombres, String persona_identificacion, String rol_nombre) {
        this.id_persona = id_persona;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cedula = cedula;
        this.rol_nombre = rol_nombre;
    }

    public FenixUsers() {
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }
}
