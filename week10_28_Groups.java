
package movable;

public class Organism implements Movable{
    private int x;
    private int y;
    
    public Organism(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public String toString(){
        return "x: " + this.x + "; y: " + this.y;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
}



package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable{
    private List<Movable> group;
    
    public Group(){
        this.group = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable){
        this.group.add(movable);
    }
    
    @Override
    public String toString(){
        String string = "";
        for(Movable m : this.group){
            string += m +"\n";
        }
        return string;
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable m : this.group){
            m.move(dx, dy);
        }
    }
    
}
