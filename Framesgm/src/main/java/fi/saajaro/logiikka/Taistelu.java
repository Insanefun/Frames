package fi.saajaro.logiikka;

import fi.saajaro.gui.AgilityKehitysNappi;
import fi.saajaro.gui.AloitusNappi;
import fi.saajaro.gui.HpKehitysNappi;
import fi.saajaro.gui.HyokkaysNappi;
import fi.saajaro.gui.PuolustusNappi;
import fi.saajaro.gui.StreightKehitysNappi;
import fi.saajaro.gui.TattleNappi;
import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Taistelu {

    private int osoitin;
    private Pelaaja hero;
    private JButton a;
    private JButton s;
    private JButton d;
    private JTextArea teksti;
    private String komento;
    private Moodi alpha;

    public Taistelu(Moodi alpha) {
        this.a = alpha.getA();
        this.s = alpha.getS();
        this.d = alpha.getD();
        this.alpha = alpha;
        this.teksti = alpha.getTeksti();
        this.osoitin = 1;
        this.hero = alpha.getHero();
    }

    public void taisto() {
        if (this.osoitin == 1) {
            this.hero.heal(this.hero.getAgility());
            ArrayList<JButton> k = new ArrayList();
            k.add(a);
            k.add(s);
            k.add(d);

            for (JButton currentButton : k) {
                for (ActionListener al : currentButton.getActionListeners()) {
                    currentButton.removeActionListener(al);
                }
            }
            Mobs enemy = Gauntlet.generateEnemy();
            HyokkaysNappi q = new HyokkaysNappi(this.teksti, this.alpha, "A", enemy, this);
            this.a.addActionListener(q);
            PuolustusNappi e = new PuolustusNappi(this.teksti, this.alpha, "D", enemy);
            this.d.addActionListener(e);

            TattleNappi w = new TattleNappi(this.teksti, this.alpha, "S", enemy);
            this.s.addActionListener(w);
        } else {
            hero.heal(10);
            this.teksti.setText("You have been healed! (woooh!)");
            this.teksti.setText("Unused skillpoints " + hero.getSp());
            ArrayList<JButton> k = new ArrayList();
            k.add(a);
            k.add(s);
            k.add(d);

            for (JButton currentButton : k) {
                for (ActionListener al : currentButton.getActionListeners()) {
                    currentButton.removeActionListener(al);
                }
            }
            Mobs enemy = new Mobs("thunderfury the blessed blade of the windseeker", 15, 3, 10, 15, 1000);
            HyokkaysNappi q = new HyokkaysNappi(this.teksti, this.alpha, "A", enemy, this);
            this.a.addActionListener(q);
            PuolustusNappi e = new PuolustusNappi(this.teksti, this.alpha, "D", enemy);
            this.d.addActionListener(e);

            TattleNappi w = new TattleNappi(this.teksti, this.alpha, "S", enemy);
            this.s.addActionListener(w);

        }
    }

    public void taisteluLoppu(Mobs enemy) {
        this.osoitin++;
        this.teksti.setText("Keepo");
        this.a = alpha.getA();
        this.s = alpha.getS();
        this.d = alpha.getD();
        if (hero.getCurrentHp() < 1) {
            ArrayList<JButton> k = new ArrayList();
            k.add(a);
            k.add(s);
            k.add(d);

            for (JButton currentButton : k) {
                for (ActionListener al : currentButton.getActionListeners()) {
                    currentButton.removeActionListener(al);
                }
            }
            alpha.getTeksti().setText("Gameover (Press D to restart(disabled))");
            //AloitusNappi e = new AloitusNappi(this.teksti, this.a, this.s, this.d, this.hero);
            //this.d.addActionListener(e);
        } else if (enemy.getHp() < 1) {
            hero.gainXp(enemy.giveXp());
            this.teksti.setText("Gained " + enemy.giveXp() + " xp");
            if (hero.getSp() > 0) {
                this.teksti.setText("Unused skillpoints " + hero.getSp());
                ArrayList<JButton> k = new ArrayList();
                k.add(a);
                k.add(s);
                k.add(d);

                for (JButton currentButton : k) {
                    for (ActionListener al : currentButton.getActionListeners()) {
                        currentButton.removeActionListener(al);
                    }
                }
                StreightKehitysNappi str = new StreightKehitysNappi(this.teksti, alpha);
                this.s.addActionListener(str);
                AgilityKehitysNappi agi = new AgilityKehitysNappi(this.teksti, alpha);
                this.a.addActionListener(agi);
                HpKehitysNappi hp = new HpKehitysNappi(this.teksti, alpha);
                this.d.addActionListener(hp);
            }
        }
    }

    public void kasvata() {
        this.osoitin++;
    }
}
