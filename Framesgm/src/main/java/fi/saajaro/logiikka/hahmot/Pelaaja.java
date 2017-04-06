package fi.saajaro.logiikka.hahmot;

import fi.saajaro.logiikka.randomnumbergod.Rng;
import java.util.HashMap;
/**
 * Luokka joka pitää sisällään monia pelaajan hahmoon liittyviä metodeja.
 */
public class Pelaaja {
    /**
     * Olion arvo joka asettaa maksimi arvon currentHplle.
     * @@see fi.saajaro.logiikka.hahmot.Pelaaja#currentHp
     */

    private int hp;
    /**
     * Olion arvo joka laskee tehdyn vaurion arvon.
     */
    private int streight;
    /**
     * Olion muutuuja jonka avulla lasketaan sen metodien arvoja.
     */
    private int agility;
    /**
     * Olion muuttuja jonka laskiessa olle yhden peliä ei voi jatkaa.
     */
    private int currentHp;
    /**
     * Olion arvo jonka noustessa määriteltyyn arvoon olion sp arvo nousee kolmella.
     */
    private int xp;
    /**
     * Olion arvo jota käytetään laskettaessa hyökkäysten tehokkuutta.
     */
    private int level;
    /**
     * Olion arvo joka säätelee muiden olion arvojen kasvatusta.
     */
    private int sp;
    /**
     * Olion arvo jonka ollessa yksi olio tekee enemmän vauriota.
     */
    private int attackBonus;
    /**
     * Olion bonusDefence arvo jonka ollessa yksi otettu vaurio on pienempi.
     */
    private int bonusDefence;
    /**
     * Olion alive arvo jonka ollessa false peliä ei voi jatkaa.
     */
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
    /**
     * Nostaa olion xp arvoa parametrina saadun määrän ja jos asetettu raja ylitetään
     * nostetaan olion level muuttujaa ja asetetaan sen xp nollaan.
     * @param exp saatu xp
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#xp
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#level
     */

    public void gainXp(int exp) {
        this.xp = this.xp + exp;
        if (this.xp >= this.level * 5 + 5) {
            this.level = this.level + 1;
            this.sp = this.sp + 3;
            this.xp = 0;
        }

    }
    /**
     * Nostaa olion streight arvoa ja laskee sen sp arvoa yhdellä.
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#streight
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#sp
     */

    public void gainStreight() {
        if (this.sp > 0) {
            this.streight++;
            this.sp--;
        }
    }
    /**
     * Nostaa olion hp ja currentHp arvoja ja laskee sen sp arvoa yhdellä.
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#hp
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#currentHp
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#sp
     */

    public void gainHp() {
        if (this.sp > 0) {
            this.hp++;
            this.currentHp++;
            this.sp--;
        }
    }
    /**
     * Nostaa olion agility arvoa ja laskee sen sp arvoa.
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#agility
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#sp
     */

    public void gainAgility() {
        if (this.sp > 0) {
            this.agility++;
            this.sp--;
        }
    }
    /**
     * Laskee olion currentHp arvoa laskettuaan lopullisen damage arvon saadusta damage 
     * arvosta. Muutta olion alive arvoksi false jos laskee currentHp arvon alle yhteen.
     * @param damage oletus arvoinen damage
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#currentHp
     */

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
    /**
     * Olion metodi joka laskee otetun vaurion suuruden ja jos oliolla on bonusDefence arvo 1
     * laskee vaurion suuruutta.
     * @param damage saatu damage arvo
     * @return mahdollisesti muuttunut damage arvo
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#bonusDefence
     */

    public int calcDamageTaken(int damage) {
        if (this.bonusDefence == 1) {
            damage = damage - this.agility / 3;
            damage = damage - damage % 2;
            this.bonusDefence = 0;
        }
        return damage;
    }
    /**
     * olion metodi jota kutsuttaessa saadaan selville sen damage arvo. 
     * Käyttää apunaan metodia calcDamage.
     * @return laskettu damage arvo
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#calcDamage(int) 
     */

