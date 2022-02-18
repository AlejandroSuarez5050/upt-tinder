/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.controller;

import com.app.app.upt.dto.LikesDTO;
import com.app.app.upt.service.LikesServices;
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
@RequestMapping(value="/likes")
public class LikesController {
     @Autowired
    private LikesServices service;
     
    @GetMapping(value="/likes-list")
    public ResponseEntity listLikes() {
        return new ResponseEntity(service.listLikes(), HttpStatus.OK);
    }
    
    @GetMapping(value="/like-list/{id}")
    public ResponseEntity listLike(@PathVariable(value="id") String id) {
        return new ResponseEntity(service.listLike(id), HttpStatus.OK);
    }
    
     @PostMapping(value="/register-like")
      public ResponseEntity addLike(@RequestBody LikesDTO post) {
          return new ResponseEntity(service.addLike(post), HttpStatus.OK);
      }
      
      @DeleteMapping(value="/{id}/delete-like")
      public ResponseEntity deleteLike(@PathVariable(value="id") String id){
          return new ResponseEntity(service.deleteLike(id), HttpStatus.OK);
      }
      
      @GetMapping(value="/super-likes-list")
    public ResponseEntity listSuperLikes() {
        return new ResponseEntity(service.listSuperLikes(), HttpStatus.OK);
    }
    
    @GetMapping(value="/super-like-list/{id}")
    public ResponseEntity listSuperLike(@PathVariable(value="id") String id) {
        return new ResponseEntity(service.listSuperLike(id), HttpStatus.OK);
    }
    
     @PostMapping(value="/super-register-like")
      public ResponseEntity addSuperLike(@RequestBody LikesDTO post) {
          return new ResponseEntity(service.addSuperLike(post), HttpStatus.OK);
      }
      
      @DeleteMapping(value="/{id}/delete-super-like")
      public ResponseEntity deleteSuperLike(@PathVariable(value="id") String id){
          return new ResponseEntity(service.deleteSuperLike(id), HttpStatus.OK);
      }
      
            @GetMapping(value="/dislikes-list")
    public ResponseEntity listDislikes() {
        return new ResponseEntity(service.listDislikes(), HttpStatus.OK);
    }
    
    @GetMapping(value="/dislike-list/{id}")
    public ResponseEntity listDislike(@PathVariable(value="id") String id) {
        return new ResponseEntity(service.listDislike(id), HttpStatus.OK);
    }
    
     @PostMapping(value="/register-dislike")
      public ResponseEntity addDislike(@RequestBody LikesDTO post) {
          return new ResponseEntity(service.addDislike(post), HttpStatus.OK);
      }
      
      @DeleteMapping(value="/{id}/delete-dislike")
      public ResponseEntity deleteDislike(@PathVariable(value="id") String id){
          return new ResponseEntity(service.deleteDislike(id), HttpStatus.OK);
      }
    
}
