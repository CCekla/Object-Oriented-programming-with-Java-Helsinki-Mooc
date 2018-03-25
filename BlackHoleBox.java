
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
