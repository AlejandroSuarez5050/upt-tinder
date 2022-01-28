/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.app.upt.service;

import com.app.app.upt.dto.PeticionesDTO;
import java.util.List;

/**
 *
 * @author Alexis Arenas
 */
public interface PeticionesServices {
    
    List<PeticionesDTO> listUsers();
    
    Boolean addUser(PeticionesDTO peticiones);
    
     Boolean editUser(String id, PeticionesDTO peticiones);
     
     Boolean deleteUser(String id);

}
