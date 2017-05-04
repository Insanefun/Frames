package fi.saajaro.gui;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class PuolustusNappi implements ActionListener {

    private String komento;
    private Pelaaja hero;
    private Mobs enemy;
    private JTextArea kohde;
    private Moodi alpha;

    /**
     * Oletus konstruktori.
     *
     * @param kohde tekstialue jolla viestitään käyttäjälle
     * @param alpha moodi rajapinnan täyttävä olio jossa tietoa käytettävistä
     * olioista
     * @param komento String esitys napin komennosta
     * @param enemy Mobs olio joka liittyy metodeihin
     */
    public PuolustusNappi(JTextArea kohde, Moodi alpha, String komento, Mobs enemy) {
        this.hero = alpha.getHero();
        this.kohde = kohde;
        this.komento = komento;
        this.alpha = alpha;
        this.enemy = enemy;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.komento = "D";
        this.alpha.setKomento(komento);
        this.alpha.getTeksti().setText(Gauntlet.action(enemy, hero, komento));

    }

}
