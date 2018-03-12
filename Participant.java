
import java.util.ArrayList;


public class Participant implements Comparable<Participant>{
    private String name;
    private int points;
    private ArrayList<Integer> jumps;
    
    public Participant (String name){
	this.name = name;
	this.points = 0;
	this.jumps = new ArrayList<Integer>();
}

    public String getName(){
	return this.name;
    }

    public int getPoints(){
	return this.points;
    }

    public ArrayList<Integer> getJumps(){
	return this.jumps;
    }

    public void addJump(int num){
	this.jumps.add(num);
    }

    public void addPoints(int num){
	this.points += num;
    }

    @Override
    public String toString(){
	return this.name + " (" + this.points + " points)";
    }

    @Override
    public boolean equals(Object object){
	if(object == null){
            return false;
        }
	if(getClass() != object.getClass()){
            return false;
        }

	Participant compared = (Participant) object;
	if(this.points != compared.getPoints()){
            return false;
        }
	if(this.name == null || !this.name.equals(compared.getName())){
            return false;
        }
	return true;
    }   

    @Override
    public int compareTo(Participant participant){
	return this.points - participant.getPoints();
    }

}
