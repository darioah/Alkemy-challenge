/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *

 */
@Entity
public class Personajes {
    @Id
       protected String id;

    public Personajes(String id) {
        
    }
  protected String  Imagen;
protected String Nombre;
 protected String Edad;
 protected String Peso;
protected String Historia;
 protected String Películas;

    public Personajes() {
    }

    public Personajes(String id, String Imagen, String Nombre, String Edad, String Peso, String Historia, String Películas) {
        this.id = id;
        this.Imagen = Imagen;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Peso = Peso;
        this.Historia = Historia;
        this.Películas = Películas;
    }

    
    
    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }

    public String getHistoria() {
        return Historia;
    }

    public void setHistoria(String Historia) {
        this.Historia = Historia;
    }

    public String getPelículas() {
        return Películas;
    }

    public void setPelículas(String Películas) {
        this.Películas = Películas;
    }
 
 
 
 
}
