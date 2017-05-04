package fi.saajaro.gui;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import static fi.saajaro.logiikka.tapahtumat.Gauntlet.NL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class TattleNappi implements ActionListener {

    private String komento;
    private Pelaaja hero;
    private Mobs enemy;
    private JTextArea kohde;
    private Moodi alpha;

    /**
     * Oletus konstruktori.
     *
     * @param kohde tekstialue jolla käyttäjälle viestitään.
     * @param alpha Moodi rajapinnan täyttävä olio joka pitää sisällään tietoa
     * muista olioista.
     * @param komento String esitys napin komennosta.
     * @param enemy Mobs olio joka liittyy metodiin.
     */
    public TattleNappi(JTextArea kohde, Moodi alpha, String komento, Mobs enemy) {
        this.hero = alpha.getHero();
        this.kohde = kohde;
        this.komento = komento;
        this.alpha = alpha;
        this.enemy = enemy;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.komento = "S";
        this.alpha.setKomento(komento);
        Gauntlet.action(enemy, hero, "s");
        this.alpha.getTeksti().setText("As you study enemy it attacks relentlessly" + NL + hero.getToiminta() + NL + hero.getToiminta() + NL + hero.selfTattle() + NL + hero.tattle(enemy) + NL + "You identify enemy as " + enemy.getNimi() + ".");

    }

}
