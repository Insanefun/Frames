package fi.saajaro.gui;

import fi.saajaro.logiikka.Taistelu;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.story.Demo;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class StreightKehitysNappi implements ActionListener {

    private JTextArea kohde;
    private Pelaaja hero;
    private Moodi alpha;

    public StreightKehitysNappi(JTextArea kohde, Moodi alpha) {
        this.hero = alpha.getHero();
        this.kohde = kohde;
        this.alpha = alpha;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        hero.gainStreight();
        this.kohde.setText(hero.toString());
        if (this.hero.getSp() == 0 && this.hero.getCurrentLevel() == 1) {
            this.kohde.setText("Le ");
            Taistelu p = new Taistelu(this.alpha);
            p.taisto();
        } else if (this.hero.getSp() == 0) {
            Taistelu p = new Taistelu(this.alpha);
            p.taisto();
        }

    }
}
