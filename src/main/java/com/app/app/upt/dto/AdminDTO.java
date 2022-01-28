/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.dto;

import lombok.Data;

/**
 * @author AxelA
 */

@Data
public class AdminDTO {
    private String id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String correo;
    private String contrasenia;
    private Boolean status;
}
