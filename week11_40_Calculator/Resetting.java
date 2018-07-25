import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Resetting implements ActionListener{
    private JTextField input;
    private JTextField output;
    private Calculator calculator;
    private JButton z;
    
    public Resetting(JTextField i, JTextField o, Calculator c, JButton z){
        input = i;
        output = o;
        calculator = c;
        this.z = z;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        calculator.reset();
        output.setText("0");
        input.setText("");
        z.setEnabled(false);
    }
}