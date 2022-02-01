/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.app.upt.service;

import com.app.app.upt.dto.LikesDTO;
import java.util.List;

/**
 *
 * @author Alexis Arenas
 */
public interface LikesServices {
    List<LikesDTO> listLikes();
    
    List<LikesDTO> listLike(String id);
    
    Boolean addLike(LikesDTO peticiones);
         
     Boolean deleteLike(String id);
}
