package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calc;
    
    public UserInterface(Calculator c){
        this.calc = c;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        calc = new PersonalCalculator();
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
                
        JLabel text = new JLabel("0");
        JButton click = new JButton("Click!");
        
        ClickListener clicker = new ClickListener(calc, text);
        click.addActionListener(clicker);
        
        container.add(text, BorderLayout.NORTH);
        container.add(click, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public Calculator getCalc(){
        return calc;
    }
}
