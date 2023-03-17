import Entities.Menu;
import Entities.Utilisateur;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner value = new Scanner(System.in);
        System.out.println("Bonjour avant d'acceder a notre menu, etes vous deja client chez nous ? yes(y) or no(n) : ");
        String response = (value.nextLine());
        if (response.equals("y") || response.equals("yes")) {
            System.out.println("entrer votre prenom");
            String prenomValue = (value.nextLine());
            System.out.println("entrer votre nom");
            String nomValue = (value.nextLine());

            //fonction(CheckUser) pour check  si un user est bien enregistré
            if (Utilisateur.CheckUser(value, prenomValue, nomValue)) {
                Menu.choiceMenu();
            } else {
                System.out.println("Vous n'etes pas deja client veuillez vous inscrire");
                Utilisateur.addUser();
                Menu.choiceMenu();
            }
        } else if (response.equals("no") || response.equals("n")) {
            Utilisateur.addUser();
            Menu.choiceMenu();
        }

    }
}



// test pour decrease quantité de 1 (pas concluant mais je le laisse quand meme)
            /*int decrease = 1;
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\loick\\IdeaProjects\\Gestion2\\csv\\Entities.Livre.csv"))) {
                FileWriter writer = new FileWriter("Entities.Livre.csv", true);
                while ((line = br.readLine()) != null) {
                    String[] bookData = line.split(",");
                    if (bookData[0].equals(title)) {
                        int currentQuantity = Integer.parseInt(bookData[2]);
                        int newQuantity = currentQuantity - decrease ;
                        bookData[2] = Integer.toString(newQuantity);
                    }
                    String updatedLine = String.join(",", bookData);
                    writer.write(updatedLine);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            /*System.out.println("Voulez vous emprunter un livre ? si vous avez fait votre choix marquer le titre du livre souhaité : ");
            String title  = (value.nextLine());

            if (Entities.Livre.checkForQuantity()) {

                System.out.println("Tres bien vous avez emprumter " + title);
            }*/