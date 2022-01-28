/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.service.impl;

import com.app.app.upt.dto.PeticionesDTO;
import com.app.app.upt.service.PeticionesServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.app.upt.firebase.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

 /* @author Alexis Arenas
 */

@Service
public class PeticionesServiceImpl implements PeticionesServices{
    
     @Autowired
     private FirebaseInitializer firebase;
    
    @Override
    public List<PeticionesDTO> listUsers() {
        
        List<PeticionesDTO> response = new ArrayList<>();
        PeticionesDTO peticiones;
        
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        
         try {
             for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
              peticiones = doc.toObject(PeticionesDTO.class);
              
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
    public Boolean addUser(PeticionesDTO peticiones) {
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
    public Boolean editUser(String id, PeticionesDTO peticiones) {
       
        Map<String, Object> docData = getDocData(peticiones);
        
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        
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
    public Boolean deleteUser(String id) {        
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
        return firebase.getFirestore().collection("user");
    }
    
    private Map<String, Object> getDocData(PeticionesDTO peticiones){
        Map<String, Object> docData = new HashMap<>();
        
        //Obtiene los datos de los dto
        docData.put("nombre", peticiones.getNombre());
        docData.put("apellidoP", peticiones.getApellidoP());
        docData.put("apellidoM", peticiones.getApellidoM());
        docData.put("edad", peticiones.getEdad());
        docData.put("carrera", peticiones.getCarrera());
        docData.put("fotoPerfil", peticiones.getFotoPerfil());
        docData.put("fotos", peticiones.getFotos());
        docData.put("match", peticiones.getMatch());
        docData.put("correo", peticiones.getCorreo());
        docData.put("contrasenia", peticiones.getContrasenia());
        docData.put("telefono", peticiones.getTelefono());
        docData.put("status", peticiones.getStatus());
        docData.put("numReportes", peticiones.getNumReportes());
        
        return docData;
    }
}
