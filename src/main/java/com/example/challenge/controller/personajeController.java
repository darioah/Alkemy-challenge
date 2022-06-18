package com.example.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.challenge.entity.Genero;
import com.example.challenge.entity.Peliculas;
import com.example.challenge.entity.Personajes;
import com.example.challenge.service.GeneroService;
import com.example.challenge.service.PersonajeService;

import java.util.List;
import  org.springframework.web.bind.annotation.GetMapping;
import com.example.challenge.repositorios.*;
// 2. Creación, Edición y Eliminación de Personajes (CRUD)

@CrossOrigin()
@RestController
public class personajeController {
    
  

    @Autowired
    private PersonajeService personajeService;
    
    @GetMapping("/personajes")
    public List<Personajes> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return personajeService.getAll(pageable);
    }
    @GetMapping("/personajes/{id}")
    public Personajes getPersonaje(@PageableDefault(page = 0, size = 10) Pageable pageable, 
    @PathVariable("id") String id) {
        
        return personajeService.getById(id);
    }


    @PostMapping("/personajes")
    public Personajes save(@RequestBody Personajes personaje) {
        try {
            return personajeService.save(personaje.getNombre(), personaje.getEdad(), personaje.getHistoria(), personaje.getImagen(), personaje.getPelículas() , personaje.getPeso());
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage());
        }

       
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        personajeService.delete(id);
    }

    @PutMapping("/{id}")
    public Personajes update(@PathVariable String id, @RequestBody Personajes personaje) {
        try {
            return personajeService.update(id, personaje.getNombre(), personaje.getEdad(), personaje.getHistoria(), personaje.getImagen(), personaje.getPelículas() , personaje.getPeso());
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        
        
       
    }
//    4 . Detalle de Personaje
// En el detalle deberán listarse todos los atributos del personaje, como así también sus
// películas o series relacionadas.

    @GetMapping("/personajes/{id}/detalle")
    public List<Personajes> getDetalle(@PathVariable Personajes personaje, Peliculas peliculas ) {
        
        
        return personajeService.getDetalle(peliculas.getCalificación(), peliculas.getFechadecreación(), peliculas.getImagen(), peliculas.getPersonajesasociados(), peliculas.getTítulo(),  personaje.getNombre(), personaje.getEdad(), personaje.getHistoria(), personaje.getImagen(), personaje.getPelículas() , personaje.getPeso());

        
    }
      
      

}
