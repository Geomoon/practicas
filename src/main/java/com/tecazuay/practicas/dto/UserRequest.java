package com.tecazuay.practicas.dto;

import java.io.Serializable;

public class UserRequest implements Serializable {

    private String email;

    private String urlFoto;

    public UserRequest() {
    }

    public UserRequest(String email, String urlFoto) {
        this.email = email;
        this.urlFoto = urlFoto;
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

}
