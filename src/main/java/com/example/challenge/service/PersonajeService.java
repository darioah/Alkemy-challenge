/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.service;

import com.example.challenge.entity.Personajes;
import com.example.challenge.repositorios.PersonajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *Creación, Edición y Eliminación de Personajes (CRUD)
● Deberán existir las operaciones básicas de creación, edición y eliminación de
personajes.
● Al guardar/actualizar un personaje, se deberá devolver esta entidad completa,
es decir, con sus películas o series relacionadas.
● Al momento del Update, es importante solo actualizar la Entidad Personaje y
no su listado de películas
4. Detalle de Personaje
En el detalle deberán listarse todos los atributos del personaje, como así también sus
películas o series relacionadas.
5. Búsqueda de Personajes
Deberá permitir buscar por nombre, y filtrar por edad, peso o películas/series en las que
participó.
Para especificar el término de búsqueda o filtros se deberán enviar como parámetros de
query:
● GET /characters?name=nombre
* ● GET /characters?age=edad
● GET /characters?movies=idMovie
El listado deberá mostrar:
● Imagen.
● Nombre.
El endpoint deberá ser:
● /characters
Recordar que si ningún filtro es enviado, se deben devolver todas las entidades

 */
@Service
public class PersonajeService {
    
    @Autowired
    private Personajes personajes;
     @Autowired
     private PersonajeRepositorio personajeRepo;
    
    public Personajes crear(String Imagen, String Nombre, String Edad, String Peso, String Historia, String Películas){
        Personajes p = new Personajes();
        p.setEdad(Edad);
        p.setHistoria(Historia);
        p.setImagen(Imagen);
        p.setNombre(Nombre);
        p.setPelículas(Películas);
        p.setPeso(Peso);
        
        
        return personajeRepo.save(p);
    }
    
     public Personajes guardar(){
        
         
        return null ;
    }
     public Personajes modificar(String id, String Imagen, String Nombre, String Edad, String Peso, String Historia, String Películas ){
        Personajes per = personajeRepo.getById(id);
         per.setEdad(Edad);
         per.setHistoria(Historia);
        per.setImagen(Imagen);
        per.setNombre(Nombre);
         per.setPeso(Peso);
        return null ;
    }
     @Transaccional
     public void  eliminar(String id){
         Personajes per = personajeRepo.getById(id);
         personajeRepo.deleteById(id);
         
       
    }
    
}
