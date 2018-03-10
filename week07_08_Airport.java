//In the airport exercises we create an application to manage an airport, with its airplanes and flights. 
//As far as the planes are concerned, we always know their ID and capacity. 
//As for the flights, we know the plane used for the flight, the departure airport code and the destination airport code.

public class Plane {
    private String idNum;
    private int capacity;
    
    public Plane(String idNum, int capacity){
        this.idNum = idNum;
        this.capacity = capacity;
    }
    
    public String toString(){
        return this.idNum + " (" + this.capacity + " ppl)";
    }
}



public class Flight {
    private Plane plane;
    private String departure;
    private String destination;
    
    public Flight(Plane plane, String dep, String des){
        this.plane = plane;
        this.departure = dep;
        this.destination = des;
    }
    
    public String toString(){
        return this.plane.toString() + " (" + this.departure + "-" + this.destination + ")";
    }
}


//the actual airport
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Airport {
    private HashMap<String, Integer> planes;
    private ArrayList<Flight> flights;
    private Scanner reader;
    
    public Airport(){
        this.planes = new HashMap<String, Integer>();
        this.flights = new ArrayList<Flight>();
        this.reader = new Scanner(System.in);
    }
    
    public void start(){
        airportPanel();
        flightService();
    }
    
    public void airportPanel(){
        System.out.println("Airport panel\n" +
        "--------------------");
        
        while(true){
            printAPMenu();
            
            System.out.print("> ");
            String command = this.reader.nextLine();
            
            if(command.equals("x")){
                break;
            }else if(command.equals("1")){
                addPlane();
            }else if(command.equals("2")){
                addFlight();
            }
            
        }
    }
    
    public void addPlane(){        
        this.planes.put(getIdNum(), getCapacity());
    }
    
    public void addFlight(){
        Flight flight = new Flight(getPlane(getIdNum()), getDeparture(), getDestination());
        
        this.flights.add(flight);
    }
    
    public Plane getPlane(String name){
        return new Plane(name, this.planes.get(name));
    }
    
    public void flightService(){
        System.out.println("Flight service\n" +
        "------------");
        
        while(true){
            printFSMenu();
            
            System.out.print("> ");
            String command = this.reader.nextLine();
            
            if(command.equals("x")){
                break;
            }else if(command.equals("1")){
                printPlanes();
            }else if(command.equals("2")){
                printFlights();
            }else if(command.equals("3")){
                printPlaneInfo();
            }
        }
    }
    
    public void printPlanes(){
        for(String key : this.planes.keySet()){
            System.out.println(getPlane(key));
        }
    }
    
    public void printFlights(){
        for(Flight flight : this.flights){
            System.out.println(flight);
        }
    }
    
    public void printPlaneInfo(){        
        System.out.println(getPlane(getIdNum()));
        
    }
    
    public String getIdNum(){
        System.out.print("Give plane ID: ");
        return this.reader.nextLine();
    }
    
    public int getCapacity(){
        System.out.print("Give plane capacity: ");
        return Integer.parseInt(this.reader.nextLine());
    }
    
    public String getDeparture(){
        System.out.print("Give departure airport code: ");
        return this.reader.nextLine();
    }
    
    public String getDestination(){
        System.out.print("Give destination airport code: ");
        return this.reader.nextLine();
    }
    
    public void printAPMenu(){
        System.out.println("Choose operation:\n" +
        "[1] Add airplane\n" +
        "[2] Add flight\n" +
        "[x] Exit");
    }
    
    public void printFSMenu(){
        System.out.println("Choose operation:\n" +
        "[1] Print planes\n" +
        "[2] Print flights\n" +
        "[3] Print plane info\n" +
        "[x] Quit");
    }
}


//main program
public class Main {
    public static void main(String[] args) {
        Airport terminal = new Airport();
        terminal.start();
    }
}
