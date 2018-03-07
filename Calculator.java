
import java.lang.reflect.Array;


public class Calculator {
    private Reader scanner;
    private int counter;
    
    public Calculator(){
        this.scanner = new Reader();
        this.counter = 0;
    }
    
    public void start(){
        while(true){
            System.out.print("command: ");
            String command = this.scanner.readString();
            
            if(command.equals("end")){
                break;
            }
            else if(command.equals("sum")){
                sum();
            }
            else if(command.equals("difference")){
                difference();
            }
            else if(command.equals("product")){
                product();
            }
        }
        statistics();
    }
    
    private void sum(){
        int [] values = getValues();
        int result = values[0] + values[1];
        this.counter++;
        
        System.out.println("sum of the values " + result);
    }
    
    private void difference(){
        int [] values = getValues();
        int result = values[0] - values[1];
        this.counter++;
        
        System.out.println("difference of the values " + result);
    }
    
    private void product(){
        int [] values = getValues();
        int result = values[0] * values[1];
        this.counter++;        
        
        System.out.println("product of the values " + result);
    }
    
    public int[] getValues(){
        int[] values =  new int[2];
        
        System.out.print("value1: ");
        values[0] = this.scanner.readInteger();
        System.out.print("value2: ");
        values[1] = this.scanner.readInteger();
        
        return values;
        
    }
    
    private void statistics(){
        System.out.println("Calculations done " + this.counter);
    }
    
}
