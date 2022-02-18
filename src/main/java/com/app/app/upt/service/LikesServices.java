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
     
     List<LikesDTO> listSuperLikes();
    
    List<LikesDTO> listSuperLike(String id);
    
    Boolean addSuperLike(LikesDTO peticiones);
         
     Boolean deleteSuperLike(String id);
     
      List<LikesDTO> listDislikes();
    
    List<LikesDTO> listDislike(String id);
    
    Boolean addDislike(LikesDTO peticiones);
         
     Boolean deleteDislike(String id);
}
