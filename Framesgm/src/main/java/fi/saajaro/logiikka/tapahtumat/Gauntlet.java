package fi.saajaro.logiikka.tapahtumat;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import fi.saajaro.logiikka.randomnumbergod.Rng;
import java.util.Scanner;
import javax.swing.JTextArea;
/**
 * Luokka joka auttaaa taisteluiden alustamisessa ja ylläpitämisessä.
 */
public class Gauntlet {

    public static final String NL = System.getProperty("line.separator");
    static Scanner lukija = new Scanner(System.in);

    /**
     * Nostaa annetun Pelaaja olion arvoja annetun parametrin mukaan ja laskee
     * sen sp arvoa.
     *
     * @param hero Pelaaja olio jonka arvoja muutetaan
     * @param k komento siitä mitä nostetaan
     */
    public static void kehita(Pelaaja hero, String k) {

        if (k.equalsIgnoreCase("D")) {
            hero.gainHp();
        }
        if (k.equalsIgnoreCase("S")) {
            hero.gainStreight();
        }
        if (k.equalsIgnoreCase("A")) {
            hero.gainAgility();
        }
    }

    /**
     * Metodi joka kutsuu generateEnemy metodia, alustaa kohtaamisen ja jatkaa
     * kohtaamista kutsumalla turn metodia kunnes jokin sen vaatimus ei täyty.
     *
     * @param alpha
     * @see fi.saajaro.logiikka.tapahtumat.Gauntlet#generateEnemy()
     * @see
     * fi.saajaro.logiikka.tapahtumat.Gauntlet#turn(fi.saajaro.logiikka.hahmot.Mobs,
     * fi.saajaro.logiikka.hahmot.Pelaaja)
     */
    /*/public void battle(Moodi alpha) {
        Pelaaja hero = alpha.getHero();
        Mobs enemy = Gauntlet.generateEnemy();
        enemy.modifyDodge(hero.hitBonus());
        alpha.getTeksti().setText(enemy.encounter());
        while (hero.tellIfAlive() && enemy.tellAlive()) {
            alpha.getTeksti().setText(alpha.getTeksti().getText() + NL + "Choose a command: A = Attack, S = Tattle, D = Defend");
            Gauntlet.turn(enemy, alpha);
        }

    }/*/

    /**
     * Metodi joka luo vihollisen kohtaamisen alussa.
     *
     * @return
     */
    public static Mobs generateEnemy() {
        Rng vihollisArpoja = new Rng(70, 100);

        //Mobs enemy = new Mobs("Powercreep", 10, 1, 0, 30, 100);
        String nimi = "Powercreep";
        int hp = 10;
        int damage = 1;
        int crit = 0;
        int dodge = 30;
        int xp = 100;

        Rng toinenVihollisArpoja = new Rng(80, 100);
        if (vihollisArpoja.randomNumber()) {
            //Mobs enemy = new Mobs("Spearman", 6, 1, 0, 50, 200);
            nimi = "Spearman";
            hp = 6;
            damage = 1;
            crit = 0;
            dodge = 50;
            xp = 200;
        } else if (toinenVihollisArpoja.randomNumber()) {
            //Mobs enemy = new Mobs("lolcat", 50, 0, 0, 60, 500);
            nimi = "Powercreep";
            hp = 50;
            damage = 0;
            crit = 0;
            dodge = 50;
            xp = 500;
        }
        Mobs enemy = new Mobs(nimi, hp, damage, crit, dodge, xp);
        return enemy;
    }

    /**
     * Metodi joka toimii kohtaamisien viestin viejänä.
     *
     * @param enemy vihollinen jonka pelaaja kohtaa
     * @param alpha peli tila jonka olio saa ja josta tiedot pelistä tulevat.
     */
    public static void turn(Mobs enemy, Moodi alpha) {

        Pelaaja hero = alpha.getHero();

        //String komento = lukija.nextLine();
        alpha.setKomento("i");
        if (alpha.getKomento().equalsIgnoreCase("A")) {
            action(enemy, hero, alpha.getKomento());
        }
        //Moodi.getAction;
        //action(enemy, hero, alpha.getKomento());
    }

    /**
     * Turn metodin käyttäjän kometojen lukija.
     *
     * @param enemy kohde johon komennot toteutetaan
     * @param hero käyttäjän Pelaaja olio joka toteuttaa käskyt
     * @param komento komento jonka metodi suorittaa
     * @see
     * fi.saajaro.logiikka.tapahtumat.Gauntlet#turn(fi.saajaro.logiikka.hahmot.Mobs,
     * fi.saajaro.logiikka.hahmot.Pelaaja)
     */
    public static String action(Mobs enemy, Pelaaja hero, String komento) {
        if (komento.equalsIgnoreCase("A")) {
            enemy.takeDamage(hero.dealDamage());
        }
        if (komento.equalsIgnoreCase("S")) {
            hero.tattle(enemy);
            hero.takeDamage(enemy.attack());
            String palautus = hero.getToiminta() + NL + hero.selfTattle() + NL + hero.tattle(enemy);
        }
        if (komento.equalsIgnoreCase("D")) {
            hero.block();
            enemy.takeDamage(0);
        }
        hero.takeDamage(enemy.attack());
        String palautus = hero.getToiminta() + NL + enemy.getToiminta();
        return palautus;
    }

}
    

//}
