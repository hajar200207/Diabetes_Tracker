package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.Glycemie;
import com.model.Patient;
import com.service.GlycemieService;
import com.service.Patientservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/")
public class PatientController {

    @Autowired
    private Patientservice patientService;
    @Autowired
    private GlycemieService glycemieService;

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
        return "redirect:/list";
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

    @GetMapping("/list")
    public String afficherListeLecturesGlycemie(Model model) {
        List<Glycemie> glycemies = glycemieService.afficherListeLecturesGlycemie();
        model.addAttribute("glycemies", glycemies);

        return "listeLectures";
    }

    @PostMapping("/supprimerLecture")
    public String supprimerLectureGlycemie(@RequestParam int id, Model model) {
        glycemieService.supprimerLectureGlycemie(id);
        model.addAttribute("message", "Lecture de glycémie supprimée avec succès!");
        return "redirect:/list";
    }
    
    @GetMapping("/updateLecture/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Glycemie glycemie = glycemieService.findById(id);
        if (glycemie != null) {
            model.addAttribute("glycemie", glycemie);
            return "updateLecture";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/updateLecture")
    public String updateLectureGlycemie(@RequestParam int id,
                                        @RequestParam String date,
                                        @RequestParam String heure,
                                        @RequestParam float niveauGlycemie, Model model) {
        try {
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Date parsedTime = new SimpleDateFormat("HH:mm").parse(heure);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            java.sql.Time sqlTime = new java.sql.Time(parsedTime.getTime());

            Glycemie glycemie = glycemieService.updateLectureGlycemie(id, sqlDate, sqlTime, niveauGlycemie);
            if (glycemie != null) {
                model.addAttribute("message", "Lecture de glycémie mise à jour avec succès!");
            } else {
                model.addAttribute("message", "Erreur: Lecture de glycémie non trouvée.");
            }
        } catch (ParseException e) {
            model.addAttribute("message", "Erreur: Format de date ou d'heure invalide.");
        }
        return "redirect:/list";
    }
    @GetMapping("/afficherLectures/{patientId}")
    public String afficherLecturesGlycemiePourPatient(@PathVariable int patientId, Model model) {
        List<Glycemie> lectures = glycemieService.afficherLecturesGlycemiePourPatient(patientId);
        model.addAttribute("lectures", lectures);
        return "afficherLectures";
    }
    @GetMapping("/ajouterPatient")
    public String showAddPatientForm() {
        return "ajouterPatient";
    }

    @PostMapping("/ajouterPatient")
    public String addPatient(@RequestParam String nom, 
                             @RequestParam int age, 
                             @RequestParam int taille, 
                             @RequestParam int poids, 
                             Model model) {
        Patient patient = new Patient();
        patient.setNom(nom);
        patient.setAge(age);
        patient.setTaille(taille);
        patient.setPoids(poids);
        boolean success = patientService.ajouterPatient(patient);
        if (success) {
            model.addAttribute("message", "Patient ajouté avec succès!");
        } else {
            model.addAttribute("message", "Erreur: Impossible d'ajouter le patient.");
        }
        return "redirect:/patients";
    }
   
    @GetMapping("/patients")
    public String showPatientsList(Model model) {
        List<Patient> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "afficherPatients";
    }

}
