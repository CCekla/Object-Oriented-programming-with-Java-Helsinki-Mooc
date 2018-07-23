/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class MindfulDictionary {
    private HashMap<String, String> finnEngDict;
    private String fileName;
    
    public MindfulDictionary() {
        this.finnEngDict = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file){
        this.finnEngDict = new HashMap<String, String>();
        this.fileName = file;
    }
    
    public void add(String word, String translation){
        if(!this.finnEngDict.containsKey(word) && !this.finnEngDict.containsValue(word)){
            finnEngDict.put(word, translation);
        }
    }
    
    public String translate(String word){
        String str = "";
        if(this.finnEngDict.containsKey(word)){
            str = this.finnEngDict.get(word);
        }
        else if(this.finnEngDict.containsValue(word)){
            for(String s : this.finnEngDict.keySet()){
                if(this.finnEngDict.get(s).equals(word)){
                    str = s;
                }
            }
        }else{
            str = null;
        }
        return str;
    }
    
    public void remove(String word) {
        if(this.finnEngDict.containsKey(word)){
            this.finnEngDict.remove(word);
        }
        
        if(this.finnEngDict.containsValue(word)){
            String str = "";
            for(String s : this.finnEngDict.keySet()){
                if(this.finnEngDict.get(s).equals(word)){
                    str = s;
                }
            }
            this.finnEngDict.remove(str);
        }

    }
    
    public boolean load() {
        boolean loadable = true;
        
        try {
            Scanner reader = new Scanner(new File(this.fileName));
            
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":"); 
                this.add(parts[0], parts[1]);
            }
            reader.close();
            
        } catch (Exception e) {
            loadable = false;
        }
        return loadable;
    }
    
    public boolean save(){
        boolean saved = true;
        
        try{
            FileWriter writer = new FileWriter(new File(this.fileName));
            
            for(String k : this.finnEngDict.keySet()){
                String line = "" + k + ":" + this.finnEngDict.get(k) + "\n";
                writer.write(line);
            }
            writer.close();
            
        }catch (Exception e){
            saved = false;
        }
        return saved;
    }
}
