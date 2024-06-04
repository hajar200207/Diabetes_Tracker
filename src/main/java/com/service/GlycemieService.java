package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Glycemie;
import com.dao.GlycemieRepository;

@Service
public class GlycemieService {

    @Autowired
    private GlycemieRepository glycemieRepository;

    
    public List<Glycemie> afficherListeLecturesGlycemie() {
        return glycemieRepository.findAll();
    }

    public void supprimerLectureGlycemie(int id) {
        glycemieRepository.deleteById(id);
    }
}

