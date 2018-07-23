
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



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Tournament {
    private ArrayList<Participant> list;
    private Scanner reader;
    private Random randomizer;
    
    public Tournament(){
	this.list = new ArrayList<Participant>();
	this.randomizer = new Random();
	this.reader = new Scanner(System.in);
    }

    public void printParticipants(){
	int i = 1;
	for(Participant participant : this.sort()){
		System.out.println("  " + i + ". " + participant);
		i++;
	}
    }

    public void addParticipant(String name){
	this.list.add(new Participant(name));
    }

    public int getLength(){
	return randomizer.nextInt(61) + 60;
    }

    public ArrayList<Participant> sort(){
	Collections.sort(this.list);
        return this.list;
    }

    public int[] getVotes(){
	int[] votes = new int[5];
	for(int i=0; i<5; i++){
		votes[i] = randomizer.nextInt(11) + 10;
	}
        return votes;
    }

    public int Result(int length, int[] votes){
	Arrays.sort(votes);
	return length + votes[1] + votes[2] + votes[3];
    }

    public void printResults(){
	for(Participant participant : this.sort()){
		System.out.println("  " + participant.getName());
		
		int l = getLength();
		participant.addJump(l);
		System.out.println("    length: " + l);

		int[] votes = getVotes();
		System.out.println("    judge votes: " + Arrays.toString(votes));
		
		participant.addPoints(Result(l, votes));
	}
    }

    public String jumpsToString(ArrayList<Integer> list){
	String string = "";
	for(int i=0; i<list.size()-1; i++){
		string += list.get(i) + " m, ";
	}
	string += list.get(list.size()-1) + " m";
	return string;
    }

    public void Registration(){
	System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

	while(true){
		System.out.print("  Participant name: ");
		String name = this.reader.nextLine();

		if(name.equals("")){break;}

		this.list.add(new Participant(name));
	}
	System.out.println("The tournament begins!");
    }

    public void Contest(){
	int i = 1;
	while(true){
		System.out.println("Write \"jump\" to jump; otherwise you quit: ");
		String command = this.reader.nextLine();

		if(!command.equals("jump")){break;}

		System.out.println("Round " + i + "\n" +
                "\n" +
                "Jumping order:");
		printParticipants();

		System.out.println("Results of round " + i);
		i++;

		printResults();
	}
	System.out.println("Thanks!");
    }

    public void Ranking(){
	System.out.println("Tournament results:\n" +
        "Position    Name");
        
        ArrayList<Participant> sorted = new ArrayList<Participant>();
        sorted = this.sort();
        Collections.reverse(sorted);
        
	for(Participant participant : sorted){
		int i = 1;
		System.out.print(i + "           ");
		System.out.println(participant);
		System.out.println("            jump lengths: " + this.jumpsToString(participant.getJumps()));
		i++;
	}
    }

    public void start(){
	Registration();
	Contest();
	Ranking();
    }
}


public class Main {

    public static void main(String[] args) {
        Tournament skiJump = new Tournament();
        
        System.out.println("Kumpula ski jumping week");
        
        skiJump.start();
    }
}
