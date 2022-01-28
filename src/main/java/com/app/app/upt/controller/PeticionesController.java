/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.controller;

import com.app.app.upt.dto.PeticionesDTO;
import com.app.app.upt.service.PeticionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Alexis Arenas
 */

//Controlador de la aplicacion donde se alojan todos los endpoint
@RestController
@RequestMapping(value="/app")
public class PeticionesController {
    
    @Autowired
    private PeticionesServices service;
    
    @GetMapping(value="/saludo")
    public String saludo() {
        return "Hola Mundo";
    }
    
    @GetMapping(value="/nombre/{name}")
    public String nombre(@PathVariable(value="name") String nombre) {
        return "Hola "+nombre;
    }
    
    @GetMapping(value="/users-list")
    public ResponseEntity listUsers() {
        return new ResponseEntity(service.listUsers(), HttpStatus.OK);
    }
    
      @PostMapping(value="/register-user")
      public ResponseEntity addUser(@RequestBody PeticionesDTO post) {
          return new ResponseEntity(service.addUser(post), HttpStatus.OK);
      }
      
      @PutMapping(value="/{id}/update-user")
      public ResponseEntity editUser(@PathVariable(value="id") String id, @RequestBody PeticionesDTO peticiones){
          return new ResponseEntity(service.editUser(id, peticiones), HttpStatus.OK);
      }
      
      @DeleteMapping(value="/{id}/delete-user")
      public ResponseEntity deleteUser(@PathVariable(value="id") String id){
          return new ResponseEntity(service.deleteUser(id), HttpStatus.OK);
      }
    
}
