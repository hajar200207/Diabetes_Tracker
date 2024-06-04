package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PatientRepository;
import com.model.Patient;

import java.util.Optional;

@Service
public class Patientservice {

    @Autowired
    private PatientRepository patientRepository;

    public Patient saisirLectureGlycemie(int patientId, java.util.Date date, java.sql.Time heure, float niveauGlycemie) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.saisirLectureGlycemie(date, heure, niveauGlycemie);
            return (Patient) patientRepository.save(patient);
        }
        return null;
    }

    public Patient modifierLesInformationsPersonnelles(int patientId, String nom, int age, int taille, int poids) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.modifierLesInformationsPersonnelles(nom, age, taille, poids);
            return (Patient) patientRepository.save(patient);
        }
        return null;
    }
}

