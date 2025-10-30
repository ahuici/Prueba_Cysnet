package com.example.aimar.model.entity;


public class Inscripcion {

    private String id;

    private String nombre;

    private String apellido;

    private String email;

    private Integer numTelefono;

    public Inscripcion(String id, String nombre, String apellido, String email, Integer numTelefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numTelefono = numTelefono;
    }

    public Inscripcion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(Integer numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", numTelefono=" + numTelefono +
                '}';
    }
}
