
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Storehouse {
    private Map<String, Integer> storage;
    private Map<String, Integer> stocks;
    
    public Storehouse(){
        this.storage = new HashMap<String, Integer>();
        this.stocks = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock){
        this.storage.put(product, price);
        this.stocks.put(product, stock);
    }
    
    public int price(String product){
        if(this.storage.get(product) == null){
            return -99;
        }
        return this.storage.get(product);
    }
    
    public int stock(String product){
        if(this.stocks.get(product) == null){
            return 0;
        }
        return this.stocks.get(product);
    }
    
    public boolean take(String product){
        if(this.stocks.get(product) != null && this.stocks.get(product) - 1 >= 0){
            int newStock = this.stocks.get(product) - 1;
            this.stocks.put(product, newStock);
           
            return true;
        }
        return false;
    }
    
    public Set<String> products(){
        return this.stocks.keySet();
    }
}
