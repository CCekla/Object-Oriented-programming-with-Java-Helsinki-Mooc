
//The class Changer turns a single character to another one. 
//The Changer holds a number of Changes and changes character strings with the help of Change objects it holds.
public class Change {
    private char from;
    private char to;
    
    public Change(char fromCharacter, char toCharacter){
        this.from = fromCharacter;
        this.to = toCharacter;
    }
        
    public String change(String characterString){
        return characterString.replace(this.from, this.to);
    }
}



import java.util.ArrayList;


public class Changer {
    private ArrayList<Change> list;
    
    public Changer(){
        this.list = new ArrayList<Change>();
    }
    
    public void addChange(Change change){
        this.list.add(change);
    }
    
    public String change(String characterString){
        for(Change c : this.list){
            characterString = c.change(characterString);
        }
        return characterString;
    }
}
