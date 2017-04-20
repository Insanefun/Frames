package fi.saajaro.logiikka.story;

import fi.saajaro.gui.HyokkaysNappi;
import fi.saajaro.logiikka.Taistelu;
import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import static fi.saajaro.logiikka.tapahtumat.Gauntlet.NL;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Demo implements Moodi {

    private int osoitin;
    private Pelaaja hero;
    private JButton a;
    private JButton s;
    private JButton d;
    private JTextArea teksti;
    private String komento;

    public Demo(Pelaaja hero, JButton a, JButton s, JButton d, JTextArea teksti) {
        this.hero = hero;
        this.a = a;
        this.s = s;
        this.d = d;
        this.teksti = teksti;
        this.osoitin = 0;
        this.komento = "q";
    }

    @Override
    public Pelaaja getHero() {
        return this.hero;
    }

    @Override
    public void seuraava() {

        this.osoitin++;
        if (this.osoitin == 1) {
            this.taisto();
        }
    }

    @Override
    public JButton getA() {
        return this.a;
    }

    @Override
    public JButton getS() {
        return this.s;
    }

    @Override
    public JButton getD() {
        return this.d;
    }

    @Override
    public JTextArea getTeksti() {
        return this.teksti;
    }

    @Override
    public int getOsoitin() {
        return this.osoitin;
    }

    @Override
    public String getKomento() {
        return this.komento;
    }

    @Override
    public void setKomento(String uusiKomento) {
        this.komento = uusiKomento;
    }

    public void taisto() {
        //ArrayList<ActionListener> k = new ArrayList();
        //for(ActionListener l : this.a.getActionListeners() ){
        // k.add(l);
        //}
        ArrayList<JButton> k = new ArrayList();
        k.add(a);
        k.add(s);
        k.add(d);

        for (JButton currentButton : k) {
            for (ActionListener al : currentButton.getActionListeners()) {
                currentButton.removeActionListener(al);
            }

        }
        this.teksti.setText("Le battle");
        Mobs enemy = Gauntlet.generateEnemy();
        HyokkaysNappi y = new HyokkaysNappi(this.teksti, this, "A", enemy);
        this.a.addActionListener(y);
        battle(this);

    }

    public void battle(Moodi alpha) {
        Pelaaja hero = alpha.getHero();
        Mobs enemy = Gauntlet.generateEnemy();
        enemy.modifyDodge(hero.hitBonus());
        alpha.getTeksti().setText(enemy.encounter());
        while (hero.tellIfAlive() && enemy.tellAlive()) {
            alpha.getTeksti().setText(alpha.getTeksti().getText() + NL + "Choose a command: A = Attack, S = Tattle, D = Defend");
            Gauntlet.turn(enemy, alpha);
        }
    }

}
