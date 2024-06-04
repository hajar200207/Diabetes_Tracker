package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.Patient;
import com.service.Patientservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class PatientController {

    @Autowired
    private Patientservice patientService;

    @GetMapping("/")
    public String show() {
        return "index";
    }

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
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Date parsedTime = new SimpleDateFormat("HH:mm").parse(heure);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            java.sql.Time sqlTime = new java.sql.Time(parsedTime.getTime());

            Patient patient = patientService.saisirLectureGlycemie(patientId, sqlDate, sqlTime, niveauGlycemie);
            if (patient != null) {
                model.addAttribute("message", "Lecture de glycémie enregistrée avec succès!");
            } else {
                model.addAttribute("message", "Erreur: Patient non trouvé.");
            }
        } catch (ParseException e) {
            model.addAttribute("message", "Erreur: Format de date ou d'heure invalide.");
        }
        return "result";
    }

    @GetMapping("/modifierPatient")
    public String showModifierPatientForm() {
        return "modifierPatient";
    }

    @PostMapping("/modifierPatient")
    public String modifierLesInformationsPersonnelles(@RequestParam int patientId, 
                                                      @RequestParam String nom, 
                                                      @RequestParam int age, 
                                                      @RequestParam int taille, 
                                                      @RequestParam int poids, Model model) {
        Patient patient = patientService.modifierLesInformationsPersonnelles(patientId, nom, age, taille, poids);
        if (patient != null) {
            model.addAttribute("message", "Informations personnelles modifiées avec succès!");
        } else {
            model.addAttribute("message", "Erreur: Patient non trouvé.");
        }
        return "result";
    }
}
