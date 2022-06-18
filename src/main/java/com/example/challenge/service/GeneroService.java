/*
3. Creación de Géneros
Deberá existir la operación de creación de Genero .

 */
package com.example.challenge.service;

import com.example.challenge.entity.Genero;

import java.util.List;

import org.springframework.stereotype.Service;

// 3. Creación de Géneros
// Deberá existir la operación de creación de Genero 

@Service
public class GeneroService {
    
    
     public Genero save(String Nombre, String Imagen, String Películas){
        Genero p = new Genero();
         p.setNombre(Nombre);
         p.setImagen(Imagen);
         p.setPelículas(Películas);
        return null ;
    }

    public List<Genero> getAll() {
        return null;
    }

    public Genero getById(int id) {
        return null;
    }

    
    
}
