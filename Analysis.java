
package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Analysis {
    private List<String> lines;
    
    public Analysis(File file) throws Exception{
        this.lines = new ArrayList<String>();
        Scanner reader = new Scanner(file);
                
        while(reader.hasNextLine()){
            lines.add(reader.nextLine());
        }        
    }
    
    public int lines(){
        return this.lines.size();
    }
    
    public int characters(){
        int characters = 0;
        for(String line : lines){
            characters += line.length();
        }
        return characters + this.lines.size();
    }
}
