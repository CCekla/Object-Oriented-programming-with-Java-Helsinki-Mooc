//EU registration plates object with overridden equals() and hashCode()
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }
    
    public String getRegCode(){
        return this.regCode;
    }
    
    public String getCountry(){
        return this.country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }
        
        RegistrationPlate plate = (RegistrationPlate) object;
        if(this.regCode == null || !this.regCode.equals(plate.getRegCode())){
            return false;
        }
        if(this.country == null || !this.country.equals(plate.getCountry())){
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode(){
        if(this.regCode == null || this.country == null){
            return 7;
        }
        return this.regCode.hashCode() + this.country.hashCode();
    }

}


//Register class
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister(){
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner){
        if(this.owners.get(plate) == null){
            this.owners.put(plate, owner);
            return true;
        }
        return false;
    }
    
    public String get(RegistrationPlate plate){
        if(this.owners.get(plate) == null){
            return null;
        }
        return this.owners.get(plate);
    }
    
    public boolean delete(RegistrationPlate plate){
        for(RegistrationPlate key : this.owners.keySet()){
            if(plate.equals(key)){
                this.owners.remove(plate);
                return true;
            }
        }
        return false;
    }
    
    public void printRegistrationPlates(){
        for(RegistrationPlate plate : this.owners.keySet()){
            System.out.println(plate);
        }
    }
    
    public void printOwners(){
        ArrayList<String> list = new ArrayList<String>();
        
        for(RegistrationPlate plate : this.owners.keySet()){
            if(!list.contains(this.owners.get(plate))){
                list.add(this.owners.get(plate));
            }
        }
        
        for(String owner : list){
            System.out.println(owner);
        }
    }
}

