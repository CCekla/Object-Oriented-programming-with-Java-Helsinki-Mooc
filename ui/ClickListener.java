/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ClickListener implements ActionListener{
    private Calculator calc;
    private JLabel counter;
    
    public ClickListener(Calculator c, JLabel t){
        this.calc = c;
        this.counter = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calc.increase();
        this.counter.setText("" + this.calc.giveValue());
    }
}
