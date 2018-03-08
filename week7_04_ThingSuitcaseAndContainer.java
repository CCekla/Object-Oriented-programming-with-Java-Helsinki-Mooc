//class Thing
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

//class Suitcase to contain Things
import java.util.ArrayList;


public class Suitcase {
    private ArrayList<Thing> things;
    private int maxWeight;
    
    public Suitcase(int num){
        this.things = new ArrayList<Thing>();
        this.maxWeight = num;
    }
    
    public void addThing(Thing thing){
        int remainingWeight = this.maxWeight - thing.getWeight();
        
        if(remainingWeight >= 0){
            this.things.add(thing);
            this.maxWeight -= thing.getWeight();
        }
    }
    
    public String toString(){
        String text;
        
        if(this.things.size() == 0){
            text = "empty (" + this.totalWeight() + " kg)";
        }
        else if(this.things.size() == 1){
            text = "" + this.things.size() + " thing (" + this.totalWeight() + " kg)";
        }
        else{
            text = "" + this.things.size() + " things (" + this.totalWeight() + " kg)";
        }
        return text;
    }
    
    public void printThings(){
        for(Thing item : this.things){
            System.out.println(item);
        }
    }
    
    public int totalWeight(){
        int total = 0;
        for(Thing item : this.things){
            total += item.getWeight();
        }
        return total;
    }
    
    public Thing heaviestThing(){
        
        if(this.things.size() ==0 ){
            return null;
        }
        
        Thing bigger = this.things.get(0);
        
        for(Thing item : this.things){
            if(item.getWeight() >= bigger.getWeight()){
                bigger = item;
            }
        }
        return bigger;
    }
}

//class Container to contain Suitcases
import java.util.ArrayList;


public class Container {
    private ArrayList<Suitcase> cases;
    private int maxWeight;
    
    public Container(int num){
        this.cases = new ArrayList<Suitcase>();
        this.maxWeight = num;
    }
    
    public void addSuitcase(Suitcase suitcase){
        int remainingWeight = this.maxWeight - suitcase.totalWeight();
        
        if(remainingWeight >= 0){
            this.cases.add(suitcase);
            this.maxWeight -= suitcase.totalWeight();
        }
    }
    
    public String toString(){
        String text;
        
        if(this.cases.size() == 0){
            text = "empty (" + this.getTotalWeight() + " kg)";
        }
        else if(this.cases.size() == 1){
            text = "" + this.cases.size() + " suitcase (" + this.getTotalWeight() + " kg)";
        }
        else{
            text = "" + this.cases.size() + " suitcases (" + this.getTotalWeight() + " kg)";
        }
        return text;
    }
    
    public int getTotalWeight(){
        int total = 0;
        
        for(Suitcase suitcase : this.cases){
            total += suitcase.totalWeight();
        }
        return total;
    }
    
    public void printThings(){
        for(Suitcase suitcase : this.cases){
            suitcase.printThings();
        }
    }
    
}


//Main program + method which adds 100 suitcases into the container it receives as parameter; 
//there is one brick in each suitcase. 
//The bricks weight will then increase by one each time until the weight becomes 100 kg.
public class Main {

    public static void main(String[] args) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container){
        for(int i=1; i<=100; i++){
            Thing brick = new Thing("brick", i);
            Suitcase myCase = new Suitcase(100);
            
            myCase.addThing(brick);
            container.addSuitcase(myCase);
        }
    }

}
