package com.example.aimar.controller;

import com.example.aimar.model.entity.Inscripcion;
import com.example.aimar.model.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InscripcionControllerRest {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping({"/inscripcion","/inscripcion/"})
    public ResponseEntity<String> inscripcionPost(@RequestBody Inscripcion inscripcion) {
        try {
            String respuesta = inscripcionService.save(inscripcion);

            if (respuesta == null || respuesta.isBlank()) {
                return ResponseEntity.ok().body("Te has inscrito correctamente");
            } else {
                return ResponseEntity.badRequest().body("Error: " + respuesta);
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error en la base de datos");
        }
    }
}
