package fi.saajaro.logiikka.hahmot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AseTest {

    public AseTest() {
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
    public void aseOlemassa() {
        Pelaaja hero = new Pelaaja();
        Ase sword = new Ase("Sword", 1, hero, 1);
        assertEquals("Sword",sword.getNim());
    }
    @Test
    public void aseDamageOikein() {
        Pelaaja hero = new Pelaaja();
        Ase sword = new Ase("Sword", 1, hero, 1);
        assertEquals(1,sword.getDamage());
    }
    @Test
    public void aseTunteeOmistajansa() {
        Pelaaja hero = new Pelaaja();
        hero.gainAgility();
        Ase sword = new Ase("Sword", 1, hero, 1);
        assertEquals(2,sword.getUser().getAgility());
    }
    @Test
    public void aseTriggerAsettuuOikein() {
        Pelaaja hero = new Pelaaja();
        Ase sword = new Ase("Sword", 1, hero, 2);
        assertEquals(2,sword.getEffect());
    }
    @Test
    public void aseVoiTrigger() {
        Pelaaja hero = new Pelaaja();
        hero.takeDamage(3);
        Ase sword = new Ase("Sword", 1, hero, 1);
        sword.trigger();
        assertEquals(8,hero.getCurrentHp());
    }
    @Test
    public void aseEiTrigger() {
        Pelaaja hero = new Pelaaja();
        Ase sword = new Ase("Sword", 1, hero, 0);
        hero.takeDamage(3);
        sword.trigger();
        assertEquals(7,hero.getCurrentHp());
    }
}
