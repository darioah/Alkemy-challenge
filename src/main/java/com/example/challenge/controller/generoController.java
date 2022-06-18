package com.example.challenge.controller;


import com.example.challenge.entity.Genero;
import com.example.challenge.service.GeneroService;

import antlr.collections.List;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// 3. Creación de Géneros
// Deberá existir la operación de creación de Genero 
@CrossOrigin()
@RestController
public class generoController {
    
   @Autowired
    private GeneroService generoService;

    @GetMapping("/generos")
    public List<Genero> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return generoService.getAll(pageable);
    }

    @GetMapping("/generos/{id}")
    public Genero getById(@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable("id") String id) {
        return generoService.getById(id);
    }

    @PostMapping("/generos")
    public Genero save(@RequestBody Genero genero) {
        try {
            return generoService.save(genero);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    // @DeleteMapping("/{id}")
    // public void delete(@PathVariable String id) {
    //     generoService.delete(id);
    // }

    // @PutMapping("/generos")
    // public Genero update(@RequestBody Genero genero) {
    //     try {
    //         return generoService.update(genero);
    //     } catch (Exception ex) {
    //         throw new ResponseStatusException(
    //                 HttpStatus.BAD_REQUEST, ex.getMessage());
    //     }
    // }

}
