
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
