package com.tecazuay.practicas.dto;

import java.io.Serializable;

public class LoginRequest  implements Serializable {

    private String email;

    public LoginRequest() {
    }

    public LoginRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
