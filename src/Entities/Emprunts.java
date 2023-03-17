package Entities;

import java.io.*;

public class Emprunts {
    private Livre LivreEmprumter;
    private Utilisateur emprumteur;



    public Livre getLivreEmprumter() {
        return LivreEmprumter;
    }

    public void setLivreEmprumter(Livre livreEmprumter) {
        LivreEmprumter = livreEmprumter;
    }

    public Utilisateur getEmprumteur() {
        return emprumteur;
    }

    public void setEmprumteur(Utilisateur emprumteur) {
        this.emprumteur = emprumteur;
    }

    public static void UserEmprumts(Utilisateur user) {


        try (FileWriter fw = new FileWriter("csv/Emprumts.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(user.getNom() +","+ user.getPrenom());
        } catch (IOException e) {
        }

    }
    public static void listeEmprumt() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("csv/Emprumts.csv"));
        String line = reader.readLine();
        String nom = null;
        String prenom = null;
        while (line != null) {
            String[] columns = line.split(",");
            nom = columns[0];
            prenom = columns[1];

            System.out.println("Emprumteur : " + nom.toUpperCase() + " : " + prenom.toUpperCase());
            line = reader.readLine();

        }
        reader.close();
    }
}
