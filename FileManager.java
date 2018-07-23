
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner reader = new Scanner(f);
        ArrayList<String> reading = new ArrayList<String>();
        while(reader.hasNextLine()){
            String str = reader.nextLine();
            reading.add(str);
        }
        reader.close();
        return reading;
    }

    public void save(String file, String text) throws IOException {
        FileWriter w = new FileWriter(file);
        w.write(text);
        w.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(String s : texts){
            writer.write(s + "\n");
        }
        writer.close();
    }
}
