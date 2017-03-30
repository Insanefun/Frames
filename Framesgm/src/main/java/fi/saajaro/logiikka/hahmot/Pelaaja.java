package fi.saajaro.logiikka.hahmot;

import fi.saajaro.logiikka.randomnumbergod.Rng;
import java.util.HashMap;

public class Pelaaja {

    private int hp;
    private int streight;
    private int agility;
    private int currentHp;
    private int xp;
    private int level;
    private int sp;
    private int attackBonus;
    private int bonusDefence;
    private boolean alive;

    public Pelaaja() {
        this.hp = 10;
        this.streight = 1;
        this.agility = 1;
        this.currentHp = 10;
        this.xp = 0;
        this.level = 1;
        this.sp = 5;
        this.attackBonus = 0;
        this.bonusDefence = 0;
        this.alive = true;

    }

    public void gainXp(int exp) {
        this.xp = this.xp + exp;
        if (this.xp >= this.level * 5 + 5) {
            this.level = this.level + 1;
            this.sp = this.sp + 3;
            this.xp = 0;
        }

    }

    public void gainStreight() {
        if (this.sp > 0) {
            this.streight++;
            this.sp--;
        }
    }

    public void gainHp() {
        if (this.sp > 0) {
            this.hp++;
            this.currentHp++;
            this.sp--;
        }
    }

    public void gainAgility() {
        if (this.sp > 0) {
            this.agility++;
            this.sp--;
        }
    }

    public void takeDamage(int damage) {
        int take = this.calcDamageTaken(damage);
        if (take < 0) {
            take = 0;
        }
        this.currentHp = this.currentHp - take;
        System.out.println("You took " + take + " damage.");
        if (this.currentHp < 1) {
            this.alive = false;
        }

    }

    public int calcDamageTaken(int damage) {
        if (this.bonusDefence == 1) {
            damage = damage - this.agility / 3;
            damage = damage - damage % 2;
            this.bonusDefence = 0;
        }
        return damage;
    }

    public int dealDamage() {
        int ignoredStr = this.streight % 2;
        int strDmg = (this.streight - ignoredStr) / 2;
        int damage = calcDamage(1 + strDmg);
        return damage;
    }

    public int calcDamage(int damage) {
        damage = crit(damage);
        damage = damageBonus(damage);

        return damage;
    }

    public int crit(int damage) {
        int critchance = this.agility * 3 - this.level - 2;
        if (critchance < 0) {
            critchance = 0;
        }
        Rng crit = new Rng(critchance, 100);
        if (crit.randomNumber() == true) {
            damage = 2 * damage;
        }
        return damage;
    }

    public int damageBonus(int damage) {
        if (this.attackBonus == 1) {
            int bonus = this.streight - this.streight % 2;
            damage = damage + bonus / 2;
            this.attackBonus = 0;
        }
        return damage;
    }

    public void block() {
        this.attackBonus = 1;
        this.bonusDefence = 1;
    }

    public void tattle(Mobs enemy) {
        System.out.println("You: " + this.toString());
        System.out.println("Enemy " + enemy.toString());
    }

    @Override
    public String toString() {
        return "Max hp " + this.hp + " current hp " + this.currentHp + " streight " + this.streight + " agility " + this.agility + " xp "
                + this.xp + " level " + this.level + " skill points " + this.sp;
    }

    public int currentXp() {
        return this.xp;
    }

    public int currentLevel() {
        return this.level;
    }

    public int tellMaxHp() {
        return this.hp;
    }

    public int tellCurrentHp() {
        return this.currentHp;
    }

    public int tellStreight() {
        return this.streight;
    }

    public int tellAgility() {
        return this.agility;
    }

    public int tellSp() {
        return this.sp;
    }

    public boolean tellIfAlive() {
        boolean life = true;
        if (this.alive == false) {
            life = false;
        }
        return life;
    }

    public void heal(int heal) {
        this.currentHp = this.currentHp + heal;
        if (this.currentHp > this.hp) {
            this.currentHp = this.hp;
        }
    }

    public int hitBonus() {
        return this.agility * 2;
    }

}
