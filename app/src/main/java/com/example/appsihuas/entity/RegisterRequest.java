package com.example.appsihuas.entity;

public class RegisterRequest {
    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private String tipo_doc;
    private String num_doc;
    private String celular;
    private String email;
    private String password;
    private String password_confirmation;

    public RegisterRequest(){};
    public RegisterRequest(String apellido_paterno, String apellido_materno, String nombres,
                           String tipo_doc, String num_doc, String celular, String email,
                           String password, String password_confirmation) {
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nombres = nombres;
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
        this.celular = celular;
        this.email = email;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
}

