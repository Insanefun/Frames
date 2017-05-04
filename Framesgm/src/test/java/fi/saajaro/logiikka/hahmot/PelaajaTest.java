package fi.saajaro.logiikka.hahmot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void currentXpPalauttaaArvon() {
        Pelaaja hero = new Pelaaja();
        assertEquals(0, hero.getCurrentXp());
    }

    @Test
    public void gainXpMuuttaaXpArvoa() {
        Pelaaja hero = new Pelaaja();
        hero.gainXp(6);
        assertEquals(6, hero.getCurrentXp());
    }

    @Test
    public void gainXpMuuttaaTasoa() {
        Pelaaja hero = new Pelaaja();
        hero.gainXp(11);
        assertEquals(2, hero.getCurrentLevel());
    }

    @Test
    public void tasonSaantiAsettaaXpnNollaan() {
        Pelaaja hero = new Pelaaja();
        hero.gainXp(1000000);
        assertEquals(0, hero.getCurrentXp());
    }

    @Test
    public void vaurioLaskeeCurrentHealth() {
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(5);
        assertEquals(5, hero.getCurrentHp());
    }

    @Test
    public void vaurioEiLaskeHp() {
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(2);
        assertEquals(10, hero.getMaxHp());
    }

    @Test
    public void dealDamageKunStreightYksi() {
        Pelaaja hero = new Pelaaja();
        assertEquals(1, hero.dealDamage());
    }

    @Test
    public void gainStreightToimiiKunSp() {
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        assertEquals(2, hero.getStreight());
    }

    @Test
    public void gainStreightEiNostaStreightKunEiSp() {
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        assertEquals(6, hero.getStreight());
    }

    @Test
    public void gainAgilityToimiiKunSp() {
        Pelaaja hero = new Pelaaja();
        hero.gainAgility();
        assertEquals(2, hero.getAgility());
    }

    @Test
    public void gainAgilityEiNostaAgilityKunEiSp() {
        Pelaaja hero = new Pelaaja();
        hero.gainAgility();
        hero.gainAgility();
        hero.gainAgility();
        hero.gainAgility();
        hero.gainAgility();
        hero.gainAgility();
        assertEquals(6, hero.getAgility());
    }

    @Test
    public void gainHpToimiiKunSp() {
        Pelaaja hero = new Pelaaja();
        hero.gainHp();
        assertEquals(11, hero.getMaxHp());
    }

    @Test
    public void gainHpEiNostaHpKunEiSp() {
        Pelaaja hero = new Pelaaja();
        hero.gainHp();
        hero.gainHp();
        hero.gainHp();
        hero.gainHp();
        hero.gainHp();
        hero.gainHp();
        assertEquals(15, hero.getMaxHp());
    }

    @Test
    public void gainHpNostaaCurrentHp() {
        Pelaaja hero = new Pelaaja();
        hero.gainHp();
        assertEquals(11, hero.getCurrentHp());
    }

    @Test
    public void dealDamageOikeinKunStreightJaollinenKahdella() {
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        assertEquals(3, hero.dealDamage());
    }

    @Test
    public void dealDamageOikeinKunStreightEiJaollinenKahdella() {
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        assertEquals(3, hero.dealDamage());
    }

    @Test
    public void bonusDamageToimii() {
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        hero.block();
        assertEquals(3, hero.dealDamage());
    }

    @Test
    public void bonusDefenceToimii() {
        Pelaaja hero = new Pelaaja();
        hero.gainAgility();
        hero.gainAgility();
        hero.block();
        hero.takeDamage(6);
        assertEquals(6, hero.getCurrentHp());
    }

    @Test
    public void eiElossaKunHpOnNolla() {
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(10);
        assertEquals(false, hero.tellIfAlive());
    }

    @Test
    public void otettuDamageEiNegatiivinen() {
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(-3);
        assertEquals(10, hero.getCurrentHp());
    }

    @Test
    public void healEiOverHeal() {
        Pelaaja hero = new Pelaaja();
        hero.heal(1);
        assertEquals(10, hero.getCurrentHp());
    }

    @Test
    public void hitBonusOikein() {
        Pelaaja hero = new Pelaaja();
        assertEquals(2, hero.hitBonus());
    }

    @Test
    public void levelTuleeOikein() {
        Pelaaja hero = new Pelaaja();
        hero.gainXp(10);
        assertEquals(2, hero.getCurrentLevel());
    }

    @Test
    public void spTuleeOikein() {
        Pelaaja hero = new Pelaaja();
        hero.gainXp(10);
        assertEquals(8, hero.getSp());
    }

    @Test
    public void critChanceOikeinKunNolla() {
        Pelaaja hero = new Pelaaja();
        assertEquals(1, hero.crit(1));
    }

    @Test
    public void tattleSelfPalauttaOikein() {
        Pelaaja hero = new Pelaaja();
        assertEquals("You: " + hero.toString(), hero.selfTattle());
    }

    @Test
    public void otettuDamageEiNegatiivinenSuurilla() {
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(-1);
        assertEquals(10, hero.getCurrentHp());
    }
    @Test
    public void tilaAnnetaanOikein() {
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(1);
        assertEquals("You took " + "1" + " damage from the attack of the enemy, 9 hp left.", hero.getToiminta());
    }

}
