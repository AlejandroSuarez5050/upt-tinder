/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.upt.controller;


import com.app.app.upt.dto.ReportesDTO;
import com.app.app.upt.service.ReportesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Alejandro
 */

@RestController
@RequestMapping(value="/reports")
public class ReportesController {
    @Autowired
    private ReportesServices service;
    
    @GetMapping(value="/reports-list")
    public ResponseEntity listReport(){
        return new ResponseEntity(service.listReports(), HttpStatus.OK);
    }
    
    @PostMapping(value="/register-report")
    public ResponseEntity addReport(@RequestBody ReportesDTO post){
        return new ResponseEntity(service.addReport(post), HttpStatus.OK);
    }
    
    @PutMapping(value="/{id}/update-report")
    public ResponseEntity editReport(@PathVariable(value="id") String id, @RequestBody ReportesDTO reportes){
        return new ResponseEntity(service.editReport(id,reportes), HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}/delete-report")
    public ResponseEntity deleteReport(@PathVariable(value="id") String id){
        return new ResponseEntity(service.deleteReport(id), HttpStatus.OK);
    }
}
