package fi.saajaro.logiikka.tapahtumat;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.moodit.Moodi;
import java.util.Scanner;
import javax.swing.JTextArea;

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
    public void battle(Moodi alpha) {
        Pelaaja hero = alpha.getHero();
        Mobs enemy = Gauntlet.generateEnemy();
        enemy.modifyDodge(hero.hitBonus());
        alpha.getTeksti().setText(enemy.encounter());
        while (hero.tellIfAlive() && enemy.tellAlive()) {
            alpha.getTeksti().setText(alpha.getTeksti().getText() + NL + "Choose a command: A = Attack, S = Tattle, D = Defend");
            Gauntlet.turn(enemy, alpha);
        }
        Gauntlet.afterBattle(hero, enemy);

    }

    /**
     * Metodi joka luo vihollisen kohtaamisen alussa.
     *
     * @return
     */
    public static Mobs generateEnemy() {
        Mobs enemy = new Mobs("Powercreep", 10, 1, 0, 30, 100);
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

    /**
     * Metodi joka selvittää mitä tapahtuu kohtaamisien jälkeen.
     *
     * @param hero käyttäjän Pelaaja olio
     * @param enemy kohdattu Mobs olio
     */
    public static void afterBattle(Pelaaja hero, Mobs enemy) {
        if (!hero.tellIfAlive()) {
            System.out.println(Gauntlet.deep());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.exit(0);
        }
        if (!enemy.tellAlive()) {
            hero.gainXp(enemy.giveXp());
        }

        while (hero.getSp() > 0) {
            //  System.out.println(hero.toString());
            //  System.out.println("Choose to improve: A = Agility, S = Streight, D = Hp");
            String k = lukija.nextLine();
            Gauntlet.kehita(hero, k);
        }

    }

    public static void outOfBattle() {

    }

    public static String deep() {
        return "... A dancer with no legs...";
    }
}
    

//}
