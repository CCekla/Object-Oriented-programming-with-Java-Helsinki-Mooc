//classes that implement given interface NationalService

public class CivilService implements NationalService {
    private int daysLeft;
    
    public CivilService(){
        this.daysLeft = 362;
    }
    
    public int getDaysLeft(){
        return this.daysLeft;
    }
    
    public void work(){
        if(this.daysLeft > 0){
            this.daysLeft--;
        }
    }
}



public class MilitaryService implements NationalService {
    private int daysLeft;
    
    public MilitaryService(int daysLeft){
        this.daysLeft = daysLeft;
    }
    
    public int getDaysLeft(){
        return this.daysLeft;
    }
    
    public void work(){
        if(this.daysLeft > 0){
            this.daysLeft--;
        }
    }
}
