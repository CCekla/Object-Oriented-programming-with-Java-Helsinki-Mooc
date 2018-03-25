package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        this.name = name;
        
        if(weight < 0){
            throw new IllegalArgumentException("negative weight value");
        }else{
            this.weight = weight;
        }
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }
        Thing compared = (Thing) object;
        if(!this.name.equals(compared.getName())){
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode(){
        if(this.name == null){
            return 3;
        }
        return this.name.hashCode();
    }

}


package boxes;

import java.util.Collection;

public abstract class Box {

    public abstract void add(Thing thing);

    public void add(Collection<Thing> things) {
        for (Thing thing : things) {
            add(thing);
        }
    }

    public abstract boolean isInTheBox(Thing thing);
}


package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box{
    private int maxWeight;
    private List<Thing> things;
    
    public MaxWeightBox(int maxWeight){
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if(this.maxWeight - thing.getWeight() >=0){
            this.things.add(thing);
            this.maxWeight -= thing.getWeight();
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(this.things.contains(thing)){
            return true;
        }
        return false;
    }
}


package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box{
    private List<Thing> theThing;
    
    public OneThingBox(){
        this.theThing = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if(this.theThing.isEmpty()){
            this.theThing.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(!this.theThing.isEmpty() && this.theThing.get(0).equals(thing)){
            return true;
        }
        return false;
    }
    
}


package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box{
    private List<Thing> everything;
    
    public BlackHoleBox(){
        this.everything = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        this.everything.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
