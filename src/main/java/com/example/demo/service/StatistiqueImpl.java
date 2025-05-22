package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StatistiqueImpl implements Statistique{

    List<Voiture> voitures = new ArrayList<Voiture>();

    @Override
    public void ajouter(Voiture voiture) {
        voitures.add(voiture);
    }

    @Override
    public Echantillon prixMoyen() throws ArithmeticException {
        int prixTotal = 0;
        int nombreDeVoitures = 0;
        Iterator<Voiture> iterator = voitures.iterator();
        while(iterator.hasNext()){
            prixTotal = prixTotal + iterator.next().getPrix();
            nombreDeVoitures++;
        }
        return new Echantillon(nombreDeVoitures, prixTotal/nombreDeVoitures);
    }

    @Override
    public List<Voiture> getVoitures() {
        return voitures;
    }

}
