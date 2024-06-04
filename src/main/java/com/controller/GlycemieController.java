package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.Glycemie;
import com.service.GlycemieService;
import com.service.Patientservice;

import java.util.List;

@Controller
@RequestMapping("/glycemie")
public class GlycemieController {

    @Autowired
    private GlycemieService glycemieService;

    @GetMapping("/saisirLecture")
    public String showSaisirLectureForm() {
        return "saisirLecture";
    }

    @PostMapping("/saisirLecture")
    public String saisirLectureGlycemie(@RequestParam int patientId, 
                                        @RequestParam String date, 
                                        @RequestParam String heure, 
                                        @RequestParam float niveauGlycemie, Model model) {
        try {
            java.util.Date parsedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(date);
            java.util.Date parsedTime = new java.text.SimpleDateFormat("HH:mm").parse(heure);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            java.sql.Time sqlTime = new java.sql.Time(parsedTime.getTime());

            Patientservice patientservice = new Patientservice();
			patientservice.saisirLectureGlycemie(patientId, sqlDate, sqlTime, niveauGlycemie);
            model.addAttribute("message", "Lecture de glycémie enregistrée avec succès!");
        } catch (java.text.ParseException e) {
            model.addAttribute("message", "Erreur: Format de date ou d'heure invalide.");
        }
        return "result";
    }

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
        return "result";
    }
}
