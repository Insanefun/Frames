package fi.saajaro.logiikka.tapahtumat;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GauntletTest {

    public GauntletTest() {
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
    public void deepOikein() {
        assertEquals("... A dancer with no legs...", Gauntlet.deep());
    }

    @Test
    public void generateEnemyLuoElossaOleviaVIhollisia() {
        Mobs enemy = Gauntlet.generateEnemy();
        assertEquals(Boolean.TRUE, enemy.tellAlive());
    }

    @Test
    public void actionAttacktoimii() {
        Pelaaja hero = new Pelaaja();
        Mobs enemy = new Mobs("Powercreep", 10, 1, 0, 0, 100);
        Gauntlet.action(enemy, hero, "A");
        assertEquals(9, enemy.getHp());
    }

    @Test
    public void vihollinenIskeeKunAction() {
        Pelaaja hero = new Pelaaja();
        Mobs enemy = new Mobs("Powercreep", 10, 1, 0, 0, 100);
        Gauntlet.action(enemy, hero, "A");
        assertEquals(9, hero.getCurrentHp());
    }

    @Test
    public void actionDefendNostaaSeuraavaaIskua() {
        Pelaaja hero = new Pelaaja();
        Mobs enemy = new Mobs("Powercreep", 10, 1, 0, 0, 100);
        Gauntlet.action(enemy, hero, "D");
        assertEquals(1, hero.getAttackBonus());
    }

    @Test
    public void kehitaNostaaAgility() {
        Pelaaja hero = new Pelaaja();
        Gauntlet.kehita(hero, "A");
        assertEquals(2, hero.getAgility());
    }

    @Test
    public void kehitaNostaaStr() {
        Pelaaja hero = new Pelaaja();
        Gauntlet.kehita(hero, "S");
        assertEquals(2, hero.getStreight());
    }

    @Test
    public void kehitaNostaaHp() {
        Pelaaja hero = new Pelaaja();
        Gauntlet.kehita(hero, "D");
        assertEquals(11, hero.getCurrentHp());
    }
}
