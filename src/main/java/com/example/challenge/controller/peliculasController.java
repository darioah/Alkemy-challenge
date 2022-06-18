package com.example.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.challenge.service.peliculaService;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

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
@CrossOrigin()
@RestController()   // 1. Creación, Edición y Eliminación de Películas (CRUD)
public class peliculasController {
    
    @Autowired
    private peliculaService peliculaService;


    @GetMapping("/peliculas")
    public List<Peliculas> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return peliculaService.getAll(pageable);
    }

    @GetMapping("/peliculas/{id}")
    public Peliculas getPelicula(@PageableDefault(page = 0, size = 10) Pageable pageable,
            @PathVariable("id") String id) {
        return peliculaService.getById(id);
    }

    @PostMapping("/peliculas")
    public Peliculas save(@RequestBody Peliculas p) {
        try {
            return peliculaService.save(p.getCalificación(), p.getFechadecreación(), p.getImagen() , p.getPersonajesasociados() , p.getTítulo()       );
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("/peliculas/{id}")
    public void delete(@PathVariable("id") String id) {
        peliculaService.delete(id);
    }

    @PutMapping("/peliculas/{id}")
    public Peliculas update(@PathVariable("id") String id, @RequestBody Peliculas pelicula) {
        try {
            return peliculaService.update(id, pelicula);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }






}
