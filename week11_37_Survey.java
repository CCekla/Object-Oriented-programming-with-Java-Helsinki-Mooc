package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    
    public UserInterface(){        
    }

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container c){
        BoxLayout layout = new BoxLayout(c, BoxLayout.Y_AXIS);
        c.setLayout(layout);
        
        c.add(new JLabel("Are you?"));
        
        c.add(new JCheckBox("Yes!"));
        c.add(new JCheckBox("No!"));
        
        c.add(new JLabel("Why?"));
        
        JRadioButton no = new JRadioButton("No reason.");
        JRadioButton be = new JRadioButton("Because it is fun!");
        
        ButtonGroup group = new ButtonGroup();
        group.add(no);
        group.add(be);
        
        c.add(no);
        c.add(be);
        
        c.add(new JButton("Done!"));
    }

    public JFrame getFrame() {
        return frame;
    }
}
