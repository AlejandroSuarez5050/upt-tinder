/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.service.impl;

import com.app.app.upt.dto.AdminDTO;
import com.app.app.upt.firebase.FirebaseInitializer;
import com.app.app.upt.service.AdminServices;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AxelA
 */

@Service
public class AdminServiceImpl implements AdminServices {
    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<AdminDTO> listAdmins() {
        List<AdminDTO> response = new ArrayList<>();
        AdminDTO admin;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();

        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                admin = doc.toObject(AdminDTO.class);
                admin.setId(doc.getId());

                response.add(admin);
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addAdmin(AdminDTO admin) {
        Map<String, Object> docData = getDocData(admin);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean editAdmin(String id, AdminDTO admin) {
        Map<String, Object> docData = getDocData(admin);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);

        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception ex) {
            return Boolean.FALSE;
        }
    }

    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("admin");
    }

    private Map<String, Object> getDocData(AdminDTO admin) {
        Map<String, Object> docData = new HashMap<>();

        docData.put("nombre", admin.getNombre());
        docData.put("apellidoP", admin.getApellidoP());
        docData.put("apellidoM", admin.getApellidoM());
        docData.put("correo", admin.getCorreo());
        docData.put("contrasenia", admin.getContrasenia());
        docData.put("status", admin.getStatus());

        return docData;
    }
}
