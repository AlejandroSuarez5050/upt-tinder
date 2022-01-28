/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.dto;

import lombok.Data;

/**
 *
 * @author Alexis Arenas
 */

@Data
public class PeticionesDTO {
    
   private String id;
   private String nombre;
   private String apellidoP;
   private String apellidoM;
   private int edad;
   private String carrera;
   private String fotoPerfil;
   private String fotos;
   private String match;
   private String correo;
   private String contrasenia;
   private String telefono;
   private Boolean status;
   private int numReportes;
}
