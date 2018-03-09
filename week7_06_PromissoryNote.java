
import java.util.HashMap;


public class PromissoryNote {
    private HashMap<String, Double> loanList;
    
    public PromissoryNote(){
        this.loanList = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value){
        this.loanList.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose){
        if(this.loanList.containsKey(whose)){
            return this.loanList.get(whose);
        }
        return 0;
    }
}
