package com.example.appsihuas.entity;

public class User {
    private int id; // Suponiendo que hay un ID en la tabla
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String tipoDoc;
    private String numDoc;
    private String celular;
    private String email;
    private String password;

    // Constructor vacío (necesario para Gson o Jackson)
    public User() {}

    // Constructor con parámetros (opcional, para uso manual)
    public User(int id, String apellidoPaterno, String apellidoMaterno, String nombres,
                String tipoDoc, String numDoc, String celular, String email, String password) {
        this.id = id;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.celular = celular;
        this.email = email;
        this.password = password;
    }

    // Getters y setters para cada campo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
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

    // Método toString (opcional para depuración)
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", nombres='" + nombres + '\'' +
                ", tipoDoc='" + tipoDoc + '\'' +
                ", numDoc='" + numDoc + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
