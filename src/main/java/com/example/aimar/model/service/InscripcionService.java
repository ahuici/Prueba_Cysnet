package com.example.aimar.model.service;

import com.example.aimar.model.entity.Curso;
import com.example.aimar.model.entity.Inscripcion;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

@Service
public class InscripcionService {

    private static final String COLLECTION = "Inscripcion";

    public List<Inscripcion> getAll() {
        Firestore db = FirestoreClient.getFirestore();
        List<Inscripcion> lista = new ArrayList<>();

        ApiFuture<QuerySnapshot> promesa = db.collection(COLLECTION).get();

        try {
            List<QueryDocumentSnapshot> documentos = promesa.get().getDocuments();

            for (QueryDocumentSnapshot doc : documentos) {
                Inscripcion inscripcion = doc.toObject(Inscripcion.class);
                inscripcion.setId(doc.getId());
                lista.add(inscripcion);
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public String save(Inscripcion inscripcion) {
        String ID = "Inscripcion " + getAll().size();
        inscripcion.setId(ID);

        if (inscripcion.getNombre().length() <= 2 ) return "El nombre debe contener al menos 3 caracteres";
        if (!validarLetras(inscripcion.getNombre())) return "El nombre debe contener solo letras";
        if (inscripcion.getApellido().length() <= 2) return "El apellido debe contener al menos 3 caracteres";
        if (!validarLetras(inscripcion.getApellido())) return "El apellido debe contener solo letras";
        if (!validarCorreo(inscripcion.getEmail())) return "El correo introducido no es valido";
        if (!validarTelefono(inscripcion.getNumTelefono())) return "El telefono introducido no es valido";

        //TODO Falta validar si se guarda en base de datos, se pierde, esta caida...
        Firestore db = FirestoreClient.getFirestore();
        db.collection(COLLECTION).document(inscripcion.getId()).set(inscripcion);
        return "";
    }

    public static boolean validarCorreo(String correo) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern PATRON = Pattern.compile(EMAIL_REGEX);

        if (correo == null || correo.isEmpty()) return false;
        return PATRON.matcher(correo).matches();
    }

    public boolean validarTelefono(String telefono) {
        if (telefono == null) return false;
        return telefono.matches("\\d{9}");
    }

    public boolean validarLetras(String texto) {
        if (texto == null || texto.isEmpty()) return false;
        return texto.matches("^[A-Za-z]+$");
    }
}
