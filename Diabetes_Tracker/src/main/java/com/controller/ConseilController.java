package com.controller;

import com.model.Conseil;
import com.service.ConseilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/conseils")
public class ConseilController {

    @Autowired
    private ConseilService conseilService;

    @GetMapping
    public String afficherTousLesConseils(Model model) {
        List<Conseil> conseils = conseilService.afficherTousLesConseils();
        model.addAttribute("conseils", conseils);
        return "afficherConseils";
    }

    @GetMapping("/{id}")
    public String afficherConseilParId(@PathVariable int id, Model model) {
        Conseil conseil = conseilService.afficherConseilParId(id);
        model.addAttribute("conseil", conseil);
        return "afficherConseil";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("conseil", new Conseil());
        return "ajouterConseil";
    }

    @PostMapping("/ajouter")
    public String ajouterConseil(@ModelAttribute Conseil conseil, Model model) {
        conseilService.ajouterConseil(conseil);
        return "redirect:/conseils";
    }

    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable int id, Model model) {
        Conseil conseil = conseilService.afficherConseilParId(id);
        model.addAttribute("conseil", conseil);
        return "modifierConseil";
    }

    @PostMapping("/modifier/{id}")
    public String modifierConseil(@PathVariable int id, @ModelAttribute Conseil conseil, Model model) {
        conseilService.mettreAJourConseil(id, conseil);
        return "redirect:/conseils";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerConseil(@PathVariable int id, Model model) {
        conseilService.supprimerConseil(id);
        return "redirect:/conseils";
    }
}
