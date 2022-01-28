/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.upt.service.impl;

import com.app.app.upt.dto.ReportesDTO;
import com.app.app.upt.service.ReportesServices;
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

/**
 *
 * @author Alejandro
 */

@Service
public class ReportesServiceImpl implements ReportesServices{
    @Autowired
     private FirebaseInitializer firebase;
    
    @Override
    public List<ReportesDTO> listReports() {
        
        List<ReportesDTO> response = new ArrayList<>();
        ReportesDTO peticiones;
        
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        
         try {
             for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
              peticiones = doc.toObject(ReportesDTO.class);
              
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
    public Boolean addReport(ReportesDTO peticiones) {
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
    public Boolean editReport(String id, ReportesDTO peticiones) {
       
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
    public Boolean deleteReport(String id) {        
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
        return firebase.getFirestore().collection("reports");
    }
    
    private Map<String, Object> getDocData(ReportesDTO peticiones){
        Map<String, Object> docData = new HashMap<>();
        
        //Obtiene los datos de los dto
        docData.put("motivo", peticiones.getMotivo());
        docData.put("idEstudianteReportado", peticiones.getIdEstudianteReportado());
        docData.put("idEstudianteReporte", peticiones.getIdEstudianteReporte());
        
        
        return docData;
    }
}
