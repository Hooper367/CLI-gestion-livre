package Entities;

import java.io.*;
import java.util.Scanner;



public class Livre {
    private String auteur;
    private String titre;
    private String typeLivre;
    private String quantite;



    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(String typeLivre) {
        this.typeLivre = typeLivre;
    }

    public static void addLivre() {
        Scanner value = new Scanner(System.in);
        System.out.println("Maintenant vous pouvez rentrer un livre en stock en mettant les info suivante : Marquer le titre du livre :");
        String livreTitre = (value.nextLine());
        System.out.println("Marquer l'auteur du livre :");
        String auteurLivre = (value.nextLine());
        System.out.println("Marquer le type du livre :");
        String typeBook = (value.nextLine());
        System.out.println("Marquer le nombre de livre que vous voulez ajouter :");
        String quantite = (value.nextLine());

        Livre book = new Livre();
        book.setTitre(livreTitre);
        book.setAuteur(auteurLivre);
        book.setTypeLivre(typeBook);
        book.setQuantite(quantite);

        try (FileWriter fw = new FileWriter("csv/Livre.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(book.getTitre() + "," + book.getAuteur() + "," + book.getQuantite() + "," + book.getTypeLivre());
            System.out.println("Votre livre a ete ajouté");
        } catch (IOException e) {
        }
    }

    public static void decreaseQuantity() {
        Scanner value = new Scanner(System.in);
        // decrease quantity
        System.out.println("Voulez vous emprunter un livre ? si vous avez fait votre choix marquer le titre du livre souhaité : ");
        String title = (value.nextLine());
        // lecture du CSV
        File inputFile = new File("csv/Livre.csv");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inputFile);
            bufferedReader = new BufferedReader(fileReader);
        } catch (IOException e) {
            System.out.println("Erreur ouverture fichier");
            return;
        }

        // permet de stocker la valeur modifier
        StringBuilder outputContent = new StringBuilder();


        //boucle sur le CSV
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                // si le fichier est vide erreur
                System.out.println("Erreur: fichier vide");
                return;
            }
            outputContent.append(line);
            while ((line = bufferedReader.readLine()) != null) {
                outputContent.append("\n");
                String[] values = line.split(",");
                if (values.length >= 3 && values[0].equals(title)) {
                    // Prend la quantite du livre et la decremente de 1
                    int currentQuantity = Integer.parseInt(values[2]);
                    int newQuantity = currentQuantity - 1;

                    if(newQuantity == 0) {
                        // appeler fonction delete la ligne
                    }else {
                        // modifie la ligne pour avoir la nouvelle quantiter et la relier au stringbuilder
                        values[2] = String.valueOf(newQuantity);

                        outputContent.append(String.join(",", values));
                    }

                } else {
                    // les lignes qui ne match avec le titre  sont directement relier(stocker) dans le stringbuilder
                    outputContent.append(line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erreur lecture du fichier ");
            return;
        }
        // en gros on lis le fichier ont stocke les donnees pas utilisé ont stocke la ligne modifier et ont reecris le fichier complet avec la ligne modifier
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(inputFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(outputContent.toString());
            bufferedWriter.close();
            // gestion erreur
        } catch (IOException e) {
            System.out.println("Erreur");
            return;
        }

        System.out.println("Vous avez emprumter Ce livre (stock : quantite -1)");
    }

    public static void listeLivres() throws IOException {
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
            System.out.println("Titre du livre : " + titre.toUpperCase() + " : " + "auteur du livre : " + auteur.toUpperCase() + " : " + type.toUpperCase());
            line = reader.readLine();

        }
        reader.close();
    }

    public static void removeZeroQuantityLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader("csv/Livre.csv"))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3 && Integer.parseInt(fields[2]) == 0) {
                    continue; // permet de skip la ligne qui a la quantite 0
                }
                builder.append(line).append("\n"); // Stocke les ligne qui n'ont pas 0 en quantiter

            }
            try (FileWriter writer = new FileWriter("csv/Livre.csv")) {
                writer.write(builder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

