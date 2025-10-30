package com.example.aimar.model.service;

import com.example.aimar.model.entity.Curso;
import com.example.aimar.model.entity.Inscripcion;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {

    private static final String COLLECTION = "Inscripcion";

    public void save(Inscripcion inscripcion) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection(COLLECTION).document(inscripcion.getId()).set(inscripcion);
    }
}
