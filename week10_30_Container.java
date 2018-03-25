package containers;

public class Container {

    private double capacity;
    private double volume;

    public Container(double tilavuus) {
        if (tilavuus > 0.0) {
            this.capacity = tilavuus;
        } else {
            this.capacity = 0.0;
        }

        volume = 0.0;
    }


    public double getVolume() {
        return volume;
    }

    public double getOriginalCapacity() {
        return capacity;
    }

    public double getCurrentCapacity() {
        return capacity - volume;
    }

    public void addToTheContainer(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount <= getCurrentCapacity()) {
            volume = volume + amount;
        } else {
            volume = capacity;
        }
    }

    public double takeFromTheContainer(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (amount > volume) {
            double everything = volume;
            volume = 0.0;
            return everything;
        }

        volume = volume - amount;
        return amount;
    }

    @Override
    public String toString() {
        return "volume = " + volume + ", free space " + getCurrentCapacity();
    }
}


package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {
    private List<Double> history;
    
    public ContainerHistory(){
        this.history = new ArrayList<Double>();
    }
    
    public void add(double situation){
        this.history.add(situation);
    }
    
    public void reset(){
        this.history.clear();
    }
    
    @Override
    public String toString(){
        return this.history.toString();
    }
    
    public double maxValue(){
        if(this.history.isEmpty()){
            return 0.0;
        }
        return Collections.max(this.history);
    }
    
    public double minValue(){
        if(this.history.isEmpty()){
            return 0.0;
        }
        return Collections.min(this.history);
    }
    
    public double average(){
        if(this.history.isEmpty()){
            return 0.0;
        }
        
        double sum = 0;
        for(double num : this.history){
            sum += num;
        }
        
        return sum / this.history.size();
    }
    
    public double greatestFluctuation(){
        if(this.history.isEmpty() || this.history.size() == 1){
            return 0.0;
        }
        
        List<Double> numbers = new ArrayList<Double>();
        double fluct = 0.0;
        for(int i = 0; i<this.history.size()-1; i++){
            double first = this.history.get(i);
            double second = this.history.get(i+1);
            
            fluct = second - first;
            numbers.add(Math.abs(fluct));
        }
        
        double first = this.history.get(this.history.size()-2);
        double second = this.history.get(this.history.size()-1);
        fluct = second - first;
        numbers.add(Math.abs(fluct));
        
        return Collections.max(numbers);
    }
    
    public double variance(){
        if(this.history.isEmpty() || this.history.size() == 1){
            return 0.0;
        }
        double result = 0.0;
        for(double n : this.history){
            result += Math.pow((n - this.average()), 2.0);
        }
        return result/(this.history.size() - 1);
    }
}



package containers;

public class ProductContainer extends Container{
    private String productName;
    
    public ProductContainer(String productName, double capacity){
        super(capacity);
        this.productName = productName;
    }
    
    public String getName(){
        return this.productName;
    }
    
    public void setName(String newName){
        this.productName = newName;
    }
    
    @Override
    public String toString(){
        return this.productName + ": " + super.toString();
    }
}


package containers;

public class ProductContainerRecorder extends ProductContainer{
    private ContainerHistory records;
    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume){
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.records = new ContainerHistory();
        this.records.add(initialVolume);
    }
    
    public String history(){
        return this.records.toString();
    }
    
    public void addToTheContainer(double amount){
        super.addToTheContainer(amount);
        this.records.add(super.getVolume());
    }
    
    public double takeFromTheContainer(double amount){
        this.records.add(super.getVolume()-amount);
        return super.takeFromTheContainer(amount);
    }
    
    public void printAnalysis(){
        System.out.println("Product: "+super.getName()+"\n" +
"History: "+this.records.toString()+"\n" +
"Greatest product amount: "+this.records.maxValue()+"\n" +
"Smallest product amount: "+this.records.minValue()+"\n" +
"Average: "+this.records.average()+"\n" +
"Greatest change: "+this.records.greatestFluctuation()+"\n" +
"Variance: " + this.records.variance());
    }
    
}
