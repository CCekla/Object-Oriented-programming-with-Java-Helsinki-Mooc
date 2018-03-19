
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear){
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }
    
    public String getLatinName(){
        return this.latinName;
    }
    
    public int getRingingYear(){
        return this.ringingYear;
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }
        
        Bird compared = (Bird) object;
        if(this.ringingYear != compared.getRingingYear()){
            return false;
        }
        if(this.latinName == null || !this.latinName.equals(compared.getLatinName())){
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode(){
        if(this.latinName == null){
            return 7;
        }
        return this.ringingYear * this.latinName.hashCode();
    }
    
    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


