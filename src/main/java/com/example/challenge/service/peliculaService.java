/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.service;

import com.example.challenge.entity.Peliculas;
import com.example.challenge.repositorios.PeliculasRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

/**
 *7. Creación, Edición y Eliminación de Película / Serie.
Deberán existir las operaciones básicas de creación, edición y eliminación de películas o
series.
○ Al crear una Película, crearla con sus personajes asociados
○ Al guardar/actualizar una película, se deberá devolver esta entidad
completa, es decir, con sus personajes asociados.
○ Al momento del Update, es importante solo actualizar la Entidad
Película y no su listado de personajes
 8. Búsqueda de Películas o Series
Deberá permitir buscar por título, y filtrar por género. Además, permitir ordenar los
resultados por fecha de creación de forma ascendiente o descendiente.
El término de búsqueda, filtro u ordenación se deberán especificar como parámetros de
query:
● /movies?name=nombre
● /movies?genre=idGenero
● /movies?order=ASC | DESC
* El listado deberá mostrar:
● Imagen.
● Título
● Fecha de Creación.
El endpoint deberá ser:
● GET /movies
Recordar que si ningún filtro es enviado, se deben devolver todas las entidades
 */
@Service 
public class peliculaService {
    
    @Autowired
    private Peliculas peliculas; 
    
       @Autowired
    private PeliculasRepositorio peliculasRepo;
    
//       ○ Al crear una Película, crearla con sus personajes asociados
@Transactional
public Peliculas  save(String Imagen, String Título, String Fechadecreación, String Calificación, String Personajesasociados){
        Peliculas p = new Peliculas ();
        p.setTítulo(Título);
        p.setImagen(Imagen);
        p.setFechadecreación(Fechadecreación);
        p.setCalificación(Calificación);
        p.setPersonajesasociados(Personajesasociados);
           
           
       return peliculasRepo.save(p);
    }
//    ○ Al guardar/actualizar una película, se deberá devolver esta entidad
//completa, es decir, con sus personajes asociados.
    public Peliculas guardar(Peliculas peliculas){
        return peliculasRepo.save(peliculas);
    }
////     ○ Al momento del Update, es importante solo actualizar la Entidad
//Película y no su listado de personajes

    

     public Peliculas  modificar(String id, String Imagen, String Título, String Fechadecreación, String Calificación, String Personajesasociados){
         Peliculas p = peliculasRepo.getById(id);
         
         p.setImagen(Imagen);
         p.setTítulo(Título);
         p.setCalificación(Calificación);
         p.setFechadecreación(Fechadecreación);
         
         
         
        return peliculasRepo.save(p);
    }
     @Transactional
     public void  delete(String id){
         
             Peliculas u = getOne(id);
        peliculasRepo.delete(u);
     
     
    }
    @Transactional
     public List<Peliculas> listarPeliculas(){
         
         return peliculasRepo.findAll();
     }
     @Transactional
    public Peliculas getOne(String id) {
        return peliculasRepo.getOne(id);

        

    }

    public List<Peliculas> getAll(SpringDataWebProperties.Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Peliculas getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Peliculas update(String id, Peliculas pelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 



}
