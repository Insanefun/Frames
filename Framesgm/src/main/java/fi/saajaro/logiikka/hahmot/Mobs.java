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
    private boolean alive;

    public Mobs(String nimi, int hp, int damage, int critical, int dodge, int xpYield) {
        this.nimi = nimi;
        this.hp = hp;
        this.currentHp = hp;
        this.damage = damage;
        this.critical = critical;
        this.dodge = dodge;
        this.xpYield = xpYield;
        this.alive = true;
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
        if (this.dodgeRoll() == true) {
            this.currentHp = this.currentHp;
            //System.out.println("Dodge");
            this.hitDetector(false, dmg);
        } else {
            this.currentHp = this.currentHp - dmg;
            System.out.println(this.hitDetector(true, dmg));
        }
        if (this.currentHp < 1) {
            this.alive = false;
        }
    }

    public boolean dodgeRoll() {
        Rng miss = new Rng(this.dodge, 100);
        if (miss.randomNumber() == true) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Max hp " + this.hp + " current health " + this.currentHp + " damage " + this.damage
                + " critical " + this.critical + " dodge " + this.dodge + " xp " + this.xpYield;
    }

    public String encounter() {
        return "Encountered " + this.nimi;
    }

    public int giveXp() {
        return this.xpYield;
    }

    public int tellHp() {
        return this.currentHp;
    }
    public boolean tellAlive() {
        boolean life = true;
        if (this.alive == false) {
            life = false;
        }
        return life;
    }
    public void modifyDodge(int modifier) {
        this.dodge = this.dodge - modifier;
    }
    public String hitDetector(Boolean hit, int damage) {
        if (hit == true) {
            return this.nimi + " took " + damage + " damage.";
        } else {
            return "Dodge";
        }
        
    }

}
