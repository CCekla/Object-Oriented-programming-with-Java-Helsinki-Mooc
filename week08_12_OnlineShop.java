//In the following exercise we build an online shop

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


import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<Purchase> basket;
    
    public ShoppingBasket(){
        this.basket = new ArrayList<Purchase>();
    }
    
    public void add(String product, int price){
        Purchase purchase = new Purchase(product, 1, price);
        if(this.basket.contains(purchase)){
            this.basket.get(this.basket.indexOf(purchase)).increaseAmount();
        }else{
            this.basket.add(purchase);
        }
    }
    
    public int price(){
        int total = 0;
        for(Purchase purchase : this.basket){
            total += purchase.price();
        }
        return total;
    }
    
    public void print(){
        for(Purchase purchase : this.basket){
            System.out.println(purchase);
        }
    }
    
    public boolean contains(Purchase purchase){
        boolean truth = false;
        for(Purchase item : this.basket){
            if(purchase.equals(item)){
                truth = true;
            }
            truth = false;
        }
        return truth;
    }
}


//We add purchases to our shopping basket. 
//With purchase we mean a specific number of a specific product. 
//For instance, we can put into our shopping basket either a purchase corresponding to one bread, 
//or a purchase corresponding to 24 coffees.
public class Purchase {
    private String product;
    private int amount;
    private int unitPrice;
    
    public Purchase(String product, int amount, int unitPrice){
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price(){
        return this.amount * this.unitPrice;
    }
    
    public void increaseAmount(){
        this.increaseAmount(1);
    }
    
    public void increaseAmount(int num){
        for(int i=0; i<num; i++){
            this.amount++;
        }
    }
    
    public String toString(){
        return this.product + ": " + this.amount;
    }
    
    public String getProduct(){
        return this.product;
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }
        
        Purchase compared = (Purchase) object;
        if(this.product == null || !this.product.equals(compared.getProduct())){
            return false;
        }
        return true;
    }
}

//Now, all the parts of our online shop are ready. Our online shop has a storage house, which contains all products. 
//We have got a shopping basket to manage all our customers. 
//Whenever a customer chooses a purchase, we add it to the shopping basket if the product is available in our storage house. 
//Meanwhile, the storage stocks are reduced by one.
import java.util.Scanner;

public class Shop {
    private Storehouse store;
    private Scanner reader; 
    
    public Shop(Storehouse store, Scanner reader){
        this.store = store;
        this.reader = reader;
    }
    
    public void manage(String customer){
        ShoppingBasket basket = new ShoppingBasket();
        System.out.println("Welcome to our shop " + customer);
        System.out.println("below is our sale offer:");

        for (String product : store.products()) {
            System.out.println( product );
        }

        while (true) {
            System.out.print("what do you want to buy (press enter to pay):");
            String product = reader.nextLine();
            if (product.isEmpty()) {
                break;
            }
            else if(this.store.price(product) != -99 && this.store.stock(product) > 0){
                basket.add(product, this.store.price(product));
                this.store.take(product);
            }
        }    
        System.out.println("your purchases are:");
        basket.print();
        System.out.println("basket price: " + basket.price());    
    }
}
