package fi.saajaro.gui;

import fi.saajaro.logiikka.hahmot.Pelaaja;
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

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelaaja hero;

    /**
     * Oletus konstruktori.
     */
    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        this.hero = new Pelaaja();
        frame = new JFrame("Frames");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextArea k = new JTextArea("Click D");
        container.add(k);
        container.add(luoValikko("A", "S", "D", k), BorderLayout.SOUTH);
        //container.add(luoValikko("Q", "W", "E", k), BorderLayout.NORTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel luoValikko(String a, String s, String d, JTextArea k) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        //panel.add(new JButton(a));
        //panel.add(new JButton(s));
        //panel.add(new JButton(d));
        JButton z = new JButton(a);
        panel.add(z);
        JButton x = new JButton(s);
        panel.add(x);
        JButton c = new JButton(d);
        AloitusNappi nappi = new AloitusNappi(k, z, x, c, this.hero);
        c.addActionListener(nappi);
        panel.add(c);
        return panel;
    }

    /**
     * Metodi jolla käyttöliittymän tällä hetkellä käyttämä pelaaja olio saadaan
     * helposti metodejen käyttöön.
     *
     * @return tällä hetkellä käytettävä pelaaja olio
     */

    public Pelaaja getPelaaja() {
        return this.hero;
    }
}
