import java.io.*;
import java.util.ArrayList;

public class CsvService {

    public static ArrayList<String> lireFichier(String file, boolean headerRow) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while(line != null){
            lines.add(line);
            line = br.readLine();
        }
        if(headerRow){
            lines.remove(0);
        }
        return lines;
    }
    public static ArrayList<String> ecrireFichier(String file, boolean headerRow) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while(line != null){
            lines.add(line);
            line = br.readLine();
        }
        if(headerRow){
            lines.remove(0);
        }
        return lines;
    }
}
