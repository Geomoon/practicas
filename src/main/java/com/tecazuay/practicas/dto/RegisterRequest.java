package com.tecazuay.practicas.dto;

import java.io.Serializable;

public class RegisterRequest implements Serializable {

    private String email;

    private String urlFoto;

    private String cedula;

    public RegisterRequest(String email, String urlFoto, String cedula) {
        this.email = email;
        this.urlFoto = urlFoto;
        this.cedula = cedula;
    }

    public RegisterRequest() {
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
