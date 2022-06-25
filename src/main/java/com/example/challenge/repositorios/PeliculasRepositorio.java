/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.repositorios;

import com.example.challenge.entity.Peliculas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dario Cardozo
 */
@Repository
public interface PeliculasRepositorio  extends JpaRepository<Peliculas, String>{
    
    @Query("SELECT p.imagen, p.titulo, p.fecha_creacion FROM Peliculas p")
    public List<Peliculas> listarPeliculas();
    
      @Query("SELECT p FROM Peliculas p WHERE p.titulo = :titulo")
    public List<Peliculas> peliculaPorNombre(@Param("titulo")String titulo);
    
    // @Query("SELECT p FROM Peliculas p WHERE p.genero.id = :id")
    // public List<Peliculas> peliculaPorGenero(@Param("id") ;   
    
     @Query("SELECT p FROM Peliculas p ORDER BY p.titulo ASC")
    public List<Peliculas> peliculaOrdenAsc(); 
    
    @Query("SELECT p FROM Peliculas p ORDER BY p.titulo DESC")
    public List<Peliculas> peliculaOrdenDesc();  

}
