/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.service.impl;

import com.app.app.upt.dto.LikesDTO;
import com.app.app.upt.service.LikesServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.app.upt.firebase.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexis Arenas
 */

@Service
public class LikesServiceImpl implements LikesServices {
    
    @Autowired
     private FirebaseInitializer firebase;
    
    @Override
    public List<LikesDTO> listLikes() {
        List<LikesDTO> response = new ArrayList<>();
        LikesDTO peticiones;
        
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        
         try {
             for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
              peticiones = doc.toObject(LikesDTO.class);
              
              peticiones.setId(doc.getId());
              
              response.add(peticiones);
             }
             return response;
         } catch (Exception ex) {
             ex.printStackTrace();
             return null;
         } 
    }
    
    @Override
    public List<LikesDTO> listLike(String id) {
          List<LikesDTO> response = new ArrayList<>();
          LikesDTO peticiones;
          try {
                DocumentReference ref = getCollection().document(id);
                ApiFuture<DocumentSnapshot> futureDoc = ref.get();
                DocumentSnapshot document = futureDoc.get();
    
                if(document.exists()) {
                    peticiones = document.toObject(LikesDTO.class);
                    peticiones.setId(document.getId());
                    response.add(peticiones);
                    }
                return response;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }     
    }
    
    @Override
    public Boolean addLike(LikesDTO peticiones) {
        Map<String, Object> docData = getDocData(peticiones);
        
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);
        
         try {
             if(null != writeResultApiFuture.get()) {
                 return Boolean.TRUE;
             }
             return Boolean.FALSE;
                } catch (Exception ex) {
                    return Boolean.FALSE;
                }    
        }

    @Override
    public Boolean deleteLike(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        
        try {
             if(null != writeResultApiFuture.get()) {
                 return Boolean.TRUE;
             }
             return Boolean.FALSE;
         } catch (Exception ex) {
             return Boolean.FALSE;
         }    
    }
    
    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("like");
    }
    
    private Map<String, Object> getDocData(LikesDTO peticiones){
        Map<String, Object> docData = new HashMap<>();
        
        //Obtiene los datos de los dto
        docData.put("id_emisor", peticiones.getId_emisor());
        docData.put("id_remitente", peticiones.getId_remitente());
        
        return docData;
    }

}
