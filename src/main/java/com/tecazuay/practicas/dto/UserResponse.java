package com.tecazuay.practicas.dto;

import java.io.Serializable;

public class UserResponse implements Serializable {

    private Long id;

    private String email;

    private String urlFoto;

    private String cedula;

    public UserResponse() {
    }

    public UserResponse(Long id, String email, String urlFoto, String cedula) {
        this.id = id;
        this.email = email;
        this.urlFoto = urlFoto;
        this.cedula = cedula;
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
}
