/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Calculator {
    private int value;
    
    public Calculator(){
        value = 0;
    }
    
    public void increase(int num){
        value += num;
    }
    
    public void decrease(int num){
        value -= num;
    }
    
    public void reset(){
        value = 0;
    }
    
    public int getValue(){
        return value;
    }
}
