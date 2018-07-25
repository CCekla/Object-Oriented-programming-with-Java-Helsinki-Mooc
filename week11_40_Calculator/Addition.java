
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Addition implements ActionListener{
    private JTextField input;
    private JTextField output;
    private Calculator calculator;
    private JButton z;
    
    public Addition(JTextField i, JTextField o, Calculator c, JButton z){
        input = i;
        output = o;
        calculator = c;
        this.z = z;
    }
    
    private boolean active(JTextField field){
        if(field.getText().equals("0")){
            return false;
        }else{
            return true;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            int num = Integer.parseInt(input.getText());
            calculator.increase(num);
            
            output.setText("" + calculator.getValue());
            input.setText("");
            
            z.setEnabled(active(output));
            
        }catch(Exception exc){
            input.setText("");
        }
    }
}
