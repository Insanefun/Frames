
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
    public void currentXpPalauttaaArvon(){
        Pelaaja hero = new Pelaaja();
        assertEquals(0, hero.currentXp());
    }
    
    @Test
    public void gainXpMuuttaaXpArvoa(){
        Pelaaja hero = new Pelaaja();
        hero.gainXp(6);
        assertEquals(6, hero.currentXp());
    }
    
    @Test
    public void gainXpMuuttaaTasoa(){
        Pelaaja hero = new Pelaaja();
        hero.gainXp(11);
        assertEquals(2, hero.currentLevel());
    }
    
    @Test
    public void tasonSaantiAsettaaXpnNollaan(){
        Pelaaja hero = new Pelaaja();
        hero.gainXp(1000000);
        assertEquals(0, hero.currentXp());
    }
    
    @Test
    public void vaurioLaskeeCurrentHealth(){
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(5);
        assertEquals(5,hero.tellCurrentHp());
    }
    @Test
    public void vaurioEiLaskeHp(){
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(2);
        assertEquals(10, hero.tellMaxHp());
    }
    @Test
    public void dealDamageKunStreightYksi(){
        Pelaaja hero = new Pelaaja();
        assertEquals(1,hero.dealDamage());
    }
    @Test
    public void gainStreightToimiiKunSp(){
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        assertEquals(2, hero.tellStreight());
    }
    @Test
    public void gainStreightEiNostaStreightKunEiSp(){
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        assertEquals(6, hero.tellStreight());
    }
    @Test
    public void dealDamageOikeinKunStreightJaollinenKahdella(){
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        assertEquals(3,hero.dealDamage());
    }
    @Test
    public void dealDamageOikeinKunStreightEiJaollinenKahdella(){
        Pelaaja hero = new Pelaaja();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        hero.gainStreight();
        assertEquals(3,hero.dealDamage());
    }
    
}
