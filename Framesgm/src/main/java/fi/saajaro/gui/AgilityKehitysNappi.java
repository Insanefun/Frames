package fi.saajaro.gui;

import static fi.saajaro.gui.AloitusNappi.NL;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.gui.story.Demo;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 * Luokka joka muokka JButton olita agilityn nostamiseen.
 */
public class AgilityKehitysNappi implements ActionListener {

    private JTextArea kohde;
    private Pelaaja hero;
    private Moodi alpha;

    /**
     * Oletus konstruktori.
     *
     * @param kohde alue jonka avulla käyttäjälle tiedotetaan mitä tapahtuu
     * @param alpha käyttöliittymä jossa nappi on
     */
    public AgilityKehitysNappi(JTextArea kohde, Moodi alpha) {
        this.hero = alpha.getHero();
        this.kohde = kohde;
        this.alpha = alpha;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        hero.gainAgility();
        this.kohde.setText(hero.toString() + NL + "Agility gives small bonus to crit chance, hit chance and blocked damage "
                + NL + " Streight increases damage " + NL
                + " Hp gives you more durability, lose it all and you die.");
        if (this.hero.getSp() == 0 && this.hero.getCurrentLevel() == 1) {
            this.kohde.setText("Battle! A = attack, S = study, D = defend");
            Taistelu p = new Taistelu(this.alpha);
            p.taisto();
        } else if (this.hero.getSp() == 0) {
            Taistelu p = new Taistelu(this.alpha);
            p.taisto();
        }

    }
}
