package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


@Controller // <-- NE PAS utiliser @RestController
public class StatistiqueController {

    @Autowired
    Statistique statistique;

    @GetMapping("/page-voiture")
    public String afficherPageVoiture() {
        return "voiture"; // => templates/voiture.html
    }

    @PostMapping("/voiture")
    @ResponseBody // cette méthode renvoie du JSON
    public void creerVoiture(@RequestBody Voiture voiture) {
        statistique.ajouter(voiture);
    }

    @GetMapping("/statistique")
    @ResponseBody // cette méthode renvoie du JSON
    public Echantillon getStatistiques() throws PasDeVoitureException {
        try {
            return statistique.prixMoyen();
        } catch (ArithmeticException e) {
            throw new PasDeVoitureException();
        }
    }

    @GetMapping("/liste-voitures")
    public String afficherListeVoitures(Model model) {
        model.addAttribute("voitures", statistique.getVoitures());
        return "liste-voitures"; // => templates/liste-voitures.html
    }

}
