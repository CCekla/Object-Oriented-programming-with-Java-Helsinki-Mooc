/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

public class PersonalCalculator implements Calculator {
    private int num;
    
    public PersonalCalculator(){
        this.num = 0;
    }
    
    @Override
    public int giveValue(){
        return this.num;
    }
    
    @Override
    public void increase(){
        this.num++;
    }
}
