package com.tecazuay.practicas.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "usuario")
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String urlFoto;

    private String cedula;

    public Usuario(Long id, String email, String urlFoto, String cedula) {
        this.id = id;
        this.email = email;
        this.urlFoto = urlFoto;
        this.cedula = cedula;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}