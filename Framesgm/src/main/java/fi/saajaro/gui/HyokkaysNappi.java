package fi.saajaro.gui;

import static fi.saajaro.gui.AloitusNappi.NL;
import fi.saajaro.logiikka.Taistelu;
import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class HyokkaysNappi implements ActionListener {

    private String komento;
    private Pelaaja hero;
    private Mobs enemy;
    private JTextArea kohde;
    private Moodi alpha;
    private Taistelu kappa;
    private JButton a;
    private JButton s;
    private JButton d;

    public HyokkaysNappi(JTextArea kohde, Moodi alpha, String komento, Mobs enemy) {
        this.hero = alpha.getHero();
        this.kohde = kohde;
        this.komento = komento;
        this.alpha = alpha;
        this.enemy = enemy;
        this.kappa = kappa;
        this.a = alpha.getA();
        this.s = alpha.getS();
        this.d = alpha.getD();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.komento = "A";
        this.alpha.setKomento(komento);
        this.alpha.getTeksti().setText(Gauntlet.action(enemy, hero, komento));
        if (!enemy.tellAlive() || !hero.tellIfAlive()) {
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
                alpha.getTeksti().setText("Gained " + enemy.giveXp() + " xp");
                if (hero.getSp() > 0) {
                    alpha.getTeksti().setText("Enemy defeated: Unused skillpoints " + hero.getSp() + NL + "Agility gives small bonus to crit chance, hit chance and blocked damage "
                            + NL + " Streight increases damage " + NL
                            + " Hp gives you more durability, lose it all and you die.");
                    ArrayList<JButton> k = new ArrayList();
                    k.add(a);
                    k.add(s);
                    k.add(d);

                    for (JButton currentButton : k) {
                        for (ActionListener al : currentButton.getActionListeners()) {
                            currentButton.removeActionListener(al);
                        }
                    }
                    StreightKehitysNappi str = new StreightKehitysNappi(alpha.getTeksti(), alpha);
                    this.s.addActionListener(str);
                    AgilityKehitysNappi agi = new AgilityKehitysNappi(alpha.getTeksti(), alpha);
                    this.a.addActionListener(agi);
                    HpKehitysNappi hp = new HpKehitysNappi(alpha.getTeksti(), alpha);
                    this.d.addActionListener(hp);
                }

            }

        }
    }
}
