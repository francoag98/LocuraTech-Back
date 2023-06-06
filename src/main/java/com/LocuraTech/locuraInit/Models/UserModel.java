package com.LocuraTech.locuraInit.Models;

public class UserModel {
    private String name;
    private String email;
    private String password;
    private String ciudad;
    private int telefono;


    public UserModel(String name, String email, String password, String ciudad, int telefono) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
