
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private List<String> words;
    
    public WordInspection(File file)throws Exception{
        this.words = new ArrayList<String>();
        Scanner reader = new Scanner(file, "UTF-8");
        
        while(reader.hasNext()){
            words.add(reader.next());
        }
    }
    
    public int wordCount(){
        return this.words.size();
    }
    
    public List<String> wordsContainingZ(){
        List<String> found = new ArrayList<String>();
        for(String word : this.words){
            if(word.indexOf("z")>=0){
                found.add(word);
            }
        }
        return found;
    }
    
    public List<String> wordsEndingInL(){
        List<String> found = new ArrayList<String>();
        for(String word : this.words){
            String c = "" + word.charAt(word.length()-1);
            if(c.equals("l")){
                found.add(word);
            }
        }
        return found;
    }
    
    public List<String> palindromes(){
        List<String> found = new ArrayList<String>();
        for(String word : this.words){
            if(word.equals(reverse(word))){
                found.add(word);
            }
        }
        return found;
    }
    
    public List<String> wordsWhichContainAllVowels(){
        List<String> found = new ArrayList<String>();
        for(String word : this.words){
            if(word.contains("a") && word.contains("e") && word.contains("i") && word.contains("o") && word.contains("u") && word.contains("y") && word.contains("ä") && word.contains("ö")){
                found.add(word);
            }
        }
        return found;
    }
    
    public String reverse(String text){
        String reverse = "";
            for(int i = text.length()-1; i>=0; i--){
                reverse += "" + text.charAt(i);
            }
            return reverse;
    }
}
