package fi.saajaro.logiikka.tapahtumat;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import java.util.Scanner;

public class Gauntlet {

    static Scanner lukija = new Scanner(System.in);
    
    /**
     * Luo Pelaaja olion käyttäjälle.
     * @return luotu Pelaaja olio
     */

    public static Pelaaja luoHero() {
        Pelaaja hero = new Pelaaja();
        /*/   Käyttöliittymä kertoo.
        System.out.println("Agility gives small bonus to crit chance, hit chance and blocked damage");
        System.out.println("Streight increases damage");
        System.out.println("Hp gives you more durability, lose it all and you die.");
/*/
        while (hero.getSp() > 0) {
           // System.out.println(hero.toString());
           // System.out.println("Choose to improve: A = Agility, S = Streight, D = Hp");
            String k = lukija.nextLine();
            Gauntlet.kehita(hero, k);
        }
        return hero;

    }
        /**
         * Nostaa annetun Pelaaja olion arvoja annetun parametrin mukaan ja laskee
         * sen sp arvoa.
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
     * @param hero 
     * @see fi.saajaro.logiikka.tapahtumat.Gauntlet#generateEnemy() 
     * @see fi.saajaro.logiikka.tapahtumat.Gauntlet#turn(fi.saajaro.logiikka.hahmot.Mobs, fi.saajaro.logiikka.hahmot.Pelaaja) 
     */
    public static void battle(Pelaaja hero) {
        Mobs enemy = Gauntlet.generateEnemy();
        enemy.modifyDodge(hero.hitBonus());
        System.out.println(enemy.encounter());
        while (hero.tellIfAlive() && enemy.tellAlive()) {
            Gauntlet.turn(enemy, hero);
        }
        Gauntlet.afterBattle(hero, enemy);

    }
        /**
         * Metodi joka luo vihollisen kohtaamisen alussa.
         * @return 
         */
    public static Mobs generateEnemy() {
        Mobs enemy = new Mobs("Powercreep", 10, 1, 0, 30, 100);
        return enemy;
    }
    /**
     * Metodi joka toimii kohtaamisien viestin viejänä.
     * @param enemy vihollinen jonka pelaaja kohtaa
     * @param hero pelaajan Pelaaja olio
     */
    public static void turn(Mobs enemy, Pelaaja hero) {
       // System.out.println("Choose a command: A = Attack, S = Tattle, D = Defend, Other command= Skip");
        String komento = lukija.nextLine();
        action(enemy, hero, komento);
    }
    /**
     * Turn metodin käyttäjän kometojen lukija.
     * @param enemy kohde johon komennot toteutetaan
     * @param hero käyttäjän Pelaaja olio joka toteuttaa käskyt
     * @param komento komento jonka metodi suorittaa
     * @see fi.saajaro.logiikka.tapahtumat.Gauntlet#turn(fi.saajaro.logiikka.hahmot.Mobs, fi.saajaro.logiikka.hahmot.Pelaaja) 
     */
    public static void action(Mobs enemy, Pelaaja hero, String komento) {
        if (komento.equalsIgnoreCase("A")) {
            enemy.takeDamage(hero.dealDamage());
        }
        if (komento.equalsIgnoreCase("S")) {
            hero.tattle(enemy);
        }
        if (komento.equalsIgnoreCase("D")) {
            hero.block();
        }
        hero.takeDamage(enemy.attack());
    }
    /**
     * Metodi joka selvittää mitä tapahtuu kohtaamisien jälkeen.
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
