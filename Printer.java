
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Printer {
    private File file;
    private Scanner reader;
    
    public Printer(String fileName) throws Exception{
        this.file = new File(fileName);
        this.reader = new Scanner(this.file);
    }
    
    public void printLinesWhichContain(String word) throws FileNotFoundException{
        String string = "";
                
        while(this.reader.hasNextLine()){
            String line = this.reader.nextLine();
            if(word.equals("")){
                string += line + "\n";
            }
            else if(line.contains(word)){
                string += line + "\n";
            }
        }
        System.out.print(string);
        //I create a new scanner to parse the file again, otherwise new calls would find the file already read
        this.reader = new Scanner(this.file);
    }
}
