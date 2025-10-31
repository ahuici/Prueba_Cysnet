package com.example.aimar.controller;

import com.example.aimar.model.entity.Inscripcion;
import com.example.aimar.model.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("inscripcion", new Inscripcion());
        return "index";
    }

}
