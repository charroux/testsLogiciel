package com.example.demo.data;

public class Voiture {

    String marque;
    int prix;
    int id;

    public Voiture(){
    }

    public Voiture(String marque, int prix) {
        this.marque = marque;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marque='" + marque + '\'' +
                ", prix=" + prix +
                ", id=" + id +
                '}';
    }
}

// salut
