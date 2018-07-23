//We need storage boxes when we move to a new apartment. 
//The boxes are used to store different things. 
//All the things which are stored in the boxes have to implement the ToBeStored interface.

public class Book implements ToBeStored {
    private String writer;
    private String name;
    private double weight;
    
    public Book(String author, String title, double weight){
        this.writer = author;
        this.name = title;
        this.weight = weight;
    }
    
    public double weight(){
        return this.weight;
    }
    
    public String toString(){
        return this.writer + ": " + this.name;
    }
}


public class CD implements ToBeStored {
    private String artist;
    private String title;
    private int publishingYear;
    private double weight;
    
    public CD(String artist, String title, int year){
        this.artist = artist;
        this.title = title;
        this.publishingYear = year;
        this.weight = 0.1;
    }
    
    public double weight(){
        return this.weight;
    }
    
    public String toString(){
        return this.artist + ": " + this.title + " (" + this.publishingYear + ")";
    }
}


import java.util.ArrayList;

public class Box implements ToBeStored {
    private ArrayList<ToBeStored> storage;
    private double maxWeight;
    
    public Box(double weight){
        this.storage = new ArrayList<ToBeStored>();
        this.maxWeight = weight;
    }
    
    public void add(ToBeStored thing){
        if((this.maxWeight - thing.weight()) >= 0){
            this.storage.add(thing);
            this.maxWeight -= thing.weight();
        }
    }
    
    public String toString(){
        return "Box: " + this.storage.size() + " things, total weight " + this.weight() + " kg";
    }
    
    public double weight(){
        double weight = 0;
        for(ToBeStored thing : this.storage){
            weight += thing.weight();
        }
        return weight;
    }
}


public interface ToBeStored {
    double weight();
}
