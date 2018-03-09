//In this exercise, we implement a dictionary which can be used to retrieve the English translation of Finnish words. 
//We implement our dictionary using the HashMap data structure.

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


//The text user interface stores into two object variables the reader and dictionary it has received as constructor parameters. 
import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start(){
        System.out.println("Statements:\n" +
        "  add - adds a word pair to the dictionary\n" +
        "  translate - asks a word and prints its translation\n" +
        "  quit - quits the text user interface");
        
        while(true){
            System.out.println("Statement: ");
            String command = this.reader.nextLine();
            
            if(command.equals("quit")){
                break;
            }else if(command.equals("add")){
                add();
            }else if(command.equals("translate")){
                translate();
            }else{
                System.out.println("Unknown statement");
            }
        }
        System.out.println("Cheers!");
    }
    
    public void add(){
        System.out.print("In Finnish: ");
        String finnish = this.reader.nextLine();
        System.out.print("Translation: ");
        String translated = this.reader.nextLine();
        
        this.dictionary.add(finnish, translated);
    }
    
    public void translate(){
        System.out.print("Give a word: ");
        String word = this.reader.nextLine();
        
        System.out.println("Translation: " + this.dictionary.translate(word));
    }
}
