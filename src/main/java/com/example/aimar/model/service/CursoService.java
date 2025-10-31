package com.example.aimar.model.service;

import com.example.aimar.model.entity.Curso;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    private static final String COLLECTION = "Curso";

    public void save(Curso curso) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection(COLLECTION).document(curso.getId()).set(curso);
    }

    public List<Curso> getAll() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Curso> cursos = new ArrayList<>();

        for (QueryDocumentSnapshot document : documents) {
            Curso curso = document.toObject(Curso.class);
            cursos.add(curso);
        }

        return cursos;
    }
}
