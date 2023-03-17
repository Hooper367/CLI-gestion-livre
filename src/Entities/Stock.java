package Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Stock {
    private java.util.Map<Livre, Integer> nbrLivre;
    private String auteur;
    private String titre;
    private String typeLivre;
    private String quantite;


    public Map<Livre, Integer> getNbrLivre() {
        return nbrLivre;
    }

    public void setNbrLivre(Map<Livre, Integer> nbrLivre) {
        this.nbrLivre = nbrLivre;
    }
    public static void stockLivre() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("csv/Livre.csv"));
        String line = reader.readLine();
        String titre = null;
        String quantity = null;
        String type = null;
        while (line != null) {
            String[] columns = line.split(",");
            titre = columns[0];
            String auteur = columns[1];
            quantity = columns[2];
            type = columns[3];
            System.out.println("Titre du livre : " + titre.toUpperCase() + " : " + "auteur du livre : " + auteur.toUpperCase() + " : " + type.toUpperCase() + " : "  + "x"+quantity);
            line = reader.readLine();

        }
        reader.close();
    }
}
