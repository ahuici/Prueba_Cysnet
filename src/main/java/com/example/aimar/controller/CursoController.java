package com.example.aimar.controller;

import com.example.aimar.model.entity.Inscripcion;
import com.example.aimar.model.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ExecutionException;

@Controller
public class CursoController {

    @Autowired
    private CursoService cursoService;

    //TODO Gestionar errores
    @GetMapping({"/cursos" , "/cursos/"})
    private String cursos(Model model) throws ExecutionException, InterruptedException {
        model.addAttribute("cursos", cursoService.getAll());
        return "curso";
    }
}
