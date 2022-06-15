/*
3. Creación de Géneros
Deberá existir la operación de creación de Genero .

 */
package com.example.challenge.service;

import com.example.challenge.entity.Genero;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    
    
     public Genero crearGenero(String Nombre, String Imagen, String Películas){
        Genero p = new Genero();
         p.setNombre(Nombre);
         p.setImagen(Imagen);
         p.setPelículas(Películas);
        return null ;
    }
    
}
