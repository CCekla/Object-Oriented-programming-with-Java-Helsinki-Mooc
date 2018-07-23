
package moving.domain;

public interface Thing {
    int getVolume();
}



package moving.domain;

public class Item implements Thing, Comparable<Item>{
    private String name;
    private int volume;
    
    public Item(String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return this.name + " (" + this.volume + " dm^3)";
    }
    
    @Override
    public int getVolume(){
        return this.volume;
    }
    
    @Override
    public int compareTo(Item thing){
        return this.volume - thing.getVolume();
    }
}



package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing{
    private List<Thing> list;
    private int maximumCapacity;
    
    public Box(int maximumCapacity){
        this.list = new ArrayList<Thing>();
        this.maximumCapacity = maximumCapacity;
    }
    
    public boolean addThing(Thing thing){
        if(this.maximumCapacity - thing.getVolume() >= 0){
            Item toAdd = (Item) thing;
            this.list.add(toAdd);
            this.maximumCapacity -= thing.getVolume();
            return true;
        }
        return false;
    }
    
    @Override
    public int getVolume(){
        int volumes = 0;
        for(Thing thing : this.list){
            volumes += thing.getVolume();
        }
        return volumes;
    }
    
    
}


package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;


public class Packer {
    private List<Box> boxes;
    private int boxesVolume;
    
    public Packer(int boxesVolume){
        this.boxes = new ArrayList<Box>();
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things){
        List<Box> packed = new ArrayList<Box>();
        Box box = new Box(this.boxesVolume);
        
        for(Thing thing : things){
            if(box.addThing(thing)){
                box.addThing(thing);
            }
            packed.add(box);
            box = new Box(this.boxesVolume);            
        }
        return packed;
    }
}
