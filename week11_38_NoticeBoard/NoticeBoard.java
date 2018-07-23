package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;
    
    public NoticeBoard(){        
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400,400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        JTextField field = new JTextField();
        JLabel text = new JLabel("I was copied here from the JTextArea.");
        
        JButton copy = new JButton("Copy!");
        ActionEventListener copier = new ActionEventListener(field, text);
        copy.addActionListener(copier);
        
        container.add(field);
        container.add(copy);
        container.add(text);
    }
}
