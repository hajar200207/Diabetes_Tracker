package com.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Glycemie;
import com.model.Patient;
import com.dao.GlycemieRepository;

@Service
public class GlycemieService {

    @Autowired
    private GlycemieRepository glycemieRepository;

    public void saisirLectureGlycemie(int patientId, java.sql.Date date, java.sql.Time heure, float niveauGlycemie) {
        Glycemie glycemie = new Glycemie();
        glycemie.setPatientId(patientId);
        glycemie.setDate(date);
        glycemie.setHeure(heure);
        glycemie.setNiveauGlycemie(niveauGlycemie);
        glycemieRepository.save(glycemie);
    }
    
    public List<Glycemie> afficherListeLecturesGlycemie() {
        return (List<Glycemie>) glycemieRepository.findAll();
    }

    public void supprimerLectureGlycemie(int id) {
        glycemieRepository.deleteById(id);
    }

    public Glycemie findById(int id) {
        return glycemieRepository.findById(id).orElse(null);
    }

    public Glycemie updateLectureGlycemie(int id, java.sql.Date date, java.sql.Time heure, float niveauGlycemie) {
        Optional<Glycemie> optionalGlycemie = glycemieRepository.findById(id);
        if (optionalGlycemie.isPresent()) {
            Glycemie glycemie = optionalGlycemie.get();
            glycemie.setDate(date);
            glycemie.setHeure(heure);
            glycemie.setNiveauGlycemie(niveauGlycemie);
            return glycemieRepository.save(glycemie);
        }
        return null;
    }
 

	public List<Glycemie> afficherLecturesGlycemiePourPatient(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}
}

