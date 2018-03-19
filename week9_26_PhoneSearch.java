import Contacts.logic.Phone;


public class Main {

    public static void main(String[] args) {
        Phone telephone = new Phone();
        telephone.start();
    }
}


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



package Contacts.logic;

import Contacts.domain.PhoneBook;
import java.util.ArrayList;



public class PhoneInterface {
   PhoneBook contacts;
   
   public PhoneInterface(){
       this.contacts = new PhoneBook();
   }
    
    public void printNumbers(ArrayList<String> numbers){
        if(numbers.size()==0){
            System.out.println("not found");
        }else if(numbers.size() == 1){
            System.out.println(numbers.get(0));
        }else{
            for(String num : numbers){
                System.out.println(" " + num);
            }
        }
    }
    
    public void printInfo(String name){
        if(this.contacts.getAdress(name).equals("") && this.contacts.getPhoneNumbers(name).size()==0){
            System.out.println("not found");
        }else{
            if(this.contacts.getAdress(name).equals("")){
                System.out.println("  address unknown");
            }else{
                System.out.print("adress: ");
                System.out.println(this.contacts.getAdress(name));
            }
            
            if(this.contacts.getPhoneNumbers(name).size()==0){
                System.out.println("  phone number not found");
            }else{
                System.out.println("  phone numbers:");
                printNumbers(this.contacts.getPhoneNumbers(name));
            }
        }
    }
    
    public void printAll(ArrayList<String> nameList){
        for(String name : nameList){
            System.out.println(" " + name);
            printInfo(name);
        }
    }
}



package Contacts.logic;

import java.util.Scanner;

public class Phone {
    private PhoneInterface phone;
    private Scanner reader;
    
    public Phone(){
        this.phone = new PhoneInterface();
        this.reader = new Scanner(System.in);
    }
    
    public void printMenu(){
        System.out.println("phone search\n" +
        "available operations:\n" +
        " 1 add a number\n" +
        " 2 search for a number\n" +
        " 3 search for a person by phone number\n" +
        " 4 add an address\n" +
        " 5 search for personal information\n" +
        " 6 delete personal information\n" +
        " 7 filtered listing\n" +
        " x quit");
    }
    
    public void start(){
        printMenu();
        
        while(true){
            System.out.print("command: ");
            String command = this.reader.nextLine();
            
            if(command.equals("x")){
                break;
            }
            else if(command.equals("1")){
                addANumber();
            }
            else if(command.equals("2")){
                searchNumber();
            }
            else if(command.equals("3")){
                searchName();
            }
            else if(command.equals("4")){
                addAnAdress();
            }
            else if(command.equals("5")){
                searchInfo();
            }
            else if(command.equals("6")){
                deleteInfo();
            }
            else if(command.equals("7")){
                filteredListing();
            }
        }
    }
    
    public void addANumber(){
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        
        System.out.print("number: ");
        String number = this.reader.nextLine();
        
        this.phone.contacts.addPhoneNumber(name, number);
    }
    
    public void addAnAdress(){
        System.out.print("whose address: ");
        String name = this.reader.nextLine();
        
        System.out.print("street: ");
        String adress = this.reader.nextLine() + " ";
        System.out.print("city: ");
        adress += this.reader.nextLine();
        
        this.phone.contacts.addAdress(name, adress);
    }
    
    public void searchNumber(){
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        
        this.phone.printNumbers(this.phone.contacts.getPhoneNumbers(name));
    }
    
    public void searchName(){
        System.out.print("number: ");
        String name = this.reader.nextLine();
        System.out.println(" " + this.phone.contacts.getNameByNumber(name));
    }
    
    public void searchInfo(){
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        
        this.phone.printInfo(name);
    }
    
    public void deleteInfo(){
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        
        this.phone.contacts.Remove(name);
    }
    
    public void filteredListing(){
        System.out.print("keyword (if empty, all listed): ");
        String input = this.reader.nextLine();
        
        if(input.isEmpty()){
            this.phone.printAll(this.phone.contacts.allNames());
        }
        else if(this.phone.contacts.getNamesWithInput(input).size()==0){
            System.out.println(" keyword not found");
        }
        else{
            this.phone.printAll(this.phone.contacts.getNamesWithInput(input));
        }
    }
}

