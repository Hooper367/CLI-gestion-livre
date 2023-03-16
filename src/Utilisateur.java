import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilisateur {
    private java.util.ArrayList<Livre> livreEmprumter;
    private String nom;
    private String prenom;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Livre> getLivreEmprumter() {
        return livreEmprumter;
    }

    public void setLivreEmprumter(ArrayList<Livre> livreEmprumter) {
        this.livreEmprumter = livreEmprumter;
    }

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

    public static void addUser() {
        Scanner value = new Scanner(System.in);
        System.out.println("Creer votre compte en entrant les info suivante : Entrer votre nom :");
        String nom = (value.nextLine());
        System.out.println("Entrer votre prenom :");
        String prenom = (value.nextLine());

        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        try (FileWriter fw = new FileWriter("C:\\Users\\loick\\IdeaProjects\\Gestion2\\csv\\User.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(user.getNom() + "," + user.getPrenom());
        } catch (IOException e) {

        }
    }

    public static boolean CheckUser(Scanner value, String prenomValue, String nomValue) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\loick\\IdeaProjects\\Gestion2\\csv\\User.csv"));
        String line = reader.readLine();

        while (line != null) {
            String[] columns = line.split(",");

            if (prenomValue.equals(columns[0]) && nomValue.equals(columns[1])) {
                return true;
            }
            line = reader.readLine();
        }
        return false;
    }
}
