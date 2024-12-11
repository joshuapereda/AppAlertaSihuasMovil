package com.example.appsihuas.entity;

public class UserResponse {
    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private String tipo_doc;
    private String num_doc;
    private String celular;
    private String email;

    // Getters y setters

    public String getApellidoPaterno() {
        return apellido_paterno;
    }

    public void setApellidoPaterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    // Agrega los demás getters y setters según lo necesites
}
