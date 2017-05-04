package fi.saajaro.gui;

import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.gui.story.Demo;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AloitusNappi implements ActionListener {

    public static final String NL = System.getProperty("line.separator");

    private JTextArea kohde;
    private JButton kohdeA;
    private JButton kohdeS;
    private JButton kohdeD;
    private Pelaaja hero;

    /**
     * Oletus konstruktori.
     *
     * @param kohde alue jolla olio ilmoittaa tapahtumista käyttäjälle.
     * @param a käyttöliittymän nappi jota olio muuttaa
     * @param s käyttöliittymän nappi jota olio muuttaa
     * @param d käyttöliittymän nappi jota olio muuttaa
     * @param hero pelaaja olio jota käyttöliitymässä käytetään
     */
    public AloitusNappi(JTextArea kohde, JButton a, JButton s, JButton d, Pelaaja hero) {

        this.kohde = kohde;
        this.kohdeA = a;
        this.kohdeD = d;
        this.kohdeS = s;
        this.hero = hero;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kohde.setText("Agility gives small bonus to crit chance, hit chance and blocked damage( choose A) "
                + NL + " Streight increases damage(choose S) " + NL
                + " Hp gives you more durability, lose it all and you die.(choose D)");

        Demo alpha = new Demo(this.hero, kohdeA, kohdeS, kohdeD, kohde);
        StreightKehitysNappi str = new StreightKehitysNappi(this.kohde, alpha);
        this.kohdeS.addActionListener(str);
        AgilityKehitysNappi agi = new AgilityKehitysNappi(this.kohde, alpha);
        this.kohdeA.addActionListener(agi);
        HpKehitysNappi hp = new HpKehitysNappi(this.kohde, alpha);
        this.kohdeD.removeActionListener(this);
        this.kohdeD.addActionListener(hp);

    }
}
