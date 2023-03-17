package Entities;

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

    public static void UserEmprumts(String consoleName, String consoleFirstName, String title) {


    }
}
