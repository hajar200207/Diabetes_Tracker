package com.service;

import com.model.Conseil;
import com.dao.ConseilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConseilService {

    @Autowired
    private ConseilRepository conseilRepository;

    @Transactional
    public Conseil ajouterConseil(Conseil conseil) {
        return conseilRepository.save(conseil);
    }

    @Transactional
    public List<Conseil> afficherTousLesConseils() {
        return (List<Conseil>) conseilRepository.findAll();
    }

    @Transactional
    public Conseil afficherConseilParId(int id) {
        Optional<Conseil> optionalConseil = conseilRepository.findById(id);
        return optionalConseil.orElse(null);
    }

    @Transactional
    public Conseil mettreAJourConseil(int id, Conseil nouveauConseil) {
        Optional<Conseil> optionalConseil = conseilRepository.findById(id);
        if (optionalConseil.isPresent()) {
            Conseil ancienConseil = optionalConseil.get();
            ancienConseil.setDescription(nouveauConseil.getDescription());
            ancienConseil.setNiveauxMax(nouveauConseil.getNiveauxMax());
            ancienConseil.setNiveauxMin(nouveauConseil.getNiveauxMin());
            ancienConseil.setPhoto(nouveauConseil.getPhoto());
            return conseilRepository.save(ancienConseil);
        }
        return null;
    }

    @Transactional
    public void supprimerConseil(int id) {
        conseilRepository.deleteById(id);
    }
}
