
package Contacts.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, ArrayList<String>> phones;
    private Map<String, String> adresses;
    
    public PhoneBook(){
        this.phones = new HashMap<String, ArrayList<String>>();
        this.adresses = new HashMap<String, String>();
    }
    
    public void addPhoneNumber(String name, String number){
        if(!this.phones.containsKey(name)){
            this.phones.put(name, new ArrayList<String>());
        }
        this.phones.get(name).add(number);
    }
    
    public void addAdress(String name, String adress){
        this.adresses.put(name, adress);
    }
    
    public String getNameByNumber(String number){
        String found = "";
        for(String name : this.phones.keySet()){
            if(this.phones.get(name).contains(number)){
                found += name;
            }else{
                found += "not found";
            }
        }
        return found;
    }
    
    public String getNameByAdress(String adress){
        String found = "";
        for(String name : this.adresses.keySet()){
            if(this.adresses.get(name).equals(adress)){
                found += name;
            }else{
                found += "not found";
            }
        }
        return found;
    }
    
    public ArrayList<String> getPhoneNumbers(String name){
        if(this.phones.containsKey(name)){
            return this.phones.get(name);
        }else{
            return new ArrayList<String>();
        }
    }
    
    public String getAdress(String name){
        if(this.adresses.containsKey(name)){
            return this.adresses.get(name);
        }else{
            return "";
        }
    }
    
    public ArrayList<String> getNamesWithInput(String input){
        Set<String> found = new HashSet<String>();
        for(String name : this.allNames()){
            if(name.contains(input)){
                found.add(name);
            }
        }
        for(String adress : this.adresses.values()){
            if(adress.contains(input)){
                found.add(this.getNameByAdress(adress));
            }
        }
        ArrayList<String> names = new ArrayList<String>(found);
        Collections.sort(names);
        return names;
    }
    
    public ArrayList<String> allNames(){
        Set<String> allNames = new HashSet<String>();
        
        for(String name : this.phones.keySet()){
            allNames.add(name);
        }
        for(String n : this.adresses.keySet()){
            allNames.add(n);
        }
        
        ArrayList<String> names = new ArrayList<String>(allNames);
        Collections.sort(names);
        
        return names;
    }
    
    public void Remove(String name){
        this.phones.remove(name);
        this.adresses.remove(name);
    }
    
    
}
