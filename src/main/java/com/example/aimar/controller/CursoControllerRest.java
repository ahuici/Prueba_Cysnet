package com.example.aimar.controller;

import com.example.aimar.model.entity.Curso;
import com.example.aimar.model.service.CursoService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
public class CursoControllerRest {

    @Autowired
    private CursoService cursoService;

    private String contrasenaCursos;

    public CursoControllerRest() {
        Dotenv dotenv = Dotenv.load();
        this.contrasenaCursos = dotenv.get("CONTRASENA_CURSOS");
    }

    /* Al ser un endpoint que solo los administradores usaran pido una contraseña */
    @PostMapping({"/cursos","/cursos/"})
    public ResponseEntity<String> cursoPost(@RequestBody Curso curso, @RequestParam(required = false) String contraseña) {
        if (contraseña == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acceso denegado");

        try {
            if (!contraseña.equals(contrasenaCursos)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acceso denegado");

            String respuesta = cursoService.save(curso);

            if (respuesta == null || respuesta.isBlank()) {
                return ResponseEntity.ok().body("Curso guardado correctamente");
            } else {
                return ResponseEntity.badRequest().body("Error: " + respuesta);
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error en la base de datos");
        }
    }
}
