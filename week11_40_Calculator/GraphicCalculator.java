
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calculator;
    
    public GraphicCalculator(){
        calculator = new Calculator();
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400,400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {        
        container.setLayout(new GridLayout(3,1));
        
        JTextField input = new JTextField();
        JTextField output = new JTextField("0");
        output.setEnabled(false);
        
        container.add(output);
        container.add(input);
        container.add(createPanel(input, output));
    }
    
    private JPanel createPanel(JTextField i, JTextField o){
        JPanel panel = new JPanel(new GridLayout(1,3));
        
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        
        JButton z = new JButton("Z");
        z.setEnabled(false);
        
        Addition addition = new Addition(i, o, calculator, z);
        plus.addActionListener(addition);
        
        Subtraction sub = new Subtraction(i, o, calculator, z);
        minus.addActionListener(sub);
        
        Resetting reset = new Resetting(i, o ,calculator, z);
        z.addActionListener(reset);
        
        panel.add(plus);
        panel.add(minus);
        panel.add(z);
        
        return panel;
    }
        
    public JFrame getFrame() {
        return frame;
    }
}
