
public class Thing {
    private String name;
    private int weight;
    
    public Thing(String text, int number){
        this.name = text;
        this.weight = number;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public String toString(){
        return "" + this.getName() + " (" + this.getWeight() + " kg)";
    }
    
}
