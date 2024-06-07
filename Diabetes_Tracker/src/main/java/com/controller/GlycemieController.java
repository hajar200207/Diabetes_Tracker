package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Glycemie;
import com.service.GlycemieService;
import com.service.Patientservice;

import java.util.List;

@Controller
@RequestMapping("/glycemie")
public class GlycemieController {

    @Autowired
    private GlycemieService glycemieService;

    

    @GetMapping("/list")
    public String afficherListeLecturesGlycemie(Model model) {
        List<Glycemie> glycemies = glycemieService.afficherListeLecturesGlycemie();
        model.addAttribute("glycemies", glycemies);

        return "listeLectures";
    }



    @PostMapping("/supprimer")
    public String supprimerLectureGlycemie(@RequestParam int id, Model model) {
        glycemieService.supprimerLectureGlycemie(id);
        model.addAttribute("message", "Lecture de glycémie supprimée avec succès!");
        return "listeLectures";
    }
}
