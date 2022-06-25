/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.repositorios;


import com.example.challenge.entity.Personajes;

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
public interface PersonajeRepositorio extends JpaRepository<Personajes, String> {
    
       
    @Query("SELECT p.imagen, p.nombre FROM Personajes p")
    public List<Personajes> ListarPersonajes();
    
    @Query("SELECT p FROM Personajes p WHERE p.edad = :edad")
    public List<Personajes> PersonajePorEdad(@Param("edad")Integer edad);
    
    @Query("SELECT p FROM Personajes p WHERE p.nombre = :nombre")
    public List<Personajes> PersonajePorNombre(@Param("nombre") String nombre);   
    
     @Query("SELECT p FROM Personajes p WHERE p.pelicula_o_serie.id = :id")
    public List<Personajes> PersonajePorPelicula(@Param("id") String movie);   


  
}
