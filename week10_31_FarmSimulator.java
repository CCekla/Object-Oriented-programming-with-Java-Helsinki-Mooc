package farmsimulator;

public interface Alive {
    void liveHour();
}


package farmsimulator;

public interface Milkable {
    double milk();
}


package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive{
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    private Random r;
    private String name;
    private double milk;
    private int udder;
    
    public Cow(){
        this.r = new Random();
        this.name = NAMES[r.nextInt(NAMES.length)];
        this.udder = r.nextInt(26)+15;
        this.milk = 0.0;
        
    }
    
    public Cow(String name){
        this.r = new Random();
        this.name = name;
        this.udder = r.nextInt(26)+15;
        this.milk = 0.0;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getCapacity(){
        return this.udder;
    }
    
    public double getAmount(){
        return this.milk;
    }
    
    public String toString(){
        return "" + this.name + " " + Math.ceil(this.milk) + "/" + this.udder;
    }

    @Override
    public double milk() {
        double totalMilk = this.getAmount();
        this.milk = 0.0;
        return totalMilk;
    }

    @Override
    public void liveHour() {
        double newMilk = 0.7 + (1.3 * r.nextDouble());
        if(this.milk + newMilk <= this.udder){
            this.milk += newMilk;
        }else{
            this.milk = this.udder;
        }
    }
}


package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume;
    
    public BulkTank(){
        this.capacity = 2000.0;
        this.volume = 0.0;
    }
    
    public BulkTank(double capacity){
        this.capacity = capacity;
        this.volume = 0.0;
    }
    
    public double getCapacity(){
        return this.capacity;
    }
    
    public double getVolume(){
        return this.volume;
    }
    
    public double howMuchFreeSpace(){
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount){
        if(this.volume + amount <= this.capacity){
            this.volume += amount;
        }else{
            this.volume = this.capacity;
        }
    }
    
    public double getFromTank(double amount){
        double taken = 0.0;
        if(this.volume - amount >= 0){
            this.volume -= amount;
            taken = amount;
        }else{
            taken = this.volume;
            this.volume = 0.0;
        }
        return taken;
    }
    
    @Override
    public String toString(){
        return "" + Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}


package farmsimulator;

public class MilkingRobot {
    private BulkTank tank;
    
    public MilkingRobot(){
    }
    
    public BulkTank getBulkTank(){
        return this.tank;
    }
    
    public void setBulkTank(BulkTank tank){
        this.tank = tank;
    }
    
    public void milk(Milkable milkable){
        if(this.tank == null){
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        this.tank.addToTank(milkable.milk());
    }
}


package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank farmTank;
    private MilkingRobot milker;
    
    public Barn(BulkTank tank){
        this.farmTank = tank;
        this.milker = new MilkingRobot();
    }
    
    public BulkTank getBulkTank(){
        return this.farmTank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.milker = milkingRobot;
        milker.setBulkTank(this.farmTank);
    }
    
    public void takeCareOf(Cow cow){
        if(milker.getBulkTank() == null){
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }else{
            this.milker.milk(cow);
        }
    }
    
    public void takeCareOf(Collection<Cow> cows){
        for(Cow cow : cows){
            this.takeCareOf(cow);
        }
    }
    
    @Override
    public String toString(){
        return this.farmTank.toString();
    }
}


package farmsimulator;

import java.util.ArrayList;
import java.util.Collection;

public class Farm implements Alive{
    private String owner;
    private Barn barn;
    private Collection<Cow> cows;
    
    public Farm(String name){
        this.owner = name;
        this.barn = new Barn(new BulkTank());
        this.cows = new ArrayList<Cow>();
    }
    
    public Farm(String name, Barn barn){
        this.owner = name;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public String getOwner(){
        return this.owner;
    }
    
    public void addCow(Cow cow){
        this.cows.add(cow);
    }
    
    public void installMilkingRobot(MilkingRobot robot){
        this.barn.installMilkingRobot(robot);
    }
    
    public void manageCows(){
        this.barn.takeCareOf(this.cows);
    }

    @Override
    public void liveHour() {
        for(Cow cow : this.cows){
            cow.liveHour();
        }
    }
    
    @Override
    public String toString(){
        String cowsTotal = "";
        for(Cow cow : this.cows){
            cowsTotal += "        " + cow.toString() + "\n";
        }
        return "Farm owner: " + this.owner + "\n" + "Barn bulk tank: " + this.barn.toString() + "\n" + "Animals:\n" + cowsTotal;
    }
}
