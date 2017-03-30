package fi.saajaro.logiikka.tapahtumat;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import java.util.Scanner;

public class Gauntlet {
    
    static Scanner lukija = new Scanner(System.in);
    //static Pelaaja hero = new Pelaaja();

    public static Pelaaja luoHero() {
        Pelaaja hero = new Pelaaja();
        System.out.println("Agility gives small bonus to crit chance, hit chance and blocked damage");
        System.out.println("Streight increases damage");
        System.out.println("Hp gives you more durability, lose it all and you die.");
        
        while (hero.tellSp() > 0) {
            Gauntlet.kehita(hero);
        }
        return hero;
        
    }

    public static void kehita(Pelaaja hero) {
        System.out.println(hero.toString());
        System.out.println("Choose to improve: A = Agility, S = Streight, D = Hp");
        String k = lukija.nextLine();
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
    
    public static void battle(Pelaaja hero) {
        Mobs enemy = Gauntlet.generateEnemy();
        enemy.modifyDodge(hero.hitBonus());
        System.out.println(enemy.encounter());
        while (hero.tellIfAlive() && enemy.tellAlive()) {
            Gauntlet.turn(enemy, hero);
        }
        Gauntlet.afterBattle(hero, enemy);
        
    }
    
    public static Mobs generateEnemy() {
        Mobs enemy = new Mobs("Powercreep", 10, 1, 0, 30, 100);
        return enemy;
    }
    
    public static void turn(Mobs enemy, Pelaaja hero) {
        System.out.println("Choose a command: A = Attack, S = Tattle, D = Defend, Other command= Skip");
        String komento = lukija.nextLine();
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
        
        while (hero.tellSp() > 0) {
            Gauntlet.kehita(hero);
        }
        
    }

    public static void outOfBattle() {
        
    }

    public static String deep() {
        return "... A dancer with no legs...";
    }
}
    

//}
