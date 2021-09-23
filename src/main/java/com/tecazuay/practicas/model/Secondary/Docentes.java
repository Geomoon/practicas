package com.tecazuay.practicas.model.Secondary;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Immutable
@Table(name = "vdocentes_ed")
public class Docentes implements Serializable {
    @Id
    @Column(name = "pro_codigo", nullable = false,updatable = false)
    private Long pro_codigo;

    private String per_primerapellido;

    private String per_celular;

    private String per_correo;

    public Docentes() {

    }

    public Docentes(Long pro_codigo, String per_primerapellido, String per_celular, String per_correo) {
        this.pro_codigo = pro_codigo;
        this.per_primerapellido = per_primerapellido;
        this.per_celular = per_celular;
        this.per_correo = per_correo;
    }

    public Long getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(Long pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPer_primerapellido() {
        return per_primerapellido;
    }

    public void setPer_primerapellido(String per_primerapellido) {
        this.per_primerapellido = per_primerapellido;
    }

    public String getPer_celular() {
        return per_celular;
    }

    public void setPer_celular(String per_celular) {
        this.per_celular = per_celular;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public void setPer_correo(String per_correo) {
        this.per_correo = per_correo;
    }
}
