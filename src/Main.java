import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner value = new Scanner(System.in);
        System.out.println("Bonjour voulez vous consulter le stock de nos livres ? yes or no :");
        String response = (value.nextLine());
        if(response.equals("yes")) {

            // fonction permettant de lister tout les livres
            Livre.listeLivres();

            // fonction permettant d'enlever 1 de quantiter si un utilisateur l'emprunte
            Livre.decreaseQuantity();

        } else if(response.equals("no")) {
            System.out.println("Alors voulez vous ajouter un livre en stock ? yes or no :");
            String res = (value.nextLine());

            if(res.equals("yes")){
                System.out.println("Ete vous deja client de chez nous ?  yes or no :");
                String answer = (value.nextLine());

                if(answer.equals("no")){
                  Utilisateur.addUser();
                  Livre.addLivre();

                } else if (answer.equals("yes")) {
                    System.out.println("entrer votre prenom");
                    String prenomValue = (value.nextLine());
                    System.out.println("entrer votre nom");
                    String nomValue = (value.nextLine());

                    //fonction(CheckUser) pour check  si un user est bien enregistré
                    if(Utilisateur.CheckUser(value, prenomValue, nomValue)){
                        Livre.addLivre();
                    } else {
                        // sinon il s'enregistre et peut ajouter un livre
                      Utilisateur.addUser();
                      Livre.addLivre();
                    }

                }
            } else if (res.equals("no")) {
                System.out.println("Dehors");
            }
        }

    }
}


// test pour decrease quantité de 1 (pas concluant mais je le laisse quand meme)
            /*int decrease = 1;
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\loick\\IdeaProjects\\Gestion2\\csv\\Livre.csv"))) {
                FileWriter writer = new FileWriter("Livre.csv", true);
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

            if (Livre.checkForQuantity()) {

                System.out.println("Tres bien vous avez emprumter " + title);
            }*/