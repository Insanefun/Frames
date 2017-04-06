package fi.saajaro.logiikka.hahmot;

import fi.saajaro.logiikka.randomnumbergod.Rng;

public class Mobs {

    /**
     * Olion muutuja joka kertoo sille määritellyn nimen.
     */
    private String nimi;
    /**
     * Olion muuttuja joka kertoo kuinka paljon vauriota se voi enintään kärsiä.
     */
    private int hp;
    /**
     * Olion muuttuja joka kertoo kuinka paljon vauriota se voi vielä kärsiä.
     */
    private int currentHp;
    /**
     * Olion muuttuja joka kertoo sen iskujen voimakkuuden.
     */
    private int damage;
    /**
     * Olion muuttuja joka antta mahdollisuude tehdä kriittisiä iskuja.
     */
    private int critical;
    /**
     * Olion muuttuja joka antaa mahdollisuuden väistää iskut.
     */
    private int dodge;
    /**
     * Olion muuttuja joka kertoo olion kukistamisesta saadun xp määrän.
     */
    private int xpYield;
    /**
     * Olion muttuja jonka ollessa false olio on kukistettu.
     */
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

    /**
     * Metodi laskee olion seuraavan hyökkäyksen vaurion ja käyttäen Rng oliota
     * tarkistaa onko osuma kriittinen.
     *
     * @return palauttaa lasketun vaurio määrän
     * @see fi.saajaro.logiikka.randomnumbergod.Rng#Rng(int, int)
     */

    public int attack() {
        Rng k = new Rng(this.critical, 255);
        if (k.randomNumber() == true) {
            return this.damage + this.damage;
        } else {
            return this.damage;
        }

    }

    /**
     * Metodi joka vähentää olion currentHp arvoa parametrina saadun dmg arvo
     * verran paitsi jos olion dodgeRoll metodi saa arvon true.
     *
     * @param dmg vaurio jonka olio kärsii jos hyökkäys osuu
     * @see fi.saajaro.logiikka.hahmot.Mobs#dodgeRoll()
     */

    public void takeDamage(int dmg) {
        if (this.dodgeRoll() == true) {
            this.currentHp = this.currentHp;
            //System.out.println("Dodge");
            this.hitDetector(false, dmg);
        } else {
            if (dmg < 0) {
                dmg = 0;
            }
            this.currentHp = this.currentHp - dmg;
            System.out.println(this.hitDetector(true, dmg));
        }
        if (this.currentHp < 1) {
            this.alive = false;
        }
    }

    /**
     * Luo satunnaisluvun ja tarkitaa onko se pienempi kuin olion dodge arvo
     * käyttäen Rng oliota.
     *
     * @return totuus arvo olion väistöstä
     * @see fi.saajaro.logiikka.randomnumbergod.Rng#Rng(int, int)
     */

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

    /**
     * String muotoinen esitys olion kohtaamiselle.
     *
     * @return String esitys olion kohtaamisesta
     */

    public String encounter() {
        return "Encountered " + this.nimi;
    }

    /**
     * Antaa muille metodeille olion xpYield arvon.
     *
     * @return olion xpYield arvo
     */

    public int giveXp() {
        return this.xpYield;
    }

    public int getHp() {
        return this.currentHp;
    }

    /**
     * Kertoo olion alive totuusarvon muille metodeille.
     *
     * @return totuus arvo joka kuvaa olion aliven tilaa
     */
    public boolean tellAlive() {
        boolean life = true;
        if (this.alive == false) {
            life = false;
        }
        return life;
    }

    /**
     * Muutta olion dodge arvoa vähentämällä siitä parametrina saadun modifier
     * arvon.
     *
     * @param modifier arvo joka vähennetään olion dodge arvos, voi olla
     * negatiivinen
     */
    public void modifyDodge(int modifier) {
        this.dodge = this.dodge - modifier;
    }

    /**
     * Metodi luo String muotoisen esityksen muutkan damage tekemästä vauriosta
     * olioon kun parametri hit on true. Muulloin palauttaa String muotoisen
     * esityksen epäonnistuneesta iskusta.
     *
     * @param hit saatu totuusarvo kyseisen iskun onnistumisesta.
     * @param damage saatu vaurio jos isku on onnistunut
     * @return String muotoinen esitys iskusta
     */
    public String hitDetector(Boolean hit, int damage) {
        if (hit == true) {
            return this.nimi + " took " + damage + " damage.";
        } else {
            return "Dodge";
        }

    }

}
