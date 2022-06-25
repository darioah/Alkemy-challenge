/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genero {

    @Id
    protected String id;

    protected String Nombre;

    protected String Imagen;

    @ManyToMany
    protected String Películas;

    public Genero() {
    }

    public Genero(String id, String Nombre, String Imagen, String Películas) {
        this.id = id;
        this.Nombre = Nombre;
        this.Imagen = Imagen;
        this.Películas = Películas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getPelículas() {
        return Películas;
    }

    public void setPelículas(String Películas) {
        this.Películas = Películas;
    }

}
