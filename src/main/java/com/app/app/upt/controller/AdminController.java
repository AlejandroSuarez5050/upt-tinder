/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.controller;

import com.app.app.upt.dto.AdminDTO;
import com.app.app.upt.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author AxelA
 */

@RestController
@RequestMapping(value="/app")
public class AdminController {

    @Autowired
    private AdminServices service;

    @GetMapping(value="/admins-list")
    public ResponseEntity listAdmins() {
        return new ResponseEntity(service.listAdmins(), HttpStatus.OK);
    }

    @PostMapping(value="/register-admin")
    public ResponseEntity addAdmin(@RequestBody AdminDTO post) {
        return new ResponseEntity(service.addAdmin(post), HttpStatus.OK);
    }

    @PutMapping(value="/{id}/update-admin")
    public ResponseEntity editAdmin(@PathVariable(value="id") String id, @RequestBody AdminDTO admin){
        return new ResponseEntity(service.editAdmin(id, admin), HttpStatus.OK);
    }

}