package com.example.demo.service;
import java.util.List;
import com.example.demo.data.Voiture;

public interface Statistique {

    public void ajouter(Voiture voiture);

    public Echantillon prixMoyen() throws ArithmeticException;

    public List<Voiture> getVoitures();


}
