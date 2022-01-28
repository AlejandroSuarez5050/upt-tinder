/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.app.upt.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Alexis Arenas
 */

@Service    
public class FirebaseInitializer {
    
    @PostConstruct
    private void iniFirestore() throws IOException {
        
        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("tinder-upt-conecction.json");

        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://tinder-upt.firebaseio.com").build();
        
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options); 
        }
        
    }
    
    public Firestore getFirestore(){
        return FirestoreClient.getFirestore();
    }

}