    public int dealDamage() {
        int ignoredStr = this.streight % 2;
        int strDmg = (this.streight - ignoredStr) / 2;
        int damage = calcDamage(1 + strDmg);
        return damage;
    }
    /**
     * laskee parametrina saadun damagen loppu arvon käyttämällä apunaan metodeja crit() ja damageBonus().
     * @param damage parametrina saatu damage jonka loppu arvo lasketaan
     * @return damagen loppu arvo
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#crit(int) 
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#damageBonus(int) 
     */

    public int calcDamage(int damage) {
        damage = crit(damage);
        damage = damageBonus(damage);

        return damage;
    }
    /**
     * Metodi joka luo satunnaisluvun käyttäen Rng oliota ja muokkaa parametrinä saatua
     * damage arvoa jos oliolle laskettava critchance on suurempi kuin arvottu satunnaisluku.
     * @param damage parametrina saatu hyökkäyksen oletus damage arvo
     * @return mahdollisesti muuttunut hyökkäyksen damage arvo
     */

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
    /**
     * Metodi joka tarkistaa onko oliolla attackBonusta ja lisää parametrinä annettua
     * damage arvoa riippuen attackBonus arvosta ja asettaa attackBonuksen nollaan.
     * @param damage parametrina saatu hyökkäyksen oletus damage arvo
     * @return mahdollisesti muuttunut damage arvo
     */

    public int damageBonus(int damage) {
        if (this.attackBonus == 1) {
            int bonus = this.streight - this.streight % 2;
            damage = damage + bonus / 2;
            this.attackBonus = 0;
        }
        return damage;
    }
    /**
     * Metodi jota kutsuttaessa olion attackBonus ja bonusDefence arvot asettuvat yhteen.
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#attackBonus
     * @see fi.saajaro.logiikka.hahmot.Pelaaja#bonusDefence
     */

    public void block() {
        this.attackBonus = 1;
        this.bonusDefence = 1;
    }
    /**
     * Metodi joka antaa tietoa parametrina annetusta kohteesta.
     * @param enemy kohde johon metodia käytetään.
     * @return palauttaa String muotoisen esityksen kohteesta.
     */

    public String tattle(Mobs enemy) {
        return "Enemy " + enemy.toString();
    }
    /**
     * Metodi joka helpottaa olion toString() metodin kutsua.
     * @return palauttaa olion tärkeät arvot.
     */
    public String selfTattle() {
        return "You: " + this.toString();
    }
    /**
     * Luo oliosta String muotoisen esityksen.
     * @return palauttaa olion String muotoisen esityksen
     */

    @Override
    public String toString() {
        return "Max hp " + this.hp + " current hp " + this.currentHp + " streight " + this.streight + " agility " + this.agility + " xp "
                + this.xp + " level " + this.level + " skill points " + this.sp;
    }

    public int getCurrentXp() {
        return this.xp;
    }

    public int getCurrentLevel() {
        return this.level;
    }

    public int getlMaxHp() {
        return this.hp;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public int getStreight() {
        return this.streight;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getSp() {
        return this.sp;
    }
    public int getAttackBonus() {
        return this.attackBonus;
    }
    /**
     * Kertoo muille metodeille olion alive arvon.
     * @return olion alive arvoa vastaava boolean arvo
     */

    public boolean tellIfAlive() {
        boolean life = true;
        if (this.alive == false) {
            life = false;
        }
        return life;
    }
    /**
     * Nostaa olion currentHp arvoa parametrinä saadun arvon verran.
     * Ei nosta currentHp arvoa yli olion hp arvon.
     * @param heal joltain esineeltä saatu parannus arvo
     */

    public void heal(int heal) {
        this.currentHp = this.currentHp + heal;
        if (this.currentHp > this.hp) {
            this.currentHp = this.hp;
        }
    }
    /**
     * Metodi kertoo kyseinen Pelaaja olio vähentää vihollisen mahdollisuutta väistää.
     * Käyttää olion agility arvoa.
     * @return kuinka paljon vaikeampi olion hyökkäyksiä on väistää
     */
    public int hitBonus() {
        return this.agility * 2;
    }

}
