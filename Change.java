
public class Change {
    private char from;
    private char to;
    
    public Change(char fromCharacter, char toCharacter){
        this.from = fromCharacter;
        this.to = toCharacter;
    }
    
    public char getFrom(){
        return this.from;
    }
    
    public char getTo(){
        return this.to;
    }
    
    public String change(String characterString){
        return characterString.replace(this.from, this.to);
    }
}
