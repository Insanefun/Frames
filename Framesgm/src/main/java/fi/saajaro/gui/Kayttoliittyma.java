package fi.saajaro.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
public class Kayttoliittyma { }
/*/
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Frames");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.add(new JTextArea());
        container.add(luoValikko("A", "S", "D"), BorderLayout.SOUTH);
        container.add(luoValikko("Q", "W", "E"), BorderLayout.NORTH);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private JPanel luoValikko(String a, String s, String d) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JButton(a));
        panel.add(new JButton(s));
        panel.add(new JButton(d));
        return panel;
    } 
} 

/*/
