/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.challenge.repositorios;

import com.example.challenge.entity.Peliculas;
import com.example.challenge.entity.Personajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dario Cardozo
 */
@Repository
public interface PersonajeRepositorio extends JpaRepository<Personajes, String> {
    
}
