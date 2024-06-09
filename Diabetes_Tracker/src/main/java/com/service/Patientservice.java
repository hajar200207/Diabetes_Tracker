package com.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PatientRepository;
import com.model.Patient;

@Service
public class Patientservice {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Patient saisirLectureGlycemie(int patientId, Date date, java.sql.Time heure, float niveauGlycemie) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.saisirLectureGlycemie(date, heure, niveauGlycemie);
            return patientRepository.save(patient);
        }
        return null;
    }

    @Transactional
    public Patient modifierLesInformationsPersonnelles(int patientId, String nom, int age, int taille, int poids) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.modifierLesInformationsPersonnelles(nom, age, taille, poids);
            return patientRepository.save(patient);
        }
        return null;
    }
    public List<Patient> findAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient findPatientById(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.orElse(null);
    }
    public boolean ajouterPatient(Patient patient) {
       
        try {
            patientRepository.save(patient);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
