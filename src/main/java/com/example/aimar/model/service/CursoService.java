package com.example.aimar.model.service;

import com.example.aimar.model.entity.Curso;
import com.example.aimar.model.entity.Inscripcion;
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

    public String save(Curso curso) throws ExecutionException, InterruptedException {
        String ID = "Curso " + ( getAll().size() + 1);
        curso.setId(ID);

        if (curso.getDescripcion().isEmpty() || curso.getDescripcion().isBlank() || curso.getDescripcion() == null) return "Tiene que haber una descripcion";
        if (curso.getPrecio() == null || curso.getPrecio() < 10) return "El precio debe ser mayor que 10";
        if (curso.getTitulo().isEmpty() || curso.getTitulo().isBlank() || curso.getTitulo() == null) return "Tiene que haber un titulo";

        Firestore db = FirestoreClient.getFirestore();
        db.collection(COLLECTION).document(curso.getId()).set(curso);

        return "";
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
