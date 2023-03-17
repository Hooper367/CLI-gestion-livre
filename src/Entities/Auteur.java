package Entities;

import java.util.ArrayList;

public class Auteur {
    private String nom;
    private String prenom;
    private java.util.ArrayList<Livre> livreEcrit;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<Livre> getLivreEcrit() {
        return livreEcrit;
    }

    public void setLivreEcrit(ArrayList<Livre> livreEcrit) {
        this.livreEcrit = livreEcrit;
    }
}
