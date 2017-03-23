package fi.saajaro.logiikka.hahmot;

import fi.saajaro.logiikka.randomnumbergod.Rng;

public class Mobs {

    private String nimi;
    private int hp;
    private int currentHp;
    private int damage;
    private int critical;
    private int dodge;
    private int xpYield;

    public Mobs(String nimi, int hp, int damage, int critical, int dodge, int xpYield) {
        this.nimi = nimi;
        this.hp = hp;
        this.currentHp = hp;
        this.damage = damage;
        this.critical = critical;
        this.dodge = dodge;
        this.xpYield = xpYield;
    }

    public int attack() {
        Rng k = new Rng(this.critical, 255);
        if (k.randomNumber() == true) {
            return this.damage + this.damage;
        } else {
            return this.damage;
        }

    }

    public void takeDamage(int dmg) {
        this.currentHp = this.currentHp - dmg;
    }

    @Override
    public String toString() {
        return "Max hp " + this.hp + " current health " + this.currentHp + " damage " + this.damage
                + " critical " + this.critical + " dodge " + this.dodge + " xp " + this.xpYield;
    }

}
