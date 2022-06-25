/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Peliculas {

    @Id
    protected String id;
    protected String Imagen;
    protected String Título;
    protected String Fechadecreación;
    protected String Calificación;
    protected String Personajesasociados;

    public Peliculas() {
    }

    public Peliculas(String id, String Imagen, String Título, String Fechadecreación, String Calificación,
            String Personajesasociados) {
        this.id = id;
        this.Imagen = Imagen;
        this.Título = Título;
        this.Fechadecreación = Fechadecreación;
        this.Calificación = Calificación;
        this.Personajesasociados = Personajesasociados;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getTítulo() {
        return Título;
    }

    public void setTítulo(String Título) {
        this.Título = Título;
    }

    public String getFechadecreación() {
        return Fechadecreación;
    }

    public void setFechadecreación(String Fechadecreación) {
        this.Fechadecreación = Fechadecreación;
    }

    public String getCalificación() {
        return Calificación;
    }

    public void setCalificación(String Calificación) {
        this.Calificación = Calificación;
    }

    public String getPersonajesasociados() {
        return Personajesasociados;
    }

    public void setPersonajesasociados(String Personajesasociados) {
        this.Personajesasociados = Personajesasociados;
    }

}
