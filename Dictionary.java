
import java.util.ArrayList;
import java.util.HashMap;


public class Dictionary {
    private HashMap<String, String> terms;
    
    public Dictionary(){
        this.terms = new HashMap<String, String>();
    }
    
    public String translate(String word){
        return this.terms.get(word);
    }
    
    public void add(String word, String translation){
        this.terms.put(word, translation);
    }
    
    public int amountOfWords(){
        int wordsNum = 0;
        
        for(String key : this.terms.keySet()){
            wordsNum++;
        }
        return wordsNum;
    }
    
    public ArrayList<String> translationList(){
        ArrayList<String> list = new ArrayList<String>();
        for(String key: this.terms.keySet()){
            String text = key + " = " + this.terms.get(key);
            list.add(text);
        }
        return list;
    }
    
}
