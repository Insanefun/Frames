package fi.saajaro.gui;

import fi.saajaro.logiikka.Taistelu;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.story.Demo;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class HpKehitysNappi implements ActionListener {

    private JTextArea kohde;
    private Pelaaja hero;
    private Moodi alpha;

    public HpKehitysNappi(JTextArea kohde, Moodi alpha) {
        this.hero = alpha.getHero();
        this.kohde = kohde;
        this.alpha = alpha;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        hero.gainHp();
        this.kohde.setText(hero.toString());
        if (this.hero.getSp() == 0 && this.hero.getCurrentLevel() == 1) {

            Taistelu p = new Taistelu(this.alpha);
            p.taisto();
        } else if (this.hero.getSp() == 0) {
            Taistelu p = new Taistelu(this.alpha);
            p.taisto();
        }

    }

}
