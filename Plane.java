
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
